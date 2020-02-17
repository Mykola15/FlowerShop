package com.FlowerShop.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;
    private Integer price;
    private String description;
    private String type;
    private String photo;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeList> listLists;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts;
    public Product() {
    }

    public Product(Integer price, Integer quantity, String name, String description,String type, String photo) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.photo = photo;
        listLists = new ArrayList<>();
        carts = new ArrayList<>();

    }
    public void addCart(Cart cart) {
        cart.setProduct(this);
        carts.add(cart);
    }

    public void removeCart(Cart cart) {
        carts.remove(cart);
    }

    public void addLikeList(LikeList likeList) {
        likeList.setProduct(this);
        listLists.add(likeList);
    }

    public void removeLikeList(LikeList likeList) {
        listLists.remove(likeList);
    }
    public List<LikeList> getListList() {
        return listLists;
    }

    public void setListList(List<LikeList> listLists) {
        this.listLists = listLists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
