/**
 * The following program takes two text files as input and compares them line by line.
 * Once two lines are different, the program prints out the line and character number
 * where the files differ.
 * */

import java.util.Scanner;
import java.io.*;

public class SearchTexts{
	private static String file1;
	private static String file2;
	private static String lineInFile1;
	private static String lineInFile2;
	private static int line;

	public static void main(String[] args) throws IOException{
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		file1 = kbd.nextLine();
		File firstFile = new File(file1);
		Scanner scannedFile1 = new Scanner(firstFile);
		System.out.print("Enter a second file name: ");
		file2 = kbd.nextLine();
		File secondFile = new File(file2);
		Scanner scannedFile2 = new Scanner(secondFile);

		line = 0;
		boolean different = false;
		while(scannedFile1.hasNext()){
			line++;
			lineInFile1 = scannedFile1.nextLine();
			lineInFile2 = scannedFile2.nextLine();
			if(!lineInFile1.equalsIgnoreCase(lineInFile2)){
              /*	if(!lineInFile1.equals(lineInFile2)){ //Optional way with sensitive case */
				//System.out.println(line);
				different = true;
				differenceAt(lineInFile1, lineInFile2, 0, line);
				break;
			}

		}
		scannedFile1.close();
		scannedFile2.close();
		if(!different)
			System.out.println("You did not enter different files");
	}
	
	/**
	 * charNum() prints out the index with a different character of String s1 ans s2
	 * @param s1 The first string to be compared
	 * @param s2 The second string to be compared
	 * @param i The index of both strings
	 * */
	public static void differenceAt(String s1, String s2, int i, int line){
		while(s1.charAt(i) == s2.charAt(i)){
			i++;
		}
		
		System.out.println("The string is different at line "+line+", position "+ (i+1));
	}
}
