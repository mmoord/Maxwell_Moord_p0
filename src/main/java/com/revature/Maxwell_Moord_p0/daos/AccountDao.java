package com.revature.Maxwell_Moord_p0.daos;

import com.revature.Maxwell_Moord_p0.models.Account;
import com.revature.Maxwell_Moord_p0.services.AccountServices;
import com.revature.Maxwell_Moord_p0.util.ConnectionFactory;

import java.sql.*;

public class AccountDao {



    public static Account create(Account newUser) {
        System.out.println("Here is the newUser as it enters our DAO layer: "+ newUser); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal

        try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "insert into usr_data (id, email, username, password) values (default,?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // 1-indexed, so first ? starts are 1
            ps.setString(1, newUser.getEmail());
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());

            int checkInsert = ps.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e){
            e.printStackTrace();
            return null;
        }
        return newUser;
    }

    public Account[] findUsers(){

        Account[] accounts = new Account[10];
        int index =0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "select * from usr_data";
            Statement s = conn.createStatement();

            ResultSet rs =s.executeQuery(sql);

            while (rs.next()) {
                Account account = new Account();

                account.setEmail(rs.getString("email"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                accounts[index] = account;
                index++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


        return (accounts);
    }

    public void pullUsernames(Account newUser) {
        AccountServices accountServices = new AccountServices();
        String username = null;
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "select * from usr_data";
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                username = rs.getString("username");
                accountServices.verifyNewUsername(username, newUser);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
