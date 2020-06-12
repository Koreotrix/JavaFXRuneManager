package runeorganizer.model;

import java.awt.Color;
import runeorganizer.model.RuneStat.RuneStatType;

/**
 *
 * @author Tristan
 * @version 0.2 Create Rune class
 *      > included the field variables: description and setRequired for RuneSet
 *        enum
 * 
 * 
 *      TODO: add description for each RuneSet item
 */
public class Rune {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private RuneSet set;
    private int grade;
    private int level;
    private RuneStat main, prefix;
    private RuneStat[] subs;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private Rune() {
        this.set = RuneSet.ENERGY;
        
        
        this.main = new RuneStat(RuneStatType.ATKF, 99);
        this.prefix = new RuneStat(RuneStatType.RES, 5);
        
        this.subs = new RuneStat[] {
            new RuneStat(RuneStatType.ACC, 6),
            new RuneStat(RuneStatType.SPD, 21),
            new RuneStat(RuneStatType.HPF, 436),
            new RuneStat(RuneStatType.CRIDMG, 99)
        };
    }
    
    private Rune(Stat main, Stat prefix, Stat[] subs) {
        
    }
    
    public enum RuneSet {
       
        ENERGY("Energy", 2, "HP +15%"),
        GUARD("Guard", 2, "DEF +15%"),
        SWIFT("Swift", 4, "SPD +25%"),
        BLADE("Blade", 2, "CRI Rate +12%"),
        RAGE("Rage", 4, "CRI Dmg +40%"),
        FOCUS("Focus", 2, "Accuracy +20%"),
        ENDURE("Endure", 2, "Resistance +20%"),
        FATAL("Fatal", 4, "ATK +35%"),
        DESPAIR("Despair", 4, "Stun Rate +25%"),
        VAMPIRE("Vampire", 4, "Life Drain +35%"),
        VIOLENT("Violent", 4, "Get Extra Turn +22%"),
        NEMESIS("Nemesis", 2, "ATK Gauge +4% (For every 7% HP lost)"),
        WILL("Will", 2, "Immunity +1 turn(s)"),
        SHIELD("Shield", 2, "Ally Shield for 3 turns (15% of HP)"),
        REVENGE("Revenge", 2, "Counterattack +15%"),
        DESTROY("Destroy", 2, "Enemy MAX HP -4% (30% of DMG dealt)"),
        FIGHT("Fight", 2, "Ally ATK +8%"),
        DETERMINAITION("Determination", 2, "Ally DEF +8%"),
        ENHANCE("Enhance", 2, "Ally HP + 8%"),
        ACCURACY("Accuracy", 2, "Ally Resistance +10%"),
        TOLERANCE("Tolerance", 2, "Ally Accuracy +10%");
        
        private String name;
        private int setRequired;
        private String description;
        
        private RuneSet(String name, int setRequired, String description) {
            this.name = name;
            this.description = description;
            
            this.setRequired = setRequired;
        }
    }
    
    public enum Grade {
        NORMAL("Normal", Color.WHITE), UNCOMMON("Uncommon", Color.GREEN), 
        RARE("Rare", Color.BLUE), HERO("Hero", Color.MAGENTA), LEGEND("Legend", Color.ORANGE);
        
        private String name;
        private Color color;
        
        private Grade(String name, Color color) {
            this.name = name;
            this.color = color;
        }
        
        public Color getColor() { return this.color; }
        
        @Override
        public String toString() { return this.name; }
    }
    
}
