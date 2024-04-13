import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    int canvasHeight = 500;
    int canvasWidth = 500;

    public void settings() {
        size(canvasWidth, canvasHeight);
    }

    int balloonNum = 2;

    Balloon balloons[] = new Balloon[balloonNum];

    public void setup() {
        int x = 0;
        int dx = Balloon.width;
        for (int i = 0; i < balloonNum; i++) {
            balloons[i] = new Balloon(this, x, 'r');
            balloons[i].setup();
            x += (dx+10);
        }
    }

    public void mousePressed() {
        for (Balloon b : balloons) {
            b.pop();
        }

    }


    public void draw() {
        background(155);

        for (Balloon b : balloons) {
            b.showWithBoundryBox();
            b.updateYPos();
        }

    }
}
