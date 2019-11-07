package pers.jiangyinzuo.learn.dao.impl;

import pers.jiangyinzuo.learn.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    public AccountDaoImpl() {
        System.out.println("创建AccountDaoImpl对象");
    }

    @Override
    public void saveAccount() {
        System.out.println("保存账户成功");
    }
}
