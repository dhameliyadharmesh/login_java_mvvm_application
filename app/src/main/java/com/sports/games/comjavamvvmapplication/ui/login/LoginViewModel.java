package com.sports.games.comjavamvvmapplication.ui.login;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class LoginViewModel extends BaseObservable {

    private LoginFormModel loginFormModel;

    public LoginViewModel() {
        loginFormModel = new LoginFormModel();
    }

    public void setLoginId(String loginId) {
        loginFormModel.setLoginId(loginId);
        notifyPropertyChanged(BR.loginId);
    }

    public void setLoginPwd(String loginPwd){
        loginFormModel.setLoginPwd(loginPwd);
        notifyPropertyChanged(BR.loginPwd);
    }


    @Bindable
    public String getLoginId() {
        return loginFormModel.getLoginId();
    }

    @Bindable
    public String getLoginPwd() {
        return loginFormModel.getLoginPwd();
    }

    public void onSignInClicked() {

    }

}
