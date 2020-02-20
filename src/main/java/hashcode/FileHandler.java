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
	       int signUp = libData[1];
	       int rate = libData[2];
	       Integer[] indexes = strArrayToIntArray(reader.readLine().split("//s"));
	       libraries.add(new Library(indexes, rate, signUp, i));
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
   
   public static void writeFile(String filePath, Data data){
       File file = new File(filePath);
       try {
	   BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	   writer.write(Integer.toString(data.libraries.size()));
	   writer.write("\n");
	   for (Library lib : data.libraries){
	       String str =
		Integer.toString(lib.id) + Integer.toString(lib.bookIndexes.length) + "\n";
	       writer.write(str);
	       //record number of books
	   }
       } catch (IOException e){
	   System.out.println("...");
       }
       
   }
    
}
