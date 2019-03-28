import java.util.*;
import static java.util.stream.Collectors.*;
class IndianArmy {
    public static void main(String args[] ) throws Exception {
        int i,checkpoints;
        Scanner scan=new Scanner(System.in);
        checkpoints=scan.nextInt();
        long start=scan.nextLong();
        long end=scan.nextLong();
        long position[]=new long[checkpoints];
        long army[]=new long[checkpoints];
        for(i=0;i<checkpoints;i++)
        {
            position[i]=scan.nextLong();
            army[i]=scan.nextLong();
        }
        Solution sln=new Solution();
        System.out.println(sln.help(checkpoints,start,end,position,army));
    }
}
class Solution{
    public static long help(int checkpoints,long start,long end,long[] pos,long[] armyarray){
        int i;
        long sum=0;
        long min_defend[]=new long[checkpoints+2];
        long max_defend[]=new long[checkpoints+2];
        min_defend[0]=start;
        min_defend[1]=end;
        max_defend[0]=min_defend[0];
        max_defend[1]=min_defend[1];
        for(i=2;i<checkpoints+2;i++)
        {
            long position=pos[i-2];
            long army=armyarray[i-2];
            if((min_defend[0]<=position+army)&&(max_defend[1]>=position-army)){
                min_defend[i]=position-army;
                max_defend[i]=position+army;
            }
            else if(min_defend[0]>position+army){
                min_defend[i]=min_defend[0];
                max_defend[i]=min_defend[0];
            }
            else{
                min_defend[i]=min_defend[1];
                max_defend[i]=min_defend[1];
                }
        }
        Arrays.sort(min_defend);
        Arrays.sort(max_defend);
        for(i=1;i<min_defend.length;i++){
            if(min_defend[i]-max_defend[i-1]>0)
                sum+=min_defend[i]-max_defend[i-1];}
          return sum;
    } 
}
