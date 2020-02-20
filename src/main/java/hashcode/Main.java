/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.util.ArrayList;

/**
 *
 * @author Yek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	Data data = FileHandler.readFile(args[1]);
	LibraryScheduler scheduler = new LibraryScheduler();
	int daysRemaining = data.days;
	ArrayList<Library> libraries = (ArrayList<Library>) data.libraries.clone();
	ArrayList<Library> sequence = scheduler.getLibrarySequence(libraries, daysRemaining);
	String fileName = "answer-to-" + args[1];
	FileHandler.writeFile(fileName, libraries);
    }
    
}
