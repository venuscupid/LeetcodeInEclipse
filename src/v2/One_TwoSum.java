package v2;

import java.util.HashMap;

public class One_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers == null || numbers.length <= 1) return null; // if only 1 number, return null
        
        // assume each input just have 1 solution
        return loopFind(numbers, target);
    }
    
    /**
     * find 2 numbers, which sum is target.
     * If 1 number is the target, do not return.
     */
    private int[] loopFind(int[] array, int target)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int i, pair;
        
        for(i = 0; i < array.length; i ++){
            
            // check hashMap if there are the paired number. if so, return result; otherwise, put to hashMap and loop next
            pair = target - array[i];
            if(hashMap.containsKey(pair))
                return getResult(i, hashMap.get(pair));
            else{
                // put to hashMap
                if(!hashMap.containsKey(array[i]))
                    hashMap.put(array[i], i);
            }
        }
        
        return null;    // do not find
    }
    
    private int[] getResult(int index1, int index2)
    {
        int temp;
        
        if(index1 > index2){
            temp = index1;
            index1 = index2;
            index2 = temp;
        }
        return (new int[]{index1 + 1, index2 + 1});
    }
}
