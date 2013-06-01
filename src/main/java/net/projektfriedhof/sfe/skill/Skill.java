package net.projektfriedhof.sfe.skill;

import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLogEngine;

/**
 * Created with IntelliJ IDEA.
 * User: falko
 * Date: 17.05.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Skill {

	FightLogEngine log = FightLogEngine.createLogger("Skill");
	
	public abstract void executeInternal(Fighter fighter, Fighter opponent, RoundKB kb);

	public void execute(Fighter fighter, Fighter opponent, RoundKB kb){
		log.setSkillForAction(this);
		executeInternal(fighter, opponent, kb);
	}

	public abstract String getSkillId();
	
	public void logSkillProp(String key, String value){
		log.logSkillProp(key, value);
	}
	
}
