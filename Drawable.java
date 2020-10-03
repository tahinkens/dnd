package theseus.dnd2;

import com.badlogic.gdx.graphics.Texture;

/**
 * <code>Drawable</code> specifies the necessary components of an object to be 
 * successfully rendered via OpenGL.
 * 
 * @author thinkens
 * on 7/18/2017
 * @since 0.1.0
 */
public interface Drawable {
    

    /**
     * Flips the current <code>Texture</code> of this object over the y-axis.
     * This is necessary for objects that move left to right across the screen.
     */
    public void mirrorTexture();
    
    /**
     * 
     * @return the <code>Texture</code> that this object is represented by
     */
    public Texture getTexture();
    
    /**
     * 
     * @return a String containing the filename of the image file of this object's
     *         texture
     */
    public String getTextureName();
    
    /**
     * Assigns a new <code>Texture</code> to represent this object.
     * 
     * @param texture 
     */
    public void setTexture(Texture texture);
    
    /**
     * 
     * @param texName the filename (including extension) of the desired image
     *                file to be used as a texture
     */
    public void setTextureName(String texName);
}
