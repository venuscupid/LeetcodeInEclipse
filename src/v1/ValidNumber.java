package v1;
public class ValidNumber {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    	return true;
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
        
        return null;
    }
    
    private boolean isBinary(String s){
        
    	return true;
    }
    
    private boolean isOctal(String s){
        
    	return true;
    }
    
    private boolean isHex(String s){
        
    	return true;
    }
    
    private boolean isDecimal(String s){
        
    	return true;
    }
}
