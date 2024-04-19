import processing.core.PApplet;


public class Arrow {
    PApplet parent;
    int balloonWidth = Balloon.width;
    int balloonHeight = Balloon.height;
    public float arrow_x = 100;
    public int arrow_y;
    public float arrow_head_x = arrow_x + 40;
    public float arrow_head_y;
    public int y_delay = 60;
    public Arrow(PApplet parent) {
        this.parent = parent;
    }

    public void showAndMove(int k) {
        parent.fill(255, 0, 0);
        parent.ellipse(arrow_x + 3, k + y_delay, 9, 7);
        parent.line(arrow_x, k + y_delay, arrow_x + 40, k + y_delay);
        parent.strokeWeight(1.6F);
        parent.line(arrow_x + 35, k + y_delay, arrow_x + 40, k + y_delay + 1);
        parent.line(arrow_x + 40, k + y_delay, arrow_x + 35, k + y_delay + 1);
        arrow_x += 3;
        arrow_head_x += 3;
    }

    public void collisionDetection(Balloon balloons[]) {
        for (Balloon b : balloons) {
            if ((arrow_head_x < (b.xPos + balloonWidth)) && (arrow_head_x > b.xPos)
                    && (arrow_head_y > b.yPos) && (arrow_head_y < (b.yPos + balloonHeight)))
            {
                if (!b.popped)
                {
                    b.pop();
                    Score.score_calc();
                    // System.out.println(Score.score);
                }
            }
        }

    }

    public void ArrowGo(Balloon balloons[]) {
        arrow_head_y = arrow_y + y_delay;
        showAndMove(arrow_y);
        collisionDetection(balloons);

    }
}
