package theseus.dnd2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Class <code>GameCharacter</code> contains necessary information and operations
 * to define a <code>GameCharacter</code>.
 * 
 * @author thinkens
 * on 7/18/2017
 * @since 0.1.0
 * @see Drawable
 */
public class GameCharacter implements Drawable {
    
    private String name, textureName;
    private int hp, xp;
    private float x, y, vx, vy;
    private Texture texture;

    
    /**
     * Switches the <code>textureName</code> between the left facing and right
     * facing versions of this <code>GameCharacter</code>'s texture
     */
    @Override
    public void mirrorTexture() {
        
        
    }
    
    public void move() {
        
        while(Gdx.input.isKeyPressed(Input.Keys.A)) vx = -50;
        vx = 0;
        while(Gdx.input.isKeyPressed(Input.Keys.D)) vx = 50;
        vx = 0;
        
        x += vx;
        y += vy;
    }
    
    public float[] getCoordinates() {
        
        float[] coords = {x,y};
        return coords;
    }
    
    public String getName() {
        
        return name;
    }
    
    @Override
    public Texture getTexture() {
        
        return texture;
    }
    
    public int getHp() {
        
        return hp;
    }
    
    public int getXp() {
        
        return xp;
    }
    
    public void setCoordinates(float x, float y) {
        
        this.x = x;
        this.y = y;
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public void setHp(int hp) {
        
        this.hp = hp;
    }
    
    /**
     * Sets the velocity vector of this <code>GameCharacter</code>
     * 
     * @param vx the desired x-component of the velocity vector
     * @param vy the desired y-component of the velocity vector
     */
    public void setVelocity(float vx, float vy) {
        
        this.vx = vx;
        this.vy = vy;
    }

    public void setXp(int xp) {
        
        this.xp = xp;
    }

    @Override
    public void setTexture(Texture texture) {
        
        this.texture = texture;
    }

    @Override
    public String toString() {
        
        return name + " currently has " + hp + " HP and " + xp + " XP and "
                + "resides at (" + x +  "," + y + ")";
    }

    @Override
    public String getTextureName() {
        
        return textureName;
    }

    @Override
    public void setTextureName(String texName) {
        
        this.textureName = texName;
    }
}
