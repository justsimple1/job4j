package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if(!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }else {
            System.out.println("user" +user + "already exists");
        }
    }


    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if(!list.contains(account.getRequisite())){
            list.add(account);
            users.put(user, list);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if(key.getPassport().equals(passport)) {
                user = key;
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
                }

            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        User user = findByPassport(srcPassport);
        User user2 = findByPassport(destPassport);
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, dеstRequisite);
        if ( user != null && user2 != null && account != null && account2 != null && account.getBalance() >= amount) {
           double first = account.getBalance() - amount;
           double second = account2.getBalance() + amount;
           account.setBalance(first);
           account2.setBalance(second);
           List<Account> list = users.get(user);
           List<Account> list2 = users.get(user2);
           list.add(account);
           list2.add(account2);
           users.put(user, users.get(user));
           users.put(user2, list2);
           rsl = true;
        }
        return rsl;
    }
}