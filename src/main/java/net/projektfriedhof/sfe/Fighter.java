package net.projektfriedhof.sfe;

import net.projektfriedhof.sfe.ki.FighterStats;
import net.projektfriedhof.sfe.ki.PublicRoundKB;
import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLog;
import net.projektfriedhof.sfe.skill.TestAttackSkill;
import net.projektfriedhof.sfe.skill.Skill;

public class Fighter implements FighterStats {

    private FightLog log = FightLog.createLogger("Fighter");
    private String name = "unknown";

	private int hitPoints;
    private int currentMaxHP;

    private int threat = 0; //bedrohung


    //BIG4
    private int attackRating=100;
    private int defenseRating=100;
    private int weaponRating=0;
    private int evadeRating=0;

    //Secondary
    int blockRating;
    //int blockActive;
    //int blockPassive;

    int glanceRating;
    //int glanceAcrive;
    //int glancePassive;

    int critRating;
    //int critActive;
    //int critPassive;

    int critrRating;
    //int penActive;
    //int penPassive;

    //effective Values



    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;


	public Fighter(String name) {
		this.name = name;
	}


	public void setCurrentMaxHP(int hp) {
		hitPoints = hp;
		currentMaxHP = hp;
	}

	
	public void dumpPlayer(){
		log.log("Name:\t"+ name);
		log.log("HP:\t" + hitPoints+ "/" + currentMaxHP);

        log.log("Attackrating:\t" + attackRating);
        log.log("DefenseRating:\t" + defenseRating);
        log.log("Weaponrating:\t" + weaponRating);
        log.log("Evaderating:\t" + evadeRating);

		log.log("Thread\t" + threat);
	}


	public boolean isAlive() {
		return hitPoints > 0;
	}


	public void tick(int tick) {
		//do updates on effecs lying on player
		
	}


	public boolean canDoAction() {
		//check if some action is running taking more than 1 tick and locks the actions
		return true;
	}


	public Action getAction() {
		//decide what todo by interpreting the KI made by players
		return new Action();
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public int maxHP() {
		return currentMaxHP;
	}


	@Override
	public int currentHP() {
		return hitPoints;
	}


	public FighterStats getOpponent(PublicRoundKB kb) {
		for(FighterStats f :kb.getFighters()){
			if(f.isAlive() && !f.getName().equals(name)){
				return f;
			}
		}
		return null;
	}


	public Skill getUsedSkill(RoundKB kb) {
		//decide which skill to use form the KI configuration for the Payer
		return new TestAttackSkill();
	}


	
	public boolean canEvadeAttack(Fighter attacker) {
		//do a evade check
		return Dice.roll(100) <=5;
	}


	public boolean isStreifTreffer(Fighter fighter) {
		return Dice.roll(100) <=5;
	}


	public boolean isCriticalHit(Fighter opponent) {
		return Dice.roll(100) <=5;
	}


	public boolean isBlock(Fighter fighter) {
		return Dice.roll(100) <=5;
	}


	public boolean isPenetrating(Fighter opponent) {
		return Dice.roll(100) <=5;
	}


	public int getPrimaryBaseDamage() {
		// TODO Auto-generated method stub
		return (int) attackRating/10;
	}


	public void applyDamage(int damage) {
		log.log(damage +"");
		hitPoints -= damage;
	}


	
}
