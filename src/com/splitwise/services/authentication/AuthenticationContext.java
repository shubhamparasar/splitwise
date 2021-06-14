package com.splitwise.services.authentication;

import com.splitwise.models.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthenticationContext {
    Optional<User> getCurrentlyLoggedInUser();
    Boolean isAuthenticated();
}
