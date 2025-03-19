# Slot Machine Simulator
## Overview
This project implements a 3x5 slot machine simulator as a Java console application.  
The simulator features a grid of symbols, configurable paylines, and payout rules based on matching symbols.  
It runs a simulation of multiple spins and calculates the Return to Player (RTP) percentage.

# Features
* 3x5 grid (3 rows, 5 reels) of slot machine symbols
* Four distinct symbols with different payout values
* Five paylines (horizontal, diagonal patterns)
* Random symbol generation with equal probability
* Detailed win calculation based on consecutive matching symbols
* Statistical analysis including RTP calculation
* Visual representation using Unicode symbols

How to Compile and Run
Prerequisites
* Java Development Kit (JDK) 8 or higher

## Compilation
Navigate to the src directory and compile all Java files with:
`javac -d out Main.java slotmachine/*.java slotmachine/*/*.java`
This will place the compiled class files inside an out directory.

## Running the Application
Once compiled, run the simulator with:
`java -cp out Main`

## All-in-One Command
For convenience, use a single command:
`javac -d out Main.java slotmachine/*.java slotmachine/*/*.java && java -cp out Main`


## Implementation Details   
Slot Machine Configuration
* Grid Size: 3 rows × 5 reels
* Bet Amount: 10 coins per spin
* Simulation Size: 10,000 spins

# Symbols
The slot machine uses four symbols, each with different payout values:
* Symbol	Display	3 of a Kind	4 of a Kind	5 of a Kind
* CHERRY	🍒	5 coins	10 coins	20 coins
* LEMON	🍋	10 coins	20 coins	40 coins
* ORANGE	🍊	15 coins	30 coins	60 coins
* SEVEN	7️⃣	20 coins	50 coins	100 coins

# Paylines
The simulator uses five predefined paylines:
1. Top Row: [0,0], [0,1], [0,2], [0,3], [0,4]
2. Middle Row: [1,0], [1,1], [1,2], [1,3], [1,4]
3. Bottom Row: [2,0], [2,1], [2,2], [2,3], [2,4]
4. Diagonal: [0,0], [1,1], [2,2], [1,3], [0,4]
5. Reverse Diagonal: [2,0], [1,1], [0,2], [1,3], [2,4]

# Win Calculation Rules
* A win occurs when at least 3 consecutive matching symbols appear on a payline, starting from the leftmost position.
* Only the highest win per payline is counted.
* When multiple paylines win in a single spin, the total win is the sum of all winning paylines.

# Design Approach
## Object-Oriented Design
The implementation follows object-oriented design principles:
1. Encapsulation: Each class has well-defined responsibilities with private fields and appropriate getters/setters.
2. Abstraction: Complex operations are abstracted into dedicated manager classes.
3. Modularity: The code is organized into logical packages representing different aspects of the slot machine.

## Key Classes
* Symbol: An enum representing the different symbols with their display characters and payout values.
* GridManager: Handles the generation and display of the 3x5 grid of symbols.
* PaylineManager: Manages the evaluation of paylines and calculates wins.
* PaylinePattern: Defines the structure of a payline with positions and description.
* SlotMachineConfig: Contains configuration constants organized in nested classes.
* SimulationResult: Tracks statistics and calculates the final RTP.
  
## Data Structures
* 2D Array: The slot machine grid is implemented as a 2D array of Symbol objects.
* Enums: Symbols are implemented as enum values for type safety and readability.
* Nested Classes: Configuration values are organized using nested classes for better organization.
  
* Assumptions
1. Symbol Distribution: All symbols have an equal probability (25%) of appearing in any position.
2. Fixed Bet: The bet amount is fixed at 10 coins per spin.
3. Consecutive Matches: Only consecutive matches from the leftmost position count toward wins.
4. Independent Spins: Each spin is independent of previous spins (no memory).
5. Multiple Payline Wins: A player can win on multiple paylines in a single spin.

# Future Enhancements
## Potential improvements for future versions:
1. Interface Implementation: Add interfaces for key components to provide:
    * Loose Coupling: Components can be changed without affecting others
    * Testability: Easy to mock interfaces for unit testing
    * Flexibility: Different implementations can be swapped easily
    * Clear Contracts: Interfaces define clear expectations
    * Maintainability: Changes are isolated to specific implementations
Conclusion
This slot machine simulator demonstrates a comprehensive implementation of a gaming system with proper architecture and design principles.   
The code is structured for maintainability and extensibility, making it easy to adjust parameters or add new features.
