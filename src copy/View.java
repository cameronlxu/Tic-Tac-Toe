import javax.swing.*;
import java.awt.*;
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
        this.setLayout(new GridLayout(3,3));
        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[i].length; j ++)
            {
                int tempi = i;
                int tempj = j;
                board[i][j] = new JButton();
                board[i][j].setText("");
                board[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        board[tempi][tempj].setText(model.getPlayer());
                        board[tempi][tempj].setEnabled(false);
                        model.setValue(tempi,tempj);
                        model.setNextPlayer();
                    }
                });
                this.add(board[i][j]);
            }
    }

    public void gameEnd()
    {

    }
    //Updates the view of the board
    public void update()
    {

    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.setView(view);
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
        frame.add(view);
        frame.add(new JButton("Hello"));
        frame.setSize(300,300);
        frame.setVisible(true);

    }



}
