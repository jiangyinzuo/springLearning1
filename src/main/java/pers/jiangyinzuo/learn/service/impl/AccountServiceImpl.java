package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    private static AccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("创建AccountServiceImpl对象");
    }

    @Override
    public void saveAccount() {
        System.out.println("存钱");
    }

    public void initMethod() {
        System.out.println("init");
    }

    public void destroyMethod() {
        System.out.println("destroy");
    }
}
