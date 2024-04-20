import processing.core.PApplet;

public class Score  {
PApplet parent;
public Score(PApplet parent){
    this.parent = parent;
}
static int score = 0;
static int level1_score = 0;
static int highscore;
static int shotBalloons = 0;

public static void score_calc() {
    shotBalloons++;

    score = ((Main.ammo + 1) * shotBalloons) + level1_score;
}
public static void Update_highscore() {
    if (score>highscore){
        highscore = score;
    }
}

}
