package br.com.evergreenapi.ViewModels;

public class AuthenticationResponseViewModel {
    private final String jwt;
    private final boolean success;
  
    public AuthenticationResponseViewModel(boolean success, String jwt) {
        this.jwt = jwt;
        this.success = success;
    }

    public String getJwt() {
        return jwt;
    }

    public boolean isSuccess() {
        return success;
    }
}
