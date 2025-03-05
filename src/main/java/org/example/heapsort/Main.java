package org.example.heapsort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Read players
        Player[] players = readPlayersFromFile("players.txt");

        // heapsort
        heapsort(players);

        // Print sorted players
        System.out.println("Players sorted by score (Descending Order):");
        for (Player player : players) {
            System.out.println(player);
        }

        // Heap deep copy methods
        PQHeap pq = new PQHeap();
        for (Player player : players) {
            pq.add(player);
        }

        PQHeap copiedHeap = new PQHeap(pq);  // Copy constructor
        PQHeap clonedHeap = pq.createClone(); // createClone()

        System.out.println("Copied Heap: " + copiedHeap.getSize());
        System.out.println("Cloned Heap: " + clonedHeap.getSize());
    }

    /**
     * Reads player data from a file and creates an array of Player objects.
     *
     * @param filename file containing player data.
     * @return Player objects read from the file.
     */
    private static Player[] readPlayersFromFile(String filename) {
        Player[] players = new Player[1000];
        int count = 0;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                int score = Integer.parseInt(scanner.nextLine().trim());
                players[count++] = new Player(name, score);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return players;
    }

    /**
     * Heap sort
     *
     * @param players players to be sorted.
     */

    public static void heapsort(Player[] players) {
        PQHeap pq = new PQHeap();

        // Insert all players
        for (Player player : players) {
            if (player != null) {
                pq.add(player);
            }
        }

        // Extract elements back into the array in sorted order (This will be the final ordered list)
        for (int i = 0; i < players.length; i++) {
            players[i] = pq.getHighestScorePlayer();
        }
    }
}




