package leetcode.topn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给一个无序的数组，长度为N， 请输出最大的5个数。
 */
public class GetTopKByHeapInsertTopKElement {
    List<Integer> res = new LinkedList<>();

    public void getTopN(int[] array, int topN) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(topN);
        for (int i = 0; i < array.length; i++) {
            if (i < topN) {
                heap.add(array[i]);
            } else {
                // peek会获取但不删除队首元素
                if (heap.peek() != null && array[i] > heap.peek()) {
                    heap.poll();
                    heap.add(array[i]);
                }
            }
        }
        Iterator<Integer> iterator = heap.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
    }


}
