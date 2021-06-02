package cn.nnxy;

class Solution {
    public boolean isMatch(String s, String p) {
        int sLen=s.length(),pLen=p.length();
        boolean[][] memory=new boolean[sLen+1][pLen+1];
        memory[0][0]=true;
        for(int i=0;i<=sLen;i++){
            for(int j=1;j<=pLen;j++){
                if(p.charAt(j-1)=='*'){
                    System.out.print( memory[i][j]=memory[i][j-2]||(i>0&&(s.charAt(i-1)=='.')&&memory[i-1][j]));
                }
                else System.out.print(memory[i][j]=i>0&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')&&memory[i-1][j-1]);
                System.out.print(" "+i+","+j+" ");
            }
            System.out.println();
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isMatch("ab",".*");
    }
}