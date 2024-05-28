package com.study.food.activity;

import android.app.Application;

import com.study.food.model.Food;
import com.study.food.model.User;
import com.study.food.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static List<Food> cartFoods;

    private static User user;

    private static boolean isLogin;

    public static List<Food> getCartSnacks() {
        return cartFoods;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MyApplication.user = user;
    }

    public static boolean isLogin() {
        return isLogin;        //检查是否登录
    }

    public static void isLogin(boolean isLogin) {
        MyApplication.isLogin = isLogin;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        cartFoods = new ArrayList<>();        // 初始化购物车
        Utils.init(this);        // 初始化工具类
    }
}
