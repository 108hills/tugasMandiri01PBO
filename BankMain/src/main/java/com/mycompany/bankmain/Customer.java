/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmain;

/**
 * @author imrong
 */
public class Customer {
    private String customerID;
    private String fullName;
    private String email;
    
    public Customer(String customerID, String fullName) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.email = "Belum ada";
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
            System.out.println("Email berhasil diupdate.");
        } else {
            System.out.println("Error: format salah.");
        }
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String displayProfile() {
        System.out.println("Customer ID: " + this.customerID + " | Nama: " + this.fullName + " | Email: " + this.email);
    }
}
