package net.projektfriedhof.sfe;

import java.security.SecureRandom;
import java.util.Random;

import net.projektfriedhof.sfe.output.FightLogEngine;

public class Dice {

	static Random rand;
	static FightLogEngine dlog = FightLogEngine.createLogger("Dice");
	
	public static void init(byte[] seed){
		if(rand != null){
			throw new RuntimeException("Allready Initialized");
		}
		rand = new SecureRandom(seed);
	}
	
	public static int roll(int d){
		int r = rand.nextInt(d);
		//dlog.log("D"+d +" rolled " + r);
		return r;
	}
	
	public static int roll(int d , int plus){
		int r = rand.nextInt(d)+plus;
		//dlog.log("D"+d+"+"+plus +" rolled " + r);
		return r;
	}

	public static int roll(int x, int d, int plus) {
		int r = 0;
		for(int i=0;i<x;i++){
			r+=roll(d);
		}
		r+=plus;
		//dlog.log(x+"D"+d+"+"+plus +" rolled " + r);
		return r;
	}
	
}
