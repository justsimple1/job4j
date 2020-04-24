package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
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
        Input validate = new ValidateInput();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()};
        new StartUI().init(validate, tracker, actions);
    }
}
