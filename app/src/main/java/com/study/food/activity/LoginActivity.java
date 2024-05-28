package com.study.food.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.CacheDiskUtils;
import com.google.gson.Gson;
import com.study.food.R;
import com.study.food.dao.UserDao;
import com.study.food.data.DataServer;
import com.study.food.model.User;
import com.study.food.utils.Tips;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.loginUsernameEdit)
    EditText usernameEdit;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.loginPasswordEdit)
    EditText passwordEdit;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("登录");

        ButterKnife.bind(this);

        // 恢复账号
        String username = UserDao.getUsername();
        usernameEdit.setText(username);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        finish();
    }

    //登录按钮点击事件
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.loginBtn)
    void login() {
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        User user = new User(username, password);

        User loginUser = new Gson().fromJson(CacheDiskUtils.getInstance().getString("User"),User.class);
        if (loginUser.equals(user)) {
            Tips.show("登录成功");
            MyApplication.isLogin(true);
            MyApplication.setUser(loginUser);

            UserDao.saveUser(loginUser);            // 保存已登录用户数据
            UserDao.isLogin(true);

            UserDao.saveUsername(username);       //退出登录后不用再输入账号
            finish();
        } else {
            Tips.show("登录失败");
            passwordEdit.setText("");
        }
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.registerBtn)
    void register() {
        RegisterActivity.actionStart(this);
    }

    public User checkUserFromAccountList(User u) {    //登录成功return查询到的用户对象, 失败null
        for (User tmp : DataServer.getAccountList()) {
            if (tmp.equals(u)) {
                return tmp;
            }
        }
        return null;
    }
}