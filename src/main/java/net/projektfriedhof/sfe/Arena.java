package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arena {

	int tick = 0;
	
    List<Team> teams = new ArrayList<>();

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
		// TODO Auto-generated method stub
		return true;
	}

	public void tick() {
        //order fighters
		List<Fighter> fightersForTick = orderFighters();
        tick++;

        //for fighters in ordered List
        for(Fighter fighter : fightersForTick){
        
            //fighter.tick()
        	fighter.tick(tick);
        	
            //if( fighter.canDoAction)
        	if(fighter.canDoAction()){
        	
                //action = fighter.getAction  //user OnTime, Heal, Attack, .....

                //switch(action.type)

                    //fight -> processFight(fighter, tick)

                    //useXXXX -> processXXX

                    //default -> fallAssleep()

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

	public void processFight(Fighter fighter, int tick){

        //Fighter opponent = fighter.getOpponent(enviroment);

        //Skill skill = fighter.getUsedSkill();

        //skill.execute(fighter,opponent,enviroment);

    }
	
	
}
