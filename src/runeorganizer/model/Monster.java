package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.4 Continued Monster Class
 *      > added calculateAddedStats() method
 *      > added calualateStatsTotal() mehtod
 */
public class Monster {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String name; // unique name of the mosnter. ie Taor
    private String monster; // monster group. ie Chimera
    private Attribute attribute;
    
    private int baseHP, baseATK, baseDEF, baseSPD;
    private int baseCRIRate, baseCRIDmg, baseRes, baseAcc;
    
    private RunePreset runes;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public Monster() {
        
        this("Lamor", "Low Element", Attribute.FIRE, 1140, 88, 76, 100);
        
    }
    
    public Monster(String name, String monster, Attribute attribute,
            int baseHP, int baseATK, int baseDEF, int baseSPD) {
        
        this.name = name;
        this.monster = monster;
        this.attribute = attribute;
        
        this.baseHP = baseHP;
        this.baseATK = baseATK;
        this.baseDEF = baseDEF;
        this.baseSPD = baseSPD;
        
        this.baseCRIRate = 15;
        this.baseCRIDmg = 50;
        this.baseRes = 15;
        this.baseAcc = 0;
        
        this.runes = new RunePreset();
        
    }
    
    public Monster(String name, String monster, Attribute element,
            int baseHP, int baseATK, int baseDEF, int baseSPD,
            int baseCRIRate, int baseCRIDmg, int baseRes, int baseAcc, 
            Rune[] runes) {
        
        this(name, monster, element, baseHP, baseATK, baseDEF, baseSPD);
        
        this.baseCRIRate = baseCRIRate;
        this.baseCRIDmg = baseCRIDmg;
        this.baseRes = baseRes;
        this.baseAcc = baseAcc;
        
        this.runes = new RunePreset(runes);
        
    }
    
    public Monster(String name, String monster, Attribute element,
            int baseHP, int baseATK, int baseDEF, int baseSPD,
            int baseCRIRate, int baseCRIDmg, int baseRes, int baseAcc, 
            RunePreset runes) {
        
        this(name, monster, element, baseHP, baseATK, baseDEF, baseSPD);
        
        this.baseCRIRate = baseCRIRate;
        this.baseCRIDmg = baseCRIDmg;
        this.baseRes = baseRes;
        this.baseAcc = baseAcc;
        
        this.runes = runes;
    }
    

    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public String getName() { return this.name; }
    public String getMonster() { return this.monster; }
    public Attribute getAttribute() { return this.attribute; }
    public int getBaseHP() { return this.baseHP; }
    public int getBaseATK() { return this.baseATK; }
    public int getBaseDEF() { return this.baseDEF; }
    public int getBaseSPD() { return this.baseSPD; }
    public int getBaseCRIRate() { return this.baseCRIRate; }
    public int getBaseCRIDmg() { return this.baseCRIDmg; }
    public int getBaseRes() { return this.baseRes; }
    public int getBaseAcc() { return this.baseAcc; }
    public Rune[] getRunes() { return this.runes.getAllRunes(); }
    public Rune getRuneAt(int slot) { return this.runes.getRuneAt(slot); }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void setName(String name) { this.name = name; }
    public void setMonster(String monster) { this.monster = monster; }
    public void setElement(Attribute attribute) { this.attribute = attribute; }
    public void setBaseHP(int hp) { this.baseHP = hp; }
    public void setBaseATK(int atk) { this.baseATK = atk; }
    public void setBaseDEF(int def) { this.baseDEF = def; }
    public void setBaseSPD(int spd) { this.baseSPD = spd; }
    public void setBaseCRIRate(int criRate) { this.baseCRIRate = criRate; }
    public void setBaseCRIDmg(int criDmg) { this.baseCRIDmg = criDmg; }
    public void setBaseRes(int res) { this.baseRes = res; }
    public void setBaseAcc(int acc) { this.baseAcc = acc; }
    public void setAllRunes(Rune[] runes) { this.runes = new RunePreset(runes); }
    public void setAllRunes(RunePreset runes) { this.runes = runes; }
    public void setRuneAt(Rune rune) { this.runes.addRune(rune); }
    
    // Utilities ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public String calculateAddedStats() {
        
        StringBuilder builder = new StringBuilder("");
        
        int addedHP = (runes.getAddedHPP() * baseHP) + runes.getAddedHPF();
        int addedATK = (runes.getAddedATKP() * baseATK) + runes.getAddedATKF();
        int addedDEF = (runes.getAddedDEFP() * baseATK) + runes.getAddedDEFF();
        
        builder.append("HP: +" + addedHP + "\n");
        builder.append("ATK: +" + addedATK + "\n");
        builder.append("DEF: +" + addedDEF + "\n");
        builder.append("SPD: +" + runes.getAddedSPD() + "\n");
        builder.append("CRI Rate: +" + runes.getAddedCRIRate() + "%\n");
        builder.append("CRI Dmg: +" + runes.getAddedCRIDmg() + "%\n");
        builder.append("Resistance: +" + runes.getAddedRes() + "%\n");
        builder.append("Accuracy: +" + runes.getAddedAcc() + "%\n");
        
        return builder.toString();
    }
    
    public String calculateStatsTotal() {
        
        StringBuilder builder = new StringBuilder("");
        
        int HP = (runes.getAddedHPP() * baseHP) + runes.getAddedHPF() + baseHP;
        int ATK = baseATK + (runes.getAddedATKP() * baseATK) + runes.getAddedATKF();
        int DEF = baseDEF + (runes.getAddedDEFP() * baseATK) + runes.getAddedDEFF();
        
        builder.append("HP: +" + HP + "\n");
        builder.append("ATK: +" + ATK + "\n");
        builder.append("DEF: +" + DEF + "\n");
        builder.append("SPD: +" + (baseSPD + runes.getAddedSPD()) + "\n");
        builder.append("CRI Rate: +" + (baseCRIRate + runes.getAddedCRIRate()) 
                + "%\n");
        builder.append("CRI Dmg: +" + (baseCRIDmg + runes.getAddedCRIDmg()) 
                + "%\n");
        builder.append("Resistance: +" + (baseRes + runes.getAddedRes()) + "%\n");
        builder.append("Accuracy: +" + (baseAcc + runes.getAddedAcc()) + "%\n");
        
        return builder.toString();
    }
    
    
    // Internal Classes ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public enum Attribute {
        FIRE("Fire"), WATER("Water"), WIND("Wind"), LIGHT("Light"), DARK("Dark");
        
        private String name;
        
        private Attribute(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() { return this.name; }
    }
    
}
