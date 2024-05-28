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
import com.study.food.model.User;
import com.study.food.utils.Tips;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.loginUsernameEdit)
    EditText usernameEdit;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.loginPasswordEdit)
    EditText passwordEdit;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("注册");

        ButterKnife.bind(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    //登录按钮点击事件
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.registerBtn)
    void register() {
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        User user = new User(username, password);
        Gson gson = new Gson();
        LoginActivity.actionStart(this);
        CacheDiskUtils.getInstance().put("User", gson.toJson(user));
        Tips.show("注册成功");
    }

}