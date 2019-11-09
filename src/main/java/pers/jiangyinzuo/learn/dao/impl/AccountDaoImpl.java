package pers.jiangyinzuo.learn.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.domain.Account;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "queryRunner")
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccounts() {
        try {
            return runner.query("SELECT * FROM `account`", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("SELECT * FROM `account` WHERE `id` = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("INSERT INTO account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("UPDATE `account` SET `name` = ?, `money` = ? WHERE `id` = ? ", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("DELETE FROM `account` WHERE `id` = ?", accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
