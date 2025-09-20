package leetcode;
import java.io.*;
import java.lang.*;
import java.util.*;
class JobSequence {
    public static void main(String[] args) throws IOException{

        Job arr[] = {new Job(1,2,100),new Job(2,1,19), new Job(3,2,27), new Job(4,1,25), new Job(5,1,15)};

        //function call
        int[] res = jobScheduling(arr, arr.length);
        System.out.println (res[0] + " " + res[1]);
    }
    //Function to find the maximum profit and the number of jobs done.
    public static int[] jobScheduling(Job arr[], int n)
    {
//        int res[] = new int[2];
//        Arrays.sort(arr, new JobComparator());
//        int prof = arr[0].profit;
//        int count =1;
//        int jobsDone = 1;
//
//        System.out.println(arr[0].toString() + " " + arr[1].toString());
//        for(int i=1;i<n;i++)
//        {
//            if(arr[i].deadline>jobsDone)
//            {
//                prof += arr[i].profit;
//                count++;
//                jobsDone++;
//            }
//        }
//        res[0] = count;
//        res[1] = prof;
//
//        return res;
        int res[] = new int[2];
        Arrays.sort(arr, new JobComparator());
        int prof = 0;
        int count =0;
        int jobsDone = 0;
        int find[] = new int[n+1];

        System.out.println(arr[0].toString() + " " + arr[1].toString());
        for(int i=0;i<n;i++)
        {
            int end = arr[i].deadline;
            System.out.println(arr[i].profit + " " + arr[i].deadline);
            while(end>0)
            {
                if(find[end]==0)
                {
                    find[end]= arr[i].id;
                    prof += arr[i].profit;
                    System.out.println("profit is "+ prof);
                    count++;
                    break;
                }
                else
                    end--;
            }
        }
        res[0] = count;
        res[1] = prof;

        return res;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}



class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2)
    {
        if(j1.profit<j2.profit)
            return 1;
        else if(j1.profit>j2.profit)
            return -1;
        else if(j1.deadline<j2.deadline)
            return -1;
        else
            return 1;
    }
}

