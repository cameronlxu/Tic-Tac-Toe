public class Model {
    private String[][] currentBoard;
    private String[][] prevBoard;
    private String player;
    private View view;

    public String[][] getCurrentBoard() {
        return currentBoard;
    }

    public String[][] getPrevBoard() {
        return prevBoard;
    }

    public void setView(View view)
    {
        this.view = view;
    }
    public void setValue(String value, int x, int y)
    {
        prevBoard = currentBoard;
        currentBoard[x][y] = value;
        view.update();
    }
    public boolean hasWinner()
    {
        return checkDiagonal() || checkRow();
    }

    public boolean checkDiagonal()
    {
        int rightDiagonal = 0;
        int leftDiagonal = 0;
        for(int i = 0; i < currentBoard.length; i ++)
        {
            if (currentBoard[i][i].equals(player))
                rightDiagonal++;
            else if (currentBoard[currentBoard.length - 1][i].equals(player))
                leftDiagonal++;
        }
        return rightDiagonal == 3 || leftDiagonal == 3;

    }

    public boolean checkRow()
    {
        for(int i = 0; i < currentBoard.length; i ++)
        {
            if(!currentBoard[i][0].equals("") && currentBoard[i][0].equals(currentBoard[i][1]) && currentBoard[i][1].equals(currentBoard[i][2]))
                return true;
            else if(!currentBoard[0][i].equals("") && currentBoard[0][i].equals(currentBoard[1][i]) && currentBoard[1][i].equals(currentBoard[2][i]))
                return true;
        }
        return false;
    }
}
