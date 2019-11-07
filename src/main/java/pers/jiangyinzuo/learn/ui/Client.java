package pers.jiangyinzuo.learn.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.service.AccountService;

public class Client {
    /**
     * ApplicationContext的三个常用实现类：
     * ClassPathXmlApplicationContext: 它可以加载类路径文件下的配置文件, 要求配置文件必须在类路径下。不在的话加载不了。
     * FileSystemXmlApplicationContext: 它可以加载磁盘任意路径下的配置文件(要有访问权限)
     * AnnotationConfigApplicationContext: 它用于读取注解创建容器
     * <p>
     * 核心容器的两个接口引发出的问题:
     * ApplicationContext:  单例对象适用  实际开发更多使用此接口
     * 构建核心容器时, 创建对象采取的策略是采用立即加载的方式, 只要一读取完配置文件就立刻创建配置文件中配置的对象。
     * BeanFactory:  多例对象适用
     * 构建核心容器时, 创建对象采取的策略是采用延时加载的方式, 什么时候根据id获取对象, 什么时候才真正的创建对象。
     */
    public static void main(String[] args) {

        // 获取Spring的IOC核心容器, 并根据id获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        System.out.println(accountService);
        System.out.println(accountDao);

        accountService.saveAccount();

//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//
//        AccountService accountService1 = (AccountService) beanFactory.getBean("accountService");
//        AccountDao accountDao1 = (AccountDao) beanFactory.getBean("accountDao");
//
//        System.out.println(accountService1);
//        System.out.println(accountDao1);

    }
}
