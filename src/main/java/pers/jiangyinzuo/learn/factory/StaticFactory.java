package pers.jiangyinzuo.learn.factory;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
