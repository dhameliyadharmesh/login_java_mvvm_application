package com.sports.games.comjavamvvmapplication.utils;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class EditTextChangeListener implements TextWatcher {

    private TextInputLayout textInputLayout;

    public EditTextChangeListener(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String input = s.toString();
        if (input.trim().length() > 0) {
            if (textInputLayout.getError() != null) {
                textInputLayout.setError(null);
            }
        }

    }
}
