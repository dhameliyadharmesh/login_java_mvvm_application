package com.sports.games.comjavamvvmapplication.ui.login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class LoginViewModel extends AndroidViewModel {

    private LoginFormModel loginFormModel;

    public LoginViewModel(Application application) {
        super(application);
    }

    void initLoginFormModel(){
        this.loginFormModel = new LoginFormModel();
    }

    public LoginFormModel getLoginFormModel() {
        return loginFormModel;
    }
}
