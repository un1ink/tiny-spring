package cn.un1ink.springframework.test.bean;

import cn.un1ink.springframework.beans.BeansException;
import cn.un1ink.springframework.beans.factory.*;
import cn.un1ink.springframework.context.ApplicationContext;
import cn.un1ink.springframework.context.ApplicationContextAware;
import cn.un1ink.springframework.stereotype.Component;

import java.util.Random;

/**
 * @description:
 * @author：un1ink
 * @date: 2023/4/30
 */
@Component("userService")
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
