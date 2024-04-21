import processing.core.PApplet;
import processing.core.PConstants;
public class U_I {
    public static void show_user_interface(PApplet parent) {
        parent.fill(150); // Gray Colour Panel
        parent.rect(0, 0, parent.width, 100); // Panel Is in Shape Of Rectangle
        parent.fill(0); // Text To Be Written in Black
        parent.textAlign(PConstants.LEFT);
        parent.textSize(22); // Size Of The Text
        parent.text("Score: " + Score.score, 15, 45);
        parent.text("High Score: " + Score.highscore, 15, 80);
        parent.textAlign(PConstants.CENTER);
        parent.text("Level " + Level.level_number + "\n" + Level.name[Level.level_number - 1], parent.width / 2, 25);
        parent.textAlign(PConstants.RIGHT);
        parent.text("Available Arrows: " + Main.ammo, parent.width - 25, 80);
        Level.gameLogic(parent);
    }
}
