/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmain;

/**
 * @author imrong
 */
public class SecurityAudit {
    private double maxTransactionLimit;
    private boolean suspiciousActivity;
    
    public SecurityAudit(double maxTransactionLimit) {
        this.maxTransactionLimit = maxTransactionLimit;
        this.suspiciousActivity = false;
    }
    
    public void auditTransaction(double amount) {
        if (amount > this.maxTransactionLimit) {
            this.suspiciousActivity = true;
            System.out.println("ALERT: Transaksi" + amount + " melebihi max balance dari" + this.maxTransactionLimit + ".");
            System.out.println("ACTION: Akun di flag untuk manual review.");
        } else {
            System.out.println("AUDIT: Nominal transaksi aman.");
        }
    }
    
    public boolean isAccountFlagged() {
        return this.suspiciousActivity;
    }
    
    public void resetFlag() {
        this.suspiciousActivity = false;
        System.out.println("SYSTEM: Security flag dibersihkan.");
    }
}
