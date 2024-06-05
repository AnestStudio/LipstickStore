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

import java.util.ArrayList;
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
        return "pages/products";
    }

    @GetMapping("/lipstick-type/{categoryId}")
    public String findByType(@PathVariable Long categoryId, Model model) {
        List<Product> products = productService.findByCategoryId(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("title", "Danh sách sản phẩm");
        return "pages/products";
    }

    @GetMapping("/lipstick-brand/{brandId}")
    public String findByBrand(@PathVariable Long brandId, Model model) {
        List<Product> products = productService.findByBrandId(brandId);
        Brand brand = brandService.findById(brandId).orElse(null);
        model.addAttribute("products", products);
        model.addAttribute("title", "Thương hiệu " + brand.getBrandName());
        return "pages/products";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String productName, Model model) {
        List<Product> products = productService.findByProductNameContaining(productName);
        model.addAttribute("products", products);
        model.addAttribute("title", "Kết quả tìm kiếm: " + productName);
        return "pages/products";
    }

    @GetMapping("/detail/{productId}")
    public String productDetail(@PathVariable Long productId, Model model) {

        Product product = productService.findById(productId).orElse(null);
        model.addAttribute("product", product);


        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        model.addAttribute("products", products);
        return "pages/product-detail";
    }
}
