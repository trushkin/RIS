package by.bsuir;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {
    private static final Logger logger = LogManager.getLogger(Fibonacci.class);

    public void sequence(int start, int limit) {
        int num1 = 0, num2 = 1, nextNum = 0;

        while (nextNum < start) {
            nextNum = num1 + num2;
            num1 = num2;
            num2 = nextNum;
        }

        while (nextNum <= limit) {
            logger.info(nextNum);
            num1 = num2;
            num2 = nextNum;
            nextNum = num1 + num2;
        }
    }
}

