package runeorganizer.model;

/**
 * This class represents the runes that will be equipped to a monster. 
 * information such as the sum of added stat value will be contained
 * 
 * @author Tristan 
 * @version 0.3 RunePreset Created
 *      > added field variables
 *      > added constructors
 *      > added accessors
 *      > added mutators
 *      > added calculateAddedStats() method
 *      > added printAddedStats() method for debugging
 */
public class RunePreset {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    private Rune[] runes;
    
    private int addedHPP, addedHPF, addedATKP, addedATKF, addedDEFP, addedDEFF,
            addedSPD, addedCRIRate, addedCRIDmg, addedRes, addedAcc;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public RunePreset() {
        
        this.runes = new Rune[6];
        
    }
    
    public RunePreset(Rune[] runes) {
        
        this();
        addRunes(runes);
        calculateAddedStats();
        
    }
    
    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public int getAddedHPP() { return this.addedHPP; }
    public int getAddedHPF() { return this.addedHPF; }
    public int getAddedATKP() { return this.addedATKP; }
    public int getAddedATKF() { return this.addedATKF; }
    public int getAddedDEFP() { return this.addedDEFP; }
    public int getAddedDEFF() { return this.addedDEFF; }
    public int getAddedSPD() { return this.addedSPD; }
    public int getAddedCRIRate() { return this.addedCRIRate; }
    public int getAddedCRIDmg() { return this.addedCRIDmg; }
    public int getAddedRes() { return this.addedRes; }
    public int getAddedAcc() { return this.addedAcc; }
    public Rune[] getAllRunes() { return this.runes; }
    public Rune getRuneAt(int slot) { return this.runes[slot - 1]; }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void addRune(Rune rune) { this.runes[rune.getSlot() - 1] = rune; }
    public void addRunes(Rune[] runes) { 
        
        try {
            
            // no more than 6 runes can be added to a Rune Preset
            if (runes.length > 6) { throw new IllegalArgumentException(); }
            
            // see if mutliple runes being added are in unique slots
            for (int i = 0; i < runes.length - 1; i++) {
                for (int j = 1; j < runes.length; j++) {
                    
                    if (runes[i].getSlot() == runes[j].getSlot()) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            
            // add the runes normally after checks
            for (Rune current: runes) {
                addRune(current);
            }
            
            calculateAddedStats();
            
        } catch (IllegalArgumentException e) {
            System.err.println("Attempt to add set of runes: invalid.");
        }
        
    }
    
    // Utilities ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void calculateAddedStats() {
        
        RuneStat[] stats;
        SubRuneStat sub;
        
        for (Rune currentRune : runes) {
            
            if (currentRune != null) {
                
                stats = currentRune.getAllStats();
                
                for (RuneStat currentStat : stats) {
                    
                    if (currentStat != null) {
                        
                        switch (currentStat.getStatType()) {
                            case HPP: addedHPP += currentStat.getValue(); break;
                            case HPF: addedHPF += currentStat.getValue(); break;
                            case ATKP: addedATKP += currentStat.getValue(); break;
                            case ATKF: addedATKF += currentStat.getValue(); break;
                            case DEFP: addedDEFP += currentStat.getValue(); break;
                            case DEFF: addedDEFF += currentStat.getValue(); break;
                            case SPD: addedSPD += currentStat.getValue(); break;
                            case CRIRATE: addedCRIRate += currentStat.getValue(); break;
                            case CRIDMG: addedCRIDmg += currentStat.getValue(); break;
                            case RES: addedRes += currentStat.getValue(); break;
                            case ACC: addedAcc += currentStat.getValue(); break;
                        }

                        if (currentStat instanceof SubRuneStat) {

                            sub = (SubRuneStat) currentStat;

                            if (sub.isGrinded()) { 

                                switch (currentStat.getStatType()) {
                                    case HPP: addedHPP += sub.getGrindValue(); break;
                                    case HPF: addedHPF += sub.getGrindValue(); break;
                                    case ATKP: addedATKP += sub.getGrindValue(); break;
                                    case ATKF: addedATKF += sub.getGrindValue(); break;
                                    case DEFP: addedDEFP += sub.getGrindValue(); break;
                                    case DEFF: addedDEFF += sub.getGrindValue(); break;
                                    case SPD: addedSPD += sub.getGrindValue(); break;
                                    case CRIRATE: addedCRIRate += sub.getGrindValue(); break;
                                    case CRIDMG: addedCRIDmg += sub.getGrindValue(); break;
                                    case RES: addedRes += sub.getGrindValue(); break;
                                    case ACC: addedAcc += sub.getGrindValue(); break;
                                }
                            }
                        }
                    }
                } 
            }
        }  
    }
    
    public void resetAddedStats() {
        
        addedHPP = addedHPF = addedATKP = addedATKF = addedDEFP = addedDEFF
                = addedSPD = addedCRIRate = addedCRIDmg = addedRes = addedAcc
                = 0;
        
    }
    
    public void printAddedStats() {
        
        System.out.println("HP +" + addedHPP + "%");
        System.out.println("HP +" + addedHPF);
        System.out.println("ATK +" + addedATKP + "%");
        System.out.println("ATK +" + addedATKF);
        System.out.println("DEF +" + addedDEFP + "%");
        System.out.println("DEF +" + addedDEFF);
        System.out.println("SPD +" + addedSPD);
        System.out.println("CRI Rate +" + addedCRIRate + "%");
        System.out.println("CRI Dmg +" + addedCRIDmg + "%");
        System.out.println("Resistance +" + addedRes + "%");
        System.out.println("Accuracy +" + addedAcc + "%");
        
    }
    
}
