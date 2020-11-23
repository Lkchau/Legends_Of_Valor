import java.util.HashMap;

// Spell representation that is castable
public class Spell extends Item implements Castable {
    /*
    A spell represents a magic attack and can be executed by a hero. A spell has a
    name, a price and a minimum hero level required to be used by a hero. A spell has
    a damage range and an amount of magic energy (called mana ) that it requires in
    order to get casted. After casting a spell, this specified amount of mana is
    deducted from the hero. The level of damage a spell causes depends on the
    dexterity skill level of the hero. Spells:
        o An ice spell, apart from the damage it causes it also reduces the damage of
            the enemy.
        o A fire spell, apart from the damage it causes it also reduces the defense of
            the enemy.
        o A lightning spell, apart from the damage it causes it also reduces the
            dodge chance of the enemy.
     */

    // Requires some mana to be used
    private Mana mana;

    // Constructors
    public Spell(Name name, Money price, Level level, Damage damage, Mana mana){
        super(name, price, level, damage);
        setMana(mana);
    }

    public Spell(){
        this(new Name(), new Money(), new Level(), new Damage(), new Mana());
    }

    // setter and getter
    public Mana getMana() {
        return mana;
    }

    public void setMana(Mana mana) {
        this.mana = mana;
    }

    // Cast a spell and apply a debuff based on the type of spell it is
    @Override
    public boolean cast(Character c, Debuffable b) {
        if(c instanceof Hero){
            Hero h = (Hero) c;
            if(this.getMana().getMana() > h.getMana().getMana()){
                return false;
            }
        else{
                b.debuff(this);
                h.setMana(new Mana(h.getMana().getMana()-this.getMana().getMana()));
            }
            return true;
        } else{
            return false;
        }
    }

    public String toString(){
        return super.toString() + " (Mana cost: " + this.mana +")";
    }
}
