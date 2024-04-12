/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Nguyen Anh Trinh
 */
public class User implements Serializable{
    private String UserName;
    private String Password;

    public User(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    @Override
    public boolean equals(Object obj){
      User u = (User) obj;
      if(this.getUserName().equals(u.getUserName())&&this.getPassword().equals(u.getPassword())){
          return true;
      }
      return false;
    }
    @Override
    public String toString() {
        return String.format("%s %s", UserName,Password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
