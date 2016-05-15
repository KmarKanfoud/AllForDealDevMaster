/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author maroo
 */
public class User {

    public static int id;
    public static String firstName;
    private String lastName;
    public static String username;
    private String password;
    private String email;
    private String roles;
    private int enabled;
    private int bonus;
    private String image;
    private Date birth_date; 
    

    

    public User() {
    }

    public User(int id, String firstName, String lastName, String username, String email, String roles, int enabled, int bonus, String image, Date birth_date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.enabled = enabled;
        this.bonus = bonus;
        this.image = image;
        this.birth_date = birth_date;
    }

    public String toString() {
        return "User{" + "lastName=" + lastName + ", password=" + password + ", email=" + email + ", roles=" + roles + ", enabled=" + enabled + ", bonus=" + bonus + ", image=" + image + ", birth_date=" + birth_date + '}';
    }



    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }
//    public void setBirth_date(String birth_date) {
//        this.birth_date = stringToDate(birth_date);
//    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//
//    public Date stringToDate(String s) {
//        Calendar c = Calendar.getInstance();
//
//        c.set(Calendar.YEAR, Integer.parseInt(s.substring(0, 4)));
//        c.set(Calendar.MONTH, Integer.parseInt(s.substring(5, 7)));
//        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(s.substring(8, 10)));
//
//        return c.getTime();
//    }

}
