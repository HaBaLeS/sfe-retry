package net.projektfriedhof.sfe;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTests {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		List<Fighter> fighters = null;
		try {
			InputStream resourceAsStream = ProgramFlowTest.class.getResourceAsStream("players.json");
			fighters = mapper.readValue(resourceAsStream, TypeReference.);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println( fighters.size());
		fighters.get(0).dumpPlayer();
		
		
	}
	
}
