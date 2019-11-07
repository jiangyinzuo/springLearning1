package pers.jiangyinzuo.learn.ui;

import pers.jiangyinzuo.learn.factory.BeanFactory;
import pers.jiangyinzuo.learn.service.AccountService;
import pers.jiangyinzuo.learn.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {

        // 多例输出都是1; 单例输出123
        for (int i = 0; i < 3; ++i) {
            // AccountService accountService = new AccountServiceImpl();
            AccountService accountService = (AccountServiceImpl) BeanFactory.getBean("accountService");
            accountService.saveAccount();
        }

    }
}
