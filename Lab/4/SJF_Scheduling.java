import java.util.Scanner;
public class  SJF_Scheduling {
  public static void main(String [] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter Number Of Process");
    int n = sc.nextInt();
    
    int process[] = new int[n];
    int arrivalTime[] = new int[n];
    int burstTime[] = new int[n];
    int completeTime[] = new int[n];
    int turnAroundTime[] = new int[n];
    int waitingTime[] = new int[n];
    int fg[] = new int[n];
    int st = 0, totalTime = 0;
    float avgWT = 0, avgTA = 0;
    
    for(int i=0;i<n;i++) {
      System.out.println("Enter p"+(i+1)+" arrival time");
      arrivalTime[i] = sc.nextInt();
      System.out.println("Enter p"+(i+1)+" burst time");
      burstTime[i] = sc.nextInt();
      process[i] = i+1;
      fg[i] = 0;
    }
    while(true) {
      int c= n;
      int min = 999;
      if(totalTime == n) {
        break;
      }
      for(int i=0;i<n;i++) {
        if((arrivalTime[i]<=st) && (fg[i]==0) && (burstTime[i]<min)){
          min=burstTime[i];
          c=i;
        }
      }
      if(c==n)
        st++;
      else{
        completeTime[c] = st+burstTime[c];
        st=st+burstTime[c];
        turnAroundTime[c] = completeTime[c]-arrivalTime[c];
        waitingTime[c] = turnAroundTime[c]-burstTime[c];
        fg[c]=1;
        totalTime++;
      }
    }
    
    System.out.println("\nProcess Arrival \tBurst  \t\tComplete \tTurnaround \tWaiting");
    for( int i=0;i<n;i++) {
      avgWT=avgWT+waitingTime[i];
      avgTA=avgTA+turnAroundTime[i];
      System.out.println(process[i]+"\t"+arrivalTime[i]+"\t\t"+burstTime[i]+"\t\t"+ completeTime[i]+"\t\t"+turnAroundTime[i]+"\t\t"+waitingTime[i]);
    }
    System.out.println("\nAverage Waiting time : " + (avgWT/n));
    System.out.println("Average Turnaround time : " + (avgTA/n));
  }
}