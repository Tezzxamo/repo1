import java.util.Scanner;

public class ABCD  {
    public static void main(String[] args) {

        /*String a="2";
        String b="4";
        int a1= Integer.parseInt(a);
        int b1=Integer.parseInt(b);
        System.out.println(a1+b1);*/


        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }

    //完成左移操作：
    //输入                   输出
    //4
    //0 0 2 4               2 4 0 0
    //0 2 2 2               4 2 0 0
    //0 4 2 2               4 4 0 0
    //8 8 2 2               16 4 0 0
    static String solution(String[] input) {
        int length=input.length;
        String[] get=new String[length];

        for (int i=0 ; i<length; i++){
            String str=input[i];//获取本行的string
            int bit[]=new int[length];//记录本行这个数字的位数是多少
            int to=0;
            int space=length-1;
            for(int j=0;j<space;j++){
                char last='a';
                if(j!=0){
                    last= str.charAt(j-1);
                }
                char cnow = str.charAt(j);

                if (cnow==' '){
                    to++;
                }else{
                    space++;//使本行可以遍历完毕
                }

                //记录位数
                if (last!=' '&& cnow!=' '){
                    bit[to]=bit[to]+1;
                }
                if (last!=' '&& cnow==' '){
                    bit[to]=bit[to]+1;
                }
            }


            /*for(int n=0;n<length;n++){//获取length个数字
                int start=n;
                String a=str.substring(n,n+bit[n]);
                int aa=Integer.parseInt(a);
                System.out.println(aa);
            }*/


        }




        return "a";
    }








    public static int Fibonacci(int n) {
        //斐波那契数列数列从第3项开始,每一项都等于前两项之和0,1,1,2……
        int qian=0;
        int hou=1;
        int result=hou;//当n=1时，result=1，返回1
        if(n==0) return qian;
        for(int i=2;i<=n;i++){
            result=qian+hou;
            qian=hou;
            hou=result;
        }
        return result;
    }
    /*public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){//先序和中序以及后序的长度是一样的，只需要判断一个即可知道是否长度为0，若为0，即返回null
            //若是长度为0，说明上一次已经到了叶子节点，或者此二叉树是一个空树，那么就可以进行递归了
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);//先序的第一个值就是二叉树的根节点
        for(int i=0;i<pre.length;i++){
            if(pre[0] == in[i]){//以根节点为中心，分成左右两边，然后再将每一个子树当成一个新的二叉树
                //Arrays.copyOfRange(pre, 1, i+1):复制数组pre，复制范围[0,i+1)
                //Arrays.copyOfRange(in, 0, i):复制数组in，复制范围[0,i-1)
                //这里截取数组的意思就是将每个子树当成一个新的二叉树，这样就可以通过递归将二叉树从叶子节点一一链接起来，最终生成一颗完整的二叉树
                //这里是任意一个根节点的左侧二叉树
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                //这里是任意一个根节点的右侧二叉树
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;//开始递归，每次先返回的是左侧，然后在上面的if语句里面进入到right。
        //只有左侧构造完毕，才会构造右侧，不过每次左右构造都是同级的构造，也就是同一个根节点，这样就可以完整的构造一个二叉树
    }*/
}
