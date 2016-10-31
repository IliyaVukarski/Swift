package Task1_ListFileStructure;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListFileStructure {
	public static void main(String[] args) {
		System.out.println("Enter current folder path");
		Scanner scanner = new Scanner(System.in);
		String dirPath = scanner.next();
		File file = new File(dirPath);
		getAllFiles(file);
	}
	
	public static void getAllFiles(File folder) {
		File[] filesList = folder.listFiles();
		for(File files : filesList) {
			try {
				System.out.println(files.getCanonicalPath());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
