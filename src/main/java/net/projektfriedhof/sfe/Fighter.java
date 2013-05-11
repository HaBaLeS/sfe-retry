package net.projektfriedhof.sfe;

import net.projektfriedhof.sfe.output.FightLog;

public class Fighter {

	FightLog log = FightLog.createLogger("Fighter");
	String name = "unknown";
	int hitpoints;
	int currentMaxHP;
	
	int threat = 0; //bedrohung
	
	public void setCurrentMaxHP(int hp) {
		hitpoints = hp;
		currentMaxHP = hp;
	}

	
	public void dumpPlayer(){
		log.log("Name:\t"+ name);
		log.log("HP:\t" + hitpoints+ "/" + currentMaxHP);
		log.log("Thread\t" + threat);
	}
	
}
