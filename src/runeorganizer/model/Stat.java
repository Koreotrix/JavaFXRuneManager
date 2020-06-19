package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.2 Created Stat class
 *      > added StatType enumerator
 *      > added Field Variables type and value
 *      > added constructors
 *      > added accessors
 *      > added mutators
 *      > override toString() method
 */
public class Stat {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private StatType type;
    private int value;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Stat(StatType type, int value) {
        this.type = type;
        this.value = value;
    }
    
    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public StatType getStatType() { return this.type; }
    public int getValue() { return this.value; }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setValue(int value) { this.value = value; }
    
    // Overrides ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public String toString() {
        
        if (type == StatType.CRIRATE || type == StatType.RES 
                || type == StatType.ACC) {
            
            // CRI Rate, Res and Acc all cap at 100     
            if (value > 100)  return type + ": " + 100;
            
        } return type + ": " + value;
    }
    
    // Internal classes ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public enum StatType {
        HP("HP"), ATK("ATK"), DEF("DEF"), SPD("SPD"), CRIRATE("CRI Rate"), 
        CRIDMG("CRI Dmg"), RES("Resistance"), ACC("Accuracy");
        
        private String name;
        
        private StatType(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() { return this.name; }
    }
}
