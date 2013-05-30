package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.output.FightLog;

public class Team {

	List<Fighter> fighters = new ArrayList<>();
	FightLog log = FightLog.createLogger("Team");
	String name = "unknown";
    int id;
	
	public void add(Fighter p) {
		log.log("Adding Player to team:"  + name);
		p.setTeamId(id)
;		p.dumpPlayer();
		fighters.add(p);
	}

	public List<Fighter> getFighters() {
		//should be immutable list 
		return fighters;
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
	public String getName() {
		return name;
	}
}
