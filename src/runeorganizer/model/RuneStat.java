package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.3 Added gem and grind factors
 *      > modified RuneStatType to determine if a stat is grind-able
 */
public class RuneStat {
        
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private RuneStatType type;
    private int value;

    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public RuneStat() {
        
        this(RuneStatType.HPP, 8);
        
    }
    
    public RuneStat(RuneStatType type, int value) {
        
        this.type = type;
        
        if (type == RuneStatType.CRIRATE || type == RuneStatType.RES 
                || type == RuneStatType.ACC) {
            
            // CRI Rate, Res and Acc all cap at 100     
            if (value > 100) this.value = 100;
            
        } else this.value = value;
        
    }


    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public RuneStatType getStatType() { return this.type; }
    public int getValue() { return this.value; }

    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void setValue(int value) { this.value = value; }

    // Overrides ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public String toString() {
        
        String typeString = type.toString();
        
        if (typeString.charAt(typeString.length()-1) == '%') {
            return type.getType().toString() + " +" + value + "%";
        } return typeString + " +" + value;
           
    }
    
    
    public enum RuneStatType {
        // P represents percentage stats, F represents flat stats
        HPP("HP%", Stat.StatType.HP, true), HPF("HP", Stat.StatType.HP, true), 
        ATKP("ATK%", Stat.StatType.ATK, true), ATKF("ATK", Stat.StatType.ATK, true), 
        DEFP("DEF%", Stat.StatType.DEF, true), DEFF("DEF", Stat.StatType.DEF, true), 
        SPD("SPD", Stat.StatType.SPD, true), 
        CRIRATE("CRI Rate%", Stat.StatType.CRIRATE, false), 
        CRIDMG("CRI Dmg%", Stat.StatType.CRIDMG, false), 
        RES("Resistance%", Stat.StatType.RES, false), 
        ACC("Accuracy%", Stat.StatType.ACC, false);
        
        private String name;
        private Stat.StatType type;
        private boolean isGrindable;
        
        private RuneStatType(String name, Stat.StatType type, 
                boolean isGrindable) {
            
            this.name = name;
            this.type = type;
            this.isGrindable = isGrindable;
            
        }
        
        public Stat.StatType getType() { return this.type; }
        public boolean isGrindable() { return this.isGrindable; }
        
        @Override
        public String toString() { return this.name; }
    }
}