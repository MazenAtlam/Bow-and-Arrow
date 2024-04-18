import processing.core.PApplet;

public class Main extends PApplet {
    static boolean Dragged = false;
    static boolean reloaded = false;
    static boolean fire = false;
    static boolean flag = false;
    static boolean Win = false;
    static boolean win_level_2 = false;
    static boolean win_level_1 = false;
    static Balloon balloons[] = new Balloon[15];
    static int ammo = 20;
    static int availableArrows = 0;
    static Arrow[] arrows = new Arrow[ammo];


    public void restartGame() {
         Dragged = false;
         reloaded = false;
         fire = false;
         flag = false;
    //   lost = false;
         Win = false;
        ammo = 20;
        Level.level_number = 1;
        availableArrows = 0;
        Score.score = 0;
        Score.shotBalloons = 0;
        String[] args = {""};
        main(args);
    }
    public static void level_up() {
        Dragged = false;
        reloaded = false;
        fire = false;
        flag = false;
        // lost = false;
        Win = true;
       ammo = 20;
       win_level_1 = false;
       Level.level_number = 2;
       availableArrows = 0;
       Score.score = 0;
       Score.shotBalloons = 0;
       String[] args = {""};
       main(args);
   }
    @Override
    public void keyPressed() {
        if (flag)
        {
            if (key == '1')
            {
                if (win_level_1)
                {
                    level_up();
                }
                else
                {
                    restartGame();
                }
            }
            else if (key == '0')
                exit();
        }
    }

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT && reloaded) {
            fire = true;
        } else if (mouseButton == RIGHT) {
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

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    Archer archer;

    public void settings() {
        size(1920, 1080);

    }

    public void setup() {
        frameRate(60);
        smooth();
        archer = new Archer(this, 10, 500, 120, 150);
        archer.setup();
        for(int i = 0; i < ammo; i++) {
            arrows[i] = new Arrow(this);
        }
            int x = width - (Balloon.width + 390);
            if (!Win)
            {
                for (int i = 0; i<15; i++) {
                    balloons[i] = new Balloon(this, x, 'r');
                    balloons[i].setup();
                    x -= Balloon.width + 5;
                }
            }
            else
            {
                for (int i = 0; i < 12; i++)
                {
                    balloons[i] = new Balloon(this, x, 'r');
                    balloons[i].setup();
                    x -= Balloon.width + 5;
                }
                for (int i = 12; i < 15; i++)
                {
                    balloons[i] = new Balloon(this, x, 'y');
                    balloons[i].setup();
                    x  = (int) random(x, (width - (Balloon.width + 50)));
                }
            }
    }

    public void draw() {
        U_I.show_user_interface(this);
        if (!flag)
        {
            Score.Update_highscore();
            archer.entryMethod();
            for(Balloon b : balloons){
                b.show();
                b.updateYPos();
            }
            for(int i=0; i<availableArrows; i++){
                arrows[i].ArrowGo(balloons);
            }
        }

    }

}