package org.anest.mystore.controller;

import org.anest.mystore.constant.IConstant;
import org.anest.mystore.entity.Brand;
import org.anest.mystore.entity.Category;
import org.anest.mystore.entity.Product;
import org.anest.mystore.exception.BrandNotFoundException;
import org.anest.mystore.exception.ProductNotFoundException;
import org.anest.mystore.service.BrandService;
import org.anest.mystore.service.CategoryService;
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

    private final String PRODUCT_LIST_TEXT = "Danh sách sản phẩm";

    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, BrandService brandService, CategoryService categoryService) {
        this.productService = productService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("title", PRODUCT_LIST_TEXT);
        initData(model);
        return "pages/products";
    }

    @GetMapping("/lipstick-type/{categoryId}")
    public String findByType(@PathVariable Long categoryId, Model model) {
        List<Product> products = productService.findByCategoryId(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("title", PRODUCT_LIST_TEXT);
        return "pages/products";
    }

    @GetMapping("/lipstick-brand/{brandId}")
    public String findByBrand(@PathVariable Long brandId, Model model) {
        List<Product> products = productService.findByBrandId(brandId);
        Brand brand = brandService.findById(brandId).orElseThrow(() -> new BrandNotFoundException("Brand not found"));
        model.addAttribute("products", products);
        model.addAttribute("brand", brand);
        initData(model);
        return "pages/products-filter";
    }

    @GetMapping("/lipstick/search")
    public String searchByName(@RequestParam String productName, Model model) {
        List<Product> products = productService.findByProductNameContaining(productName);
        model.addAttribute("products", products);
        model.addAttribute("title", "Kết quả tìm kiếm: " + productName);
        return "pages/products";
    }

    @GetMapping("/lipstick/sort")
    public String sortByPrice(@RequestParam(name = "type") String sortType, Model model) {
        if (!sortType.toLowerCase().matches(IConstant.SORT_TYPE_REGEX)) {
            return "error400";
        }
        List<Product> products = productService.getAllSorted(sortType);
        model.addAttribute("products", products);
        model.addAttribute("title", PRODUCT_LIST_TEXT);
        return "pages/products";
    }

    @GetMapping("/lipstick/detail/{productId}")
    public String productDetail(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
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

    private void initData(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
    }
}
