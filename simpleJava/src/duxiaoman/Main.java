package duxiaoman;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] a=new int[n+1];
        a[0]=0;
        String[] string=in.nextLine().split(" ");
        for (int i = 1; i < n+1; i++) {
            a[i]=Integer.parseInt(string[i-1]);//从1开始存数
        }
        ///////////////
        int right=1;//位置从1开始
        int total=0;//总攻击次数
        while(true){
            if(right<n){
                if(a[right]>0){//如果当前指针所指的位置不为0，则攻击，对x，2*x和2*x+1三格内的敌人分别造成一点伤害
                    a[right]-=1;
                    total++;
                    if(right*2<=n){
                        a[right*2]-=1;
                    }
                    if (right*2+1<=n){
                        a[right*2+1]-=1;
                    }
                    if (a[right]==0){
                        right++;
                    }
                }
                if (a[right]<=0){
                    right++;
                }
            }else if (right==n){
                if(a[right]>0){//如果当前指针所指的位置不为0，则攻击，对x，2*x和2*x+1三格内的敌人分别造成一点伤害
                    a[right]-=1;
                    total++;
                }
                if (a[right]<=0){
                    break;
                }
            }

            /*for (int aaa=1;aaa<n+1;aaa++) {
                System.out.print(" "+a[aaa]);
            }
            System.out.println();*/

        }/*
        for (int i=1;i<n+1;i++){
            if(a[i]>0){
                a[i]-=1;
                System.out.println("a["+i+"]"+a[i]);
                if (i*2<=n){
                    a[i*2]-=1;
                    System.out.println("a["+i*2+"]"+a[i*2]);
                }
                if((i*2+1)<=n){
                    a[i*2+1]-=1;
                    System.out.println("a["+i*2+1+"]"+a[i*2+1]);
                }
                total++;
            }

        }*/
        System.out.println(total);

    }
}
