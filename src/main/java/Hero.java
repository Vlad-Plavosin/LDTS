import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    Hero(int x, int y){
        position = new Position(x,y);
    }

    public Position moveUp() {
        return new Position(position.getX(),position.getY()-1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
            return new Position(position.getX()-1,position.getY());
    }

    public Position moveRight() {
            return new Position(position.getX()+1,position.getY());
    }
    @Override
    public void draw(TextGraphics t){
        t.setForegroundColor(TextColor.Factory.fromString("#00FF22"));
        t.enableModifiers(SGR.BOLD);
        t.putString(new TerminalPosition(position.getX(), position.getY()),"X");
        Game.screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')
                [0]);
    }
}
