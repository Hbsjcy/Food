package com.study.food.adaptor;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.study.food.R;
import com.study.food.model.Food;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 下单页面购物车列表适配器
 */
public class PlaceOrderAdapter extends BaseQuickAdapter<Food, BaseViewHolder> {

    public PlaceOrderAdapter(List<Food> foods) {
        super(R.layout.order_place, foods);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Food food) {
        baseViewHolder.setImageResource(R.id.placeOrderImage, food.getImage())
                .setText(R.id.placeOrderName, food.getName())
                .setText(R.id.placeOrderPrice, "￥" + food.getPrice())
                .setText(R.id.orderCountBtn, String.valueOf(food.getCount()));
    }
}
