package project;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model {
    private int color;
    private JFrame style_select;
    private View view;

    // Initial frame for users to select a game board color
    Model(){
        style_select = new JFrame("Choose a color!");
        style_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton red = new JButton("Red");
        red.setBounds(0,0,150,100);
        red.addActionListener(
            choose_color(1)
        );
        JButton blue = new JButton("Blue");
        blue.setBounds(0,100,150,100);
        blue.addActionListener(
            choose_color(2)
        );
        
        style_select.add(red);
        style_select.add(blue);
        style_select.setSize(150,220);
        style_select.setLayout(null);
        style_select.setVisible(true);
    }
    
    public int getColor() {
        return color;
    }
    
    private JFrame window;
    private JPanel board;
    private boolean player1_turn;
    public void start_game() {
        window = new JFrame("Tic Tac Toe");
        board = new JPanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Determine color of board
        if (getColor() == 1) {
            board.setBackground(Color.RED);
        } else if (getColor() == 2){
            board.setBackground(Color.BLUE);
        }
        
        JLabel turn = new JLabel("Player 1 Turn\n");
        board.add(turn);
        
        player1_turn = true;
        
        board.setLayout(new GridLayout(3,3,5,5));
        
        for(int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.setSize(100, 100);
            button.addActionListener(event -> {
                if (player1_turn == true) {
                    turn.setText("Player 2 Turn");
                    player1_turn = false;
                } else {
                    turn.setText("Player 1 Turn");
                    player1_turn = true;
                }
            });
            board.add(button);
        }
        
        window.add(board);
        window.pack();
        window.setVisible(true);
    }
    
    // Once users select a game board color, call start_game to begin the game and create the next frame
    public ActionListener choose_color(final int chosen_color) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                color = chosen_color;
                style_select.dispose();
                start_game();
            }
        };
    }
}
