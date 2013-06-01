package net.projektfriedhof.sfe.output;

import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.Fighter;

public class RoundLog {

	private int roundnumber;
	FighterTurnLog currentFighter;
	
	public RoundLog(int rnd) {
		roundnumber = rnd;
	}

	List<FighterTurnLog> fTurns = new ArrayList<>();
	FighterTurnLog currentTurn;
	
	public void startFighterTurn(Fighter fighter) {
		FighterTurnLog ftl = new FighterTurnLog();
		fTurns.add(ftl);
		ftl.setFighter(fighter);
		currentFighter = ftl;
	}
	
	public int getRoundnumber() {
		return roundnumber;
	}
	
	public List<FighterTurnLog> getfTurns() {
		return fTurns;
	}

	public FighterTurnLog currentFighter() {
		return currentFighter;
	}
}
