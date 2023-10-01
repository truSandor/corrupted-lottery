package org.example;
/*
     - we fill lottery tickets: [HOW_MANY] different numbers from 1-[UP_TO]
     - generator makes [DATA_SIZE] random lottery tickets
     - save the tickets in a file
     - generate all possible combinations
     - we gather the number combinations that are not in the randomly generated 'tickets'
     - we check which one has the least [HOW_MANY - 1] - [HOW_MANY - 2] - [HOW_MANY - 3] matches
 */

import org.example.fileprocessor.FileProcessor;
import org.example.generator.LotteryTicketGenerator;

public class Main {
    private static final int DATA_SIZE = 1000;
    private static final int HOW_MANY = 5; // how many balls we pull
    private static final int UP_TO = 20; // of how many numbers we pull
    public static final String DATA_PATH = "src/main/resources/";
    public static final String FILENAME = "bought-lottery-tickets.txt";
    public static final String FILE_PATH = DATA_PATH + FILENAME;

    public static void main(String[] args) {
        LotteryTicketGenerator generator = new LotteryTicketGenerator();
        FileProcessor fileProcessor = new FileProcessor();

        int[][] lotteryTickets = new int[DATA_SIZE][HOW_MANY];
        for (int i = 0; i < DATA_SIZE; i++) {
            lotteryTickets[i] = generator.generateLotteryTicket(HOW_MANY, UP_TO);
        }
        fileProcessor.writeToFile(FILE_PATH, lotteryTickets);

    }

}