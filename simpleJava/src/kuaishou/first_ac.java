package kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class first_ac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] aa = in.nextLine().split(" ");
        int n = Integer.parseInt(aa[0]);//学生数量
        int m = Integer.parseInt(aa[1]);//题目数量
        String[] si = new String[n];
        for (int i = 0; i < n; i++) {
            si[i] = in.nextLine();//每个学生的答案
        }
        String[] bb=in.nextLine().split(" ");
        int[] scores = new int[m];//每道题的分数
        for (int i = 0; i < m; i++) {
            scores[i] = Integer.parseInt(bb[i]);
        }
        ////////////////////
        int total=0;
        int a,b,c,d,e;
        for (int i = 0; i < m; i++) {
            //每一道题获取最大的分
            a = 0;b = 0; c = 0; d = 0; e = 0;
            for (int j = 0; j < n; j++) {
                String get = (si[j]).substring(i, i + 1);
                if ((get.equals("A"))) {
                    a++;
                }
                if ((get.equals("B"))) {
                    b++;
                }
                if ((get.equals("C"))) {
                    c++;
                }
                if ((get.equals("D"))) {
                    d++;
                }
                if ((get.equals("E"))) {
                    e++;
                }
            }
            List<Integer> list =new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            list.add(e);
            Collections.sort(list);
            total+=list.get(4)*scores[i];
        }
        System.out.println(total);
    }
}
