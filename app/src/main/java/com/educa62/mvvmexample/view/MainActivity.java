package com.educa62.mvvmexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.educa62.mvvmexample.model.User;
import com.educa62.mvvmexample.R;
import com.educa62.mvvmexample.viewmodel.UserViewModel;


public class MainActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init view
        inputEmail = (EditText) findViewById(R.id.eEmail);
        inputPassword = (EditText) findViewById(R.id.ePassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        final User user = new User();
        userViewModel = new UserViewModel(this, user);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.updateModel(inputEmail.getText().toString(),
                        inputPassword.getText().toString());
                userViewModel.validLogin();
            }
        });

    }
}
