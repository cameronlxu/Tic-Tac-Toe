public class TicTacToeTest {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.setView(view);
        Controller controller = new Controller(model, view);

    }
}
