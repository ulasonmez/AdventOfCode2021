package problems.firstday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstPart {
	public static void main(String[] args) throws IOException{
		File file = new File("firstinput.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Integer> inputNumbers = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			inputNumbers.add(Integer.parseInt(st));
		}
		int increased = 0;
		for(int i = 1 ; i<inputNumbers.size();i++) {
			if(inputNumbers.get(i)>inputNumbers.get(i-1)) {
				increased += 1;
			}
		}
		System.out.println(increased);
	}
}
