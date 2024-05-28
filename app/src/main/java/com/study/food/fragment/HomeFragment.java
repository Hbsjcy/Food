package com.study.food.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.study.food.R;
import com.study.food.activity.DetailActivity;
import com.study.food.adaptor.HomeAdapter;
import com.study.food.data.DataServer;
import com.study.food.model.Food;
import com.study.food.model.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.homeRecyclerView)
    RecyclerView homeRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 首页瀑布流列表
        homeRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initHomeAdapter();
    }

    private void initHomeAdapter() {
        // 实例化购物车列表适配器对象
        HomeAdapter adapter = new HomeAdapter(DataServer.getHomeList());
        // 分别设置头部和尾部
        adapter.setHeaderView(getHeadView(), 1);
        adapter.setFooterView(getFooterView(), 1);

        // 点击事件监听器
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            Food food = (Food) adapter1.getItem(position);
            DetailActivity.actionStart(getContext(), food);
        });

        // 设置适配器
        homeRecyclerView.setAdapter(adapter);
    }

    //首页RecyclerView头部View
    private View getHeadView() {
        return getLayoutInflater().inflate(R.layout.head_home, homeRecyclerView, false);
    }

    //首页RecyclerView尾部View
    private View getFooterView() {
        return getLayoutInflater().inflate(R.layout.footer_none, homeRecyclerView, false);
    }
}