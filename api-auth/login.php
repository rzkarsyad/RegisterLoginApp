<?php
include 'conn.php';

if ($_POST) {

    // Data
    $username = $_POST['username'] ?? '';
    $password = $_POST['password'] ?? '';

    $response = []; //Data Responses

    // Cek username di dalam database
    $userQuery = $connection->prepare("SELECT * FROM user WHERE username = ?");
    $userQuery->execute(array($username));
    $query = $userQuery->fetch();

    if ($userQuery->rowCount() == 0) {
        $response['status'] = false;
        $response['message'] = "Pengguna tidak terdaftar";
    } else {
        
        // Mengambil password dari database
        $passwordDB = $query['password'];
        
        if (strcmp(md5($password), $passwordDB) == 0) {
            $response['status'] = true;
            $response['message'] = "Login berhasil";
            $response['data'] = [
                'user_id' => $query['id'],
                'username' => $query['username'],
                'name' => $query['name']
            ];
        } else {
            $response['status'] = false;
            $response['message'] = "Kata sandi salah";
        }
    }

    // Jadikan data yang didapatkan menjadi JSON
    $json = json_encode($response, JSON_PRETTY_PRINT);
    echo $json;

}
