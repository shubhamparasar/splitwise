package com.splitwise.controllers;

import com.splitwise.dtos.UserDTO;
import com.splitwise.exceptions.DuplicateUserNameException;
import com.splitwise.exceptions.NotLoggedInException;
import com.splitwise.exceptions.PasswordMismatchException;
import com.splitwise.models.Expense;
import com.splitwise.models.Group;
import com.splitwise.models.User;
import com.splitwise.repositories.userRepository;
import com.splitwise.services.authentication.AuthenticationContext;
import com.splitwise.services.authentication.PasswordEncoder;

import java.util.List;

public class UserController {

    userRepository userRepository;
    PasswordEncoder passwordEncoder=null;

    public  UserController( userRepository userRepository ){
        this.userRepository=userRepository;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    public User register(UserDTO details){
            User user=new User();
            user.setPhoneNumber(details.phoneNumber);
            user.setFullName(details.fullName);
        if (!userRepository.findByUserName(details.userName).isEmpty()){
            throw new DuplicateUserNameException("Duplicate Username");
        }
        user.setUserName(details.userName);
        String saltedHashedPassword= passwordEncoder.encode(details.password, details.userName);
        user.setHashedSaltedPassword(saltedHashedPassword);
        userRepository.create(user);
        return user;
    }

    public void ChangePassword(AuthenticationContext authenticationContext, String oldPassword, String newPassword){
            User user=authenticationContext.
                    getCurrentlyLoggedInUser().
                    orElseThrow(()-> new NotLoggedInException("User not logged in"));
            if(!user.getHashedSaltedPassword().equals(passwordEncoder.encode(oldPassword, user.getUserName()))){
                throw new PasswordMismatchException("wrong password");
            }
            user.setHashedSaltedPassword(passwordEncoder.encode(newPassword,user.getUserName()));
            userRepository.Save(user);
    }

    public void updateProfile(UserDTO details, AuthenticationContext authenticationContext){
        User user=authenticationContext.
                getCurrentlyLoggedInUser().
                orElseThrow(()-> new NotLoggedInException("User not logged in"));
        user.setPhoneNumber(details.phoneNumber);
        user.setFullName(details.fullName);
        userRepository.Save(user);
    }

    public double totalAmountOwed(AuthenticationContext authenticationContext){
        User user=authenticationContext.
                getCurrentlyLoggedInUser().
                orElseThrow(()-> new NotLoggedInException("User not logged in"));
        double totalAmount=user.getTotalAmount();
        return totalAmount;

    }

    public List<Expense> getMyExpenseHistory(AuthenticationContext authenticationContext){
            User user=authenticationContext.
                    getCurrentlyLoggedInUser().
                    orElseThrow(()-> new NotLoggedInException("User not logged in"));
            List<Expense> myExpenseHistory = user.getExpenses();
            return  myExpenseHistory;
    }

    public List<Group> getMyGroups(AuthenticationContext authenticationContext){
            User user= authenticationContext.
                    getCurrentlyLoggedInUser().
                    orElseThrow(()->new NotLoggedInException("User not logged in"));
            List<Group> myGroups= user.getGroups();
            return myGroups;
    }
}
