package com.FlowerShop.repos;

import com.FlowerShop.domain.Cart;
import com.FlowerShop.domain.LikeList;
import com.FlowerShop.domain.Product;
import com.FlowerShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser (User user);
    Cart findByUserAndProduct(User user,Product product);

}
