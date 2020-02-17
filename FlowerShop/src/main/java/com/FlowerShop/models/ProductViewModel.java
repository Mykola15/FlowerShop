package com.FlowerShop.models;

import com.FlowerShop.domain.Product;

public class ProductViewModel {
    String name;
    Integer quantity;
    Integer price;
    String description;
    String type;
    String photo;

    public ProductViewModel() {
    }

    public ProductViewModel(Product product) {
        setName(product.getName());
        setDescription(product.getDescription());
        setQuantity(product.getQuantity());
        setPrice(product.getPrice());
        setType(product.getType());
        setPhoto(product.getPhoto());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
