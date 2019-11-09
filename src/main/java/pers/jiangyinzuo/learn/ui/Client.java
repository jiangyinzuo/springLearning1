package pers.jiangyinzuo.learn.ui;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.service.AccountService;

public class Client {

    public static void main(String[] args) {

        // 获取Spring的IOC核心容器, 并根据id获取对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

    }
}
