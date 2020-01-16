package com.sports.games.comjavamvvmapplication.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.sports.games.comjavamvvmapplication.R;
import com.sports.games.comjavamvvmapplication.databinding.LoginActivityBinding;
import com.sports.games.comjavamvvmapplication.utils.EditTextChangeListener;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModelModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModelModel.class);
        loginActivityBinding.setLifecycleOwner(this);
        loginActivityBinding.setLoginViewModel(loginViewModel);
        loginActivityBinding.edtLoginId.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginId));
        loginActivityBinding.edtLoginPwd.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginPwd));
    }
}
