package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.1 Created RuneStat class
 *      > created RuneStatType enumerator
 *      > added field variables
 *      > added constructors
 *      > added accessors
 *      > added mutators
 *      > override toString() method
 */
public class RuneStat {
        
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private RuneStatType type;
    private int value;

    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public RuneStat(RuneStatType type, int value) {
        this.type = type;
        this.value = value;
    }

    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public RuneStatType getStatType() { return this.type; }
    public int getValue() { return this.value; }

    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void setValue(int value) { this.value = value; }

    // Overrides ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public String toString() {
           return null;
    }
    
    
    public enum RuneStatType {
        // P represents percentage stats, F represents flat stats
        HPP("HP%", Stat.StatType.HP), HPF("HP", Stat.StatType.HP), 
        ATKP("ATK%", Stat.StatType.ATK), ATKF("ATK", Stat.StatType.ATK), 
        DEFP("DEF%", Stat.StatType.DEF), DEFF("DEF", Stat.StatType.DEF), 
        SPD("SPD", Stat.StatType.SPD), 
        CRIRATE("CRI Rate", Stat.StatType.CRIRATE), CRIDMG("CRI Dmg", Stat.StatType.CRIDMG), 
        RES("Resistance", Stat.StatType.RES), ACC("Accuracy", Stat.StatType.ACC);
        
        private String name;
        private Stat.StatType type;
        
        private RuneStatType(String name, Stat.StatType type) {
            this.name = name;
            this.type = type;
        }
        
        public Stat.StatType getType() { return this.type; }
        
        @Override
        public String toString() { return this.name; }
    }
}