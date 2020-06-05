package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.1 Creating Monster class
 *      > added Element enumerator
 *      > added field variables: name, monster, element, and all stats
 *      
 */
public class Monster {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String name; // unique name of the mosnter
    private String monster; // monster group
    private Element element;
    private int baseHP, baseATK, baseDEF, baseSPD;
    private int baseCRIRate, baseCRIDmg, baseRes, baseAcc;
    
    

    
    public enum Element {
        FIRE("Fire"), WATER("Water"), WIND("Wind"), LIGHT("Light"), DARK("Dark");
        
        private String name;
        
        private Element(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() { return this.name; }
    }
    
}
