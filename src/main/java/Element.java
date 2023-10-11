import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    Element(){
        position = new Position(10,10);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected Position position;
    public abstract void draw(TextGraphics t);
}
