package v1;
public class StrStr {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if((needle == null) || (haystack == null))
            return null;
        if((needle.length() == 0) && (haystack.length() == 0))
            return "";
        //if((needle.length() == 0) || (haystack.length() == 0))
        //    return null;
            
        int i, j;
        int N = haystack.length();
        int M = needle.length();
        for(i = 0; i < N; i ++){
            for(j = 0; j < M; j ++)
                if((i + j < N) && ((haystack.charAt(i + j) != needle.charAt(j)) || !((needle.charAt(j) + "").equals(""))))
                    break;
            if(j == M)
                return haystack.substring(i);
        }
        
        return null;
    }
}