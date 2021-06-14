package com.splitwise.services.authentication;

public class DefaultPasswordEncoder implements PasswordEncoder{
    @Override
    public String encode(String password, String username) {
        return password;
    }
}
