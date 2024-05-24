package org.anest.mystore.controller;

import org.anest.mystore.entity.Brand;
import org.anest.mystore.entity.Product;
import org.anest.mystore.service.BrandService;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;
    private BrandService brandService;

    @Autowired
    public ProductController(ProductService productService, BrandService brandService) {
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("title", "Danh sách sản phẩm");
        return "layout";
    }

    @GetMapping("/lipstick-type/{categoryId}")
    public String findByType(@PathVariable Long categoryId, Model model) {
        List<Product> products = productService.findByCategoryCategoryId(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("title", "Danh sách sản phẩm");
        return "layout";
    }

    @GetMapping("/lipstick-brand/{brandId}")
    public String findByBrand(@PathVariable Long brandId, Model model) {
        List<Product> products = productService.findByBrandBrandId(brandId);
        Brand brand = brandService.findByBrandId(brandId);
        model.addAttribute("products", products);
        model.addAttribute("title", "Thương hiệu " + brand.getBrandName());
        return "layout";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String productName, Model model) {
        List<Product> products = productService.findByProductNameContaining(productName);
        model.addAttribute("products", products);
        return "layout";
    }

    @GetMapping("/detail/{productId}")
    public String productDetail(@PathVariable Long productId, Model model) {
        return "layout";
    }
}
