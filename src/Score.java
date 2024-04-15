import processing.core.PApplet;

public class Score  {
PApplet parent;
public Score(PApplet parent){
    this.parent = parent;
}
int Score = 0;
int highscore;

public int Score_calc(int remArrows,int shotBallons){

    Score = (remArrows +1)*shotBallons;
    return Score;
}
public int Update_highscore(int Score){
    if (Score>highscore){
        highscore = Score;
    }
    return highscore;
}

}