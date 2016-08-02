package com.forevas.mvp.model;

import com.forevas.mvp.bean.User;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface OnLoginListener {
    void onLoginStart(String msg);
    void onLoginSuccess(User user);
    void onLoginFail(ErrorType type,String msg);
}
