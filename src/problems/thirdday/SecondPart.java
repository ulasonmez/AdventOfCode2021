package problems.thirdday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondPart {
	public static void main(String[] args) throws IOException{
		File file = new File("thirdinput.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> inputs = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			inputs.add(st);
		}
		int oxygenDecimal = Integer.parseInt(oxygenGeneratorRating(inputs,"oxygen"),2);
		int co2Decimal = Integer.parseInt(oxygenGeneratorRating(inputs,"co2"),2);
		System.out.println("oxy = "+oxygenGeneratorRating(inputs,"oxygen")+"   co2 = "+oxygenGeneratorRating(inputs,"co2"));
		System.out.println("oxy = "+oxygenDecimal+"   co2 = "+co2Decimal);
		System.out.println(oxygenDecimal*co2Decimal);
	}

	public static String oxygenGeneratorRating(ArrayList<String> sampleInputs,String type) {
		int zeros = 0,ones = 0;
		String value = "";
		@SuppressWarnings("unchecked")
		ArrayList<String> onesArray = (ArrayList<String>) sampleInputs.clone();
		ArrayList<String> removeListOnes= new ArrayList<>();
		ArrayList<String> removeListZeros= new ArrayList<>();
		ArrayList<String> actualRemove = new ArrayList<>();
		for(int i = 0 ; i < sampleInputs.get(0).length();i++) {
			zeros = 0;
			ones = 0;
			for(String k : onesArray) {
				if(k.charAt(i)=='1') {
					ones+=1;
					removeListOnes.add(k);
				}
				else if(k.charAt(i) == '0') {
					zeros+=1;
					removeListZeros.add(k);
				}
			}
			if(type.equals("oxygen")) {
				if(ones>=zeros) {
					value += "1";
					actualRemove = removeListZeros;
				}
				else {
					value += "0";
					actualRemove = removeListOnes;
				}
			}
			else if(type.equals("co2")) {
				if(ones >= zeros) {
					value += "0";
					actualRemove = removeListOnes;
				}
				else {
					value += "1";
					actualRemove = removeListZeros;
				}
			}
			for(String p : actualRemove) {
				if(onesArray.contains(p)) {
					onesArray.remove(p);
				}
			}
			if(onesArray.size()==1) {
				for(int k = i+1;k<onesArray.get(0).length();k++) {
					value += onesArray.get(0).charAt(k);
				}
				break;
			}
			removeListOnes.clear();
			removeListZeros.clear();
		}
		return value;
	}
}
