package com.study.food.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> MText;

    public HomeViewModel(MutableLiveData<String> mText) {
        MText = new MutableLiveData<>();
        MText.setValue("首页页面");
    }

    public LiveData<String> getText() {
        return MText;
    }
}