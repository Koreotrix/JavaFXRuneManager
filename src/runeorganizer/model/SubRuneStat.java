package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.3 Created SubRuneStat 
 *      > added field variables
 *      > added constructor
 *      > added accessors
 *      > added mutators
 *      > override toString() method
 */
public class SubRuneStat extends RuneStat {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int grindValue;
    private boolean gemed;
    
    // Constructor ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public SubRuneStat() {
        
        super();
        this.grindValue = 0;
        this.gemed = false;
        
    }
    
    public SubRuneStat(RuneStatType type, int value, int grindValue, 
            boolean gemed) {
        
        super(type, value);
        
        try {
            
            if (type.isGrindable()) { this.grindValue = grindValue; }
            else if (grindValue == 0) { this.grindValue = 0; }
            else { throw new Exception(); }
            
        } catch (Exception e) {
            
            System.err.println(type + " cannot be grinded!");
            e.printStackTrace();
            
        }
        
        this.gemed = gemed;
    }
    
    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public int getGrindValue() { return this.grindValue; }
    public boolean isGemed() { return this.gemed; }
    public boolean isGrinded() { return this.grindValue != 0; }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void setGrindValue(int value) { this.grindValue = value; }
    public void addGem() { this.gemed = true; }
    public void removeGem() { this.gemed = false; } // for debugging purposes
    
    // Overrides ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    @Override
    public String toString() { 
        
        StringBuilder builder = new StringBuilder(super.toString());
        
        if(isGrinded()) { builder.append(" +" + grindValue); }
        if(gemed) { builder.append(" @"); }
        
        return builder.toString();
    }
}
