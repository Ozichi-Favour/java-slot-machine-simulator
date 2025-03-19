package slotmachine.payline;

import slotmachine.symbol.Symbol;

/**
 * Manages payline configurations and win calculations
 */
public class PaylineManager {
    private final PaylinePattern[] paylines;

    public PaylineManager() {
        this.paylines = PaylinePattern.createDefaultPatterns();
    }

    public int calculateTotalWin(Symbol[][] grid) {
        int totalWin = 0;
        for (PaylinePattern payline : paylines) {
            totalWin += calculatePaylineWin(grid, payline);
        }
        return totalWin;
    }

    private int calculatePaylineWin(Symbol[][] grid, PaylinePattern payline) {
        Symbol[] symbols = payline.extractSymbols(grid);
        int matchCount = countConsecutiveMatches(symbols);
        return symbols[0].getPayout(matchCount);
    }

    private int countConsecutiveMatches(Symbol[] symbols) {
        int count = 1;
        for (int i = 1; i < symbols.length; i++) {
            if (symbols[i] == symbols[0]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
} 