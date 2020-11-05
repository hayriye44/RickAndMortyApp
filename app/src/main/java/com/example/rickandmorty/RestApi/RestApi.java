package com.example.rickandmorty.RestApi;

import com.example.rickandmorty.model.Character;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RestApi {

   @GET("character")
   Call<Character> characters();



}
