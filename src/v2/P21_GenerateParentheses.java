package v2;

import java.util.ArrayList;

//
//修改了无数回， submit了无数回
//错误！应该先建立test case，写完后测一下，在submit，否则面试官早就不接受了
//所以有时候在纸上写反而好，因为在电脑上写，会一上来就写代码，忘记先想测试用例，或者写好后迫不及待想看正不正确，从而懒得测试

public class P21_GenerateParentheses
{
 public ArrayList<String> generateParenthesis(int n) {
     if(n == 0) return null;
     
     ArrayList<String> result = new ArrayList<String>();
     StringBuilder sb = new StringBuilder();
     makeCombination(result, n, sb, n, n);
     return result;
 }
 
 public void makeCombination(ArrayList<String> result, int n, StringBuilder sb, int countLeft, int countRight)
 {
     if(sb.length() == 2 * n){
         result.add(sb.toString());
         return;
     }
     
     // if can add left, add left
     if(countLeft > 0){
         sb.append("(");
         makeCombination(result, n, sb, countLeft - 1, countRight);
         
         // after permutation, step back
         sb.setLength(sb.length() - 1);
     }
     
     // if can add right, add right
     if(countRight > 0 && countLeft < countRight){   // left is more used than right, i.e. can add right
         sb.append(")");
         makeCombination(result, n, sb, countLeft, countRight - 1);
         
         // after permutation, step back
         sb.setLength(sb.length() - 1);
     }
 }
}