package org.demo.benchmark;

public class Fibonacci {

	private static int fibonacci(int n) {
        if (n <= 1) return n;

        int previous = 0, next = 1, sum;

        for (int i = 2; i <= n; i++) {
            sum = previous;
            previous = next;
            next = sum + previous;
        }

        return next;
    }
    
    private static void run(String msg, int n) {
    	System.out.println(msg + " : Start (" + n + ")...");
        for (int i = 1; i <= n; i++) {
        	System.out.println(i + "/" + n + ": " + fibonacci(i) );
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
