package v1;
public class Sqrt {
    public static final double EPSILON = 0.000001;
    
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0)
            return 0;
        if(x > 0)
            return sqrtNewton(x);
        return -1;  // sqrt of negative number
    }
    
    // x_n = 1/2 * (x_n-1 + d/x_n-1)
    private int sqrtNewton(int d)
    {
        double xn, xn_1;
        xn_1 = 1.0;
        
        while(true){
            xn = 0.5 * (xn_1 + d / xn_1);
            
            if(Math.abs(xn - xn_1) < EPSILON) break;
            
            xn_1 = xn;
        }
        
        return (int)xn;
    }
}    
   