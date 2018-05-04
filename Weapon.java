package theseus.dnd2;

import java.util.Random;

/**
 * The <code>Weapon</code> class contains information and operations necessary
 * to define an <code>Item</code> that can be used as a weapon.
 * 
 * @author thinkens
 * on 7/17/2017
 * @since 0.1.0
 * @see Item
 * @see Drawable
 */
public class Weapon extends Item implements Drawable {
    
    /**
     * WeaponType is the type of <code>Weapon</code> this is. Type is related
     * to damage, attack speed, and name.
     */
    public enum WeaponType {BATTLEAXE, DAGGER, FLAIL, GREATSWORD, HALBERD, 
            LONGSWORD, MACE, PIKE, SHORTSWORD, SPEAR, WARAXE, WARHAMMER}
    public enum WeaponMaterial {BRONZE, IRON, GOLD, SILVER, STEEL, STYGIAN}
    public enum WeaponElement {NONE, ACID, ELECTRIC, FIRE, ICE, POISON, 
            WATER}
    
    private float damage;
    private int elementStrength, techPool;

    private final WeaponType type;
    private final WeaponMaterial material;
    private final WeaponElement element;
    
    private static final String[] ELEMENT_PREFIXES = {"Acidic ","Caustic ",
            "Corrosive ","Hydrogenolysing ","Static ","Charged ","Shocking ",
            "Electocuting ","Smoldering ","Burning ","Flaming ","Incinerating ",
            "Chilled ","Icy ","Frozen ","Sheer ","Nauseating ","Sickening ",
            "Repugnant ","Toxic ","Moist ","Wet ","Drowned ","Tidal "};
    
    /**
     * Default constructor. Instantiates a <code>Weapon</code> with random 
     * properties. 
     */
    public Weapon() {
        
        Random rng = new Random();
        int elementRoll = rng.nextInt(20) + 1; //have the weapon an element?
        int elementStrengthRoll = rng.nextInt(20) + 1;
        
        this.type = WeaponType.values()[rng.nextInt(12)];
        this.material = WeaponMaterial.values()[rng.nextInt(6)];
        if(elementRoll > 16) {
            this.element = WeaponElement.values()[rng.nextInt(6) + 1];
            if(elementStrengthRoll == 20) elementStrength = 4; //assign elementStrength based on a die roll
            else if(elementStrengthRoll >= 16) elementStrength = 3;
            else if(elementStrengthRoll >= 11) elementStrength = 2;
            else elementStrength = 1;
        }
        else this.element = WeaponElement.NONE;
        this.name = assignName();
    }
    
    /**
     * Bare-bones constructor. Instantiates a <code>Weapon</code> with random
     * properties within the limitations of the passed arguments.
     * 
     * @param type The type of weapon (e.g. DAGGER, WARHAMMER, etc.)
     * @param material The material the weapon is made from (e.g. IRON)
     * @param element The magical element of the weapon (e.g. FIRE, NONE)
     * @param elementStrength How powerful the elemental magic is, 1-4
     */
    public Weapon(WeaponType type, 
            WeaponMaterial material, 
            WeaponElement element,
            int elementStrength) {
        
        this.type = type;
        this.material = material;
        this.element = element;
        this.elementStrength = elementStrength;
        this.name = assignName();
    }
    
    /**
     * Assigns a name to a <code>Weapon</code> based on its properties.
     * 
     * @return a String containing the name of this <code>Weapon</code>.
     */
    private String assignName() {
        
        String output = "";
        switch(element) {
            case ACID:
                output = ELEMENT_PREFIXES[elementStrength - 1];
                break;
            case ELECTRIC:
                output = ELEMENT_PREFIXES[elementStrength + 3];
                break;
            case FIRE:
                output = ELEMENT_PREFIXES[elementStrength + 7];
                break;
            case ICE:
                output = ELEMENT_PREFIXES[elementStrength + 11];
                break;
            case POISON:
                output = ELEMENT_PREFIXES[elementStrength + 15];
                break;
            case WATER:
                output = ELEMENT_PREFIXES[elementStrength + 19];
                break;
        }
        return (output + material + " " + type).toUpperCase();
    }

    public float getDamage() {
        
        return damage;
    }
    
    public int getTechPool() {
        
        return techPool;
    }

    public void setDamage(float damage) {
        
        this.damage = damage;
    }
    
    public void setTechPool(int techPool) {
        
        this.techPool = techPool;
    }
    
    @Override
    public String toString() {
        
        return this.name;
    }
}
