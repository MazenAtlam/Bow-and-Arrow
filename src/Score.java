import processing.core.PApplet;

public class Score  {
PApplet parent;
public Score(PApplet parent){
    this.parent = parent;
}
static int score = 0;
static int highscore;
static int shotBalloons = 0;

public static int score_calc() {
    shotBalloons++;

    score = (Main.ammo + 1) * shotBalloons;
    System.out.println(score);
    return score;
}
public static int Update_highscore() {
    if (score>highscore){
        highscore = score;
    }
    return highscore;
}

}
