package net.projektfriedhof.sfe;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTests {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		List l = new ArrayList<>();
		Fighter f = new Fighter();
		f.setCurrentMaxHP(100);
		f.setId(12345);
		f.setName("DDDDDD");
		l.add(f);
		l.add(f);
		String writeValueAsString=null;
		try {
			writeValueAsString = mapper.writeValueAsString(l);
			System.out.println(writeValueAsString);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Fighter> fighters = null;
		try {
			InputStream resourceAsStream = ProgramFlowTest.class.getResourceAsStream("players.json");
			fighters = mapper.readValue(resourceAsStream, new TypeReference<List<Fighter>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println( fighters.size());
		fighters.get(0).dumpPlayer();
		
		
	}
	
}
