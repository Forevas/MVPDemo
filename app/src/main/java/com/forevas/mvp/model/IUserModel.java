package com.forevas.mvp.model;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface IUserModel {
    void login(String username,String password,OnLoginListener loginListener);
}
