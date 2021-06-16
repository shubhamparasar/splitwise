package com.splitwise;

import com.splitwise.controllers.ExpenseController;
import com.splitwise.controllers.UserController;
import com.splitwise.repositories.ExpenseRepository;
import com.splitwise.repositories.GroupRepository;
import com.splitwise.repositories.userRepository;
import com.splitwise.services.authentication.DefaultPasswordEncoder;
import com.splitwise.services.authentication.PasswordEncoder;
import com.splitwise.services.authentication.console.commands.ExitCommand;
import com.splitwise.services.authentication.console.commands.RegisterUserCommand;
import com.splitwise.services.authentication.console.handler.CommandHandler;
import com.splitwise.services.authentication.console.handler.ICommandHandler;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Splitwise splitwise= new Splitwise();

        ICommandHandler commandHandler=new CommandHandler();
        commandHandler.registerCommand(new RegisterUserCommand(splitwise));
        commandHandler.registerCommand(new ExitCommand());

        while (true){
            System.out.println("\n> ");
            List<String> input= Arrays.asList(br.readLine().split(" "));
            try{
                commandHandler.execute(input);
            }
            catch (Exception e){
                 System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
                 System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
