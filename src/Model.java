public class Model {
    private String[][] currentBoard;
    private String[][] prevBoard;


    public String[][] getCurrentBoard() {
        return currentBoard;
    }

    public String[][] getPrevBoard() {
        return prevBoard;
    }

    public boolean hasWinner()
    {

        return false;
    }
}
