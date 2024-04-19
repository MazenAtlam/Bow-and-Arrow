import processing.core.PApplet;
public class U_I {
    public static void show_user_interface(PApplet parent) {
        parent.background(0, 165, 0); // Setting Green Colour Of Game Background
        parent.fill(150); // Gray Colour Panel
        parent.rect(0, 0, parent.width, 100); // Panel Is in Shape Of Rectangle
        parent.fill(0); // Text To Be Written in Black
        parent.textSize(22); // Size Of The Text
        parent.textAlign(parent.LEFT);
        parent.text("Score: " + Score.score, 15, 45);
        parent.text("High Score: " + Score.highscore, 15, 80);
        parent.textAlign(parent.CENTER);
        parent.text("Level " + Level.level_number + "\n" + Level.name[Level.level_number - 1], parent.width / 2, 25);
        parent.textAlign(parent.RIGHT);
        parent.text("Available Arrows: " + Main.ammo, parent.width - 25, 80);
        Level.gameLogic(parent);
    }
}
