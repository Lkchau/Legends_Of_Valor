public abstract class Character implements Attackable{
    // Abstract class to represent characters in a game who can be attacked
    // The have name, health, level, and whether or not it is fainted
    protected Name name;
    protected Health hp;
    protected Level level;
    protected boolean fainted;
    protected int currRow;
    protected int currCol;
    protected int spawnRow;
    protected int spawnCol;
    protected int teleportedFromRow = -1;
    protected int teleportedFromCol = -1;
    protected int charID;

    // Constructors
    public Character(Name name, Health hp, Level level,boolean fainted){
        setName(name);
        setHp(hp);
        setLevel(level);
        setFainted(fainted);

    }

    public Character(Name name, Level level, boolean fainted){
        setName(name);
        setHp(new Health(level.getLevel()*100));
        setLevel(level);
        setFainted(fainted);

    }

    public Character(){
        this(new Name(), new Health(), new Level(), false);
    }

    // getters and setters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Health getHp() {
        return hp;
    }

    public void setHp(Health hp) {
        this.hp = hp;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    public int getCharID() {
        return charID;
    }

    public int getCurrCol() {
        return currCol;
    }

    public void setCurrCol(int currCol) {
        this.currCol = currCol;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public int getSpawnCol() {
        return spawnCol;
    }

    public void setSpawnCol(int spawnCol) {
        this.spawnCol = spawnCol;
    }

    public int getSpawnRow() {
        return spawnRow;
    }

    public void setSpawnRow(int spawnRow) {
        this.spawnRow = spawnRow;
    }

    public int getTeleportedFromCol() {
        return teleportedFromCol;
    }

    public void setTeleportedFromCol(int teleportedFromCol) {
        this.teleportedFromCol = teleportedFromCol;
    }

    public int getTeleportedFromRow() {
        return teleportedFromRow;
    }

    public void setTeleportedFromRow(int teleportedFromRow) {
        this.teleportedFromRow = teleportedFromRow;
    }

    public void setInitialRow(int row){
        setCurrRow(row);
        setSpawnRow(row);
    }

    public void setInitialCol(int col){
        setCurrCol(col);
        setSpawnCol(col);
    }

    public boolean equals(Character c){
        return this.name.equals(c.name);
    }

    // from attackable
    public abstract void receiveDamage(Damage damage);

    // from attackable
    public abstract boolean calculateDodge();

    public String toString(){
        return this.name.toString();
    }
}
