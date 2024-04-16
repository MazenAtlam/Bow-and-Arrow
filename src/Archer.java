package App;
import processing.core.PApplet;


public class Archer extends Shape {

    static int ammo;
    Arrow [] arrows = new Arrow[20];
    PApplet parent;
    public Archer(PApplet parent, int x, int y,int length,int width,int ammo , String path){

        this.parent = parent;
        this.x = x;
        this.y = y;
        this.length=length;
        this.width=width;
        this.image = parent.loadImage(path);
        Archer.ammo=ammo;
    }



    public void moving(int y){

        if(y<70)
            y = 70;
        else if (y > 500)
            y = 500;
        parent.image(this.image,this.x,y,this.length,this.width);
        this.y=y;
    }

    public void reloading(){
            parent.image(this.image,this.x,this.y,this.length,this.width);
    }

    public void firing(){

        parent.image(this.image,this.x,this.y,this.length,this.width);
        Archer.ammo--;
    }

}
