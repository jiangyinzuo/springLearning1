package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    private static AccountDao accountDao;

    private int i = 1;

    public AccountServiceImpl() {
        System.out.println("创建AccountServiceImpl对象");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
