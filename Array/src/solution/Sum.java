package solution;


/**
 * Created by slsan on 2018/9/10.
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    public static int sum(int[] arr,int index){
        if (index == arr.length)
            return 0;

        return arr[index] + sum(arr,index + 1);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));


    }
}
