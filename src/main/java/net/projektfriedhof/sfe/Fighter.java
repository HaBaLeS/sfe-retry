package net.projektfriedhof.sfe;

import net.projektfriedhof.sfe.output.FightLog;

public class Fighter {

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
	
}
