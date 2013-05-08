package net.projektfriedhof.sfe.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightLog {

	private static final Map<String, FightLog> logger = new HashMap<String, FightLog>();
	private static final List<LogMessage> logs = new ArrayList<LogMessage>();
	
	private String scope;
	
	
	private  FightLog(String scope) {
		this.scope = scope;
	}

	private FightLog(){
		throw new RuntimeException("nene lass mal");
	}
	
	public static FightLog createLogger(String scope) {
		if(logger.get(scope) == null ){
			logger.put(scope, new FightLog(scope));
		}
		return logger.get(scope);
	}

	public void log(String msg){
		log(scope,msg);
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
}
