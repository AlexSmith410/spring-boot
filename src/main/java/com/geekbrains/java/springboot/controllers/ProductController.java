package com.geekbrains.java.springboot.controllers;

import com.geekbrains.java.springboot.models.Product;
import com.geekbrains.java.springboot.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("Products", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/show_product/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        model.addAttribute("Products", productService.getProductById(id));
        return "product_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.removeProductById(id);
        return "redirect:/products/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("Products", productService.getProductById(id));
        return "product_edit_page";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/add")
    public String showProductAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }

}