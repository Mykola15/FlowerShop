package com.FlowerShop.controller;

import com.FlowerShop.domain.*;
import com.FlowerShop.models.ProductViewModel;
import com.FlowerShop.repos.ProductRepo;
import com.FlowerShop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")

public class AdminController<UserDetailsImpl> {
    @Value("${upload.path}")
    private String upload_path;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "/admin_products";
    }

    @GetMapping("/products/{product}")
    public String productEditForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
        return "productEdit";
    }

    @GetMapping("/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "admin_users";
    }

    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @GetMapping("/product")
    public String addProductPage() {
        return "product";
    }

    @GetMapping("/product_exist")
    public String productExist(Model model) {
        model.addAttribute("product_exist", "Product with such name already exist!!!");
        return "product";
    }


    @GetMapping("/error")
    public String error(){
        return "/error";
    }

    @PostMapping("/product")
    public String addProduct(ProductViewModel productViewModel, @RequestParam("file") MultipartFile file) throws Exception {
        Product product = new Product();
        Product productDB = productRepo.findByName(productViewModel.getName());
        if (productDB != null) {
            return "redirect:/product_exist";
        } else {
            product.setName(productViewModel.getName());
            product.setQuantity(productViewModel.getQuantity());
            product.setPrice(productViewModel.getPrice());
            product.setDescription(productViewModel.getDescription());
            product.setType(productViewModel.getType());
            if (file != null) {
                File uploadDir = new File(upload_path);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(upload_path + "/" + resultFilename));
                product.setPhoto(resultFilename);
            }
            productRepo.save(product);
        }
        return "redirect:/products";
    }


    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            HttpServletRequest request,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String name : request.getParameterMap().keySet()) {
            for (String value : request.getParameterValues(name)) {
                if (roles.contains(value)) {
                    user.getRoles().add(Role.valueOf(value));
                }
            }
        }
        userRepo.save(user);
        return "redirect:/users";
    }

    @PostMapping("/products")
    public String productSave(
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam Integer price,
            @RequestParam String description,
            @RequestParam Integer quantity,
            @RequestParam("productId") Product product) {
        product.setName(name);
        product.setType(type);
        product.setPrice(price);
        product.setDescription(description);
        product.setQuantity(quantity);
        productRepo.save(product);
        return "redirect:/products";
    }

    @ResponseBody
    @PostMapping("/delete_product")
    public void delete_product(
            @RequestParam("id") Product product
    ) {
        productRepo.delete(product);
    }

    @ResponseBody
    @PostMapping("/delete_user")
    public void delete_user(
            @RequestParam("id") User user) {
        userRepo.delete(user);
    }
}