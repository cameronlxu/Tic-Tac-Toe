import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JPanel{
    private Model model;
    private JButton[][] board;
    private JButton undo;

    public View(Model model)
    {
        this.model = model;
        setUp();
    }

    //initial setup of board
    public void setUp()
    {
        board = new JButton[3][3];

        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[i].length; j ++)
            {
                board[i][j] = new JButton();
                board[i][j].setText("");
                board[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                    }
                });
                this.add(board[i][j]);
            }
    }

    //Updates the view of the board
    public void update()
    {
    }


}
