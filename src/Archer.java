import processing.core.PApplet;
import processing.core.PImage;

public class Archer extends Shape {
    int mouse_y;
    PImage state1, state2, state3;
    PApplet parent;

    public Archer(PApplet parent, int x, int y, int length, int width) {

        this.parent = parent;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.image = parent.loadImage("../1_deliverables/state1.png");
    }

    public int archerYPos(boolean Dragged) {
        if (parent.mousePressed && parent.mouseButton == parent.LEFT) {
            if (Dragged && parent.mouseX >= this.x && parent.mouseX <= (this.x + this.width)) {
                mouse_y = parent.mouseY;
            }
        }
        return mouse_y;

    }

    public void moving(int y) {

        if (y < 70)
            y = 70;
        else if (y > 500)
            y = 500;
        parent.image(this.image, this.x, y, this.length, this.width);
        this.y = y;
    }

    public void reloading() {
        image = state3;
        parent.image(this.image, this.x, this.y, this.length, this.width);
    }

    public void firing() {
        Main.reloaded = false;
        image = state1;
        parent.image(this.image, this.x, this.y, this.length, this.width);
        Main.arrows[Main.availableArrows].arrow_y=this.y;
        Main.availableArrows++;
        Main.ammo--;
        System.out.println(Main.ammo);
    }

    public void entryMethod() {
        if (Main.reloaded) {
            reloading();
        }
        if (Main.fire) {
            firing();
            Main.fire = false;
        }
        moving(archerYPos(Main.Dragged));
        if (parent.mousePressed && (parent.mouseButton == parent.LEFT)) {
            Main.Dragged = true;
        }
    }

    public void setup() {
        state1 = parent.loadImage("../1_deliverables/state1.png");
        state2 = parent.loadImage("../1_deliverables/state2.png");
        state3 = parent.loadImage("../1_deliverables/state3.png");
    }

    // @Override
    // public void mouseDragged() {
    // Dragged = true;
    // }
    // @Override
    // public void mouseReleased() {
    // if (parent.mouseButton == parent.LEFT)
    // Dragged = false;
    // }

}
