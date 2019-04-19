package lanchong.iloveu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 * 回溯
 *
 */
public class Recursion {

    StringBuilder sb = new StringBuilder();





    /**
     * #######################厉害了 小技巧 将数组下表作为另一个数组使用
     * 找到数组中所有未出现的数字
     * 数组长度为n，value为1-n
     */
    public List findAllNumbersDisappears(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int value = Math.abs(arr[i]) - 1;
            //置为负数
            arr[value] = -Math.abs(arr[value]);
        }
        //比如说 取出i=0时数据为5。那就将下标为5的数改成负数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 打印括号
     */
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return list;
        recursion(n, n);
        return list;
    }
    public void recursion(int l, int r) {
        if (l>r) {
            return;
        }
        if (r == 0 && l == 0) {
            list.add(sb.toString());
        } else {
            if (l > 0) {
                sb.append('(');
                recursion(l-1, r);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r > 0) {
                sb.append(')');
                recursion(l, r-1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    /**
     * 打印最短的数学公式 条件a<=b,只能使用*2和+1
     * b = a (*1+1)
     */
    public void intSeq(int a,int b) {
        sb.append(b);
        sb.append(" = ");

        System.out.print(intSeqRecursion(a,b));
    }
    public String intSeqRecursion(int a,int b) {
        if (a==b) {
            return a+"";
        }
        if (b%2==1||b<2*a) {
            sb.append("( ");
            sb.append(intSeqRecursion(a,b-1));
            sb.append(" + 1 )");
            String result = sb.toString();
            sb.setLength(0);
            return result;
        }

        sb.append("( ");
        sb.append(intSeqRecursion(a,b/2));
        sb.append(" * 2 )");
        String result = sb.toString();
        sb.setLength(0);
        return result;
    }


    /**
     * 打印汉诺塔问题 印度神话
     * 条件:大盘不能放在小的上面
     *
     *
     * 当n=1时f(1)-> start->by->end
     *
     * 当n时
     * f(n)-> start->end->by
     * f(1)-> start->by->end
     * f(n)-> by->start->end
     */
    public void hanoiTower(int n){
        hanoiTower(n,"START","END","BY");
    }

    /**
     * 移动次数为 2的n次方-1
     * f(n)=2f(n-1)+1 在数学上可以推导出 2的n次方-1
     */
    public void hanoiTower(int n,String start,String end,String by){
        if (n==1){
            System.out.println("Move from " +start +" to "+end);
        }else{
            //从start拿一个的，放在by或end的位置  递归导致by和end一直在交换
            hanoiTower(n-1,start,by,end); //n=4的过程 3 by         n=3 2 end                n=2 1 by
            //再从start拿一个大的，放在end或by的位置中空的位置
            hanoiTower(1,start,end,null);//          n=3 1 by                     1 end
            //将多的塔叠到上一步中只有一个的塔上
            hanoiTower(n-1,by,end,start);//              n=3 2  递归不打印end->by  n=2  1 by->end
        }
    }

    /**
     * n==1 enter1 enter1+1 extra1
     *
     */
    public void binaryGrayCode(int n,boolean enter){
        if (n==0){
        }else{
            binaryGrayCode(n-1,true);
            System.out.println(enter?("enter:"+n):("extra:"+n));
            binaryGrayCode(n-1,false);
        }
    }

    /**
     * 所有子集
     * ~~~~~~~~有模板
     */
    public int[][] subSet(int[] arr){
        int pow = (int) Math.pow(2, arr.length);
        int[][] result = new int[pow][];
        subSet(arr,result,0);

        return result;
    }

    public void subSet(int[] arr,int[][] result,int index){




    }







}
