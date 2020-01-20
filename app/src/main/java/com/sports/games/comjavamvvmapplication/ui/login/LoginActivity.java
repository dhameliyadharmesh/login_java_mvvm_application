package com.sports.games.comjavamvvmapplication.ui.login;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
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

                }
            }
        });
        loginActivityBinding.setLifecycleOwner(this);
        loginActivityBinding.setViewClickListener(new ViewClickListener());
        loginActivityBinding.edtLoginId.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginId));
        loginActivityBinding.edtLoginPwd.addTextChangedListener(new EditTextChangeListener(loginActivityBinding.tilLoginPwd));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            loginActivityBinding.txtCreateAccount.setText(Html.fromHtml(getString(R.string.dont_have_account), Html.FROM_HTML_MODE_LEGACY));
        } else {
            loginActivityBinding.txtCreateAccount.setText(Html.fromHtml(getString(R.string.dont_have_account)));
        }
        loginActivityBinding.setLoginViewModel(loginViewModel);
        loginActivityBinding.executePendingBindings();

    }


    public class ViewClickListener {

        public void onCreateAccountClick() {

        }

        public void onForgotPasswordClick() {

        }

        public void onSignInClick() {
            loginViewModel.getLoginFormModel().onSignInClicked();
        }

    }
}
