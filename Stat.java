// Representation of stats a character can have
public class Stat {

    private int statValue;

    // Constructors
    public Stat(int statValue){
        setStatValue(statValue);
    }

    public Stat(){
        this(0);
    }

    // setter and getter
    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

    public int getStatValue() {
        return statValue;
    }

    // Increase stat
    protected void addStat(double valueToAdd){
        this.statValue = this.statValue + (int) Math.round(this.statValue*valueToAdd);
    }

    protected void addStat(Stat valueToAdd){
        this.statValue = this.statValue + valueToAdd.statValue;
    }

    protected void multStat(double toMult){
        this.setStatValue((int) (this.statValue * toMult));
    }

    protected void divStat(double toDiv){
        this.setStatValue((int) Math.round(this.statValue / toDiv));
    }

    @Override
    public String toString() {
        return "Stats{" +
                "statValue=" + statValue +
                '}';
    }
}
