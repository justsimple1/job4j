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
            if(!list.contains(account.getRequisite())){
                list.add(account);
                users.put(user, list);
            }
        }
    }

    public User findByPassport(String passport) {
            User user = null;
            for (User key : users.keySet()) {
                    if(key.getPassport().equals(passport)) {
                        user = key;
                        break;
                    }
            }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if(user != null) {
            List<Account> list = users.get(user);
            for (Account key : list ) {
                if(key.getRequisite().equals(requisite)){
                    account = key;
                    break;
                }

            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, dеstRequisite);
        if ( account != null && account2 != null && account.getBalance() >= amount) {
            double first = account.getBalance() - amount;
            double second = account2.getBalance() + amount;
            account.setBalance(first);
            account2.setBalance(second);
            rsl = true;
        }
        return rsl;
    }
}