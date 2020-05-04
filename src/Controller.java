import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    private int color;
    private JFrame style_select;
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;

        startScreen();
    }
    public void startScreen() {
        style_select = new JFrame("Choose a color!");
        style_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton red = new JButton("Red");
        red.setBounds(0, 0, 150, 100);
        red.addActionListener(
                choose_color(1)
        );
        JButton blue = new JButton("Blue");
        blue.setBounds(0, 100, 150, 100);
        blue.addActionListener(choose_color(2)
        );

        style_select.add(red);
        style_select.add(blue);
        style_select.setSize(150, 220);
        style_select.setLayout(null);
        style_select.setVisible(true);
    }

    public int getColor()
    {
        return color;
    }
    public void start_game()
    {
        JFrame frame = new JFrame();
        if (getColor() == 1) {
            view.setBackground(Color.RED);
        } else if (getColor() == 2){
            view.setBackground(Color.BLUE);
        }
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
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
