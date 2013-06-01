package net.projektfriedhof.sfe;

import java.util.Collections;
import java.util.List;

import net.projektfriedhof.sfe.ki.FighterStats;
import net.projektfriedhof.sfe.ki.PublicRoundKB;
import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLogEngine;
import net.projektfriedhof.sfe.skill.TestAttackSkill;
import net.projektfriedhof.sfe.skill.Skill;

public class Fighter implements FighterStats {

    private FightLogEngine log = FightLogEngine.createLogger("Fighter");
    private String name = "unknown";
    private int id;
    private int teamId;
    
	private int hitPoints;
    private int currentMaxHP;

    //BIG4
//    private int attackRating=100;
//    private int defenseRating=100;
//    private int weaponRating=0;
    private int evadeChangse=5;

    //Secondary
    private int blockChangse=5;
    //int blockActive;
    //int blockPassive;

    private int glanceChangse=5;
    //int glanceAcrive;
    //int glancePassive;

    private int critChangse=5;
    //int critActive;
    //int critPassive;

    private int penChangse=5;
    //int penActive;
    //int penPassive;




    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;


	public void setCurrentMaxHP(int hp) {
		hitPoints = hp;
		currentMaxHP = hp;
	}

	
	public void dumpPlayer(){
		log.log("Name:\t"+ name);
		log.log("HP:\t" + hitPoints+ "/" + currentMaxHP);

        log.log("Evade Changse:\t" + evadeChangse + "%");
        log.log("Block Changse:\t" + blockChangse + "%");
        log.log("Penetrating Changse:\t" + penChangse + "%");
        log.log("Glance Changse:\t" + glanceChangse + "%");
        log.log("Critical Changse:\t" + critChangse + "%");
        
        
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
		List<? extends FighterStats> fighters = kb.getFighters();
		Collections.shuffle(fighters);
		for(FighterStats f :kb.getFighters()){
			if(f.isAlive() && !f.getName().equals(name) && f.getTeamId() != teamId){
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
		return Dice.roll(100) <=evadeChangse;
	}


	public boolean isStreifTreffer(Fighter fighter) {
		return Dice.roll(100) <=glanceChangse;
	}


	public boolean isCriticalHit(Fighter opponent) {
		return Dice.roll(100) <=critChangse;
	}


	public boolean isBlock(Fighter fighter) {
		return Dice.roll(100) <=blockChangse;
	}


	public boolean isPenetrating(Fighter opponent) {
		return Dice.roll(100) <=penChangse;
	}


	public int getPrimaryBaseDamage() {
		return (int) 10;
	}


	public void applyDamage(int damage) {
		log.log(name+ " Takes Damage: "+ damage +"");
		hitPoints -= damage;
		if(hitPoints <=0){
			log.log(name + " geht KO");
		}
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentMaxHP() {
		return currentMaxHP;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	public double getHealthRating() {
		return getCurrentMaxHP()/100d*hitPoints;
	}
}
