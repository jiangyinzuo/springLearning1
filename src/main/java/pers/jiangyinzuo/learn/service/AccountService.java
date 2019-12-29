package pers.jiangyinzuo.learn.service;

import pers.jiangyinzuo.learn.domain.Account;

import java.util.List;

public interface AccountService {
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
     * 转账
     * @param sourceName  转出账户名
     * @param targetName  转入账户名
     * @param money       转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
