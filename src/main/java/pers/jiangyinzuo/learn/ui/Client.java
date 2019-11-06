package pers.jiangyinzuo.learn.ui;

import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
