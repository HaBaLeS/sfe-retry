package net.projektfriedhof.sfe;

import net.projektfriedhof.sfe.input.EntityFactory;
import net.projektfriedhof.sfe.output.FightLog;

public class ProgramFlowTest {

	FightLog fightLog = FightLog.createLogger("ProgramFlowTest");
	
	
	public static void main(String[] args) {
		new ProgramFlowTest().run();
	}

	private void run() {
		
		fightLog.log("Start Test");
		
		//create resources
		EntityFactory ef = new EntityFactory();
		Dice.init("testseed".getBytes());
		
		Team team1 = ef.createRandomTeam(3,4);
		Team team2 = ef.createRandomTeam(4,3);
		Team team3 = ef.createRandomTeam(3,3);
		
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
