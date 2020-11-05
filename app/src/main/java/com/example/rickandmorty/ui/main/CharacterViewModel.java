package com.example.rickandmorty.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.rickandmorty.model.Character;
import com.example.rickandmorty.model.CharactersItem;
import com.example.rickandmorty.RestApi.ManagerAll;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {
    MutableLiveData<List<CharactersItem>> charactersMutableLiveData =new MutableLiveData<>();
    MutableLiveData<String> characters = new MutableLiveData<>();

    public void getCharacters() {
        Call<Character> request = ManagerAll.getInstance().characterList();
        request.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                    charactersMutableLiveData.setValue(response.body().getCharacters());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                characters.setValue("errr");
            }
        });
    }



}



