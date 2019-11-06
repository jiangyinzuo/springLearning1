package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.dao.impl.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
