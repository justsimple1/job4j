package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        Optional<User> rsl = Optional.of(user);
        rsl.ifPresent(value -> users.put(value, new ArrayList<>()));
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
                users.put(user.get(), list);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            for (Account el : users.get(user.get())) {
                if (el.getRequisite().equals(requisite)) {
                    account = Optional.of(el);
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account2 = findByRequisite(destPassport, dеstRequisite);
        if (account.isPresent() && account2.isPresent() && account.get().getBalance() >= amount) {
            double first = account.get().getBalance() - amount;
            double second = account2.get().getBalance() + amount;
            account.get().setBalance(first);
            account2.get().setBalance(second);
            rsl = true;
        }
        return rsl;
    }
}