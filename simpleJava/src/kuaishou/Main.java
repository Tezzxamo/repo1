package kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());//包含k个1的是病毒
        //思路：左右指针，先移动右指针找到并++，然后移动左指针
        String str = in.nextLine();//可能包含病毒的01字符串
        ///////////////
        /*int left = 0;//左指针
        int right = 0;//右指针
        int total = 0;


        if (str.charAt(0) == '1') {//预先探测
            k--;
        }
//        boolean rightgo = true;
        while (left<str.length()) {
                if (k > 0) {//需要移动右指针
                    right++;
                    if (str.charAt(right) == '1') {
                        k--;
                    }
                }
                if (k == 0) {
                    total++;
                    right++;//向右探测
                    if (str.charAt(right) == '1') {//若探测到1，k--，减到小于0，左指针开始移动
                        k--;
                    }
                }
            if (k < 0) {//需要移动左指针
                if (str.charAt(left) == '1') {
                    k++;
                }
                left++;
            }
        }
        System.out.println(total);*/


    }
}
