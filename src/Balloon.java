import processing.core.PApplet;
import processing.core.PImage;

public class Balloon {
    int canvasHeight = 500; // copied the canvas dimesnsion from Main.java till i find a better way to
    int canvasWidth = 500; // access them without copying

    PApplet parent;
    PImage balloonImg;
    int color;
    int xPos;
    int yPos;
    int factor = 6; // factor to reduce the balloon image size by
    int balloonWidth = 302 / factor;
    int balloonHeight = 488 / factor;
    boolean popped = false;

    float acc; // pixel/t^2
    float initVelocity = 1; // pixel/t

    public Balloon(PApplet parent, int xPos, char color) {
        this.parent = parent;
        this.xPos = xPos;
        this.color = color;
        acc = (color == 'y' ? 1 : 0);
    }

    public void setup() {
        if (color == 'y') {
            balloonImg = parent.loadImage("../1_deliverables/yballoon.png");
        } else {
            balloonImg = parent.loadImage("../1_deliverables/balloon.png");
        }
        yPos = canvasHeight;
    }

    public void show() {
        parent.image(balloonImg, xPos, yPos, balloonWidth, balloonHeight);
    }
    public void showWithBoundryBox() {
        parent.rect(xPos, yPos, balloonWidth, balloonHeight);
        parent.image(balloonImg, xPos, yPos, balloonWidth, balloonHeight);
    }

    public double deltaY() {
        double dy = initVelocity + (0.5 * acc); // delta S = Vo * dt + 1/2 a dt^2, dt is always 1
        if (popped) {
            dy *= -1;
        }
        return dy;
    }

    public void updateYPos() {
        if (yPos >= (-balloonHeight)) {
            yPos -= deltaY();
        } else {
            yPos = canvasHeight;
        }
    }

    public void pop() {
        if (color == 'y') {
            balloonImg = parent.loadImage("../1_deliverables/yballoon_popped.png");
        } else {
            balloonImg = parent.loadImage("../1_deliverables/balloon_popped.png");
        }
        popped = true;
    }

    // public void getWidth()
    // public void setSize()
}
