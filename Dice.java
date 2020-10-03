package theseus.dnd2;

import java.util.Random;

/**
 *
 * Provides basic functionality for simulating a die. Material, color, and 
 * number of sides are customizable. #totallyDidntWriteInCS302
 * 
 * @author Tim Hinkens
 * @date 6/29/2017
 */
public class Dice {
    
    private String material, color;
    private int numSides;
    
    private final Random RNG = new Random();
    
    /**
     * 
     * Instantiates a white plastic d6
     */
    public Dice() {
        
        material = "plastic";
        color = "white";
        numSides = 6;
    }
    
    public Dice(int numSides) {
        
        material = "";
        color = "";
        this.numSides = numSides;
    }
    
    /**
     * 
     * Simulates rolling a die
     * 
     * @return a pseudorandom integer between 1 and the number of sides of the die
     */
    public int rollDie() {
        
        return RNG.nextInt(numSides) + 1;
    }
    
    public void setMaterial(String material) {
        
        this.material = material;
    }
    
    public void setColor(String color) {
        
        this.color = color;
    }
    
    public void setSides(int numSides) {
        
        this.numSides = numSides;
    }
    
    public String getMaterial() {
        
        return material;
    }
    
    public String getColor() {
        
        return color;
    }
    
    public int getSides() {
        
        return numSides;
    }
    
    /**
     * 
     * @return a textual representation of a singular <code>Dice</code>, 
     * including information about its material, color, and how many sides it 
     * has.
     */
    @Override
    public String toString() {
        
        return "This is a " + material + ", " + color + " " + numSides + "-sided die";
    }
}
