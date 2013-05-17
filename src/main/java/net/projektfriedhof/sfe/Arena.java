package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    List<Team> teams = new ArrayList<>();

	public void add(Team team1) {
		// TODO Auto-generated method stub
		
	}

	public void begin() {
        preapreTeams(teams);
	}

	public boolean isFightOver() {
		// TODO Auto-generated method stub
		return true;
	}

	public void tick() {
        //order fighters

        //tick++

        //for fighters in ordered List

            //fighter.tick()

            //if( fighter.canDoAction)

                //action = fighter.getAction  //user OnTime, Heal, Attack, .....

                //switch(action.type)

                    //fight -> processFight(fighter, tick)

                    //useXXXX -> processXXX

                    //default -> fallAssleep()


            //end if

        //end for


        //environment.tick()


	}

    public void processFight(Fighter fighter, int tick){

        //Fighter opponent = fighter.getOpponent(enviroment);

        //Skill skill = fighter.getUsedSkill();

        //skill.execute(fighter,opponent,enviroment);

    }
	
	
}
