public class HeroStats {
    // Physical representation of the stats a hero can have
    private Dexterity dex;
    private Strength str;
    private Agility agl;


    public HeroStats(Strength str, Agility agl, Dexterity dex){
        setDex(dex);
        setStr(str);
        setAgl(agl);
    }
    public HeroStats(){
        this(new Strength(), new Agility(),new Dexterity());
    }

    // Setters and getters
    public void setStr(Strength str) {
        this.str = str;
    }

    public Strength getStr() {
        return str;
    }

    public void setDex(Dexterity dex) {
        this.dex = dex;
    }

    public Dexterity getDex() {
        return dex;
    }

    public void setAgl(Agility agl) {
        this.agl = agl;
    }

    public Agility getAgl() {
        return agl;
    }

    // Increase certain stats
    public void addStr(double toAdd){
        this.str.addStr(toAdd);
    }

    public void addDex(double toAdd){
        this.dex.addDex(toAdd);
    }

    public void addAgl(double toAdd){
        this.agl.addAgl(toAdd);
    }

    public void addStr(Strength toAdd){
        this.str.addStr(toAdd);
    }

    public void addDex(Dexterity toAdd){
        this.dex.addDex(toAdd);
    }

    public void addAgl(Agility toAdd){
        this.agl.addAgl(toAdd);
    }


    public void multDex(double toMult){
        this.dex.multDex(toMult);
    }

    public void multStr(double toMult){
        this.str.multStr(toMult);
    }

    public void multAgl(double toMult){
        this.agl.multAgl(toMult);
    }

    public void divDex(double toDiv){
        this.dex.divDex(toDiv);
    }

    public void divStr(double toDiv){
        this.str.divStr(toDiv);
    }

    public void divAgl(double toDiv){
        this.agl.divAgl(toDiv);
    }

    public void addAllStats(double addStr, double addDex, double addAgl){
        this.addStr(addStr);
        this.addDex(addDex);
        this.addAgl(addAgl);

    }
}

