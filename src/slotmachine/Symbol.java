package slotmachine;

import java.util.Random;

/**
 * Enum representing slot machine symbols and their payouts.
 * Each symbol has different payout values based on the number of consecutive matches.
 */

/**
 * Enum representing slot machine symbols and their payouts.
 */
enum Symbol {
    CHERRY(5, 10, 20),
    LEMON(10, 20, 40),
    ORANGE(15, 30, 60),
    SEVEN(20, 50, 100);

    private final int[] payouts;

    Symbol(int... payouts) {
        this.payouts = payouts;
    }

    public int getPayout(int matchCount) {
        return (matchCount >= 3 && matchCount <= 5) ? payouts[matchCount - 3] : 0;
    }

    public static Symbol getRandomSymbol(Random random) {
        return values()[random.nextInt(values().length)];
    }
}