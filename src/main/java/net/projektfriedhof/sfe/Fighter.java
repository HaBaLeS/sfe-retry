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
		hitpoints = hp;
		currentMaxHP = hp;
	}

	
	public void dumpPlayer(){
		log.log("Name:\t"+ name);
		log.log("HP:\t" + hitpoints+ "/" + currentMaxHP);

        log.log("Attackrating:\t" + attacRating);
        log.log("DefenseRating:\t" + defenseRating);
        log.log("Weaponrating:\t" + weaponRating);
        log.log("Evaderating:\t" + evadeRating);

		log.log("Thread\t" + threat);
	}
	
}
