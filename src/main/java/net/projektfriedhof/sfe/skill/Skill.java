package net.projektfriedhof.sfe.skill;

import net.projektfriedhof.sfe.Fighter;
import net.projektfriedhof.sfe.ki.RoundKB;

/**
 * Created with IntelliJ IDEA.
 * User: falko
 * Date: 17.05.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Skill {

	public abstract void execute(Fighter fighter, Fighter opponent, RoundKB kb);

}
