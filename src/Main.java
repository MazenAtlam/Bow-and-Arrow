import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    static boolean Dragged = false;
    static boolean reloaded = false;
    static boolean fire = false;
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    Archer archer;

    public void settings() {
        size(1000,600);

    }

    public void setup() {
        archer = new Archer(this, 0, height/2, 90, 90, 20);
        archer.setup();
    }

    public void draw() {
        background(155);
        archer.entryMethod();
    }

    @Override
    public void mousePressed(){
        if (mouseButton == LEFT && reloaded) {
            fire = true;
        }
        else if (mouseButton == RIGHT) {
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

}

/*
 * import App.Archer;
import App.Arrow;
import processing.core.PApplet;
import processing.core.PImage;

import java.sql.Array;

public class Main extends PApplet {  public static void main(String[] args) {
    PApplet.main("Main");
}
    Archer ar;
    PImage state1, state2,  state3;
    Arrow arrow = new Arrow(this);
    int mouse_y;
    int arrow_y;
    short f = 0;
    boolean Dragged = false;
    boolean flag = false;
    boolean reloaded = false;


    public void settings(){
        size(1000,600);
    }

    public void setup(){
        state1 = loadImage("D:\\game\\bow_and_arrow\\1_deliverables\\state1.png");
        state2 = loadImage("D:\\game\\bow_and_arrow\\1_deliverables\\state2.png");
        state3 = loadImage("D:\\game\\bow_and_arrow\\1_deliverables\\state3.png");
        mouse_y = height/2;
        ar = new Archer(this,0,mouse_y,90,90, 20,"D:\\game\\bow_and_arrow\\1_deliverables\\state1.png");
    }
    public void draw(){
        background(0,155,0);


        if (f==1) {
            ar.image = state2;
            ar.reloading();
            ar.image=state3;
            ar.reloading();
            reloaded = true;
        }

        else if(reloaded && f==2 && mouseX > (ar.x + ar.width) && mousePressed)
        {
            arrow_y = mouse_y;
            ar.firing();
            ar.image=state1;
            flag = true;
            f=0;
            reloaded =false;
        }

        else {
            ar.moving(mouse_y);
        }

        if (mousePressed && mouseButton == LEFT)
        {
            if (Dragged && mouseX >= ar.x && mouseX <= (ar.x + ar.width))
            {
                mouse_y = mouseY;
            }
        }
        if(flag)
            arrow.moving(arrow_y);

    }

    public void mousePressed()
    {
        if (mouseButton == LEFT && reloaded) {
            f = 2;


        }
        else if (mouseButton == RIGHT) {
            f = 1;
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
}
 */