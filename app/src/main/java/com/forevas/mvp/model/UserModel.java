package com.forevas.mvp.model;

import com.forevas.mvp.bean.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/8/2.
 */
public class UserModel implements IUserModel{

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                loginListener.onLoginStart("正在登录...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(username.equals("Forevas")&&password.equals("123456")){
                    User user=new User();
                    user.setUsername("Forevas");
                    user.setPassword("123456");
                    loginListener.onLoginSuccess(user);
                }else{
                    if(!username.equals("Forevas")){
                        loginListener.onLoginFail(ErrorType.username,"用户名错误！");
                    }else if(!password.equals("123456")){
                        loginListener.onLoginFail(ErrorType.password,"密码错误！");
                    }

                }
            }
        });
    }
}
