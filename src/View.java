import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Model model;
    private JButton[][] board;
    private Color background;
    private boolean player1_turn;

    public View(Model model) {
        this.model = model;
        this.setSize(new Dimension(300, 450));
        this.background = Color.BLUE;
        setUp();
    }

    //initial setup of board
    public void setUp() {
        JPanel gameBoard = new JPanel(new GridLayout(3,3));
        gameBoard.setBackground(background);
        JPanel sidePanel = new JPanel(new FlowLayout());
        //sidePanel.setBackground(Color.BLACK);
        sidePanel.add(new JButton("Undo"));
        
        // JLabel for displaying whose turn it is
        JLabel turn = new JLabel("Player 1 Turn: X");
        sidePanel.add(turn);
        player1_turn = true;
        
        this.add(gameBoard, BorderLayout.NORTH);
        this.add(sidePanel,BorderLayout.CENTER);
        board = new JButton[3][3];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                int tempi = i;
                int tempj = j;
                board[i][j] = new JButton();
                board[i][j].setPreferredSize(new Dimension(100,100));
                board[i][j].setText("");
                board[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        board[tempi][tempj].setText(model.getPlayer());
                        board[tempi][tempj].setEnabled(false);
                        model.setValue(tempi, tempj);
                        model.setNextPlayer();
                        
                        if (player1_turn == true) {
                        	turn.setText("Player 2 Turn: O");
                        	player1_turn = false;
                        } else {
                        	turn.setText("Player 1 Turn: X");
                        	player1_turn = true;
                        }
                    }
                });
                gameBoard.add(board[i][j]);
            }
    }

    public void setColor(Color color)
    {
        background = color;
        setUp();
    }

    public void gameEnd() {
        System.out.println("Game End");
        JFrame end = new JFrame("Winner!");
        
    }

    //Updates the view of the board
    public void update() {

    }
}