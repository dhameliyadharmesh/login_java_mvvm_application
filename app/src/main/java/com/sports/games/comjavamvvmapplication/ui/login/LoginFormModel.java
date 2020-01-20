package com.sports.games.comjavamvvmapplication.ui.login;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.sports.games.comjavamvvmapplication.BR;
import com.sports.games.comjavamvvmapplication.R;

public class LoginFormModel extends BaseObservable {

    private String loginId;
    private String loginPwd;
    private Integer loginIdError = null;
    private Integer loginPwdError = null;
    private ObservableField<Boolean> observableField = null;

    LoginFormModel() {
        observableField = new ObservableField<>(false);
    }

    @Bindable
    public Integer getLoginIdError() {
        return loginIdError;
    }

    private void setLoginIdError(Integer loginIdError) {
        this.loginIdError = loginIdError;
        notifyPropertyChanged(com.sports.games.comjavamvvmapplication.BR.loginIdError);
    }

    public ObservableField<Boolean> onFormObserve() {
        return observableField;
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
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
        notifyPropertyChanged(BR.loginId);
    }

    @Bindable
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
        notifyPropertyChanged(BR.loginPwd);
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

    public void onSignInClicked() {
        boolean isValidLoginId = isValidLoginId();
        if (isValidLoginId) {
            setLoginIdError(R.string.err_username_required);
        }
        boolean isValidLoginPwd = isValidLoginPwd();
        if (isValidLoginPwd) {
            setLoginPwdError(R.string.err_password_required);
        }
        observableField.set(isValidLoginId || isValidLoginPwd);
    }
}
