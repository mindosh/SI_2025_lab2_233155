package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //A
            throw new RuntimeException("Mandatory information missing!"); //B
        }

        if (user.getUsername()==null){ //C
            user.setUsername(user.getEmail()); //D
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //E
            same = 0;
            for (int i=0;i<allUsers.size();i++) { //F (F1:int i=0, F2:i<allUsers.size(), F3:i++)
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { //G
                    same += 1; //H
                }
                if (existingUser.getUsername() == user.getUsername()) { //I
                    same += 1; //J
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //K
            return false; //L
        }
        else {
            if (!passwordLower.contains(" ")) { //M
                for (int i = 0; i < specialCharacters.length(); i++) { //N  (N1: int i = 0, N2: i < specialCharacters.length(), N3: i++)
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //O
                        return same == 0; //P
                    }
                }
            }
        }
        return false; //Q
    }

} //R