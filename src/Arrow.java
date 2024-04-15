import processing.core.PApplet;

public class Arrow {
    PApplet parent;

    public Arrow(PApplet parent) {

        this.parent = parent;
    }

    public void showAndMove(int k) {
        parent.ellipse(arrow_x + 3, k + 43, 9, 7);
        parent.fill(150, 0, 0);
        parent.line(arrow_x, k + 43, arrow_x + 40, k + 43);
        parent.strokeWeight(1.6F);
        parent.line(arrow_x + 35, k + 43, arrow_x + 40, k + 44);
        parent.line(arrow_x + 40, k + 43, arrow_x + 35, k + 44);
        // parent.circle(arrow_head_x, arrow_head_y, 5);
        if (arrow_x >= parent.width) {
            arrow_x = 100;
            arrow_head_x = 140;
        } else {
            arrow_x += 2;
            arrow_head_x += 2;
        }
    }

    public float arrow_x = 100;
    public float arrow_head_x = arrow_x + 40;
    public float arrow_head_y;

    public void ArrowGo(int k, Balloon balloons[]) {
        arrow_head_y = k + 43;
        showAndMove(k);

        for (Balloon b : balloons) {
            if ((arrow_head_x < (b.xPos + b.width)) && (arrow_head_x > b.xPos)
                    && (arrow_head_y > b.yPos) && (arrow_head_y < (b.yPos + b.height))) {
                b.pop();
            }
        }

    }

}