package theseus.dnd2;

import theseus.dnd2.Weapon.*;

/**
 * Test class for package <code>Dnd2</code>.
 * @author thinkens
 * 
 * on 7/17/2017
 * @since 0.1.0
 */
public class Dnd2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Weapon acid, elec, fire, ice, poison, water;
        
        for(int i = 1; i < 5; i++) {
            acid = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.ACID,i);
            elec = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.ELECTRIC,i);
            fire = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.FIRE,i);
            ice = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.ICE,i);
            poison = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.POISON,i);
            water = new Weapon(WeaponType.DAGGER,WeaponMaterial.BRONZE,WeaponElement.WATER,i);
            
            System.out.println(acid.toString() + '\n' + elec.toString() + '\n' +
                    fire.toString() + '\n' + ice.toString() + '\n' +
                    poison.toString() + '\n' + water.toString() + '\n');
        }
        //Item axe = new Weapon(WeaponType.BATTLEAXE,WeaponMaterial.SILVER,WeaponElement.ICE,4);
        //System.out.println(axe);
    }
}
