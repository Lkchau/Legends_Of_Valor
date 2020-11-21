public class Dragon extends Monster{
    public Dragon(Name name, Health hp, Level level, boolean fainted, Damage damage, Damage defense, int dodgeChance){
        super(name,hp,level, fainted, damage, defense, dodgeChance);
    }

    public Dragon(Name name, Level level, boolean fainted, Damage damage, Damage defense, int dodgeChance){
        this(name, new Health(level.getLevel()*100), level, fainted, damage, defense, dodgeChance);
    }

    public Dragon(Name name, Level level, Damage damage, Damage defense, int dodgeChance){
        this(name,level,false,damage,defense,dodgeChance);
    }

    public Dragon(){
        this(new Name(), new Level(), false, new Damage(), new Damage(), 0);
    }

}
