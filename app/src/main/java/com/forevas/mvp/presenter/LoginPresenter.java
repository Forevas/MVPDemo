package com.forevas.mvp.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.forevas.mvp.bean.User;
import com.forevas.mvp.model.ErrorType;
import com.forevas.mvp.model.IUserModel;
import com.forevas.mvp.model.OnLoginListener;
import com.forevas.mvp.model.UserModel;
import com.forevas.mvp.view.ILoginActivity;

/**
 * Created by Administrator on 2016/8/2.
 */
public class LoginPresenter {
    private ILoginActivity loginActivity;
    private IUserModel userModel;
    private Handler handler=new Handler();
    public LoginPresenter(ILoginActivity loginActivity) {
        this.loginActivity=loginActivity;
        userModel=new UserModel();
    }
    public void login(){
        String username=loginActivity.getUsername();
        String password=loginActivity.getPassword();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            loginActivity.showToast("用户名和密码不能为空！");
            return;
        }
        userModel.login(username, password, new OnLoginListener() {
            @Override
            public void onLoginStart(final String msg) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivity.showLoading(msg);
                    }
                });

            }

            @Override
            public void onLoginSuccess(User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginActivity.hideLoading();
                        loginActivity.loginSuccess();
                    }
                });
            }

            @Override
            public void onLoginFail(final ErrorType type, final String msg) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (type){
                            case username:
                                loginActivity.hideLoading();
                                loginActivity.setUsernameError(msg);
                                loginActivity.clearUsername();
                                loginActivity.clearPassword();
                                break;
                            case password:
                                loginActivity.hideLoading();
                                loginActivity.setPasswordError(msg);
                                loginActivity.clearPassword();
                                break;
                        }
                    }
                });

            }
        });
    }
}
