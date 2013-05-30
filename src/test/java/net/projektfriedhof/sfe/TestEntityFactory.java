package net.projektfriedhof.sfe;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.projektfriedhof.sfe.Dice;
import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.Team;
import net.projektfriedhof.sfe.output.FightLog;

public class TestEntityFactory {

	FightLog fightLog = FightLog.createLogger("EntityFactory");
	
	
	public Team createRandomTeam(int level, int members) {
		Team t = new Team();
		for(int i = 0; i<members;i++){
			Fighter p = createRandomFighter(level);
			t.add(p);
		}
		return t;
	}

	public Team loadTeam(int nr){
		Team t = new Team();
		
		if(nr==0){
			t.setId(0);
			t.setName("Developers");
			t.add(loadFighter(0));
			t.add(loadFighter(1));
			t.add(loadFighter(2));
		}
		
		if(nr==1){
			t.setId(1);
			t.setName("Chinese Hackers");
			t.add(loadFighter(3));
			t.add(loadFighter(4));
			t.add(loadFighter(5));
		}
		
		if(nr==2){
			t.setId(2);
			t.setName("Insults");
			t.add(loadFighter(6));
			t.add(loadFighter(7));
			t.add(loadFighter(8));
		}
		
		
		return t;
	}
	
	
	private Fighter createRandomFighter(int level) {
		Fighter f = new Fighter();
		int hp = Dice.roll(level,6,level);
		f.setCurrentMaxHP(hp*10);
		
		return f;
	}

	
	private Fighter loadFighter(int id){
		ObjectMapper mapper = new ObjectMapper();
		List<Fighter> fighters = null;
		try {
			InputStream resourceAsStream = ProgramFlowTest.class.getResourceAsStream("players.json");
			fighters = mapper.readValue(resourceAsStream, new TypeReference<List<Fighter>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fighters.get(id);
	}
	
}
