package runeorganizer.model;

import java.awt.Color;
import runeorganizer.model.RuneStat.RuneStatType;

/**
 *
 * @author Tristan
 * @version 0.3 Completing Rune Class
 *      > Completed Constructors
 *      > Added Accessors
 *      > Added Mutators
 *      > Override toString() method
 *      > Changed subs type to SunRuneStat
 */
public class Rune {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    private SetEffect set;
    private Grade grade;
    private int level;
    private int slot;
    private RuneStat main, prefix;
    private SubRuneStat[] subs;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public Rune() {
        this.set = SetEffect.ENERGY;
        
        this.slot = 1;
        this.grade = Grade.HERO;
        this.level = 12;
        
        this.main = new RuneStat(RuneStatType.ATKF, 99);
        this.prefix = new RuneStat(RuneStatType.RES, 5);
        
        this.subs = new SubRuneStat[] {
            new SubRuneStat(RuneStatType.ACC, 6, 0, false),
            new SubRuneStat(RuneStatType.SPD, 19, 2, false),
            new SubRuneStat(RuneStatType.HPF, 213, 223, false),
            new SubRuneStat(RuneStatType.CRIDMG, 9, 0, false)
        };
    }
    
    public Rune(SetEffect set, Grade grade, int slot, int level, RuneStat main, 
            RuneStat prefix, SubRuneStat[] subs) {
        this.set = set;
        
        this.grade = grade;
        this.slot = slot;
        this.level = level;
        
        this.main = main;
        this.prefix = prefix;
        this.subs = subs;
    }
    
    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public SetEffect getSetEffect() { return this.set; }
    public Grade getGrade() { return this.grade; }
    public int getSlot()    { return this.slot; }
    public int getLevel()   { return this.level; }
    public RuneStat getMainStat() { return this.main; }
    public RuneStat getPrefixStat() { return this.prefix; }
    public SubRuneStat[] getSubstats() { return this.subs; }
    public RuneStat getStatAt(int place) { return this.subs[place]; }
    
    public RuneStat[] getAllStats() {
        
        return new RuneStat[]{
            main, prefix,
            subs[0], subs[1], subs[2], subs[3]
        };
        
    }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void setSetEffect(SetEffect set) { this.set = set; }
    public void setGrade(Grade grade) { this.grade = grade; }
    public void setSlot(int slot) { this.slot = slot; }
    public void setLevel(int level) { this.level = level; }
    public void setMainStat(RuneStat main) { this.main = main; }
    public void setPrefixStat(RuneStat prefix) { this.prefix = prefix; }
    public void setAllSubstats(SubRuneStat[] subs) { this.subs = subs; }
    public void setSubstatAt (int place, SubRuneStat sub) { this.subs[place] = sub; }
    
    // Overrides ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    @Override
    public String toString() { 
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("+" + level + " " + set.toString() + " Rune (" + slot 
                + ")\n");
        builder.append(main.toString() + "\n");
        builder.append(prefix.toString() + "\n\n");
        
        for(RuneStat current : subs) {
            builder.append(current.toString() + "\n");
        }
        
        return builder.toString();
    }
    
    
    public enum SetEffect {
       
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
        
        private SetEffect(String name, int setRequired, String description) {
            this.name = name;
            this.description = description;
            
            this.setRequired = setRequired;
        }
        
        public int getQuantityRequire() { return this.setRequired; }
        public String getDescription() { return this.description; }
        
        
        @Override
        public String toString() { return name; }
    }
    
    public enum Grade {
        NORMAL("Normal", Color.WHITE), UNCOMMON("Uncommon", Color.GREEN), 
        RARE("Rare", Color.BLUE), HERO("Hero", Color.MAGENTA), 
        LEGEND("Legend", Color.ORANGE);
        
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
