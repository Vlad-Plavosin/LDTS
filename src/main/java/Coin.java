import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    Coin(int x, int y){
        position = new Position(x,y);
    }
    @Override
    public void draw(TextGraphics t) {
        t.setForegroundColor(TextColor.Factory.fromString("#00FF22"));
        t.enableModifiers(SGR.BOLD);
        t.putString(new TerminalPosition(position.getX(), position.getY()),"0");
        Game.screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('0')
                [0]);
    }
}
