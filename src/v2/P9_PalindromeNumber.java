package v2;


//Wrong answer 1
//Input:	-2147483648
//Output:	true
//Expected:	false
//
// lesson learned: 
//if negative number can be treated too, MUST take care of min_value -> cannot just make: 0 - x, overflow


//Wrong answer 2
//Input:	10000021
//Output:	true
//Expected:	false
//
// lesson learned:
//Failed algo:
//in every loop, get rid of left most and right most digits
//cannot handle: 1031


//Can try:
//do not get rig of any digits, but compare digits from end to center

public class P9_PalindromeNumber {
 public boolean isPalindrome(int x) {
     if(x == Integer.MIN_VALUE) return false;
     // if(x < 0) x = 0 - x;
     if(x < 0) return false;
     if(x < 10) return true; // 0 to 9
     
     // judge
     int total = getNumDigits(x);
     int n = 1;
     boolean check;
     
     while((n * 2) <= total){
         check = isLeftRightNthDigitEqual(x, n, total);
         if(!check) return false;
         n ++;
     }
     return true;
 }
 
 
 // assume num > 0
 // n: checking the n-th right most (also n-th left most digits)
 // total: total number of digits in tht number
 //
 // return:
 // result[0], left digit; result[1], right digit. true if equal; false otherwise
 // if num has less than 2 digits, return true;
 private boolean isLeftRightNthDigitEqual(int num, int n, int total)
 {
     if(num < 10) return true;
     
     int[] result = new int[2];
     int wei = (int)Math.pow(10, n - 1);
     
     // get the n-th right most digit
     // wrong result[1] = (num % wei) / (wei / 10);  // WRONG!! WHY NOT DESIGN TEST CASE AND GO THROUGH STEP BY STEP???  
     result[1] = (num / wei) % 10; 
     
     // get the left most digit
     wei = (int)Math.pow(10, total - n);
     // wrong result[0] = (num % wei) / (wei / 10);
     result[0] = (num / wei) % 10;
     
     return (result[0] == result[1]);
 }
 
 // assume num >= 0
 private int getNumDigits(int num)
 {
     if(num < 10) return 1;
 
     int count = 1;
     while(num / 10 > 0){
         num = num / 10;
         count ++;
     }
     return count;
 }

}