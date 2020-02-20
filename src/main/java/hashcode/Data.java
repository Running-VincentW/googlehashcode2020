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
public class Data {
    
    public ArrayList<Library> libraries;
    public int days;
    public Integer[] scores;
    
    public Data(ArrayList<Library> libraries, int days, Integer[] scores){
	this.days = days;
	this.libraries = libraries;
	this.scores = scores;
    }
    
}

class Library{
    public Integer[] bookIndexes;
    public int shippingRate;
    
    public Library(Integer[] bookIndexes, int shippingRate){
	this.bookIndexes = bookIndexes;
	this.shippingRate = shippingRate;
    }
    
}
