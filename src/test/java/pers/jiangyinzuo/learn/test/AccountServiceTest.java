package pers.jiangyinzuo.learn.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pers.jiangyinzuo.learn.domain.Account;
import pers.jiangyinzuo.learn.service.AccountService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 使用Junit进行单元测试
 *
 * 测试方法执行时, 没有IOC容器
 * Spring integrate junit
 *      1. 使用Junit提供的注解将原有的main方法替换为Spring提供的方法
 *      2. 告知spring运行器IOC是如何创建的, 并说明位置
 *          @ContextConfiguration
 *              location: xml文件位置, 加上classpath关键字, 表示在类路径下
 *              classes: 指定注解类所在的位置
 *      使用spring5.x版本时, 要求junit版本是4.1.2以上
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

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
