package tree;

/**
 * Created by slsan on 2018/9/20.
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int index, int l, int r) {

        if (l == r) {
            tree[index] = tree[l];
            return;
        }

        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex,l,mid);
        buildSegmentTree(rightChildIndex,mid + 1,r);
        tree[index] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");

        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length;i++){
            if (tree[i] != null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }

            if (i != tree.length -1)
                res.append(", ");

        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args){
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segment = new SegmentTree<>(nums,new Merger<Integer>(){
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segment);
    }
}
