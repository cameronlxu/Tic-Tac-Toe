import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    private String font;
    
    private JFrame color_select;
    private JFrame font_select;
    private BoardFormatter formatter;
    
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        startScreen();
    }


    public void startScreen() {
    	color_select = new JFrame("Choose a color!");
    	color_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton red = new JButton("Red");
        red.setBounds(0, 0, 200, 100);
        red.addActionListener(choose_color(new RedFormatter()));
        
        JButton blue = new JButton("Blue");
        blue.setBounds(0, 100, 200, 100);
        blue.addActionListener(choose_color(new BlueFormatter()));

        color_select.add(red);
        color_select.add(blue);
        color_select.setSize(200, 220);
        color_select.setLayout(null);
        color_select.setVisible(true);
    }
    
    public void font_select() {
    	font_select = new JFrame("Choose a Font!");
    	font_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	JButton timesRoman = new JButton("Times New Roman");
    	timesRoman.setBounds(0,0,200,100);
    	timesRoman.addActionListener(choose_font("TimesRoman"));
    	
    	JButton chalkboard = new JButton("Chalkboard");
    	chalkboard.setBounds(0,100,200,100);
    	chalkboard.addActionListener(choose_font("Chalkboard"));
    	
    	font_select.add(timesRoman);
    	font_select.add(chalkboard);
    	font_select.setSize(200, 220);
    	font_select.setLayout(null);
    	font_select.setVisible(true);
    }

    public void start_game()
    {
        view.format(formatter, font);
        for (int i = 0; i < model.getCurrentBoard().length; i++)
            for (int j = 0; j < model.getCurrentBoard()[i].length; j++) {
                int tempi = i;
                int tempj = j;
                view.getBoard()[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        model.setValue(tempi, tempj);
                        if (!model.hasWinner() && !model.boardFull()) {
                            model.setNextPlayer();
                            model.resetUndo();
                            view.changeTurn();
                        }
                    }
                });
            }

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);
    }
    
    public ActionListener choose_color(final BoardFormatter format) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                formatter = format;
                color_select.dispose();
                font_select();
            }
        };
    }
    
    public ActionListener choose_font(String font_style) {
    	return new ActionListener() {
    		public void actionPerformed(ActionEvent event) {
    			font = font_style;
    			font_select.dispose();
    			start_game();
    		}
    	};
    }

}