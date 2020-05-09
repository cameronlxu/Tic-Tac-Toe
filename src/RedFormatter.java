import java.awt.*;

public class RedFormatter implements BoardFormatter {
	@Override
    public Color formatColor() {
        return Color.RED;
    }

    @Override
    public Font formatText(String font) {
        return new Font(font, Font.BOLD, 13);
    }
}
