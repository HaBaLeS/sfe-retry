package net.projektfriedhof.sfe.input;

import net.projektfriedhof.sfe.Dice;
import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.Team;
import net.projektfriedhof.sfe.output.FightLog;

public class EntityFactory {

	FightLog fightLog = FightLog.createLogger("EntityFactory");
	
	
	public Team createRandomTeam(int level, int members) {
		Team t = new Team();
		for(int i = 0; i<members;i++){
			Fighter p = createRandomFighter(level);
			t.add(p);
		}
		return t;
	}

	private Fighter createRandomFighter(int level) {
		Fighter f = new Fighter();
		int hp = Dice.roll(level,6,level);
		f.setCurrentMaxHP(hp);
		return f;
	}

}
