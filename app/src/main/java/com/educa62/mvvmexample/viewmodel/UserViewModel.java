package com.educa62.mvvmexample.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.educa62.mvvmexample.model.User;


public class UserViewModel {

    private Context context;
    private User user;
    public String toastMessageSuccess = "Login Success";
    public String toastMessageFailed = "Login Failed";

    public UserViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }


    public void updateModel(String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
    }

    public void validLogin() {

        boolean isValid = true;

        if (TextUtils.isEmpty(user.getEmail()))
            isValid = false;

        if (TextUtils.isEmpty(user.getPassword()))
            isValid = false;


        if (isValid)
            showToast(toastMessageSuccess);
        else
            showToast(toastMessageFailed);
    }

    private void showToast(String messageToast) {
        Toast.makeText(context, messageToast, Toast.LENGTH_SHORT).show();
    }

}
