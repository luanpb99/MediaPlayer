package com.example.mediaplayer.view;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mediaplayer.R;
import com.example.mediaplayer.adapter.CategoryAdapter;
import com.example.mediaplayer.base.BaseActivity;
import com.example.mediaplayer.databinding.ActivityHomeBinding;
import com.example.mediaplayer.model.response.CategoryResponse;
import com.example.mediaplayer.viewmodel.viewmodels.CategoryViewModel;

public class HomeActivity extends BaseActivity {
    private CategoryAdapter categoryAdapter;
    private CategoryViewModel categoryViewModel;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        init();
    }

    private void init() {
        categoryViewModel = new CategoryViewModel();
        categoryAdapter = new CategoryAdapter(this);
        binding.rcCategories.setLayoutManager(new LinearLayoutManager(this));
        binding.rcCategories.setAdapter(categoryAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (categoryViewModel != null){
            categoryViewModel.getCategoryResponse()
                    .observe(this,o ->{
                        if (o instanceof CategoryResponse){
                            if (categoryAdapter != null){
                                categoryAdapter.setCategories(((CategoryResponse) o).getCategoryList());
                            }
                        }
                    });
        }
    }
}
