package net.projektfriedhof.sfe.output;

import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.Fighter;

public class RoundLog {

	int roundnumber;
	
	public RoundLog(int rnd) {
		roundnumber = rnd;
	}

	List<FighterTurnLog> fTurns = new ArrayList<>();
	FighterTurnLog currentTurn;
	
	public void startFighterTurn(Fighter fighter) {
		FighterTurnLog ftl = new FighterTurnLog();
		fTurns.add(ftl);
		
		ftl.setFighter(fighter);
		
	}
	
}
