package v1;
public class RegularExpressionMatching {
    
	public final static char DOT = '.';
	public final static char STAR = '*';
	public final static char START = '#';
	
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if((s == null) || (p == null)) return false;
        if(s.length() == 0){
        	if(p.length() == 0) return true;
        	if(p.equals("" + DOT + STAR)) return true;	// ".*" matches all things
        	return false;
        }
        if(p.length() == 0)
        	return false;
        
        s = START + s;
        p = START + p;
        
        return doIsMatch(s.toCharArray(), p.toCharArray());
    }
    
    // match from index 1 to the end
    private boolean doIsMatch(char[] s, char[] p)
    {
    	int M = p.length;
    	int N = s.length;
        boolean[][] c = new boolean[M][N];
        
        c[0][0] = true;
        
        if((s[1] == p[1]) || (p[1] == DOT))
            c[1][1] = true;
            
        int i, j;
        int k;
        
        // init c[0][] and c[][0]
        // c[0][1, ...] is all false
        // c[][0]
        for(i = 1; i < M; i ++){
        	if(p[i] == STAR){
        		if(c[i - 2][0]){
        			c[i][0] = true;
        		}
        	}
        }
        
        for(i = 1; i < M; i ++)
            for(j = 1; j < N; j ++){
                if(c[i][j] == true) continue;
                
                if((p[i - 1] == DOT) && (p[i] == STAR)){ // p[i-1, i] = ".*", match everything from s[j]
                	for(k = j; k < N; k ++) c[i][k] = true;
                	break; // i ++
                }
                
                if(p[i] == STAR){ // p[i - 1, i] = "n*", match blank
                	if(c[i - 2][j]){
                		c[i][j] = true;
                		continue;
                	}
                }
                
                if(c[i - 1][j - 1])
                	if((p[i] == s[j]) || (p[i] == DOT) || ((s[j - 1] == s[j]) && (p[i] == STAR))){
                		c[i][j] = true;
                		continue;
                	}
                
                if(c[i - 1][j]){
                    if((p[i - 1] == STAR) && ((p[i] == s[j]) || (p[i] == DOT))){
                        c[i][j] = true;
                        continue;
                    }
                }
//                else{    // if p[i - 1] does not match s[j], but p[i] is '*', then p[i - 1, i] match ""
//                	if((p[i - 1] == STAR) && (c[i - 3][j - 1]))
//                		if((p[i] == s[j]) || (p[i] == DOT)){
//                    	    c[i][j] = true;
//                            continue;
//                		}
//                }
                    
                if(c[i][j - 1])
//                    if((p[i] == STAR) && (s[j - 1] == s[j])){
                	if((p[i] == STAR) && (c[i - 1][j - 1])){
                    	c[i][j] = true;
                    	continue;
                    }
            }
        
        return c[M - 1][N - 1];
    }
}