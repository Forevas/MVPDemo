package com.forevas.mvp.view;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.forevas.mvp.R;
import com.forevas.mvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginActivity,View.OnClickListener{
    private TextInputLayout username,password;
    private ProgressDialog progressDialog;
    private LoginPresenter loginPresenter;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(TextInputLayout)findViewById(R.id.username_wrapper);
        password=(TextInputLayout)findViewById(R.id.password_wrapper);
        login=(Button)findViewById(R.id.btn_login);
        login.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        loginPresenter=new LoginPresenter(this);
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
    public void showToast(String msg) {
        Snackbar.make(getWindow().getDecorView(),msg,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        username.setError(null);//这句话很重要，没有的话会导致下次setError无法显示
        username.setErrorEnabled(false);
        password.setError(null);
        password.setErrorEnabled(false);
        Snackbar.make(getWindow().getDecorView(),"登录成功",Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                loginPresenter.login();
                break;
        }
    }
}
