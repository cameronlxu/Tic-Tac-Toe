import java.util.Arrays;

public class Model {
    private String[][] currentBoard;
    private String[][] prevBoard;
    private String player;
    private int playerID;
    private View view;

    public Model()
    {
        start();
    }

    public void start()
    {
        player = "X";
        playerID = 1;
        currentBoard = new String[3][3];
        for(int i = 0; i < currentBoard.length; i ++)
            for(int j = 0; j < currentBoard.length; j ++){
                currentBoard[i][j] = "";
            }
        prevBoard = currentBoard;
    }

    public void setNextPlayer()
    {
        if(player.equals("X")) {
            player = "O";
            playerID = 2;
        }
        else if(player.equals("O")) {
            player = "X";
            playerID = 1;
        }
    }
    public String[][] getCurrentBoard() {
        return currentBoard;
    }

    public String[][] getPrevBoard() {
        return prevBoard;
    }

    public String getPlayer()
    {
        return player;
    }

    public void setView(View view)
    {
        this.view = view;
    }
    public void setValue(int x, int y)
    {
        prevBoard = currentBoard;
        if(playerID % 2 != 0)
            currentBoard[x][y] = "X";
        else
            currentBoard[x][y] = "O";
        if(!hasWinner())
            view.update();
        else
            view.gameEnd();
        System.out.println(Arrays.deepToString(currentBoard));
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
