package problems.thirdday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstPart {
	public static void main(String[] args) throws IOException{
		File file = new File("thirdinput.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> inputs = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			inputs.add(st);
		}
		int zeros = 0;
		int ones = 0;
		String gamma = "";
		String epsilon = "";
		
		for(int i = 0 ; i < inputs.get(0).length();i++) {
			zeros = 0;
			ones = 0;
			for(int j = 0; j<inputs.size();j++) {
				if(inputs.get(j).charAt(i)=='1') {
					ones+=1;
				}else {
					zeros+=1;
				}
			}
			if(zeros>ones) {
				gamma+="0";
				epsilon+="1";
			}else {
				gamma+="1";
				epsilon+="0";
			}
		}
		int gammaDecimal = Integer.parseInt(gamma,2);
		int epsilonDecimal = Integer.parseInt(epsilon,2);
		System.out.println(gammaDecimal*epsilonDecimal);
	}
}
