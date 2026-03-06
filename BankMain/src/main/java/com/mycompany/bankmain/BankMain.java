/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankmain;

/**
 * @author imrong
 */

public class BankMain {

    public static void main(String[] args) {
        private String accountNumber;
        private double balance;
        
        public BankAccount(String accountNum, double initBalance) {
            this.accountNumber = accountNum;
            
            if (initBalance >= 0 ) {
                this.balance = initBalance;
            } else {
                this.balance = 0.0;
                System.out.println("Balance berada pada negatif/kosong, default 0.");
            }
        }
        
        public String getAccNumber() {
            return this.accountNumber;
        }
        
        public double getBal() {
            return this.balance;
        }
        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Berhasil. Deposit:" + amount);
            } else {
                System.out.println("Deposit gagal. Nominal harus lebih dari 0.");
            }
        }
        
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdraw gagal. Nominal harus lebih dari 0.");
            } else if (amount > this.balance) {
                System.out.println("Withdraw gagal. Nominal harus kurang dari/sama dengan Balance. Balance:" + this.balance);
            } else {
                this.balance -= amount;
                System.out.println("Withdraw" + amount + " berhasil.");
            }
        }
    }
}

