package com.FlowerShop.models;
import com.FlowerShop.domain.User;
public class RegistrationViewModel {
    String username;
    String email;
    String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public RegistrationViewModel() {
    }

    public RegistrationViewModel(User user) {
        setUsername(user.getUsername());
        setEmail(user.getEmail());
        setPassword(user.getPassword());

    }
}
