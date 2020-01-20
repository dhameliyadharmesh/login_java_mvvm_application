package com.sports.games.comjavamvvmapplication.ui.login;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProviders;

import com.sports.games.comjavamvvmapplication.R;
import com.sports.games.comjavamvvmapplication.databinding.LoginActivityBinding;
import com.sports.games.comjavamvvmapplication.utils.EditTextChangeListener;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        if (loginViewModel == null) {
            loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
            loginViewModel.initLoginFormModel();
        }
        loginViewModel.getLoginFormModel().onFormObserve().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (loginViewModel.getLoginFormModel().onFormObserve().get()) {
                    Toast.makeText(LoginActivity.this, "Invalid login form", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginActivityBinding.setLifecycleOwner(this);
        loginActivityBinding.setLoginViewModel(loginViewModel);
        loginActivityBinding.edtLoginId.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginId));
        loginActivityBinding.edtLoginPwd.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginPwd));
    }
}
