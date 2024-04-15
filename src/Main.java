import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(1001, 600);

    }

    int balloonsNumber = 15;
    Balloon balloons[] = new Balloon[balloonsNumber];
    Arrow a;

    public void setup() {
        a = new Arrow(this);
        int x = 201;
        char tmp;
        for (int i = 0; i < balloonsNumber; i++) {
            tmp = i%2 == 1 ? 'r':'y';

            balloons[i] = new Balloon(this, x, tmp);
            balloons[i].setup();
            x+= (balloons[i].width+5);
        }

    }

    public void draw() {
        background(155);
        a.ArrowGo(mouseY, balloons);
        for (Balloon b : balloons) {
            b.show();
            b.updateYPos();
        }

    }
}