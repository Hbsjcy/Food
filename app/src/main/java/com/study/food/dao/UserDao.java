package com.study.food.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.study.food.model.User;
import com.study.food.utils.Utils;

public class UserDao {

    // 实例化SharedPreferences对象
    private static final SharedPreferences data = Utils.getContext().getSharedPreferences("data", Context.MODE_PRIVATE);

    private static final Gson gson = new Gson();

    public static boolean isLogin() {
        return data.getBoolean("isLogin", false);
    }

    public static void isLogin(boolean bool) {
        SharedPreferences.Editor edit = data.edit();
        edit.putBoolean("isLogin", bool);
        edit.apply();
    }

    public static User getUser() {    //获取已登录用户
        String userJson = data.getString("user", "");
        return gson.fromJson(userJson, User.class);
    }

    public static void saveUser(User user) {    //保存登录用户信息
        String userJson = gson.toJson(user);
        SharedPreferences.Editor edit = data.edit();
        edit.putString("user", userJson);
        edit.apply();
    }

    public static void removeUserAndLoginStatus() {     //清除登录用户信息和登录状态
        SharedPreferences.Editor edit = data.edit();
        edit.remove("user");
        edit.remove("isLogin");
        edit.apply();
    }

    public static void removeAll() {
        SharedPreferences.Editor edit = data.edit();
        edit.clear();
        edit.apply();
    }

    public static void saveUsername(String username) {     //保存账号
        SharedPreferences.Editor editor = data.edit();
        editor.putString("username", username);
        editor.apply();
    }

    public static String getUsername() {
        return data.getString("username", "");
    }
}
