 //Name: J4-18 
 //Date: 10/26/19

import java.util.*;
import java.io.*;

public class InsertionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Insertion.sort(array);
      print(array);
      
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
      System.out.println();
      
      //Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      Insertion.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
   
   public static void print(double[] a)
   {
      for(double d: a)         // for-each loop
         System.out.print(d+" ");
      System.out.println();
   }
   
   public static void print(Object[] papaya)
   {
      for(Object abc : papaya)    
         System.out.print(abc+" ");
   }
   
   public static boolean isAscending(double[] a)
   {
      int x = 0;
      for(int i = 0; i < (a.length - 1); i++)
      {
         if(a[i] <= a[i+1])
         {
            x++;
         }
      }
      if(x == a.length - 1)
      {
         return true;
      }
      return false;
   }
   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static boolean isAscending(Comparable[] a)
   {
      int x = 0;
      for(int i = 0; i < (a.length - 1); i++)
      {
         if(a[i].compareTo(a[i+1]) <= 0)
         {
            x++;
         }
      }
      if(x == a.length - 1)
      {
         return true;
      }
      return false;
   }
}

//**********************************************************

class Insertion
{
   public static void sort(double[] array)
   { 
      for(int i = 1; i < array.length; i++)
      {
         double start = array[i];
         int index = i - 1;
         int x = shift(array, index, start);
         array[x + 1] = start;
      }
   }
 
   private static int shift(double[] array, int index, double value)
   {
      while(index >= 0 && array[index] > value)
      {
         array[index + 1] = array[index];
         index = index - 1;
      }
      return index;
   }
 
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   { 
      for(int i = 1; i < array.length; i++)
      {
         Comparable start = array[i];
         int index = i - 1;
         int x = shift(array, index, start);
         array[x + 1] = start;
      }

   }
   
   @SuppressWarnings("unchecked")
   private static int shift(Comparable[] array, int index, Comparable value)
   {
      while(index >= 0 && array[index].compareTo(value) > 0)
      {
         array[index + 1] = array[index];
         index = index - 1;
      }
      return index;

   }
}
