package pers.jiangyinzuo.learn.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import pers.jiangyinzuo.learn.dao.AccountDao;
import pers.jiangyinzuo.learn.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 * @author Jiang Yinzuo
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

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

    @Override
    public Account queryAccountByName(String name) throws RuntimeException {
        try {
            List<Account> accounts = runner.query("SELECT * FROM `account` WHERE `name` = ?",
                    new BeanListHandler<Account>(Account.class), name);
            if (accounts == null || accounts.isEmpty()) {
                return null;
            } else if (accounts.size() > 1) {
                throw  new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
