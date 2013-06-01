package net.projektfriedhof.sfe.skill;

import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLogEngine;

public class TestAttackSkill extends Skill{

	FightLogEngine log = FightLogEngine.createLogger("TestAttackSkill");
	
	

	@Override
	public void executeInternal(Fighter fighter, Fighter opponent, RoundKB kb) {
		log.log(fighter.getName()+" attacks " + opponent.getName());
		boolean hasEvaded = opponent.canEvadeAttack(fighter);
		double damageMul = 1.0d;
		if(hasEvaded){
			log.log(opponent.getName() + " evaded");
			logSkillProp("evade","evade");
			return;
		}
		
		if(opponent.isStreifTreffer(fighter)){
			log.log("Nur ein Streiftreffer");
			logSkillProp("damageModifier","glance");
			damageMul -=0.20;
		} else {
			if(fighter.isCriticalHit(opponent)){
				logSkillProp("damageModifier","critical");
				log.log("Critical Hit");
				damageMul +=0.20;
			}
		}
		
		if(opponent.isBlock(fighter)){
			log.log("Block");
			logSkillProp("damageReduction","block");
			damageMul-=0.20;
		} else {
			if(fighter.isPenetrating(opponent)){
				log.log("Penetrating");
				logSkillProp("damageReduction","penetrating");
				damageMul+=0.20;
			}
		}
		
		
		int bd =fighter.getPrimaryBaseDamage();
		int damage = (int)(bd*damageMul);
		
		logSkillProp("damageDone",damage+"");
		opponent.applyDamage(damage);
		
		logSkillProp("health", opponent.getHealthRating() + "");
		
		if(!opponent.isAlive()){
			logSkillProp("targetdead","targetdead");
		}
		
	}

	@Override
	public String getSkillId() {
		return "test.skill";
	}

}
