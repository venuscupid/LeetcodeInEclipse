import java.util.ArrayList;


public class MainProgram
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// combinationSum();
		// RegularExpressionMatch();
		// FirstMissingPositive();
		sqrt();
	}
	
	private static void combinationSum()
	{
		CombinationSum cs = new CombinationSum();
		ArrayList<ArrayList<Integer>> solSet = cs.combinationSum(new int[]{1, 2}, 3);
		
		if(solSet.size() == 0)
			System.out.println("No solution.");
		
		int i, j;
		for(i = 0; i < solSet.size(); i ++){
			System.out.print("sol " + i + ": ");
			for(j = 0; j < solSet.get(i).size(); j ++){
				System.out.print(solSet.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	private static void RegularExpressionMatch()
	{
		RegularExpressionMatching rem = new RegularExpressionMatching();
		String s = "aaba";
		String p = "ab*a*c*a";
		
		boolean isMatching = rem.isMatch(s, p);
		
		System.out.println("s: " + s + "\np: " + p + "\nMatch: " + isMatching);
	}
	
	private static void FirstMissingPositive()
	{
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] A = new int[]{2, 1};
		
//		printArray(A);
//		fmp.moveNonPosToFront(A);
//		printArray(A);
		
		System.out.println(fmp.firstMissingPositive(A));
	}
	
	private static void strStr()
	{
		StrStr doStrStr = new StrStr();
		System.out.println(doStrStr.strStr("aaa", "aaaa"));
	}
	
	private static void sqrt()
	{
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(3));
	}
	
	
	
	
	private static void printArray(int[] array)
	{
		System.out.print("Array: ");
		for(int i = 0; i < array.length; i ++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
