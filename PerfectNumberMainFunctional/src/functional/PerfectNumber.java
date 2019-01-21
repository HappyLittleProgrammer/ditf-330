/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functional;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author bedim
 */
public class PerfectNumber {

    public static STATE detect(int n) {
        return process(n);
    }

    public static Set<Integer> divisors(int n) {
        return IntStream
                .rangeClosed(1, (int) Math.sqrt(n))
                .flatMap(i -> IntStream.of(i, n / i))
                .filter(i -> n % i == 0)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static STATE process(int n) {
        Integer sum = divisors(n).stream().mapToInt(Integer::intValue).sum() / 2;

        return STATE
                .valueOf(Integer.signum(sum - n))
                .get();
    }

    public enum STATE {
        ABUNDANT(1),
        DEFICIENT(-1),
        PERFECT(0);

        private final int state;

        STATE(int state) {
            this.state = state;
        }

        public static Optional<STATE> valueOf(int value) {
            return Arrays.stream(values())
                    .filter(s -> s.state == value)
                    .findFirst();
        }
    }
}
