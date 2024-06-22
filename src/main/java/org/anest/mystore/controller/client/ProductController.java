package org.anest.mystore.controller.client;

import org.anest.mystore.constant.IConstants;
import org.anest.mystore.entity.Brand;
import org.anest.mystore.entity.Category;
import org.anest.mystore.entity.Product;
import org.anest.mystore.exception.BrandNotFoundException;
import org.anest.mystore.exception.CategoryNotFoundException;
import org.anest.mystore.exception.ProductNotFoundException;
import org.anest.mystore.service.BrandService;
import org.anest.mystore.service.CategoryService;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.anest.mystore.constant.IConstants.*;

@Controller
public class ProductController {

    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, BrandService brandService, CategoryService categoryService) {
        this.productService = productService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("title", TITLE_PRODUCT_LIST_TEXT);
        model.addAttribute("description", PRODUCT_LIST_DESCRIPTION);
        initDataFilter(model);
        return "pages/product/products";
    }

    @GetMapping("/products")
    public String listProducts(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size
    ) {
        Page<Product> productPage = productService.findPaginated(page, size);
        model.addAttribute("productPage", productPage);
        model.addAttribute("title", TITLE_PRODUCT_LIST_TEXT);
        model.addAttribute("description", PRODUCT_LIST_DESCRIPTION);
        initDataFilter(model);
        return "pages/product/products2";
    }

    @GetMapping("/lipstick-type/{categoryId}")
    public String findByType(@PathVariable Long categoryId, Model model) {
        List<Product> products = productService.findByCategoryId(categoryId);
        Category category = categoryService.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        model.addAttribute("products", products);
        model.addAttribute("title", category.getCategoryName());
        model.addAttribute("description", category.getCategoryDescription());
        initDataFilter(model);
        return "pages/product/products-filter";
    }

    @GetMapping("/lipstick-brand/{brandId}")
    public String findByBrand(@PathVariable Long brandId, Model model) {
        List<Product> products = productService.findByBrandId(brandId);
        Brand brand = brandService.findById(brandId).orElseThrow(() -> new BrandNotFoundException("Brand not found"));
        model.addAttribute("products", products);
        model.addAttribute("title", TITLE_BRAND_TEXT + brand.getBrandName());
        model.addAttribute("description", brand.getBrandDescription());
        initDataFilter(model);
        return "pages/product/products-filter";
    }

    @GetMapping("/lipstick/search")
    public String searchByName(@RequestParam String productName, Model model) {
        List<Product> products = productService.findByProductNameContaining(productName);
        model.addAttribute("products", products);
        model.addAttribute("title", TITLE_RESULT_SEARCH_TEXT + productName);
        model.addAttribute("description", "");
        initDataFilter(model);
        return "pages/product/products-filter";
    }

    @GetMapping("/lipstick/sort")
    public String sortByPrice(@RequestParam(name = "type") String sortType, Model model) {
        if (!sortType.toLowerCase().matches(IConstants.SORT_TYPE_REGEX)) {
            return "error400";
        }
        List<Product> products = productService.getAllSorted(sortType);
        model.addAttribute("products", products);
        model.addAttribute("title", TITLE_PRODUCT_LIST_TEXT);
        model.addAttribute(
                "description",
                SORT_PRODUCT_DESCRIPTION + (sortType.equalsIgnoreCase("ASC") ? "tăng dần." : "giảm dần.")
        );
        initDataFilter(model);
        return "pages/product/products-filter";
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
        return "pages/product/product-detail";
    }

    private void initDataFilter(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
    }

    private void initData(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
    }
}
