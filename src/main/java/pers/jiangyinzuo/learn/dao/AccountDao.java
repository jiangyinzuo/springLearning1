package pers.jiangyinzuo.learn.dao;

import pers.jiangyinzuo.learn.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccounts();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * @param name 账户名
     * @return 有唯一的结果就返回，没有就返回null，超过一个抛异常
     */
    Account queryAccountByName(String name) throws RuntimeException;
}
