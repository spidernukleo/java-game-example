package entities;

public abstract class Entity {
    protected float x,y;
    //abstract entity object which will be extended by any entity in the game
    public Entity(float x, float y){
        this.x=x;
        this.y=y;
    }
}
