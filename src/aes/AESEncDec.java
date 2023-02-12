package aes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class AESEncDec {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[][] Sbox = 
				{{0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76},
		        {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0},
		        {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15},
		        {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75},
		        {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84},
		        {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf},
		        {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8},
		        {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2},
		        {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73},
		        {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb},
		        {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79},
		        {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08},
		        {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a},
		        {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e},
		        {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf},
		        {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}};
		
		int[][] inv_Sbox = 
				{{0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
				{0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
				{0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
				{0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
				{0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
				{0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
				{0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
				{0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
				{0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
				{0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
				{0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
				{0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
				{0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
				{0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
				{0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
				{0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}};
		
		int in[][] = 
				{{2, 10, 1, 5},
				{3, 8, 12, 9},
				{4, 15, 0, 7}, 
				{13, 6, 11, 14}};
		
		int key[][] = 
				{{1, 15, 12, 5}, 
				{7, 3, 4, 10}, 
				{11, 8, 9, 13}, 
				{6, 14, 0, 2}};
		
		int cipher[][] = new int[4][4];
		
		
		System.out.println("Enter the stream of 16 bytes plain text to encrypt: ");
		//Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split("");
		
		int x=0;
		boolean f = false;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++) {
				in[j][i] = (int)input[x++].charAt(0);
				if(x == input.length) {
					f = true;
					break;
				}
			}
			if(f) break;
		}
		
		System.out.println("Plain text:");
		printToOutput(in);
		
		System.out.println("Enter the stream of 16 bytes key: ");
		input = sc.nextLine().split("");
		
		x=0;
		f = false;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++) {
				key[j][i] = (int)input[x++].charAt(0);
				if(x == input.length) {
					f = true;
					break;
				}
			}
			if (f) break;
		}
		
		System.out.println("Master Key: ");
		printToOutput(key);
		
		cipher = encryption(in, key, Sbox);
		
		System.out.println("The encrypted text: ");
		printToOutput(cipher);
		
		System.out.println();
		System.out.println("-----------------------------------------Decryption started-------------------------------------------");
		System.out.println();
		
		int plain[][] = new int[4][4];
		plain = decryption(cipher, key, Sbox, inv_Sbox);
		
		System.out.println("The decrypted text: ");
		printToOutput(plain);
		
	}
	
	public static int[][] encryption(int in[][], int key[][], int Sbox[][]){
		
		int rounds = 10;
		int out[][] = new int[4][4];
		
		pressEnterToContinue();
				
		System.out.println("Key: 0");
		printToOutput(key);
		
		//Initial step
		System.out.println("Add round key: ");
		out = addRoundKey(in, key);
		
		System.out.println("Cipher: 0");
		printToOutput(out);
		
		pressEnterToContinue();
		
		//Intermediate rounds
		for(int i=1; i<=rounds; i++){
			
			System.out.println("-----------Round " + i + "-----------");
			
			key = nextRoundKey(key, i, Sbox);
			
			System.out.println("Key: " + i);
			printToOutput(key);
			
			boolean isLastRound = false;
			if(i==rounds)
				isLastRound = true;
			
			out = roundProcessing(Sbox, out, key, isLastRound);
			
			System.out.println("Cipher: " + i);
			printToOutput(out);
			
			
		}
		
		return out;
	}
	
	public static int[][] decryption(int cipher[][], int key[][], int Sbox[][], int inv_Sbox[][]) {
		
		int plain[][] = new int[4][4];
		int rounds = 10;
		int inverseRoundKeys[][][] = new int[11][4][4];
		
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				inverseRoundKeys[0][i][j] = key[i][j];
		
		for(int i=1; i<=rounds; i++){
			int prev[][] = new int[4][4];
			for(int j=0; j<4; j++)
				for(int k=0; k<4; k++)
					prev[j][k] = inverseRoundKeys[i-1][j][k];
			
			inverseRoundKeys[i] = nextRoundKey(prev, i, Sbox);
		}
		
		System.out.println("Key: 10");
		printToOutput(inverseRoundKeys[10]);
		
		for(int i=rounds; i>0; i--) {
			
			System.out.println("Key: " + (i-1));
			printToOutput(inverseRoundKeys[i]);
			
			boolean isLastRound = false;
			if(i == rounds) {
				isLastRound = true;
			}
			
			cipher = reverseRoundProcessing(inv_Sbox, cipher, inverseRoundKeys[i], isLastRound);
		}
		
		plain = addRoundKey(cipher, inverseRoundKeys[0]);
		
		return plain;
	}
	
	public static int[][] roundProcessing(int Sbox[][], int in[][], int key[][], boolean isLastround){
		
		int out[][] = new int[4][4];
		int mc[][] = {{2,3,1,1}, {1,2,3,1},{1,1,2,3},{3,1,1,2}};
		
		pressEnterToContinue();
		
		System.out.println("Sub Bytes: ");
		//Sub Bytes
		in = subBytes(in, Sbox);
		printToOutput(in);
		
		pressEnterToContinue();
		
		System.out.println("Shift rows: ");
		//Shift rows
		in = shiftRowsLeft(in);
		printToOutput(in);
		
		//Mix Nibbles
		if(isLastround == false)
		{
			pressEnterToContinue();
			System.out.println("Mix Columns: ");
			in = mixColumns(in, mc);
			printToOutput(in);
		}
		
		pressEnterToContinue();
		System.out.println("Add round key: ");
		//Add round Key
		out = addRoundKey(in, key);
		printToOutput(out);
		
		return out;
	}
	
	public static int[][] reverseRoundProcessing(int Sbox[][], int cipher[][], int key[][], boolean isLastRound) {
		
		int in[][] = new int[4][4];
		int mc[][] = {{14,11,13,9}, {9,14,11,13},{13,9,14,11},{11,13,9,14}};
		
		in = addRoundKey(cipher, key);
		
		if(isLastRound == false)
			in = mixColumns(in, mc);
		
		in = shiftRowsRight(in);
		
		in = subBytes(in, Sbox);
		
		return in;
	}
	
	public static int[][] addRoundKey(int in[][], int key[][]){
		
		int out[][] = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++)
				out[i][j] = in[i][j] ^ key[i][j];
		}
		
		return out;
	}
	
	public static int[][] subBytes(int in[][], int Sbox[][]){
		
		int out[][] = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++) {
				
				String s = Integer.toHexString(in[i][j]);
				
				if(s.length() == 2) {
					int a = hexToInt(s.charAt(0));
					int b = hexToInt(s.charAt(1));
					out[i][j] = Sbox[a][b];
				}
				else {
					int a = 0;
					int b = hexToInt(s.charAt(0));
					out[i][j] = Sbox[a][b];
				}
			}
				
		}
		
		return out;
	}
	
	public static int[][] shiftRowsLeft(int in[][]){
		
		int out[][] = new int[4][4];
		
		for(int i=0; i<4; i++) {
			out[i] = leftRotate(in[i], i);
		}
		
		return out;
		
	}
	
	public static int[][] shiftRowsRight(int in[][]){
		
		int out[][] = new int[4][4];
		
		for(int i=0; i<4; i++) {
			out[i] = rightRotate(in[i], i);
		}
		
		return out;
		
	}
	
	public static int[][] mixColumns(int in[][], int mc[][]){
		
		int out[][] = new int[4][4];
		
		//int c[][] = new int[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
				
					int m1[] = multiply(decimalToBinary(mc[i][k], 8), decimalToBinary(in[k][j], 8), 8, 8);
					int x1 = Integer.parseInt(concat(m1), 2);
					x1 = x1 > 255 ? reduce(x1) : x1;
					out[i][j] = out[i][j] ^ x1;
				}
			}
		}
		
		return out;
	}
	
	public static int[][] nextRoundKey(int key[][], int r, int Sbox[][]) {
		
		int newKey[][] = new int[4][4];
		int rc = 0;
		
		HashMap<Integer, Integer> roundConstMap = new LinkedHashMap<>();
		roundConstMap.put(1, 0x1);
		roundConstMap.put(2, 0x2);
		roundConstMap.put(3, 0x4);
		roundConstMap.put(4, 0x8);
		roundConstMap.put(5, 0x10);
		roundConstMap.put(6, 0x20);
		roundConstMap.put(7, 0x40);
		roundConstMap.put(8, 0x80);
		roundConstMap.put(9, 0x1B);
		roundConstMap.put(10, 0x36);
		
		rc = roundConstMap.get(r);
		
		int temp[] = new int[4];
		for(int i=0; i<4; i++)
				temp[i] = key[i][3];
		
		//rotate last column
		int first = temp[0];
		for(int i=0; i<3; i++) {
			temp[i] = temp[i+1];
		}
		temp[3] = first;
		
		//SBox
		for(int i=0; i<4; i++) {
			
			String s = Integer.toHexString(temp[i]);
			if(s.length() == 2) {
				int a = hexToInt(s.charAt(0));
				int b = hexToInt(s.charAt(1));
				temp[i] = Sbox[a][b];
			}
			else {
				int a = 0;
				int b = hexToInt(s.charAt(0));
				temp[i] = Sbox[a][b];
			}
				
			
		}
		
		//Add round const
		temp[0] = temp[0] ^ rc;
		
		//Xor with first column
		for(int i=0; i<4; i++) {
			newKey[i][0] = key[i][0] ^ temp[i];
		}
		
		for(int i=0; i<4; i++) {
			newKey[i][1] = key[i][1] ^ newKey[i][0];
		}
		
		for(int i=0; i<4; i++) {
			newKey[i][2] = key[i][2] ^ newKey[i][1];
		}
		
		for(int i=0; i<4; i++) {
			newKey[i][3] = key[i][3] ^ newKey[i][2];
		}
		
		return newKey;
		
	}
	
	public static int reduce(int v){
		
		int[] data = new int[20];
        int id = 0;
 
        while (v > 0) {
            data[id++] = v % 2;
            v = v / 2;
        }
        int binary[] = new int[id];
        System.arraycopy(data, 0, binary, 0, id);
        
        binary = reverse(binary, binary.length);
        
		int poly[] = {1, 0, 0, 0, 1, 1, 0, 1, 1};
		
		for(int i=0; i<(binary.length-poly.length) + 1; i++){
			if(binary[i] == 1){
				int index = i;
				for(int j=0; j<poly.length; j++){
					binary[index] = binary[index] ^ poly[j];
					index++;
				}
			}
		}
		binary = reverse(binary, binary.length);
		int a[] = new int[8];
		System.arraycopy(binary, 0, a, 0, 8);
		a = reverse(a, a.length);
		int x = Integer.parseInt(concat(a), 2);
		
		return x;
	}
	
	public static int[] decimalToBinary(int num, int bits)
    {
		int[] binary = new int[bits];
        int id = 0;
 
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }
        
        return reverse(binary, binary.length);
    }
	
	public static int[] multiply(int A[], int B[], int m, int n) {
		
		int[] prod = new int[m + n - 1];
		
		for (int i = 0; i < m + n - 1; i++) {
			prod[i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) 
			{
				prod[i + j] += A[i] * B[j];
			}
		}
		
		for(int i=0; i<prod.length; i++)
			prod[i] = prod[i] % 2;
		return prod;
	}
	
	public static String concat(int a[]){
		
		String s = "";
		for(int i=0; i<a.length; i++){
			s += a[i];
		}
		StringBuilder input1 = new StringBuilder();          
        input1.append(s); 
        input1.reverse(); 
		return s;
	}
	
	public static int[] reverse(int a[], int n) 
    { 
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    }
	
	public static int[] leftRotate(int arr[], int n){
		
		for(int i = 0; i < n; i++){    
            int j;
            int first;
            first = arr[0];
            
            for(j = 1; j<arr.length; j++){
            	arr[j-1] = arr[j];
            }
            arr[arr.length-1] = first;
        }
		
		return arr;
	}
	
	public static int[] rightRotate(int arr[], int n){
		
		for(int i = 0; i < n; i++){    
            int j;
            int last;
            last = arr[arr.length-1];
            
            for(j = arr.length-1; j>0; j--){
            	arr[j] = arr[j-1];
            }
            arr[0] = last;
        }
		
		return arr;
	}

	public static int hexToInt(char c){
		
		int res=0;
		if(c == 'a' || c == 'b' || c == 'c' || c == 'd'|| c == 'e' || c == 'f')
			res = c - 'a' + 10;
		else
			res = c - '0';
		return res;
	}
	
	public static void printToOutput(int arr[][]) {
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++) {
				System.out.print(Integer.toHexString(arr[i][j]) + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void pressEnterToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
}
