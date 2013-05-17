package net.projektfriedhof.sfe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: falko
 * Date: 17.05.13
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class Weapon {

    String type;
    String name;

    int damageOutput;
    int numboosterSlots;

    List<WeaponBooster> boosters = new ArrayList<>();


}
