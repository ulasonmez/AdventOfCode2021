package problems.secondday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstPart {

	public static void main(String[] args) throws IOException{
		File file = new File("secondinput.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> inputs = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			inputs.add(st);
		}
		int horizontal = 0;
		int depth = 0;
		for(String i : inputs) {
			String[] arrOfInput = i.split(" ");
			String direction = arrOfInput[0];
			int amount = Integer.parseInt(arrOfInput[1]);
			if(direction.equals("forward")) {
				horizontal+=amount;
			}
			else if(direction.equals("down")) {
				depth += amount;
			}
			else if(direction.equals("up")) {
				depth -= amount;
			}
		}
		System.out.println(horizontal*depth);
	}
}
