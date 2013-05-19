package net.projektfriedhof.sfe;

public class Action {

	public enum Type {
		attack,
		useOntime,
		useSkill,
		heal,
		takeCover
	}
	
	public Type getType(){
		return Type.attack;
	}
	
}
