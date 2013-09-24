public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
    
    /**
     * trim
     * detect if obviously not a number
     */
    private String preProcess(String s){
        if(s == null) return null;
        if(s.length() == 0) return null;
        
        int i, startSpace, endSpace;
        char[] str = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        
        // trim leading spaces
        for(i = 0; i < str.length; i ++)
            if(str[i] != ' ') break;
        
        // store str, and pre-process
        boolean hasDot = false;
        boolean hasChar = false;
        for(; i < str.length; i ++){
            
        }
        
        // trim ending spaces
        
    }
    
    private boolean isBinary(String s){
        
    }
    
    private boolean isOctal(String s){
        
    }
    
    private boolean isHex(String s){
        
    }
    
    private boolean isDecimal(String s){
        
    }
}
