package com.revature.Maxwell_Moord_p0.services;

import com.revature.Maxwell_Moord_p0.daos.AccountDao;
import com.revature.Maxwell_Moord_p0.models.Account;

public class AccountServices {

    public static boolean validateUserInput(Account newUser) {
        System.out.println("Validating User: " + newUser);
        if(newUser == null) return false;
        if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) return false;
        if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) return false;
        if(newUser.getPassword() == null || newUser.getPassword().trim().equals("")) return false;
        System.out.println("The User Has been Validated");
        AccountDao.create(newUser);
        return true;
    }

}
