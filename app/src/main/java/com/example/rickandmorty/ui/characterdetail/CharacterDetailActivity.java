package com.example.rickandmorty.ui.characterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.rickandmorty.model.CharactersItem;
import com.example.rickandmorty.R;
import com.example.rickandmorty.databinding.ActivityCharacterDetailBinding;
public class CharacterDetailActivity extends AppCompatActivity {

    CharactersItem character;
    ActivityCharacterDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Bundle extras = getIntent().getExtras();
        character=(CharactersItem)getIntent().getSerializableExtra("character");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_character_detail);
        binding.setCharacter(character);
        binding.setImageUrl(character.getImage());


    }
}