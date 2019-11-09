package pers.jiangyinzuo.learn.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.jiangyinzuo.learn.config.SpringConfiguration;
import pers.jiangyinzuo.learn.domain.Account;
import pers.jiangyinzuo.learn.service.AccountService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 使用Junit进行单元测试
 */
public class AccountServiceTest {
    private static ApplicationContext applicationContext;
    private static AccountService accountService;

    @BeforeAll
    public static void setUp() {
        // 1. 获取容器
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2. 得到业务层对象
        accountService = applicationContext.getBean("accountService", AccountService.class);
    }

    @Test
    public void testFindAll() {

        // 3. 执行方法
        List<Account> accountList = accountService.findAllAccounts();

        assertTrue(accountList.size() > 0, "列表长度小于0");

    }

    @Test
    public void testFindOne() {
        Account account = accountService.findAccountById(1);
        assertNotEquals(null, account, "account 为空");
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("Dave");
        account.setMoney(20f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("Dave");
        account.setMoney(40f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(5);
    }
}
