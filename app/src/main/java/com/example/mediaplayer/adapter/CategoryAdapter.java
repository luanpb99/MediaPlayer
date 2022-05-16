package com.example.mediaplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaplayer.R;
import com.example.mediaplayer.databinding.ItemCategoryBinding;
import com.example.mediaplayer.model.entity.Category;
import com.example.mediaplayer.view.ListSongActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categories = new ArrayList<>();
    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_category,parent,false);
        return new CategoryViewHolder(itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.setCategoryItemBinding(category);
        holder.itemView.setOnClickListener(view -> {
            onClickItemCategory(category);
        });

    }
    private void onClickItemCategory(Category category){
        Intent intent = new Intent(context, ListSongActivity.class);
        intent.putExtra("codeCategory",category.getName());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (categories != null){
            return categories.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding itemCategoryBinding;
        public CategoryViewHolder(ItemCategoryBinding itemCategoryBinding) {
            super(itemCategoryBinding.getRoot());
            this.itemCategoryBinding = itemCategoryBinding;
        }

        public void setCategoryItemBinding(Category category){
            itemCategoryBinding.setCategoryItem(category);
            itemCategoryBinding.executePendingBindings();
        }
    }
}
