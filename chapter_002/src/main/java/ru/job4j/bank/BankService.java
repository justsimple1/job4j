package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
        }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!user.equals(null)) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
                users.put(user, list);
            }
        }
    }

    public User findByPassport(String passport) {
            User user = users.keySet().stream().filter(e -> e.getPassport()
                    .equals(passport)).findFirst().orElse(null);
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user != null) {
             account = users.get(user).stream().filter(e -> e.getRequisite()
                     .equals(requisite)).findFirst().orElse(null);
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, dеstRequisite);
        if (account != null && account2 != null && account.getBalance() >= amount) {
            double first = account.getBalance() - amount;
            double second = account2.getBalance() + amount;
            account.setBalance(first);
            account2.setBalance(second);
            rsl = true;
        }
        return rsl;
    }
}