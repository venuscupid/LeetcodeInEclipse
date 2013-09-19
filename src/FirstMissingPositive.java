public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((A == null) || (A.length == 0)) return 1;
        
        int firstPosiPos = moveNonPosToFront(A);
        if(firstPosiPos < 0) return 1;  // 1 will be the first positive in this case
        return findFirstMissingPositive(A, firstPosiPos);
    }
    
    public int findFirstMissingPositive(int[] A, int posFirstPos)
    {
        int i;
        int pos;
        int tempPos;
        for(i = posFirstPos; i < A.length; i ++){
            if(A[i] > 0){
            	pos = A[i] + posFirstPos - 1;
                while((pos >= posFirstPos) && (pos < A.length) &&(A[pos] > 0)){
                	tempPos = A[pos] + posFirstPos - 1;
                	makeEleNeg(A, pos);
                	pos = tempPos;
                }
            }
        }
        for(i = posFirstPos; i < A.length; i ++){
            if(A[i] > 0)
                return (i - posFirstPos + 1);
        }
        
        return (A.length - posFirstPos + 1);
    }
    
    private void makeEleNeg(int[] A, int pos)
    {
        if((pos < 0) || (pos >= A.length)) return;
        A[pos] = -1;
    }
    
    // returns the starting index of the first pos num in the array (just in the array)
    // T(n) = O(n)
    public int moveNonPosToFront(int[] A)
    {
        int posPos = -1;
        int posNeg = -1;
        for(posPos = 0; posPos < A.length; posPos ++){
            if(A[posPos] > 0){
                // find a positive, look ahead and try to find a neg/0, swap it with the pos
                if(posNeg >= A.length) break;   // no neg/0 number at the tail
                posNeg = (posNeg > posPos) ? posNeg : posPos + 1;
                for(; posNeg < A.length; posNeg ++){
                    if(A[posNeg] <= 0){
                        swap(A, posPos, posNeg);
                        posNeg ++;
                        break;
                    }
                }
            }
            else
                ;
        }
        
        for(int i = 0; i < A.length; i ++)
            if(A[i] > 0)
                return i;
        return -1;
    }
    
    private void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}