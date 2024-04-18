import processing.core.PApplet;
import processing.core.PImage;

public class Balloon {
    int canvasWidth;
    private int canvasHeight;

    private PApplet parent;
    private PImage balloonImg;
    private int color;
    int xPos;
    int yPos;
    private static int factor = 6; // factor to reduce the balloon image size by
    static int width = 302 / factor;
    static int height = 488 / factor;
    boolean popped = false;
    private static int poppedBalloon = 0;

    float acc; // pixel/t^2
    float initVelocity = 1; // pixel/t


    public static int getPoppedBalloon() {
        return (poppedBalloon);
    }
    public Balloon(PApplet parent, int xPos, char color) {
        this.parent = parent;
        this.xPos = xPos;
        this.color = color;
        this.canvasHeight = parent.height;
        this.canvasWidth = parent.width;
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
        parent.image(balloonImg, xPos, yPos, width, height);
    }
    // public void showDebugging() {
    //     parent.circle(xPos, yPos, 5);
    //     parent.circle(xPos, yPos+height, 5);
    //     parent.image(balloonImg, xPos, yPos, width, height);
    // }

    private double deltaY() {
        double dy = initVelocity + (0.5 * acc); // delta S = Vo * dt + 1/2 a dt^2, dt is always 1
        if (popped) {
            dy *= -1;
        }
        return dy;
    }

    public void updateYPos() {
        if (yPos >= (-height)) {
            yPos -= deltaY();
        } else {
            yPos = canvasHeight;
        }
    }

    public void pop() {
        popped = true;
        Balloon.poppedBalloon++;
        System.out.println(Balloon.poppedBalloon);
        if (color == 'y') {
            balloonImg = parent.loadImage("../1_deliverables/yballoon_popped.png");
        } else {
            balloonImg = parent.loadImage("../1_deliverables/balloon_popped.png");
        }
        popped = true;
    }

}
