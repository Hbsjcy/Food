package com.study.food.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<String> MText;

    public MyViewModel() {
        MText = new MutableLiveData<>();
        MText.setValue("我的页面");
    }

    public LiveData<String> getText() {
        return MText;
    }
}