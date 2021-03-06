/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.util.*;

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

class Book implements Comparable<Book>{
    int ID;
    int score;

    @Override
    public int compareTo(Book o) {
        return this.score - o.score;
    }

    public Book(int ID, int score){
        this.ID = ID;
        this.score = score;
    }
}

class Library{
//    public PriorityQueue<Book> books = new PriorityQueue<>();
    public ArrayList<Book> books;
    public int shippingRate;
    public int signUpTime;
    public final int id;

    static Set<Book> scannedBooks;
    private ArrayList<Book> scannedBooksAtLibrary;

    public Library(ArrayList<Book> books, int shippingRate, int signUpTime, int id){
//	this.books.addAll(books);
	this.shippingRate = shippingRate;
	this.books = books;
	this.signUpTime = signUpTime;
	this.id = id;
    }

//    public int getDistinctNewBooks(){
//        int count = 0;
//        for (Book book : scannedBooks){
//            if (!scannedBooks.contains(book)){
//                count ++;
//            }
//        }
//        return count;
//    }

    public ArrayList<Book> scanBooks(int days){
        Collections.sort(this.books);
        return this.books;
    }

}
