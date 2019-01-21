/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functional;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 *
 * @author bedim
 */
public class Solution {

    static long superDigit(long x) {
        long sum = Long
                .toString(x)
                .chars()
                .mapToLong(c -> c - '0')
                .sum();

        return LongStream.of(sum)
                .filter(l -> l < 10)
                .findFirst()        
                .orElseGet(() -> superDigit(sum));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter number: ");
        int x = reader.nextInt();

        reader.close();
        System.out.print("Super digit of that number is: " + superDigit(x));
    }
}
