package org.anest.mystore.controller.client;

import org.anest.mystore.entity.Brand;
import org.anest.mystore.entity.Category;
import org.anest.mystore.entity.Color;
import org.anest.mystore.entity.Product;
import org.anest.mystore.exception.ProductNotFoundException;
import org.anest.mystore.service.BrandService;
import org.anest.mystore.service.CategoryService;
import org.anest.mystore.service.ColorService;
import org.anest.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.anest.mystore.constant.IConstants.*;

@Controller
public class ProductController {

    private final ProductService productService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ColorService colorService;

    @Autowired
    public ProductController(
            ProductService productService,
            BrandService brandService,
            CategoryService categoryService,
            ColorService colorService
    ) {
        this.productService = productService;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.colorService = colorService;
    }

    @GetMapping("")
    public String index(Model model) {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String filterProducts(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(required = false) String categoryIds,
            @RequestParam(required = false) String brandIds,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "ASC") String sortDir
    ) {
        List<Long> categoryIdList = (categoryIds != null && !categoryIds.isEmpty())
                ? Arrays.stream(categoryIds.split(",")).map(Long::parseLong).collect(Collectors.toList())
                : null;

        List<Long> brandIdList = (brandIds != null && !brandIds.isEmpty())
                ? Arrays.stream(brandIds.split(",")).map(Long::parseLong).collect(Collectors.toList())
                : null;

        page = (page <= 0) ? 0 : page;
        Page<Product> productPage = productService.findProducts(
                categoryIdList, brandIdList, color, name,
                minPrice, maxPrice,
                sortField, sortDir,
                page,
                size
        );

        // If the user enters a page number in the url is greater than the calculated page number
        if (!productPage.hasContent() && productPage.getTotalElements() != 0) {
            page = 0;
            productPage = productService.findProducts(
                    categoryIdList, brandIdList, color, name,
                    minPrice, maxPrice,
                    sortField, sortDir,
                    page,
                    size
            );
        }

        model.addAttribute("resultPage", productPage);
        model.addAttribute("title", TITLE_PRODUCT_LIST_TEXT);
        model.addAttribute("description", PRODUCT_LIST_DESCRIPTION);
        initData(model);
        pagingData(categoryIds, brandIds, color, name, minPrice, maxPrice, sortField, sortDir, model);

        if ((categoryIds == null || categoryIds.isEmpty())
                && (brandIds == null || brandIds.isEmpty())
                && (color == null || color.isEmpty())
                && (name == null || name.isEmpty())
                && minPrice == null
                && maxPrice == null
                && sortField.equals("id")
        ) {
            return "pages/client/product/products";
        }

        List<Color> colors = colorService.findAll();
        model.addAttribute("colors", colors);
        return "pages/client/product/products-filter";
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
        return "pages/client/product/product-detail";
    }

    private void pagingData(
            String categoryIds, String brandIds, String color, String name,
            Double minPrice, Double maxPrice,
            String sortField, String sortDir,
            Model model
    ) {
        model.addAttribute("categoryIds", categoryIds);
        model.addAttribute("brandIds", brandIds);
        model.addAttribute("color", color);
        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
    }

    private void initData(Model model) {
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
    }
}
