<?php

$connection = null;

try {
    // config
    $host = "localhost";
    $username = "root";
    $password = "";
    $dbname = "db-auth";
    
    // connect
    $database = "mysql:dbname=$dbname;host=$host";
    $connection = new PDO($database, $username, $password);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Cek koneksi
    // if($connection){
    //     echo "Koneksi berhasil!";
    // } else {
    //     echo "Gagal menyambungkan";
    // }

} catch (PDOException $e) {
    echo "Error! " . $e->getMessage();
    die;
}