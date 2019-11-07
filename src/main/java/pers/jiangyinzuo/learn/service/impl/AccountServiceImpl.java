package pers.jiangyinzuo.learn.service.impl;

import pers.jiangyinzuo.learn.factory.BeanFactory;
import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    private static AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    private int i = 1;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
