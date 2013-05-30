package net.projektfriedhof.sfe.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.projektfriedhof.sfe.Action;
import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.skill.Skill;

public class FightLogEngine {

	private static final Map<String, FightLogEngine> logger = new HashMap<String, FightLogEngine>();
	private static final List<LogMessage> logs = new ArrayList<LogMessage>();
	
	private String scope;
	private RoundLog currentRound;
	
	
	private  FightLogEngine(String scope) {
		this.scope = scope;
	}

	private FightLogEngine(){
		throw new RuntimeException("nene lass mal");
	}
	
	public static FightLogEngine createLogger(String scope) {
		if(logger.get(scope) == null ){
			logger.put(scope, new FightLogEngine(scope));
		}
		return logger.get(scope);
	}

	public void log(String msg){
		log(scope,msg);
		System.out.println("[" + scope + "]" + "\t\t" + msg);
		
	}
	


	private synchronized void log(String scope, String msg){
		LogMessage l = new LogMessage();
		l.scope = scope;
		l.msg = msg;
		logs.add(l);
	}
	

	private class LogMessage{
		String scope;
		String msg;
	}
	
	public void printToConsole() {
		for (LogMessage log : logs) {
			System.out.println("[" + log.scope + "]" + "\t\t" + log.msg);
		}
	}

	public void newRound(int tick) {
		currentRound= new RoundLog(tick);
	}

	public void startFighterTurn(Fighter fighter) {
		currentRound.startFighterTurn(fighter);
		
	}

	public void actionForFighter(Action action) {
		// TODO Auto-generated method stub
		
	}

	public void setTargetForAction(Fighter opponent) {
		// TODO Auto-generated method stub
		
	}

	public void setSkillForAction(Skill skill) {
		// TODO Auto-generated method stub
		
	}
}
