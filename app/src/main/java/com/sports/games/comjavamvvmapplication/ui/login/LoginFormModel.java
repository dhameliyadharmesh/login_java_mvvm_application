package com.sports.games.comjavamvvmapplication.ui.login;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.sports.games.comjavamvvmapplication.BR;
import com.sports.games.comjavamvvmapplication.R;

public class LoginFormModel extends BaseObservable {

    private String loginId;
    private String loginPwd;
    private Integer loginIdError = null;
    private Integer loginPwdError = null;

    @Bindable
    public Integer getLoginIdError() {
        return loginIdError;
    }

    private void setLoginIdError(Integer loginIdError) {
        this.loginIdError = loginIdError;
        notifyPropertyChanged(com.sports.games.comjavamvvmapplication.BR.loginIdError);
    }

    @Bindable
    public Integer getLoginPwdError() {
        return loginPwdError;
    }

    private void setLoginPwdError(Integer loginPwdError) {
        this.loginPwdError = loginPwdError;
        notifyPropertyChanged(BR.loginPwdError);
    }

    @Bindable
    String getLoginId() {
        return loginId;
    }

    void setLoginId(String loginId) {
        this.loginId = loginId;
        notifyPropertyChanged(BR.loginId);
    }

    @Bindable
    String getLoginPwd() {
        return loginPwd;
    }

    void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
        notifyPropertyChanged(BR.loginPwd);
    }

    boolean isValidLoginForm() {
        boolean valid = isValidLoginId();
        valid = isValidLoginPwd() && valid;
        return valid;
    }

    private boolean isValidLoginPwd() {
        boolean isLoginPwdValid = TextUtils.isEmpty(loginPwd);
        setLoginPwdError(isLoginPwdValid ? R.string.err_password_required : null);
        return isLoginPwdValid;
    }

    private boolean isValidLoginId() {
        boolean isLoginIdValid = TextUtils.isEmpty(loginId);
        setLoginIdError(isLoginIdValid ? R.string.err_username_required : null);
        return isLoginIdValid;
    }
}
