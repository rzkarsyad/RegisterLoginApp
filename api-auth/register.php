<?php
include 'conn.php';

if ($_POST) {

    // Post Data
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);

    $response = [];

    // Cek username di dalam database
    $userQuery = $connection->prepare("SELECT * FROM user WHERE username = ?");
    $userQuery->execute(array($username));

    // Cek username sudah ada atau belum
    if ($userQuery->rowCount() != 0) {
        $response['status'] = false;
        $response['message'] = "Nama pengguna sudah terdaftar";
    } else {
        $insertAccount = 'INSERT INTO user (name, username, password) VALUES (:name, :username, :password)';
        $statement = $connection->prepare($insertAccount);

        try {
            // Eksekusi statement db
            $statement->execute([
                ':name' => $name,
                ':username' => $username,
                ':password' => md5($password),
            ]);

            $response['status'] = true;
            $response['message'] = "Akun berhasil didaftar";
            $response['data'] = [
                'username' => $username,
                'name' => $name,
            ];
        } catch (Exception $e) {
            die($e->getMessage());
        }
    }

      // Jadikan data yang didapatkan menjadi JSON
      $json = json_encode($response, JSON_PRETTY_PRINT);
      echo $json;
}
