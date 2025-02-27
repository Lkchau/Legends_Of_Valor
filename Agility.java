public class Agility extends Stat{
    // Class to represent the agility stat that a hero can have
    public Agility(int value){
        super(value);
    }

    public Agility(){
        super();
    }

    // Two functions to add agility! utilizes the superclass's addStat function
    public void addAgl(Agility toAdd){
        this.addStat(toAdd);
    }

    public void addAgl(double toAdd){
        this.addStat(toAdd);
    }

    public void multAgl(double toMult){
        this.multStat(toMult);
    }

    public void divAgl(double toDiv){
        this.divStat(toDiv);
    }

    public String toString(){
        return ""+getStatValue();
    }
}
