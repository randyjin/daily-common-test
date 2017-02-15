package org.trlove.common.test.util.shudu;

import java.util.Random;

public class Seed {
	private static  Random random = new Random();  
	public static int[][] result = new int[9][9]; 
	private static final int seedSudokuArrays[][][] = {
		{ { 7, 1, 5, 4, 3, 6, 2, 9, 8 }, { 4, 3, 6, 2, 9, 8, 7, 1, 5 },  
            { 2, 9, 8, 7, 1, 5, 4, 3, 6 },  
            { 1, 7, 4, 5, 6, 3, 9, 8, 2 },  
            { 5, 6, 3, 9, 8, 2, 1, 7, 4 },  
            { 9, 8, 2, 1, 7, 4, 5, 6, 3 },  
            { 3, 5, 7, 6, 4, 1, 8, 2, 9 },  
            { 6, 4, 1, 8, 2, 9, 3, 5, 7 },  
            { 8, 2, 9, 3, 5, 7, 6, 4, 1 } } };
	
	public Seed(){}
																			   //�����ȡһ��Ԥ�ȶ���õ�����
	public static int[][] ChooseSeed() {  
        int randomInt = random.nextInt(seedSudokuArrays.length);  
        return seedSudokuArrays[randomInt];  
    } 
	
	public static int[][] getArrayWithDiagonalSymmetry() {                           //�����Խ��ߵ����֣�������̾���
	     for (int i = 0; i < 9; i++) {  
	         for (int j = 0; j < 9; j++) {     
	             result[i][j] = Seed.ChooseSeed()[j][i];  
	         }  
	     }  
	     return result;  
	 } 
	
}
