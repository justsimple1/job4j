package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.valueOf(input.askStr("Select: "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserAction[] actions) {
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}
