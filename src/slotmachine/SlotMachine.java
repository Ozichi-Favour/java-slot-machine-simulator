package slotmachine;

import slotmachine.config.SlotMachineConfig;
import slotmachine.grid.GridManager;
import slotmachine.payline.PaylineManager;
import slotmachine.symbol.Symbol;

import java.util.Random;

/**
 * Main slot machine controller that coordinates the simulation
 */
public class SlotMachine {
    private final GridManager gridManager;
    private final PaylineManager paylineManager;
    private final Random random;

    public SlotMachine() {
        this.random = new Random();
        this.gridManager = new GridManager(random);
        this.paylineManager = new PaylineManager();
    }

    public void runSimulation() {
        SimulationResult result = new SimulationResult();
        System.out.println("Starting simulation of " +
                SlotMachineConfig.Simulation.SIMULATION_SPINS + " spins...");

        for (int i = 0; i < SlotMachineConfig.Simulation.SIMULATION_SPINS; i++) {
            Symbol[][] grid = gridManager.generateGrid();
            int win = paylineManager.calculateTotalWin(grid);

            result.addSpin(SlotMachineConfig.Simulation.BET_PER_SPIN, win);

            if (i < SlotMachineConfig.Simulation.SAMPLE_SPINS ||
                    i % SlotMachineConfig.Simulation.PROGRESS_INTERVAL == 0) {
                printSpinResults(i + 1, grid, win);
            }
        }

        result.printSummary();
    }

    private void printSpinResults(int spinNumber, Symbol[][] grid, int win) {
        System.out.println("Spin #" + spinNumber + ":");
        gridManager.printGrid(grid);
        System.out.println("Win: " + win + " coins");
        System.out.println("---------------------");
    }
}