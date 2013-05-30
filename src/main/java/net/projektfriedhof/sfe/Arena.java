package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.projektfriedhof.sfe.ki.RoundKB;
import net.projektfriedhof.sfe.output.FightLog;
import net.projektfriedhof.sfe.skill.Skill;

public class Arena {

	private FightLog log = FightLog.createLogger("ARENA");
	int tick = 0;
    List<Team> teams = new ArrayList<>();
    RoundKB kb;
    
    
	public void add(Team team1) {
		teams.add(team1);
	}

	public void begin() {
        preapreTeams(teams);
	}

	private void preapreTeams(List<Team> teams2) {
		//nothing et
		
	}

	public boolean isFightOver() {
		Set teams = new HashSet<>();
		for(Fighter f : orderFighters()){
			teams.add(f.getTeamId());
		}
		boolean ended =  teams.size() <= 1;
		
		if(ended){
			log.log("FIGHT IS OVER");
			log.log("Fighters alive:");
			for(Fighter f: orderFighters()){
				f.dumpPlayer();
			}
		}
		
		return ended;
	}

	public void tick() {
        //order fighters
		List<Fighter> fightersForTick = orderFighters();
        tick++;
        log.log("Begin of round " + tick);
        
        kb = new RoundKB(tick);
        kb.setFighters(fightersForTick);
        
        //for fighters in ordered List
        for(Fighter fighter : fightersForTick){
        
            //fighter.tick()
        	fighter.tick(tick);
        	
            //if( fighter.canDoAction)
        	if(fighter.canDoAction()){
        	
               Action action = fighter.getAction(); //user OnTime, Heal, Attack, in Deckung gehen etc

                //switch(action.type)
               switch (action.getType()) {
					case attack:
						processFight(fighter);
						break;
		
					default:
						throw new RuntimeException("Implement the other tpyed to advance");
               }
                    
        	}
            //end if

        }
        //end for


        //environment.tick()


	}

    private List<Fighter> orderFighters() {
		List<Fighter> fightersForRound = new ArrayList<>();
		for(Team t : teams){
			List<Fighter> fighters = t.getFighters();
			for(Fighter f : fighters){
				if(f.isAlive()){
					fightersForRound.add(f);
				}
			}
		}
		
		//this should be ordered by initiative but for now shuffle is ok!
		Collections.shuffle(fightersForRound);
		return fightersForRound;
	}

	public void processFight(Fighter fighter){
        Fighter opponent = (Fighter) fighter.getOpponent(kb);
        Skill skill = fighter.getUsedSkill(kb);
        
        if(skill != null && opponent != null){
        	skill.execute(fighter,opponent,kb);
        }
    }
	
	
}
