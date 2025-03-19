package slotmachine.config;

/**
 * Configuration constants for the slot machine
 */
public class SlotMachineConfig {
    public static final class Grid {
        public static final int ROWS = 3;
        public static final int REELS = 5;
    }

    public static final class Simulation {
        public static final int BET_PER_SPIN = 10;
        public static final int SIMULATION_SPINS = 10000;
        public static final int SAMPLE_SPINS = 5;
        public static final int PROGRESS_INTERVAL = 1000;
    }

    public static final class Paylines {
        public static final int[][][] PATTERNS = {
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}}, // Top row
                {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}}, // Middle row
                {{2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}}, // Bottom row
                {{0, 0}, {1, 1}, {2, 2}, {1, 3}, {0, 4}}, // Diagonal
                {{2, 0}, {1, 1}, {0, 2}, {1, 3}, {2, 4}}  // Reverse diagonal
        };
    }
}