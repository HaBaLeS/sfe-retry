package net.projektfriedhof.sfe;

import net.projektfriedhof.sfe.input.EntityFactory;
import net.projektfriedhof.sfe.output.FightLog;

public class ProgramFlowTest {

	public static void main(String[] args) {
		new ProgramFlowTest().run();
	}

	private void run() {
		
		FightLog fightLog = FightLog.createLogger("ProgramFlowTest");
		fightLog.log("Start Test");
		
		//create resources
		EntityFactory ef = new EntityFactory();
		
		Team team1 = ef.createRandomTeam();
		Team team2 = ef.createRandomTeam();
		Team team3 = ef.createRandomTeam();
		
		//Create and Fill Fight Arena
		Arena arena = new Arena();
		arena.add(team1);
		arena.add(team2);
		arena.add(team3);
		
		//do The Fighting!
		arena.begin();
		while(!arena.isFightOver()){
			arena.tick();
		}
		
		//print results
		fightLog.log("End Test");
		fightLog.printToConsole();
		
	}
	
}
