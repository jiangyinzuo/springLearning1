package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.factory.BeanFactory;
import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.dao.impl.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
