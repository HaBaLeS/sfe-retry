package net.projektfriedhof.sfe.ki;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.Fighter;

public class RoundKB implements PublicRoundKB, Serializable{

	private static final long serialVersionUID = 1L;

	List< ? extends FighterStats> fighters = new ArrayList<>();
	
	public RoundKB(int tick) {
	}

	public List< ? extends FighterStats> getFighters() {
		//immutable!!!
		return fighters;
	}
	
	public void setFighters(List<Fighter> fightersForTick) {
		this.fighters = fightersForTick;
		
	}
	
}
