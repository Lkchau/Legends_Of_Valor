public class Armor extends Item implements Equippable {
    /*
    Assignment Description: An armor, which when worn by a hero, reduces the incoming damage from
    enemy’s attacks. An armor has a price, a name and a minimum hero level as a
    requirement to be used.
    */

    // Class to represent equippable armor.
    public Armor(Name name, Money price, Level level, Damage damage){
        super(name,price,level,damage);
    }

    public Armor(){
        this(new Name(),new Money(), new Level(), new Damage());
    }


    // Set the equipped armor for a hero
    @Override
    public void equip(Character character) {
        if(character instanceof Hero) {
            ((Hero) character).getInv().setEquippedArmor(this);
        }
    }
}
