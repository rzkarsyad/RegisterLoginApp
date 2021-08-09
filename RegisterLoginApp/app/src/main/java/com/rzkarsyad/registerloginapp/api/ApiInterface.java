package com.rzkarsyad.registerloginapp.api;

import com.rzkarsyad.registerloginapp.model.login.Login;
import com.rzkarsyad.registerloginapp.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password
    );

}
