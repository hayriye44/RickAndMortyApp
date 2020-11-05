package com.example.rickandmorty.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rickandmorty.model.CharactersItem;
import com.example.rickandmorty.R;
import com.example.rickandmorty.util.AutoFitGridLayoutManager;

import java.util.List;

public class CharacterListActivity extends AppCompatActivity {

    CharacterViewModel characterViewModel;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.character_list);
        characterViewModel= ViewModelProviders.of(this).get(CharacterViewModel.class);
        characterViewModel.getCharacters();
        final CharacterListAdapter adapter = new CharacterListAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        int span = AutoFitGridLayoutManager.calculateNoOfColumns(getApplicationContext(), 196);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), span);
        recyclerView.setLayoutManager(gridLayoutManager);

        characterViewModel.charactersMutableLiveData.observe(this, new Observer<List<CharactersItem>>() {
            @Override
            public void onChanged(List<CharactersItem> postModels) {
                adapter.setList(postModels);
            }
        });


    }

}