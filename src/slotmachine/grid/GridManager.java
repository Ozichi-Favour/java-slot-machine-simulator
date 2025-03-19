package slotmachine.grid;

import slotmachine.config.SlotMachineConfig;
import slotmachine.symbol.Symbol;

import java.util.Random;

/**
 * Manages the slot machine grid operations
 */
public class GridManager {
    private final int rows;
    private final int reels;
    private final Random random;

    public GridManager(Random random) {
        this.rows = SlotMachineConfig.Grid.ROWS;
        this.reels = SlotMachineConfig.Grid.REELS;
        this.random = random;
    }

    public Symbol[][] generateGrid() {
        Symbol[][] grid = new Symbol[rows][reels];
        for (int row = 0; row < rows; row++) {
            for (int reel = 0; reel < reels; reel++) {
                grid[row][reel] = Symbol.getRandomSymbol(random);
            }
        }
        return grid;
    }

    public void printGrid(Symbol[][] grid) {
        for (int row = 0; row < rows; row++) {
            for (int reel = 0; reel < reels; reel++) {
                System.out.print(grid[row][reel] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}