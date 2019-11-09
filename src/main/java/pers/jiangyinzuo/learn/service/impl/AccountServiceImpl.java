package pers.jiangyinzuo.learn.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * XML配置:
 * <bean
 *      id="accountService"
 *      class="pers.jiangyinzuo.learn.service.impl"
 *      scope="singleton"
 *      init-method=""
 *      destroy-method=""
 * >
 *      <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 注解类型:
 * 用于创建对象的注解  --> 和在xml中编写一个bean标签实现的功能相同
 * @Component: 用于将当前类对象存入Spring容器中
 *      属性:
 *          value: 用于指定bean的id, 默认值是当前类名且首字母改小写
 * @Controller: 表现层
 * @Service: 业务层
 * @Repository: 持久层
 * 以上3个注解的作用和属性和Component相同, 这是spring框架为我们提供的明确的三层架构的注解,
 * 使3层对象更为清晰。
 *
 * 用于注入数据的注解  --> 和在xml配置文件中的bean标签中写一个<property>标签作用相同
 * @Autowired：
 *      自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *      如果IOC容器中没有任何bean类型和要注入的变量类型匹配, 则报错。
 *      如果IOC容器中有多个匹配时, 首先按类型、其次使用变量变量名作bean的id进行匹配。
 *      出现位置: 成员变量、方法
 *      细节: 使用注解注入时, 不需要set方法
 * @Qualifier:
 *      在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以。
 *      属性:
 *          value: 用于指定注入bean的id
 * @Resource
 *      直接按照bean的id注入。它可以独立使用
 *      属性:
 *          name: bean的id
 *  以上3种注解只能注入其它bean类型的数据, 而基本类型和String类型无法使用上述注解实现
 *
 * @Value
 *      用于注入基本类型和String类型的数据
 *      属性:
 *          value: 用于指定数据的值。它可以使用Spring中的SpEL(spring中的el表达式)
 *          SpEL的写法: ${表达式}
 *
 * 用于改变作用范围的注解  --> 和在bean标签中用scope属性功能相同
 * @Scope: 用于指定bean的作用范围
 *      属性:
 *          value: singleton  prototype
 * 和生命周期相关的注解 --> 和在bean标签中使用init-method和destroy-method相同
 * @Predestroy: 用于指定销毁方法
 * @PostConstruct: 用于指定初始化方法
 */

@Scope(value = "singleton")
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
