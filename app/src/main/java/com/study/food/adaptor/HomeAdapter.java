package com.study.food.adaptor;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.study.food.R;
import com.study.food.model.Food;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<Food, BaseViewHolder> {

    public HomeAdapter(List<Food> foods) {
        super(R.layout.home_food, foods);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Food food) {
        baseViewHolder.setImageResource(R.id.homeSnackImage, food.getImage());
    }
}
