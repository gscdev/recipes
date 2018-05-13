package com.gsc.recipes.ui.recipes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsc.recipes.R;
import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.view.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;

class RecipesRecyclerViewAdapter extends RecyclerView.Adapter<RecipesRecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Recipe> recipes;


    public RecipesRecyclerViewAdapter(List<Recipe> recipes, OnItemClickListener<Integer> listener) {
        this.recipes = recipes;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);

        holder.title.setText(recipe.getTitle());
        holder.ingredients.setText(recipe.getIngredients());
        setImage(holder.image, recipe.getImage());

        holder.itemView.setOnClickListener(view -> listener.onItemClick(position));
    }

    private void setImage(ImageView imageView, String imageUrl) {
        if (isEmpty(imageUrl)) {
            Picasso.get().load(R.drawable.recipe_placeholder).into(imageView);
        } else {
            Picasso.get().load(imageUrl).into(imageView);
        }
    }


    @Override
    public int getItemCount() {
        return recipes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_title)
        TextView title;
        @BindView(R.id.item_ingredients)
        TextView ingredients;
        @BindView(R.id.item_image)
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
