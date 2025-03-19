package slotmachine;

/**
 * Tracks and calculates simulation statistics
 */
public class SimulationResult {
    private long totalBet;
    private long totalWon;

    public void addSpin(int bet, int win) {
        totalBet += bet;
        totalWon += win;
    }

    public void printSummary() {
        double rtp = ((double) totalWon / totalBet) * 100;
        System.out.println("\nSimulation Results:");
        System.out.println("Total coins bet: " + totalBet);
        System.out.println("Total coins won: " + totalWon);
        System.out.println("RTP: " + String.format("%.2f%%", rtp));
    }
} 