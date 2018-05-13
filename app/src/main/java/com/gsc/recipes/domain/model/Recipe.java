package com.gsc.recipes.domain.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {

    private String title;
    private String ingredients;
    private String url;
    /** Image url */
    private String image;


    public Recipe(String title, String ingredients, String url, String image) {
        this.title = title;
        this.ingredients = ingredients;
        this.url = url;
        this.image = image;
    }


    protected Recipe(Parcel in) {
        title = in.readString();
        ingredients = in.readString();
        url = in.readString();
        image = in.readString();
    }

    //region getters
    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }
    //endregion

    //region Parcelable
    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(ingredients);
        parcel.writeString(url);
        parcel.writeString(image);
    }
    //endregion
}
