public class Dexterity extends Stat{

    // Represen the dexterity stat a hero can have
    public Dexterity(int value){
        super(value);
    }
    public Dexterity(){
        super();
    }

    public void addDex(double statToAdd){
        this.addStat(statToAdd);
    }

    public void addDex(Dexterity statToAdd){
        this.addStat(statToAdd);
    }

    public void multDex(double toMult){
        this.multStat(toMult);
    }

    public void divDex(double toDiv){
        this.divStat(toDiv);
    }

    public String toString(){
        return ""+getStatValue();
    }
}
