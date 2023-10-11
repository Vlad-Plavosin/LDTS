import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    Hero hero = new Hero(10,10);
    private List<Wall> walls;
    private List<Coin> coins;
    int width = 20;
    int height = 20;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public int processKey(KeyStroke key){

        if(key.getKeyType() == KeyType.Character){
            char keychar = key.getCharacter();
            switch (keychar){
                case 'q':
                    return 1;
                case 'w':
                    moveHero(hero.moveUp());
                case 'a':
                    moveHero(hero.moveLeft());
                case 's':
                    moveHero(hero.moveDown());
                case 'd':
                    moveHero(hero.moveRight());
            }
        }
        System.out.println(key.getCharacter());
        return 0;
    }
    private boolean canHeroMove(Position p, List<Wall> walls){
        for(Wall wall:walls)
            if(wall.getPosition().equals(p))
                return false;
        return true;
    }
    private Coin checkCoins(Position p) {
        for(Coin c : coins){
            if(c.position == p)
                return c;
        }
        return null;
    }
    private void moveHero(Position p){
        if(canHeroMove(p,walls))
            hero.setPosition(p);
        Coin c = checkCoins(p);
        if(c != null) {
            coins.remove(c);
        }
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }
    public void draw(TextGraphics t){
        t.setBackgroundColor(TextColor.Factory.fromString("#227788"));
        t.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height),' ');
        for(Wall wall: walls){
            wall.draw(t);
        }
        for(Coin coin : coins){
            coin.draw(t);
        }
        this.hero.draw(t);
    }
}
