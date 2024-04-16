import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    static boolean Dragged = false;
    static boolean reloaded = false;
    static boolean fire = false;

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT && reloaded) {
            fire = true;
        } else if (mouseButton == RIGHT) {
            reloaded = true;
        }
    }

    @Override
    public void mouseDragged() {
        Dragged = true;
    }

    @Override
    public void mouseReleased() {
        if (mouseButton == LEFT)
            Dragged = false;
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    Archer archer;

    public void settings() {
        size(1000, 600);

    }

    public void setup() {
        archer = new Archer(this, 0, height / 2, 90, 90, 20);
        archer.setup();
    }

    public void draw() {
        background(155);
        archer.entryMethod();
    }

}