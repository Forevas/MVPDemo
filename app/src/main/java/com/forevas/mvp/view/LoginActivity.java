package com.forevas.mvp.view;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.forevas.mvp.R;

public class LoginActivity extends AppCompatActivity implements ILoginActivity{
    private TextInputLayout username,password;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(TextInputLayout)findViewById(R.id.username_wrapper);
        password=(TextInputLayout)findViewById(R.id.password_wrapper);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    @Override
    public String getUsername() {
        return username.getEditText().getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getEditText().getText().toString();
    }

    @Override
    public void clearUsername() {
        username.getEditText().setText("");
    }

    @Override
    public void clearPassword() {
        password.getEditText().setText("");
    }

    @Override
    public void setUsernameError(String msg) {
        username.setError(msg);
    }

    @Override
    public void setPasswordError(String msg) {
        password.setError(msg);
    }

    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void loginSuccess() {
        Snackbar.make(getWindow().getDecorView(),"登录成功",Snackbar.LENGTH_LONG).show();
    }
}
