package com.FlowerShop.repos;


import com.FlowerShop.domain.LikeList;
import com.FlowerShop.domain.Product;
import com.FlowerShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeListRepo extends JpaRepository<LikeList, Long> {
    List<LikeList> findAllByUser(User user);

    LikeList findByUserAndProduct(User user, Product product);
}
