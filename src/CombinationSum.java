import java.util.*;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if((target <= 0) || (candidates == null) || (candidates.length == 0)) return null;
        
        descending(candidates); // descending order
        candidates = removeDup(candidates);
        
        Result result = new Result();
        doCombineSumRecur(candidates, 0, 0, target, result);
        
        return result.solSet;
    }
    
    private void descending(int[] array)
    {
        Arrays.sort(array);
        int i, j, temp;
        int length = array.length;
        for(i = 0; i < length; i ++){
            j = length - 1 - i;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    private int[] removeDup(int[] array)
    {
        ArrayList<Integer> ary = new ArrayList<Integer>();
        ary.add(array[0]);
        for(int i = 1; i < array.length; i ++){
            if(array[i] != array[i - 1])
                ary.add(array[i]);
        }
        int[] ret = new int[ary.size()];
        
        for(int i = 0; i < ret.length; i ++)
            ret[i] = ary.get(i);
        return ret;
    }
    
    private boolean doCombineSumRecur(int[] candidates, int curPos, int numCans, int target, Result result)
    {
        // if found a solution
        if(target == 0){
            return true;
        }
        
        // if not a solution
        if(curPos >= candidates.length){
            return false;
        }
        
        // recursively find a solution
        int copyNumCans = numCans;
        int numCurCan = -1;
        int i;
        for(i = 0; i * candidates[curPos] <= target; i ++){
            numCurCan ++;
            if(numCurCan > 0) {
                copyNumCans ++;
                result.addInt(candidates[curPos]);
            }
            if(doCombineSumRecur(candidates, curPos + 1, copyNumCans, target - i * candidates[curPos], result)){
                result.addSol();
                result.removeSol(copyNumCans);
            }
        }
        
        result.removeSol(numCans);
        return false;
    }
}

class Result
{
    public ArrayList<Integer> sol = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> solSet = new ArrayList<ArrayList<Integer>>();
    
    public void addInt(int i)
    {
        sol.add(i);
    }
    
    public void removeSol(int fromPos)
    {
        int length = sol.size();
        int i;
        for(i = length - 1; i >= fromPos; i --){
            sol.remove(i);
        }
    }
    
    public void addSol()
    {
        if(sol.size() < 1) return; // only one integer, is also a solution
        
        ArrayList<Integer> toSave = createReverseCopy(sol);;
        
        solSet.add(toSave);
    }
    
    private ArrayList<Integer> createReverseCopy(ArrayList<Integer> sol)
    {
        ArrayList<Integer> toSave = new ArrayList<Integer>();
        
        int i;
        int length = sol.size();
        for(i = 0; i < length; i ++){
            // toSave.add(sol.get(length - 1 - i));
            toSave.add(sol.get(i));
        }
        
        return toSave;
    }
}