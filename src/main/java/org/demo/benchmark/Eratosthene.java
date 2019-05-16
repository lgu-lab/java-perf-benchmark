package org.demo.benchmark;

public class Eratosthene {

	private static int countTrueValues(boolean[] flags) {
		int count = 0;
		for ( boolean b : flags) {
			if ( b ) {
				count++ ;
			}
		}
		return count ;
	}
	
	private static int[] buildResult(int size, boolean[] flags) {
		int[] premiers = new int[size];
		int j = 0;
		for ( int i = 0 ; i < flags.length ; i++) {
			if ( flags[i] ) {
				premiers[j++] = i;
			}
		}
		return premiers ;
	}
	
	private static int[] eratosthene(int valMax) {
		if (valMax >= 2) { // le seul cas valide
			// déclarations
			int size = valMax + 1; // taille du tableau
			boolean[] flags = new boolean[size];
			int i;
			// initialise le tableau à vrai.
			for (i = 0; i < size; i++) {
				flags[i] = true;
			}
			flags[0] = false; 
			flags[1] = false; // se débarrasser des nombres premiers connus

			// crible
			int j;
			for (i = 2; i < Math.sqrt(size) + 1; i++) {
				if (flags[i] != false) // si i n'est pas éliminé, éliminer ses multiples.
					for (j = 2 * i ; j < size ; j += i)
						flags[j] = false; // les multiples ne sont pas premiers
			}

			// combien de premiers sont faits ?
//			int compteur = 0;
//			for (i = 0; i < size; i++) {
//				if (flags[i] != false)
//					compteur++; // ajoute au compteur
//			}			
			int compteur = countTrueValues(flags);
			
//			int[] premiers = new int[compteur];
//
//			// mettre les nombres premiers dans le tableau des résultats
//			for (i = 0, j = 0; i < size; i++)
//				if (flags[i] == true) // si premier
//					premiers[j++] = i;
//			return premiers; // retourne les nombres premiers
			return buildResult(compteur, flags);
		} 
		else { // valeurMax < 2
			return new int[0]; // retourne un tableau nul si l'entrée est mauvaise.
		}
	}

	private static void run(String msg, int n) {
		System.out.println(msg + " : Start (" + n + ")...");
		int[] array = eratosthene(n);
		for (int i = 0; i < array.length; i++) {
			System.out.println(" . " + array[i]);
		}
		System.out.println(msg + " : End.");
	}

	private static void warmup() {
		run("WARMUP", 10);
	}

	private static void benchmark(int n) {
		run("BENCHMARK", n);
	}

	public static void main(String[] args) {

		int n = 1000;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		warmup();
		benchmark(n);
	}
}
