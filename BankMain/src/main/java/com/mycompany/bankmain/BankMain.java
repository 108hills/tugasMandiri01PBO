/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankmain;
import java.util.Scanner;
/**
 * @author imrong
 */

public class BankMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Customer nasabah = new Customer("C-8842", "Alex");
        BankAccount akun = new BankAccount("ACC-0001", 500.0);
        SecurityAudit audit = new SecurityAudit(10000.0);
        
        nasabah.setEmail("alex@securemail.com");
        
        System.out.println("=== Selamat Datang di Sistem Bank ===");

        OUTER:
        while (true) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Profile");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
            System.out.print("Pilih opsi (1-4): ");
            
            int opsi = input.nextInt();
            switch (opsi) {
                case 1 -> {
                    System.out.println("\n--- Profil Nasabah ---");
                    System.out.println(nasabah.displayProfile());
                    System.out.println("Nomor Rekening: " + akun.getAccNumber());
                    System.out.println("Saldo Saat Ini: $" + akun.getBal());
                }
                case 2 -> {
                    System.out.print("\nMasukkan nominal Deposit: $");
                    double depositAmount = input.nextDouble();

                    audit.auditTransaction(depositAmount);

                    if (!audit.isAccountFlagged()) {
                        akun.deposit(depositAmount);
                    } else {
                        System.out.println("SYSTEM: Transaksi dibatalkan karena alasan keamanan.");
                    }
                }
                case 3 -> {
                    System.out.print("\nMasukkan nominal Withdrawal: $");
                    double withdrawAmount = input.nextDouble();

                    audit.auditTransaction(withdrawAmount);

                    if (!audit.isAccountFlagged()) {
                        akun.withdraw(withdrawAmount);
                    } else {
                        System.out.println("SYSTEM: Transaksi dibatalkan karena alasan keamanan.");
                    }
                }
                case 4 -> {
                    System.out.println("\nTerima kasih telah menggunakan layanan kami. Sistem ditutup.");
                    break OUTER;
                }
                default -> System.out.println("\nSYSTEM: Opsi tidak valid. Silakan masukkan angka 1 hingga 4.");
            }
        }
        
        input.close();
    }
}

