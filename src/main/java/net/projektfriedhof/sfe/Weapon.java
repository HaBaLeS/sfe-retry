package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.List;

import net.projektfriedhof.sfe.ki.WeaponStats;

/**
 * Created with IntelliJ IDEA.
 * User: falko
 * Date: 17.05.13
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class Weapon implements WeaponStats{

    String type;
    String name;

    int damageOutput;
    int numboosterSlots;

    List<WeaponBooster> boosters = new ArrayList<>();

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getDamageOutput() {
		return damageOutput;
	}

	@Override
	public int getNumboosterSlots() {
		return numboosterSlots;
	}


}
