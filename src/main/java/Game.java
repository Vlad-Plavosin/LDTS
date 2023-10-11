import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    public static Screen screen;
    TextGraphics graphics;
    Arena arena = new Arena(20,20);

    Game(){
        try {
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if
            graphics = screen.newTextGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private KeyStroke processKeystroke() throws IOException{
        KeyStroke key;
        key = screen.readInput();
        return key;
    }
    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private int processKey(KeyStroke key){
        return arena.processKey(key);
    }
    public void run() throws IOException {
        while (true){
            draw();
            KeyStroke stroke = processKeystroke();
            if(this.processKey(stroke) == 1)
                break;
        }
        System.exit(0);
    }
}
