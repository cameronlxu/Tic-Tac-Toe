import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class View extends JFrame {
    private Model model;
    private JButton[][] board;
    private Color background;
    private Font font;
    private boolean player1_turn;
    private JFrame winner;
    private JLabel turn;

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
        
        JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.undo();
            }
        });
        sidePanel.add(undo);
        
        // JLabel to display whose turn it is
        turn = new JLabel("Player 1 Turn: X");
        turn.setFont(font);
        sidePanel.add(turn);
        
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
                board[i][j].setFont(font);
                board[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        board[tempi][tempj].setText(model.getPlayer());
                        board[tempi][tempj].setEnabled(false);
                        model.setValue(tempi, tempj);

                        if(!model.hasWinner() && !model.boardFull())
                        {
                            model.setNextPlayer();
                            model.resetUndo();
                            changeTurn();
                        }
                    }
                });
                gameBoard.add(board[i][j]);
            }
    }

    public void format(BoardFormatter formatter, String font_style)
    {
        background = formatter.formatColor();
        font = formatter.formatText(font_style);
        setUp();
    }
    
    public void gameEnd(String message) {
        if(!model.hasWinner())
            turn.setText(message);
        else if(model.getPlayer().equals("X"))
            turn.setText("Player 1 Wins!");
        else
            turn.setText("Player 2 Wins!");

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(board[i][j].isEnabled())
                    board[i][j].setEnabled(false);
    }

    public void gameEnd(boolean player1_turn) {
    	// Check to see who won
    	if (player1_turn == true) {
    		turn.setText("Player 1 Wins!");
    	} else {
    		turn.setText("Player 2 Wins!");
    	}
    	
    	// disable the rest of the buttons because the game has ended
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[i].length; j++) {
    			if(board[i][j].isEnabled() == true) {
    				board[i][j].setEnabled(false);
    			}
    		}
    	}	
    }
    
    public void changeTurn()
    {
        if(model.getPlayer().equals("X"))
            turn.setText("Player 1 Turn: X");
        else
            turn.setText("Player 2 Turn: O");
    }

    //Updates the view of the board
    public void update() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setText(model.getCurrentBoard()[i][j]);
                board[i][j].setEnabled(model.getCurrentBoard()[i][j].equals(""));
            }
        changeTurn();
    }
}