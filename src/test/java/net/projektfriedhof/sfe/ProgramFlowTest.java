package net.projektfriedhof.sfe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import net.projektfriedhof.sfe.output.FightLogEngine;

public class ProgramFlowTest {

	FightLogEngine fightLog = FightLogEngine.createLogger("ProgramFlowTest");
	
	
	public static void main(String[] args) {
		new ProgramFlowTest().run();
	}

	private void run() {
		
		fightLog.log("Start Test");
		
		//create resources
		TestEntityFactory ef = new TestEntityFactory();
		Dice.init("testseed".getBytes());
		
		Team team1 = ef.loadTeam(0);
		Team team2 = ef.loadTeam(1);
		Team team3 = ef.loadTeam(2);
		
		//Create and Fill Fight Arena
		Arena arena = new Arena();
		arena.add(team1);
		arena.add(team2);
		arena.add(team3);
		
		//do The Fighting!
		arena.begin();
		while(!arena.isFightOver()){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			arena.tick();
		}
		
		//print results
		fightLog.log("End Test");
		fightLog.printToConsole();
		
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter wtr = mapper.writerWithDefaultPrettyPrinter();
		try {
			String out = wtr.writeValueAsString(fightLog.getFightLogObjects());
			System.out.println(out);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
