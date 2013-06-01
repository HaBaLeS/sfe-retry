package net.projektfriedhof.sfe.output;

import java.util.HashMap;
import java.util.Map;

import net.projektfriedhof.sfe.Action;
import net.projektfriedhof.sfe.ki.FighterStats;

public class FighterTurnLog {

	private String fighterName;
	private String action;
	private String usedSkill;
	private String targetName;
	
	private Map<String, String> skillProps = new HashMap<>();
	
	public void setFighter(FighterStats fighter) {
		fighterName = fighter.getName();
	}

	
	public String getFighterName() {
		return fighterName;
	}


	public void setAction(Action action) {
		this.action = action.getType().name();
		
	}
	
	public String getAction() {
		return action;
	}
	public String getUsedSkill() {
		return usedSkill;
	}
	public void setUsedSkill(String usedSkill) {
		this.usedSkill = usedSkill;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetName() {
		return targetName;
	}
	
	public Map<String, String> getSkillProps() {
		return skillProps;
	}
}
