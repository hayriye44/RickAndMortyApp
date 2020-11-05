package com.example.rickandmorty.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rickandmorty.model.CharactersItem;
import com.example.rickandmorty.R;
import com.example.rickandmorty.ui.characterdetail.CharacterDetailActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>  {
    private List<CharactersItem> characterList = new ArrayList<>();
    Context context;
    public CharacterListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_character, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, final int position) {
        holder.name.setText(characterList.get(position).getName());
        holder.species.setText(characterList.get(position).getSpecies()+"");
        holder.status.setText(characterList.get(position).getStatus());
        Picasso.get().load(Uri.parse(characterList.get(position).getImage())).into(holder.characterImage);

        holder.characterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("character", characterList.get(position));
                Intent intent = new Intent(context, CharacterDetailActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }
    public void setList(List<CharactersItem> characterList) {
        this.characterList = characterList;
        notifyDataSetChanged();
    }


    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name, status,species;
        ImageView characterImage;
        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.character_name);
            status = (TextView) itemView.findViewById(R.id.status);
            characterImage = (ImageView) itemView.findViewById(R.id.character_image);
            species = (TextView) itemView.findViewById(R.id.species);
        }
    }
}