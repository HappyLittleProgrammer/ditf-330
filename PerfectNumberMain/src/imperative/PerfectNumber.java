/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imperative;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bedim
 */
public class PerfectNumber {
    private  static Set<Integer> dvsrs;
    
    public static STATE detect(int n) {
        divisors(n);
        return process(n);
    }
    
    public static Set<Integer> divisors(int n) {
        dvsrs = new HashSet<Integer>();
        for(int i = n; i > 0; i--)
        {
            if(n % i == 0)
                dvsrs.add(i);
        }
        
        return dvsrs;
    }

    public static STATE process(int n) {
        Integer sum = divisors(n).stream().mapToInt(Integer::intValue).sum()/2;
        
        if(sum == n)
            return STATE.PERFECT;
        else if(sum > n)
            return STATE.ABUNDANT;
        else
            return STATE.DEFICIENT;       
    }

    public enum STATE {
        ABUNDANT,
        DEFICIENT,
        PERFECT
    }
}
