import java.awt.*;


public class RedFormatter implements BoardFormatter {
    public Color formatColor() {
        return Color.RED;
    }

    @Override
    public Font formatText() {
        return new Font("TimesRoman", Font.ITALIC, 13);
    }


}
