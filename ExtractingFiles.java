package extractingFiles;

import java.util.*;
import java.io.*;

public class ExtractingFiles {

	File f1 = new File("W:/Super30/New folder/src/extractingFiles/abc.txt");
	File f2 = new File("");
	ArrayList<File> allFiles = new ArrayList<>();
	String pathcsvFile, tempPath,directoryLocation,path;
	//pathcsvFile = path for csv file
	//tempPath = from where we require files

	public void input() throws IOException {
		Scanner s = new Scanner(System.in);
		FileWriter fout = new FileWriter(f1);
//		BufferedWriter buffwr = new BufferedWriter(fout);
		
		System.out.println("Enter path where you want to save files.");
		pathcsvFile = s.nextLine();
		System.out.println("Enter path from where you need all files: ");
		tempPath = s.nextLine();
		
		formatPaths();
		f1.createNewFile();

		PrintWriter pw = new PrintWriter(f1);
		pw.println(pathcsvFile);
		pw.println(tempPath);
		pw.close();
		s.close();

	}
	public void start() throws IOException {
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		path = br.readLine();
		while(path!=null)
		{
			File thisDir = new File(path);
			Fetch(thisDir);
			path = br.readLine();
		}
		
	}
	public void Fetch(File dir) throws FileNotFoundException{
		File files[] = dir.listFiles();
		if(files == null) {
			return;
		}
		for(int i =0; i<files.length ; i++) {
			if(files[i].isDirectory()) {
				Fetch(files[i]);
			}
			else
			{
				allFiles.add(files[i]);
			}
		}
	}

	public void formatPaths() {
		pathcsvFile = pathcsvFile.replace("\\\\", "/");
		pathcsvFile = pathcsvFile.replace("\\", "/");
		tempPath = tempPath.replace("\\\\", "/");
		tempPath = tempPath.replace("\\", "/");
	//	directoryLocation = tempPath + "/allFiles.txt";
		
	}

	public void display() throws IOException {
		String csvLoc = pathcsvFile + "/AllFiles.csv";
		File csv = new File(csvLoc);
		csv.createNewFile();
		FileWriter fw = new FileWriter(csv);
		BufferedWriter buffer = new BufferedWriter(fw);
		for(File all : allFiles) {
			buffer.write("Name= " + all.getName() + " , Path= " + all.getPath());
			buffer.newLine();
			System.out.println("Name= " + all.getName() + " , Path= " + all.getPath());
		}
		buffer.close();
	}
	public static void main(String[] args) throws IOException {
		ExtractingFiles program = new ExtractingFiles();
		program.input();
		program.start();
		program.display();
	}

}
