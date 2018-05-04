package theseus.dnd2;

import com.badlogic.gdx.graphics.Texture;

/**
 * Class <code>Item</code> contains necessary information and operations to
 * define an <code>Item</code>.
 * 
 * @author thinkens
 * on 7/17/2017
 * @since 0.1.0
 * @see Drawable
 */
public class Item implements Drawable {
    
    protected String name, flavorText;
    private float x = 0, y = 0;
    private int value;
    private Texture texture;

    
    @Override
    public void mirrorTexture() {

        
    }
    
    public void setCoordinates(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    /**
     * 
     * @param texture The <code>Texture</code> that this <code>Item</code> 
     * should display
     * @see Drawable
     */
    @Override
    public void setTexture(Texture texture) {
        
        this.texture = texture;
    }
    
    public void setValue(int value) {
        
        this.value = value;
    }
    
    public float[] getCoordinates() {
        
        float[] coords = {x,y};
        return coords;
    }
    
    public String getName() {
        
        return name;
    }
    
    /**
     * 
     * @return the current <code>Texture</code> of this <code>Item</code>
     * @see Drawable
     */
    @Override
    public Texture getTexture() {
        
        return texture;
    }
    
    public int getValue() {
        
        return value;
    }

    @Override
    public String getTextureName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTextureName(String texName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
