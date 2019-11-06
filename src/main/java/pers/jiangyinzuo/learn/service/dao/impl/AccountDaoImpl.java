package pers.jiangyinzuo.learn.service.dao.impl;

import pers.jiangyinzuo.learn.service.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存账户成功");
    }
}
