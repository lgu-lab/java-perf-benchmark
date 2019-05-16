package org.demo.benchmark;

public class FibonacciRecursion {

    private static long fibonacciRecursion(int n) {
        if (n <= 1) return n;
        else return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

//    public static void fibonacci1(int n) {
//        for (int i = 1; i <= n; i++) {
//        	System.out.println(i + ": " + fibonacciRecursion(i) );
//    	}
//    }
    
    private static void run(String msg, int n) {
    	System.out.println(msg + " : Start (" + n + ")...");
        for (int i = 1; i <= n; i++) {
        	System.out.println(i + "/" + n + ": " + fibonacciRecursion(i) );
    	}
    	System.out.println(msg + " : End.");
    }

    private static void warmup() {
        run("WARMUP", 5);
    }
    private static void benchmark(int n) {
        run("BENCHMARK", n);
    }

    public static void main(String[] args) {
    	
    	int n = 45 ;
    	if ( args.length > 0 ) {
            n = Integer.parseInt(args[0]);
    	}
    	warmup();
    	benchmark(n);
    }	
}
