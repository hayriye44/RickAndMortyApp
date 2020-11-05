package com.example.rickandmorty.model;

import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;
import java.io.Serializable;

public class CharactersItem extends BaseObservable implements Serializable  {
	private int id;
	private String name;
	private String image;
	private String status;
	private String species;
	private String gender;
	private String created;
	private Location location;
	private String type;
	private String url;

	public CharactersItem() {
	}

	public CharactersItem(int id, String name, String image, String status, String species, String gender, String created, Location location, String type, String url) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
		this.species = species;
		this.gender = gender;
		this.created = created;
		this.location = location;
		this.type = type;
		this.url = url;
	}

	public String getImage(){
		return image;
	}

	public String getGender(){
		return gender;
	}

	public String getSpecies(){
		return species;
	}

	public String getCreated(){
		return created;
	}

	public String getName(){
		return name;
	}

	public Location getLocation(){
		return location;
	}

	public int getId(){
		return id;
	}

	public String getType(){
		return type;
	}

	public String getUrl(){
		return url;
	}

	public String getStatus(){
		return status;
	}

	@BindingAdapter("image")
	public static void loadImage(ImageView view, String imageUrl) {
		Picasso.get().load(Uri.parse(imageUrl)).into(view);

	}

	@Override
	public String toString() {
		return "CharactersItem{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", status='" + status + '\'' +
				", species='" + species + '\'' +
				", gender='" + gender + '\'' +
				", created='" + created + '\'' +
				", location=" + location +
				", type='" + type + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}