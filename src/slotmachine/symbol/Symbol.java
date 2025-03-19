package slotmachine.symbol;

import java.util.Random;

/**
 * Represents slot machine symbols and their payouts
 */
public enum Symbol {
    CHERRY("🍒", new int[]{5, 10, 20}),
    LEMON("🍋", new int[]{10, 20, 40}),
    ORANGE("🍊", new int[]{15, 30, 60}),
    SEVEN("7️⃣", new int[]{20, 50, 100});

    private final String display;
    private final int[] payouts;

    Symbol(String display, int[] payouts) {
        this.display = display;
        this.payouts = payouts;
    }

    public int getPayout(int matchCount) {
        if (matchCount < 3 || matchCount > 5) {
            return 0;
        }
        return payouts[matchCount - 3];
    }

    public static Symbol getRandomSymbol(Random random) {
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return display;
    }

    public static class Payouts {
        public static final int MIN_MATCHES = 3;
        public static final int MAX_MATCHES = 5;
    }
} 