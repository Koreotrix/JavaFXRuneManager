package runeorganizer.model;

/**
 *
 * @author Tristan
 * @version 0.2 Continue to populate Monster Class
 *      > added Constructors
 *      > added Accessors
 *      > added Mutators
 */
public class Monster {
    
    // Field Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String name; // unique name of the mosnter
    private String monster; // monster group
    private Element element;
    private int baseHP, baseATK, baseDEF, baseSPD;
    private int baseCRIRate, baseCRIDmg, baseRes, baseAcc;
    
    // Constructors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Monster() {
        
        this("Lamor", "Low Element", Element.FIRE, 1140, 88, 76, 100);
        
    }
    
    public Monster(String name, String monster, Element element,
            int baseHP, int baseATK, int baseDEF, int baseSPD) {
        
        this.name = name;
        this.monster = monster;
        this.element = element;
        
        this.baseHP = baseHP;
        this.baseHP = baseATK;
        this.baseHP = baseDEF;
        this.baseHP = baseSPD;
        
        this.baseCRIRate = 15;
        this.baseCRIDmg = 50;
        this.baseRes = 15;
        this.baseAcc = 0;
        
    }
    
    public Monster(String name, String monster, Element element,
            int baseHP, int baseATK, int baseDEF, int baseSPD,
            int baseCRIRate, int baseCRIDmg, int baseRes, int baseAcc) {
        
        this(name, monster, element, baseHP, baseATK, baseDEF, baseSPD);
        
        this.baseCRIRate = baseCRIRate;
        this.baseCRIDmg = baseCRIDmg;
        this.baseRes = baseRes;
        this.baseAcc = baseAcc;
        
    }

    // Accessors ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String getName() { return this.name; }
    public String getMonster() { return this.monster; }
    public Element getElement() { return this.element; }
    public int getBaseHP() { return this.baseHP; }
    public int getBaseATK() { return this.baseATK; }
    public int getBaseDEF() { return this.baseDEF; }
    public int getBaseSPD() { return this.baseSPD; }
    public int getBaseCRIRate() { return this.baseCRIRate; }
    public int getBaseCRIDmg() { return this.baseCRIDmg; }
    public int getBaseRes() { return this.baseRes; }
    public int getBaseAcc() { return this.baseAcc; }
    
    // Mutators ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setName(String name) { this.name = name; }
    public void setMonster(String monster) { this.monster = monster; }
    public void setElement(Element element) { this.element = element; }
    public void setBaseHP(int hp) { this.baseHP = hp; }
    public void setBaseATK(int atk) { this.baseATK = atk; }
    public void setBaseDEF(int def) { this.baseDEF = def; }
    public void setBaseSPD(int spd) { this.baseSPD = spd; }
    public void setBaseCRIRate(int criRate) { this.baseCRIRate = criRate; }
    public void setBaseCRIDmg(int criDmg) { this.baseCRIDmg = criDmg; }
    public void setBaseRes(int res) { this.baseRes = res; }
    public void setBaseAcc(int acc) { this.baseAcc = acc; }
    
    
    // Internal Classes ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
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
