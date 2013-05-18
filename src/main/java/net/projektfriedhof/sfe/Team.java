package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.output.FightLog;

public class Team {

	List<Fighter> fighters = new ArrayList<>();
	FightLog log = FightLog.createLogger("Team");
	String name = "unknown";
	
	public void add(Fighter p) {
		log.log("Adding Player to team:"  + name);
		p.dumpPlayer();
		fighters.add(p);
	}

	public List<Fighter> getFighters() {
		//should be immutable!!
		return fighters;
	}
	
}
