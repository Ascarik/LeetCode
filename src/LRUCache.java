import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 146. LRU Cache
 * <p>
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
  private final Map<Integer, Integer> map;
  private final Set<Integer> keys;
  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>(capacity);
    this.keys = new LinkedHashSet<>(capacity);
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      keys.remove(key);
      keys.add(key);
      return map.get(key);
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {

    if (map.containsKey(key)) {
      keys.remove(key);
      keys.add(key);
      map.put(key, value);
      return;
    }

    if (keys.size() == capacity) {
      Integer k = keys.stream().findFirst().get();
      keys.remove(k);
      map.remove(k);
      if (k == key) {
        keys.add(k);
      } else {
        keys.add(key);
      }
      map.put(key, value);
    } else {
      keys.add(key);
      map.put(key, value);
    }
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    assert lRUCache.get(1) == 1;    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    assert lRUCache.get(2) == -1;    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    assert lRUCache.get(1) == -1;    // return -1 (not found)
    assert lRUCache.get(3) == 3;    // return 3
    assert lRUCache.get(4) == 4;    // return 4

    //["LRUCache","put","put","put","put","get","get"]
    //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    lRUCache = new LRUCache(2);
    lRUCache.put(2, 1);
    lRUCache.put(1, 1);
    lRUCache.put(2, 3);
    lRUCache.put(4, 1);
    assert lRUCache.get(1) == -1;
    assert lRUCache.get(2) == 3;

    //["LRUCache","put","put","get","put","put","get"]
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

    lRUCache = new LRUCache(2);
    lRUCache.put(2, 1);
    lRUCache.put(2, 2);
    assert lRUCache.get(2) == 2;
    lRUCache.put(1, 1);
    lRUCache.put(4, 1);
    assert lRUCache.get(2) == -1;

    //["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
    //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    //[null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]

    lRUCache = new LRUCache(3);
    lRUCache.put(1, 1);
    lRUCache.put(2, 2);
    lRUCache.put(3, 3);
    lRUCache.put(4, 4);
    assert lRUCache.get(4) == 4;
    assert lRUCache.get(3) == 3;
    assert lRUCache.get(2) == 2;
    assert lRUCache.get(1) == -1;
    lRUCache.put(5, 5);
    assert lRUCache.get(1) == -1;
    assert lRUCache.get(2) == 2;
    assert lRUCache.get(3) == 3;
    assert lRUCache.get(4) == -1;
    assert lRUCache.get(5) == 5;
  }
}

