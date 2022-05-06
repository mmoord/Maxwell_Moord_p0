package com.revature.Maxwell_Moord_p0.menus;
import java.util.*;
import com.revature.Maxwell_Moord_p0.models.Account;
import com.revature.Maxwell_Moord_p0.services.AccountServices;
public class CreateAccountMenu extends Menu{


    public CreateAccountMenu(Scanner kb) {super(kb);}

    //TODO: Fix Scanner Issues, Scanner Moment

    public void render() throws Exception{
        String prompt = "Please enter your ";
        String emailPrompt = "email: ";
        String usernamePrompt = "username: ";
        String passwordPrompt = "password: ";
        String passwordAgainPrompt = "password again: ";

        System.out.printf("%s%s", prompt,emailPrompt);
        String email = kb.nextLine();
        System.out.printf("%s%s", prompt,usernamePrompt);
        String username = kb.nextLine();
        System.out.printf("%s%s", prompt,passwordPrompt);
        String password = kb.nextLine();
        System.out.printf("%s%s", prompt,passwordAgainPrompt);
        String passwordAgain = kb.nextLine();

        if (!password.equals(passwordAgain)) {
            System.out.println("Passwords do not match");
            return;
        }

        System.out.printf(" %s %s \n %s %s \n %s %s \n ",emailPrompt,email,usernamePrompt,username,passwordPrompt,password);
        Account newUser = new Account(email,username,password);
        System.out.println(newUser);
        AccountServices.validateUserInput(newUser);

    }

}
