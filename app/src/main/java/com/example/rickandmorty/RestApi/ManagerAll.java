package com.example.rickandmorty.RestApi;

import com.example.rickandmorty.model.Character;
import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }


    public Call<Character> characterList() {
        Call<Character> x=getRestApi().characters();
        return x;
    }




}
