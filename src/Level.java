import processing.core.PApplet;

public class Level {
    public static int level_number = 1; // This Variable is used to show text onscreen

    /*
     * level_up - Call This Function When All Balloons are Down To Reset
     * this values and proceed to next level
     */
    public static void level_up(PApplet parent) {
        if (Main.ammo == 1)
        {
            Main.flag = true;
            Main.win_level_1 = true;
            parent.background(0, 165, 0);
            parent.fill(255);
            parent.textSize(38);
            parent.textAlign(parent.CENTER);
            parent.text("Congratulation !\nYou've Successfully Passed Level 1\n\nReady For Level 2 !\n Here You Go\n\nPress (1) To Continue", parent.width / 2, parent.height / 2);
        }
        else if (Main.ammo == 2 && Main.Win)
        {

            Main.flag = true;
            parent.background(0, 165, 0);
            parent.fill(255);
            parent.textSize(38);
            parent.textAlign(parent.CENTER);
            parent.text("Congratulation !\nYou've Successfully Win The Game\n\nPress (1) To Start Again OR (0) To Exit", parent.width / 2, parent.height / 2);
            Main.win_level_2 = true;
        }
    }
    public static void hard_luck(PApplet parent) {
        Level.level_up(parent);
        if (Main.ammo == 0 && Balloon.getPoppedBalloon() != 15)
        {
            Main.flag = true;
            parent.background(0, 165, 0);
            parent.fill(255, 0, 0);
            parent.textSize(38);
            parent.textAlign(parent.CENTER);
            parent.text("Hard Luck!\n\nPress (1) To Start Again OR (0) To Exit", parent.width / 2, parent.height / 2);
        }
    }
}