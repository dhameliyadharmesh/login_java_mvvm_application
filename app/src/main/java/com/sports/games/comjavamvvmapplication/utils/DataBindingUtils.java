package com.sports.games.comjavamvvmapplication.utils;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public class DataBindingUtils {

    @BindingAdapter({"android:inputErrorText"})
    public static void setInputErrorText(final TextInputLayout inputErrorText, Integer error) {
        if (error == null) {
            inputErrorText.setError(null);
        } else {
            inputErrorText.setError(inputErrorText.getContext().getString(error));
        }
    }
}
