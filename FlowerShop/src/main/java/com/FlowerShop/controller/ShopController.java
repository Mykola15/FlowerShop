package com.FlowerShop.controller;

import com.FlowerShop.domain.*;
import com.FlowerShop.repos.CartRepo;
import com.FlowerShop.repos.LikeListRepo;
import com.FlowerShop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private LikeListRepo likeListRepo;

    @GetMapping("/")
    public String start(@AuthenticationPrincipal Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "/startpage";
    }

    @GetMapping("/startpage")
    public String startpage(@AuthenticationPrincipal Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "/startpage";
    }

    @GetMapping("/cart")
    public String cart(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("products", cartRepo.findAllByUser(user));
        return "/cart";
    }

    @GetMapping("/like_list")
    public String like_list(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("products", likeListRepo.findAllByUser(user));
        return "like_list";
    }

    @GetMapping("/startpage/{type}")
    public String sortByType(@PathVariable("type") String type, Model model) {
        model.addAttribute("products", productRepo.findByType(type));
        return "/startpage";
    }

    @ResponseBody
    @PostMapping("/to_like_list")
    public void to_like_list(
            @AuthenticationPrincipal User user,
            @RequestParam("id") Product product,
            @RequestParam Integer value) {
        LikeList likeList = new LikeList();
        if (value == 1 && likeListRepo.findByUserAndProduct(user, product) == null) {
            likeList.setUser(user);
            likeList.setProduct(product);
            likeListRepo.save(likeList);
        }
        if (value == 0 && likeListRepo.findByUserAndProduct(user, product) != null) {
            likeListRepo.delete(likeListRepo.findByUserAndProduct(user, product));
        }
    }

    @ResponseBody
    @PostMapping("/from_like_list")
    public void from_like_list(
            @RequestParam("id") LikeList likeList) {
        likeListRepo.delete(likeList);
    }

    @ResponseBody
    @PostMapping("/from_cart")
    public int from_cart(
            @RequestParam("id") Cart cart,
            @AuthenticationPrincipal User user) {
        cartRepo.delete(cart);

        List<Cart> carts = cartRepo.findAllByUser(user);
        int price = 0;
        for (Cart car : carts) {
            price += car.getQuantity() * car.getProduct().getPrice();
        }
        return price;
    }


    @PostMapping("/to_cart")
    public String to_cart(
            @AuthenticationPrincipal User user,
            @RequestParam("productId") Product product,
            @RequestParam Integer quantity) {
        if(cartRepo.findByUserAndProduct(user,product)==null) {
            Cart cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cartRepo.save(cart);
        }
        return "redirect:/startpage";
    }

    @ResponseBody
    @PostMapping("/content")
    public List<Product> content() {
        return productRepo.findAll();
    }


    @ResponseBody
    @PostMapping("/price")
    public int price(@AuthenticationPrincipal User user) {
        List<Cart> carts = cartRepo.findAllByUser(user);
        int price = 0;
        for (Cart cart : carts) {
            price += cart.getQuantity() * cart.getProduct().getPrice();
        }
        return price;
    }

    @ResponseBody
    @PostMapping("/change_quantity")
    public int change_quantity(
            @AuthenticationPrincipal User user,
            @RequestParam("id") Cart car,
            @RequestParam Integer value) {
        car.setQuantity(value);
        cartRepo.save(car);
        List<Cart> carts = cartRepo.findAllByUser(user);
        int price = 0;
        for (Cart cart : carts) {
            price += cart.getQuantity() * cart.getProduct().getPrice();
        }

        return price;
    }
}
