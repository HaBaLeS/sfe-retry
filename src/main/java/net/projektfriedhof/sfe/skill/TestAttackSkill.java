package net.projektfriedhof.sfe.skill;

import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLog;

public class TestAttackSkill extends Skill{

	FightLog log = FightLog.createLogger("TestAttackSkill");
	
	//Uses primary weapon to attack opponent
	@Override
	public void execute(Fighter fighter, Fighter opponent, RoundKB kb) {
		log.log(fighter.getName()+" attacks " + opponent.getName());
		boolean hasEvaded = opponent.canEvadeAttack(fighter);
		double damageMul = 1.0d;
		if(hasEvaded){
			log.log(opponent.getName() + " evaded");
			return;
		}
		
		if(opponent.isStreifTreffer(fighter)){
			log.log("Nur ein Streiftreffer");
			damageMul -=0.20;
		} else {
			if(fighter.isCriticalHit(opponent)){
				log.log("Critical Hit");
				damageMul +=0.20;
			}
		}
		
		if(opponent.isBlock(fighter)){
			log.log("Block");
			damageMul-=0.20;
		} else {
			if(fighter.isPenetrating(opponent)){
				log.log("Penetrating");
				damageMul+=0.20;
			}
		}
		
		
		int bd =fighter.getPrimaryBaseDamage();
		int damage = (int)(bd*damageMul);
		
		opponent.applyDamage(damage);
		
	}

}
