import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(600,600);

    }

    Balloon b;
    Arrow a;
    public void setup(){
        b = new Balloon(this, 500, 'r');
        a = new Arrow(this);
        b.setup();

    }

    
    public void draw(){
        background(155);
        a.moving(mouseY, b);
        b.show();
        b.updateYPos();


    }
}