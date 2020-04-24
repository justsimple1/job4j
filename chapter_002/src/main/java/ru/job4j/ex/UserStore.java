package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean flag = true;
        User rsl = null;
        for (User name: users) {
            if (name.getUsername().equals(login)) {
                flag = false;
                rsl = name;
            }
        }
        if (flag) {
            throw new UserNotFoundException("User not Found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Invalid user name");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Nikita Panin", true)
        };
        try {
            User user = findUser(users, "Nikita Panin");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }   catch (UserInvalidException uie) {
            uie.printStackTrace();
        }
        catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
