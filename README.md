# Register Login Android App
Aplikasi ini merupakan aplikasi dasar sistem register dan login. Aplikasi ini saya buat sebagai hasil belajar saya tentang pemrograman android.
Tidak hanya sebagai hasil belajar, aplikasi ini juga saya gunakan sebagai template jika saya ingin membuat sebuah aplikasi yang menggunakan sistem register dan login. Anda juga dapat menggunakan project ini sebagai penunjang belajar atau pekerjaan.

## Fitur
- Register
- Login
- Logout
- Session
- Validasi Registrasi :  
  - Kolom tidak boleh kosong
  - Nama pengguna sudah terdaftar  
- Validasi Login :  
  - Kolom tidak boleh kosong
  - Nama pengguna belum terdaftar
  - Kata sandi salah
- Halaman MainActivity yang menampilkan username dan nama pengguna yang telah login

## Tangkapan Layar
![Screenshot_1628474117](https://user-images.githubusercontent.com/62179572/128653415-edb2dad0-c0ff-4e13-9f2d-102b250984c1.png)
![Screenshot_1628474121](https://user-images.githubusercontent.com/62179572/128653417-4ef235e6-1be6-45ba-925c-5028f5d81578.png)
![Screenshot_1628474135](https://user-images.githubusercontent.com/62179572/128653414-c4adbeb1-2083-4469-9fe2-16235dfcd089.png)

## Instalasi
1. Clone repository ini
```
https://github.com/rzkarsyad/RegisterLoginApp.git
```
2. Buat database dengan nama **db-auth** lalu import database
3. Pindahkan folder **api-auth** ke dalam **localhost/htdocs** (di sini saya menggunakan XAMPP)
4. Buka Project **RegisterLoginApp** di Android Studio
5. Ubah alamat IP agar sesaui dengan device kalian di file:
   - ApiClient.java
   - network-security-config.xml (letaknya di res->xml)
6. Jalankan


## Pembuat
Rizki Muhammad Aulia Arsyad
