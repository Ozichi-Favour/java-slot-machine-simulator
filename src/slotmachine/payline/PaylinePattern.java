package slotmachine.payline;

import slotmachine.config.SlotMachineConfig;
import slotmachine.symbol.Symbol;

/**
 * Represents a single payline pattern and its evaluation logic
 */
public class PaylinePattern {
    private final int[][] positions;
    private final String description;

    public PaylinePattern(int[][] positions, String description) {
        this.positions = positions;
        this.description = description;
    }

    public Symbol[] extractSymbols(Symbol[][] grid) {
        Symbol[] symbols = new Symbol[positions.length];
        for (int i = 0; i < positions.length; i++) {
            symbols[i] = grid[positions[i][0]][positions[i][1]];
        }
        return symbols;
    }

    public static PaylinePattern[] createDefaultPatterns() {
        int[][][] patterns = SlotMachineConfig.Paylines.PATTERNS;
        PaylinePattern[] paylines = new PaylinePattern[patterns.length];
        String[] descriptions = {"Top Row", "Middle Row", "Bottom Row", "Diagonal", "Reverse Diagonal"};
        
        for (int i = 0; i < patterns.length; i++) {
            paylines[i] = new PaylinePattern(patterns[i], descriptions[i]);
        }
        return paylines;
    }

    public String getDescription() {
        return description;
    }
} 