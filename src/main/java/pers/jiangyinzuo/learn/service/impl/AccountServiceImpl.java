package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    // 经常变化的数据不适用于依赖注入
    private String name;
    private Integer age;
    private Date birthday;

    private static AccountDao accountDao;

    public AccountServiceImpl() {}

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void setAccountDao(AccountDao accountDao) {
        AccountServiceImpl.accountDao = accountDao;
    }

    @Override
    public void saveAccount() {
        System.out.println("存钱" + name + age + birthday);
    }
}
