import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class demonstrates the use of multiple threads to search for prime numbers within a given range.
 */
public class MultithreadPrimes {
    public static void main(String[] args) throws InterruptedException {

        // Replaces the harde coded values for number of threads and upper bound with user input.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();
        System.out.print("Enter the upper bound for the range: ");
        int upperBound = scanner.nextInt();
        scanner.close();

        List<PrimeSearchThread> threads = new ArrayList<>();
        int blockSize = upperBound / numThreads;

        // Record the start time of the program.
        long startTime = System.currentTimeMillis();

        // Create and start the prime search threads
        for (int i = 0; i < numThreads; i++) {
            int start = i * blockSize + (i == 0 ? 2 : 0); // Skip 0 and 1 for all threads except the first one
            int end = (i == numThreads - 1) ? upperBound : (i + 1) * blockSize;
            PrimeSearchThread thread = new PrimeSearchThread(start, end);
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (PrimeSearchThread thread : threads) {
            thread.join();
        }

        // Record the end time of the program.
        long endTime = System.currentTimeMillis();

        // Implement a mechanism to measure and display the execution time of the multithreaded program.
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
        System.out.println("Done!");
    }

    /**
     * A thread class that searches for prime numbers within a given range.
     */
    private static class PrimeSearchThread extends Thread {
        private final int start;
        private final int end;

        /**
         * Constructs a PrimeSearchThread object with the specified range.
         *
         * @param start the starting number of the range (inclusive)
         * @param end   the ending number of the range (exclusive)
         */
        public PrimeSearchThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * The run method of the thread.
         * It searches for prime numbers within the specified range and prints them to the console.
         */
        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                if (isPrime(i)) {
                    synchronized (System.out) {
                        System.out.println(i);
                    }
                }
            }
        }

        /**
         * Checks if a number is prime.
         *
         * @param n the number to be checked
         * @return true if the number is prime, false otherwise
         */
        private boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

/*
Questionnaire:
1. What is the purpose of using multiple threads in prime number search? How does it benefit the program?
2. How does the program ensure that the output is not interleaved? Explain the mechanism used.
3. What could be a potential drawback of increasing the number of threads beyond the number of available processors?
4. How is the range divided among different threads? Is it divided equally? Explain.
*/

/**
 * Answers:
 * 1. The purpose of using multiple threads in prime number search is to divide the workload among different threads and perform the search in parallel. 
 * This can significantly improve the performance of the program by utilizing the available CPU resources more efficiently.
 * 
 * 2. The program ensures that the output is not interleaved by using a synchronized block when printing the prime numbers to the console. 
 * The synchronized block ensures that only one thread can access the System.out object at a time, preventing interleaved output.
 * 
 * 3. A potential drawback of increasing the number of threads beyond the number of available processors is that it can lead to excessive context switching. 
 * Context switching is the process of saving and restoring the state of a thread so that it can be resumed later. When there are more threads than available processors, the operating system needs to 
 * constantly switch between threads, which can introduce overhead and degrade performance.
 * 
 * 4. The range is divided among different threads by calculating a blockSize based on the upperBound and the number of threads. Each thread is assigned a start and end value based on its index and 
 * the blockSize. The first thread starts from 2 and skips 0 and 1, while the last thread ends at the upperBound. The range is divided as evenly as possible among the threads, but the last thread may 
 * have a slightly larger range if the upperBound is not divisible by the number of threads.
 */


 /*
  * Brief Report: The observed results are consistent with the notion of parallel processing. The program successfully divides the workload among multiple threads and searches for prime numbers in parallel. 
  One interesting observation is that the execution time decreases as the number of threads increases up to a certain point. However, beyond a certain number of threads, the performance improvement diminishes.
  This can be observed as the difference in execution times among 4,5,and 10 threads all running an upperbound of 1,000,000. For 4 threads, the execution time was 6895 ms, for 5 threads the execution time was 6746, 
  and for 10 threads the execution time was 7160 ms which is significantly more than the other trials eventhough there are more threads. This is demonstrates the problem of increased overhead of context switching 
  and the limited.
  */
