import java.util.*;
import java.lang.*;
import java.io.*;

public class Main 
{
public static void main(String[] args) {
    int A[] = {5,6,15,3,10,22,15};

    int min = A[0]; 
    int maxProfit = 0; 
    int profit = 0;
 
    for (int i = 1; i < A.length; i++) {
        if (A[i] < min) {
            min = A[i];
          
        }
        profit = A[i] - min;
        
        if (profit > maxProfit) {
            maxProfit = profit;
           
        }
    }
    System.out.println("maxProfit is : "+maxProfit);
}
}