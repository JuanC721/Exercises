package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cases; i++) {
			
			String[] info = br.readLine().split(" ");
			int x = Integer.parseInt(info[0]);
			int size = Integer.parseInt(info[1]);
			int[] A = new int[size];
			
			for (int j = 0; j < size; j++) {
				A[j] = Integer.parseInt(br.readLine());
			}
			System.out.println(DCClosestNumber(A, x));
		}	
	}
	
	public static int DCClosestNumber(int[] A, int x) {
		if(x < A[0]) {
			return A[0];
		}else if(x > A[A.length-1]){
			return A[A.length-1];
		}else {
			return DCClosestNumber(A, (A.length-1)/2, 0, A.length-1, x);
		}
	}
	
	public static int DCClosestNumber(int[] A, int m, int i, int j, int x) {
		if(x > A[m] && x < A[m+1]) {
			return closestToX(x, A[m], A[m+1]); 
		}else {
			if(x > A[m] && x > A[m+1]) {
				int newM = j - (j-m+1)/2;
				return DCClosestNumber(A, newM, m+1, j, x);
			}else {
				int newM = i + (m-i)/2;
				return DCClosestNumber(A, newM, i, m, x);
			}
		}
	}
	
	public static int closestToX(int x, int a, int b) {
		if(Math.abs(x-a) < Math.abs(x-b)) {
			return a;
		}else if(Math.abs(x-a) > Math.abs(x-b)){
			return b;
		}else {
			return a>b ? b : a;
		}
	}
}
