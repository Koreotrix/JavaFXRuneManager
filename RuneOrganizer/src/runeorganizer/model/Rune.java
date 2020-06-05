package runeorganizer.model;

import java.awt.Color;
import runeorganizer.model.RuneStat.RuneStatType;

/**
 *
 * @author Tristan
 * @version 0.2 Create Rune class
 *      > added field variables
 *      > added constructors (including default, based on an existing Rune)
 *      > created RuneSet enumerator
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
       
        ENERGY("Energy"),
        GUARD("Guard"),
        SWIFT("Swift"),
        BLADE("Blade"),
        RAGE("Rage"),
        FOCUS("Focus"),
        ENDURE("Endure"),
        FATAL("Fatal"),
        DESPAIR("Despair"),
        VAMPIRE("Vampire"),
        VIOLENT("Violent"),
        NEMESIS("Nemesis"),
        WILL("Will"),
        SHIELD("Shield"),
        REVENGE("Revenge"),
        DESTROY("Destroy"),
        FIGHT("Fight"),
        DETERMINAITION("Determination"),
        ENHANCE("Enhance"),
        ACCURACY("Accuracy"),
        TOLERANCE("Tolerance");
        
        private String name;
        
        private RuneSet(String name) {
            this.name = name;
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
