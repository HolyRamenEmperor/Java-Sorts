// Name: J4-18 
// Date: 10/24/19

import java.util.*;
import java.io.*;

public class SelectionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Selection.sort(array);
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
   
      Selection.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
  
   public static void print(double[] a)
   {
      for(double d: a)         //for-each
         System.out.print(d+" ");
      System.out.println();
   }
  
   public static void print(Object[] papaya)
   {
      for(Object abc : papaya)     //for-each
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
   
   @SuppressWarnings("unchecked")
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
/////////////////////////////////////////////////////

class Selection
{
   public static void sort(double[] array)
   {
      int max = 0;
      for(int i = array.length-1; i >= 0; i--)
      {
         max = findMax(array, i);
         swap(array, i, max);
      }
         
   }
   
   // upper controls where the inner loop of the Selection Sort ends
   private static int findMax(double[] array, int upper)
   {
      double max = array[0];
      int index = 0;
      for(int i = 1; i <= upper; i++)
      {
         if(array[i] > max)
         {
            max = array[i];
            index = i;
         }
      }
      return index;
   }
   private static void swap(double[] array, int a, int b)
   {
      double temp = array[b];
      array[b] = array[a];
      array[a] = temp;
      
   }   	
   
	/*******  for Comparables ********************/
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   {
      int max = 0;
      for(int i = array.length-1; i >= 0; i--)
      {
         max = findMax(array, i);
         swap(array, i, max);
      }

   }
   
   @SuppressWarnings("unchecked")
   public static int findMax(Comparable[] array, int upper)
   {
      Comparable max = array[0];
      int index = 0;
      for(int i = 1; i <= upper; i++)
      {
         if(array[i].compareTo(max) > 0)
         {
            max = array[i];
            index = i;
         }
      }
      return index;
   }
   public static void swap(Object[] array, int a, int b)
   {
      Object temp = array[b];
      array[b] = array[a];
      array[a] = temp;
   }
}

