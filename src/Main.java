import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    static boolean Dragged = false;
    static boolean reloaded = false;
    static boolean fire = false;
    static Balloon balloons[] = new Balloon[15];
    static int ammo = 20;
    static int availableArrows = 0;
    static Arrow[] arrows = new Arrow[ammo];

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT && reloaded) {
            fire = true;
            arrows[1].ArrowGo(500, balloons);
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
        archer = new Archer(this, 0, height / 2, 90, 90);
        archer.setup();
        for(int i = 0; i<ammo; i++) {
            arrows[i] = new Arrow(this);
        }
        int x = 300;
        for(int i = 0; i<15; i++) {
            balloons[i] = new Balloon(this, x, 'r');
            balloons[i].setup();
            x+= Balloon.width+5;
        }
    }

    public void draw() {
        background(155);
        archer.entryMethod();
        for(Balloon b : balloons){
            b.show();
            b.updateYPos();
        }
        for(int i=0; i<availableArrows; i++){
            arrows[i].ArrowGo(Archer.y, balloons);

        }
    }

}