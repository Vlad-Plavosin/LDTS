import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    Wall(int x, int y){
        position = new Position(x,y);
    }
    @Override
    public void draw(TextGraphics t){
        t.setForegroundColor(TextColor.Factory.fromString("#339911"));
        t.enableModifiers(SGR.BOLD);
        t.putString(new TerminalPosition(position.getX(), position.getY()),"O");
        Game.screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('O')
                [0]);
    }
}
