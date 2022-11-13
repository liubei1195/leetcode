package leetcode;

import java.util.LinkedHashMap;

public class LRUCache_LinkedHashMap {
    int cap; // 最大容量
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache_LinkedHashMap(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) { // 如果key在cache里存在，修改值
            // 修改key的值
            cache.put(key, val);
            // 将key变为最近使用
            makeRecently(key);
            return;
        }
        // 不存在时，判断长度是否已超
        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的key
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的key 添加到链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}
