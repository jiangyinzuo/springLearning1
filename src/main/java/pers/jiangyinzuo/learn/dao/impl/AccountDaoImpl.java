package pers.jiangyinzuo.learn.dao.impl;

import pers.jiangyinzuo.learn.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存账户成功");
    }
}
