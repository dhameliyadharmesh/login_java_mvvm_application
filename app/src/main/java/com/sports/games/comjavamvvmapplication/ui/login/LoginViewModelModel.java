package com.sports.games.comjavamvvmapplication.ui.login;

import android.app.Application;

import androidx.databinding.Bindable;
import androidx.lifecycle.AndroidViewModel;


public class LoginViewModelModel extends AndroidViewModel {

    private LoginFormModel loginFormModel;

    public LoginFormModel getLoginFormModel() {
        return loginFormModel;
    }

    public LoginViewModelModel(Application application) {
        super(application);
        loginFormModel = new LoginFormModel();
    }

    public void setLoginId(String loginId) {
        loginFormModel.setLoginId(loginId);
    }

    public void setLoginPwd(String loginPwd) {
        loginFormModel.setLoginPwd(loginPwd);
    }

    public String getLoginId() {
        return loginFormModel.getLoginId();
    }

    public String getLoginPwd() {
        return loginFormModel.getLoginPwd();
    }

    public void onSignInClicked() {
        if (loginFormModel.isValidLoginForm()) {

        }
    }

}
