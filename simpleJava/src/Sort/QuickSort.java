package Sort;

public class QuickSort {

    public static void main(String[] args) {
        int array[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        /**
         * 冒泡排序
         */
        /*array=BubbleSort(array);*/
        /**
         * 选择排序
         */
        /*array=SelectionSort(array);*/
        /**
         * 插入排序
         */
        array=InsertionSort(array);



        /**
         * 输出排序后的数组
         */
        for(int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }



    /**
     * 冒泡排序:
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * 排序思想：两两之间不断比较，将较大的向后移动（或者较小的向前移动），直到两次for循环结束，排序完成
     * @param array
     * @return
     */
    public static int[] BubbleSort(int[] array){
        if(array.length==0){
            return array;
        }
        for(int i=0 ;i<array.length;i++){
            /**
             * 常规写法，两个for循环嵌套：
             * ①第一种排序，从小到大：从前向后冒泡，后者小于前者则换位到前面，后者大于前者则双方不动
             * ②第二种排序，从大到小：从后向前冒泡，后者大于前者则换位到前面，后者小于前者则双方不动
             */
            /*for(int j= 0;j<array.length -1 ;j++){
                if(array[j+1]<=array[j]){
                    swap(array,j+1, j+0);
                }
            }*/
            /**
             * 改进的冒泡，两个for循环嵌套，但是对第二个循环的循环次数进行改进：
             * 循环条件变为：j<array.length-1-i
             * 意为每一次将最大的放到最后面以后，就不用再次用其他数与最大的数比较，这样就会比之前的写法更有效率。
             */
            for(int j= 0;j<array.length -1-i;j++){
                if(array[j+1]<=array[j]){
                    swap(array,j+1, j+0);
                }
            }
        }
        return array;
    }

    /**
     * 选择排序:
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     * 适合于数据量小的情况，最稳定的排序之一
     *
     * 排序思想：每次选中当前序列中最小的（或最大的）放到首位，经过两次for循环以后，所有数字都经历了一次放在当前序列的首位时，排序完成
     * @param array
     * @return
     */
    public static int[] SelectionSort(int[] array){
        if (array.length==0)
            return array;
        for(int i=0;i<array.length;i++){
            int smallIndex=i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[smallIndex]){
                    smallIndex=j;
                }
            }
            swap(array,smallIndex,i);
        }



        return  array;
    }

    /**
     * 插入排序：
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     *
     * 排序思想：将第一个数看做已经排序好的序列，每一次for循环，都将加入一个新的数进行排序
     *          排序的方式是一一对比已经排序好的数，与排序好的数的最后一个比较，小于则将新数左移，否则不移动，直接将排序好的数的长度+1
     *
     * @param array
     * @return
     */
    private static int[] InsertionSort(int[] array) {
        if(array.length==0){
            return array;
        }
        int index;
        for(int i=0;i<array.length-1;i++){
            index=array[i+1];


        }


        return array;
    }


    /**
     * 数组元素交换方法：swap(array[],one,two)
     * @param array
     * @param one
     * @param two
     * @return
     */
    public static int[] swap(int array[] ,int one ,int two){
        int a=array[one];
        array[one]=array[two];
        array[two]=a;
        return array;
    }

}
