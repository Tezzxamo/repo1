package thread1test2example;

/**
 * @author y
 */
public final class Print1to53AndAtoZ {
    /*   public static void main(String[] args) {
           ArrayList<Integer> arrayList = new ArrayList<>();
           arrayList.add(-1);
           arrayList.add(3);
           arrayList.add(3);
           arrayList.add(-5);
           arrayList.add(7);
           arrayList.add(4);
           arrayList.add(-9);
           arrayList.add(-7);
           HashSet<Integer> hashSet = new HashSet<>();
           hashSet.add(1);
           hashSet.add(3);
           hashSet.add(787878);
           hashSet.add(2);

           Map scores = new HashMap();
           scores.put("语文" , 80);
           scores.put("Java" , 82);

           System.out.println(scores);

           int a[]={1,2,3,4,2,2,3};
           Arrays.sort(a);
           for(int i:a){
               System.out.println(i);
           }

   //        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
   //        System.out.println(stooges);

           List<String> list=new ArrayList<String>(){
               {
                   add("A");
                   add("B");
                   add("C");
               }
           };
           String[] str= list.toArray(new String[0]);//new String[0]起到一个模版的作用，意为泛型指定为String[]，如果需要的是int[]，则在括号里写new int[0]即可
           System.out.println(str[2]);

           Object[] objs=list.toArray();
           System.out.println(objs[1]);

           char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
           // 排序后再进行二分查找，否则找不到
           Arrays.sort(e);
           System.out.println("Arrays.sort(e)" + Arrays.toString(e));
           System.out.println("Arrays.binarySearch(e, 'c')：");
           int s = Arrays.binarySearch(e, 'd');
           System.out.println("字符c在数组的位置：" + s);

           System.out.println(Math.abs(s));

           int c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
           // parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
           Arrays.parallelSort(c);
           System.out.println("Arrays.parallelSort(c)：");
           for (int i : c) {
               System.out.print(i);
           }
           System.out.println();
           System.out.println(Arrays.toString(c));
           List<Integer> integers = Collections.unmodifiableList(arrayList);
           System.out.println(integers);//[-1, 3, 3, -5, 7, 4, -9, -7]

           arrayList.add(106);
           System.out.println(arrayList);
           System.out.println(integers);
           Collections.sort(arrayList, Comparator.reverseOrder());
           System.out.println();
           System.out.println(arrayList);
           System.out.println(integers);


           List<Object> list = Collections.emptyList();
           System.out.println(list);//[]
           Set<Object> set = Collections.emptySet();
           System.out.println(set);//[]
           Map<Object, Object> objectObjectMap = Collections.emptyMap();
           System.out.println(objectObjectMap);//{}
           //Collections.singletonXXX();
           List<ArrayList<Integer>> singletonList = Collections.singletonList(arrayList);
           System.out.println(singletonList);//[[-1, 3, 3, -5, 7, 4, -9, -7]]
   //        System.out.println(arrayList);
           //创建一个只有一个元素，且不可改变的Set对象
           Set<HashSet<Integer>> singleton = Collections.singleton(hashSet);
           System.out.println(singleton);//[[-1, 3, 3, -5, 7, 4, -9, -7]]
           Map<String, String> nihao = Collections.singletonMap("1", "nihao");
           System.out.println(nihao);//{1=nihao}

           Map  singletonMap=Collections.singletonMap(scores,arrayList);
           System.out.println(singletonMap);


           List<Integer> lll=Collections.singletonList(1);
           System.out.println(lll);


       }*/
    public static void main(String[] args) {
        Object obj = new Object();//使用object控制
        Thread t1= new Thread(new ShuZi(obj));
        Thread t2= new Thread(new ZiMu(obj));
        /*Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("zzx" + i + "的线程...");
                        obj.notifyAll();
                        if (i < 4) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });*/
        t1.start();
        t2.start();
        /*t3.start();*/
    }

    private static class ShuZi implements Runnable {
        public Object object;

        public ShuZi(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 1; i < 53; i++) {
                    System.out.print(i);
                    if (i % 2 == 0) {
                        object.notifyAll();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class ZiMu implements Runnable {
        public Object object;

        public ZiMu(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) (i + 'A') + " ");
                    object.notifyAll();
                    if (i + 'A' < 'Z') {  // 线程执行的最后一次不能堵塞，不然会一直堵塞下去。
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
