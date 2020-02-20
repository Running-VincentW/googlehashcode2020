/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yek
 */
public class FileHandler {
    
   public static Data readFile(String filePath){
       File file = new File(filePath);
       Data data = null;
       ArrayList<Library> libraries = new ArrayList<>();
       try {
	   BufferedReader reader = new BufferedReader(new FileReader(file));
	   Integer[] booksLibrariesDays = strArrayToIntArray(reader.readLine().split("//s"));
	   Integer[] scores = strArrayToIntArray(reader.readLine().split("//s"));
	   for (int i = 0; i < booksLibrariesDays[1]; i++){
	       // library data stuff
	       Integer[] libData = strArrayToIntArray(reader.readLine().split("//s"));
	       ArrayList<Book> books = new ArrayList<>();
	       int signUp = libData[1];
	       int rate = libData[2];
	       Integer[] indexes = strArrayToIntArray(reader.readLine().split("//s"));
	       for (int j = 0; j < libData[0]; j++){
		   books.add(new Book(indexes[j], scores[indexes[j]]));
	       }
	       libraries.add(new Library(books, rate, signUp, i));
	   }
	   data = new Data(libraries, booksLibrariesDays[2], scores);
       } catch (FileNotFoundException e){
	   System.out.println("YA DUN FUCKED UP");
       } catch (IOException e){
	   System.out.println("KIRE CARRY ON");
       }
       return data;
   }
   
   private static Integer[] strArrayToIntArray(String[] strArray){
       Integer[] intArray = new Integer[strArray.length];
       for (int i = 0; i < strArray.length; i++){
	   intArray[i] = Integer.parseInt(strArray[i]);
       }
       return intArray;
   }
   
   public static void writeFile(String filePath, ArrayList<Library> libraries){
       File file = new File(filePath);
       try {
	   BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	   writer.write(Integer.toString(libraries.size()));
	   writer.write("\n");
	   for (Library lib : libraries){
	       String str =
		Integer.toString(lib.id) + Integer.toString(lib.books.size()) + "\n";
	       writer.write(str);
	       //record number of books
	       ArrayList<Book> books = lib.scanBooks(lib.books.size());
	       str = "";
	       for (int i = 0; i < lib.books.size(); i++){
		   str += Integer.toString(books.get(i).ID);
		   if (i < lib.books.size() - 1){
		       str += " ";
		   }
	       }
	       str += "\n";
	       writer.write(str);
	   }
       } catch (IOException e){
	   System.out.println("...");
       }
       
   }
    
}
