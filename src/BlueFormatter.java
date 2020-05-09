import java.awt.*;

public class BlueFormatter implements  BoardFormatter{
    @Override
    public Color formatColor() {
        return new Color(51,204,255);
    }

    @Override
    public Font formatText(String font) {
        return new Font(font, Font.BOLD, 13);
    }
}
