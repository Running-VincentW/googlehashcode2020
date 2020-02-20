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
public class LibraryScheduler {
    
    public ArrayList<Library> getLibrarySequence(ArrayList<Library> libraries, int totalDays){
	ArrayList<Library> sequence = new ArrayList<>();
	int length = libraries.size();
	int daysRemaining = totalDays;
	Library result;
	for (int i = 0; i < length; i++){
	    result = getNextLibrary(libraries, daysRemaining);
	    daysRemaining -= result.signUpTime;
	    sequence.add(result);
	    libraries.remove(result);
	}
	return sequence;
    }
    
    private Library getNextLibrary(ArrayList<Library> libraries, int daysRemaining){
	ArrayList<Integer> scores = new ArrayList<>();
	Library nextLibrary = null;
	int maxScore = 0;
	for (Library lib : libraries){
	    int score = (lib.shippingRate * daysRemaining) - lib.signUpTime;
	    if (score > lib.books.size()){
		score = lib.books.size();
	    }
	    if (score > maxScore){
		maxScore = score;
		nextLibrary = lib;
	    }
	}
	return nextLibrary;
    }
    
}
