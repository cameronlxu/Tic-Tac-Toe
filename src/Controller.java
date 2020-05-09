import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    private int color;
    private JFrame style_select;
    private BoardFormatter formatter;
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
                choose_color(new RedFormatter())
        );
        JButton blue = new JButton("Blue");
        blue.setBounds(0, 100, 150, 100);
        blue.addActionListener(choose_color(new BlueFormatter())
        );

        style_select.add(red);
        style_select.add(blue);
        style_select.setSize(150, 220);
        style_select.setLayout(null);
        style_select.setVisible(true);
    }

    public void start_game()
    {
        view.format(formatter);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);
    }
    public ActionListener choose_color(final BoardFormatter format) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                formatter = format;
                style_select.dispose();
                start_game();
            }
        };
    }

}
