package com.temp;

import java.util.*;
import java.io.*;

/*

https://docs.oracle.com/javase/8/docs/api/java/util/Properties.html#load-java.io.Reader-
Reads a property list (key and element pairs) from the input character stream in a simple line-oriented format.

The keySet() method of Properties class is used to create a set out of the key elements contained in the Properties.

 */
public class TestProperties {
    Properties properties = new Properties();
    //Optional<String> locatorKey = properties.keySet().stream().filter(e -> e.toString().startsWith(key))
    //				.map(Object::toString).findFirst();
    private static final String BASE_TEMP_DIR = "src/test/resources/temp";
    private final File file =  new File(BASE_TEMP_DIR,"test1.properties");
    	public  void readFile(){
            try {
                Reader reader = new FileReader(file);
                properties.load(reader);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            String fruits= properties.getProperty("fruits");
            System.out.println(fruits);
            System.out.println(properties);
        }

        public void writeFile(){
            //set property
            properties.setProperty("username", "testuser");
            properties.setProperty("username2", "testuser2");

            //write to file

            try {
                properties.store(new FileOutputStream(BASE_TEMP_DIR+"/test1.properties"), null);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        public static void main(String [] args){
           TestProperties tp = new TestProperties();
           tp.readFile();
           tp.writeFile();
        }
}
