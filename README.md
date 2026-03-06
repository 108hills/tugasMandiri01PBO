# Secure Bank Account System
## Penjelasan Desain Class
Sistem ini dirancang untuk mendemonstrasikan prinsip OOP *Encapsulation* secara nyata. Berikut adalah penjelasan struktur dari setiap class:

### 1. `BankAccount.java`
Class ini menangani penyimpanan dan mutasi dana secara aman.
* Atribut Private (Hidden Data): accountNumber (String), balance (double).
* Validation Logic:
  * BankAccount() (Constructor): Memvalidasi agar saldo awal (initBalance) tidak boleh bernilai negatif saat pembuatan objek. Jika negatif, sistem mengaturnya ke 0.0.
  * deposit(double amount): Mencegah angka negatif atau nol masuk sebagai setoran.
  * withdraw(double amount): Memastikan nominal penarikan lebih dari nol dan tidak melampaui sisa saldo (balance) yang tersedia.

### 2. `Customer.java`
Class ini mengelola profil nasabah secara terisolasi.
* Atribut Private (Hidden Data): customerID (String), fullName (String), email (String).
* Validation Logic:
  * setEmail(String email): Bertindak sebagai setter dengan filter ketat. Method ini memvalidasi bahwa input wajib memiliki karakter @ dan . sebelum state atribut email diizinkan untuk berubah.

### 3. `SecurityAudit.java`
Class ini berfungsi sebagai sistem deteksi anomali (rule-based) untuk melindungi transaksi akun.
* Atribut Private (Hidden Data): maxTransactionLimit (double), suspiciousActivity (boolean).
* Validation Logic:
  * auditTransaction(double amount): Memantau ukuran transaksi. Jika nominal melebihi ambang batas (maxTransactionLimit), sistem akan mengubah status flag suspiciousActivity menjadi true, yang digunakan oleh sistem utama untuk memblokir mutasi dana.

### 4. `BankMain.java`
Ini adalah class eksekusi utama yang memiliki method main().
* Class ini menginisialisasi dan menghubungkan objek dari BankAccount, Customer, dan SecurityAudit.
* Menggunakan library Scanner untuk menangkap input dinamis dan menggunakan siklus infinite loop (while (true)) yang dipadukan dengan percabangan switch-case untuk membuat menu interaktif berbasis terminal (Profile, Deposit, Withdrawal, Exit).
