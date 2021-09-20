package br.com.evergreenapi.ViewModels;

import br.com.evergreenapi.Domain.User;

public class NewUserResponse {
    private User user;
    private String message;
    private boolean success;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
