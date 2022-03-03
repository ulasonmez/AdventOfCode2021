package firstday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SecondPart {
	public static void main(String[] args) throws IOException{
		File file = new File("firstinput.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Integer> inputNumbers = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			inputNumbers.add(Integer.parseInt(st));
		}
		int beforeSum = 0;
		int increased = 0;
		for(int i = 0 ; i<inputNumbers.size()-2;i++) {
			int sum = inputNumbers.get(i)+inputNumbers.get(i+1)+inputNumbers.get(i+2);
			if(sum>beforeSum && beforeSum!=0) {
				increased+=1;
			}
			beforeSum = sum;
		}
		System.out.println(increased);
	}
}
