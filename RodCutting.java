import java.util.Scanner;
class RodCutting {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int [] input=new int[t];
        for(int i=0;i<t;i++)
        {
            input[i]=sc.nextInt();
        }
        Solution soln=new Solution();
        System.out.println(soln.specialRods(t,input));
    }
}
class Solution {
    public static String specialRods(int t,int[] input){
        String out=new String();
        out="";
        for(int i=0;i<t;i++)
        {
            int len=input[i];
            int temp=3;
            int count=0;
         while(temp<=len)
            {
               count++;
               temp=temp*2+1;
            }
             out+=count+"\n";
        }
        return out;
    }
}