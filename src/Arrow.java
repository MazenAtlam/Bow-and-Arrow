import processing.core.PApplet;

public class Arrow {
    PApplet parent = new PApplet();
    // public Arrow(PApplet parent){

    // this.parent = parent;
    // }
    public float arrow_x = 100;

    public void moving(int k, Balloon b) {

        parent.ellipse(arrow_x + 3, k + 43, 9, 7);
        parent.fill(150, 0, 0);
        parent.line(arrow_x, k + 43, arrow_x + 40, k + 43);
        parent.strokeWeight(1.6F);
        parent.line(arrow_x + 35, k + 43, arrow_x + 40, k + 44);
        parent.line(arrow_x + 40, k + 43, arrow_x + 35, k + 44);
        arrow_x += 2;
        if (arrow_x == b.xPos && k == b.yPos) {
            b.pop();
        }

    }

}