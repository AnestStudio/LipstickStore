package org.anest.mystore.controller.admin;

import org.anest.mystore.service.BrandService;
import org.anest.mystore.service.CategoryService;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public AdminController(
            BrandService brandService,
            ProductService productService,
            CategoryService categoryService
    ) {
        this.brandService = brandService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String goToDashboard() {
        return "pages/admin/dashboard";
    }

    @GetMapping("/orders")
    public String goToOrders() {
        return "pages/admin/orders";
    }

    @GetMapping("/products")
    public String goToProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "pages/admin/products";
    }

    @GetMapping("/categories")
    public String goToCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "pages/admin/categories";
    }

    @GetMapping("/brands")
    public String goToBrands(Model model) {
        model.addAttribute("brands", brandService.findAll());
        return "pages/admin/brands";
    }

//    @GetMapping("/brand/delete/{brandId}")
//    public String deleteBrand(@PathVariable Long brandId, Model model) {
//        model.addAttribute("brands", brandService.findAll());
//        return "pages/admin/brands";
//    }
}
