package org.anest.mystore.controller.admin;

import jakarta.mail.MessagingException;
import org.anest.mystore.entity.Product;
import org.anest.mystore.service.EmailService;
import org.anest.mystore.service.ProductService;
import org.anest.mystore.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("admin/report")
public class ReportController {

    private final ReportService reportService;
    private final ProductService productService;
    private final EmailService emailService;

    @Autowired
    public ReportController(ReportService reportService, ProductService productService, EmailService emailService) {
        this.reportService = reportService;
        this.productService = productService;
        this.emailService = emailService;
    }

    @GetMapping("/excel")
    public ResponseEntity<ByteArrayResource> outputExcelListProduct() {
        String fileName = "PRODUCTS.xlsx";
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            List<Product> products = this.productService.findAll();
            reportService.outputExcel(products, stream);

            return ResponseEntity.ok()
                    .contentType(new MediaType("application", "vnd.ms-excel"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .body(new ByteArrayResource(stream.toByteArray()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/excel/v2")
    public ResponseEntity<InputStreamResource> downloadFile() {
        String fileName = "PRODUCTS.xlsx";
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            List<Product> products = this.productService.findAll();
            reportService.outputExcel(products, out);

            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            InputStreamResource resource = new InputStreamResource(in);
            return ResponseEntity.ok()
                    .contentType(new MediaType("application", "vnd.ms-excel"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/send")
    public String sendEmail() {
        try {
            emailService.sendMessage(
                    "SunCho Telecom",
                    "[TEST] Subject",
                    "[TEST] Content",
                    "s2.25111211@gmail.com"
            );
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
}
