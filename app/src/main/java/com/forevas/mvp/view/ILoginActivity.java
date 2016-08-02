package com.forevas.mvp.view;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface ILoginActivity {
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
    void setUsernameError(String msg);
    void setPasswordError(String msg);
    void showLoading(String msg);
    void hideLoading();
    void showToast(String msg);
    void loginSuccess();
}
