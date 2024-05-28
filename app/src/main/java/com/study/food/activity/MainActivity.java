package com.study.food.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.study.food.R;
import com.study.food.dao.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView naviView = findViewById(R.id.navi_view);
        // 将每个菜单ID作为一组ID传递
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_snack, R.id.navigation_place, R.id.navigation_my).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(naviView, navController);

        checkLogin();
    }

    private void checkLogin() {        // 检查保存的登录数据信息
        if (UserDao.isLogin()) {
            MyApplication.isLogin(true);
            MyApplication.setUser(UserDao.getUser());
        } else {
            MyApplication.isLogin(false);
            MyApplication.setUser(null);
        }
    }
}