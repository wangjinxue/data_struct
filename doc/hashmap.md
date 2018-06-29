## put方法
``` java
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                      boolean evict) {
            //tab 临时表、p临时的键值对、n 临时长度,i临时索引
           Node<K,V>[] tab; Node<K,V> p; int n, i;
           //表数据为空的情况下
           if ((tab = table) == null || (n = tab.length) == 0)
               n = (tab = resize()).length;
               //重新生成表格并赋值给n
               //(n-1)&16获取hash值所对应的数组的索引
           if ((p = tab[i = (n - 1) & hash]) == null)
                //创建一个新节点，普通链表模式
               tab[i] = newNode(hash, key, value, null);
           else {
               Node<K,V> e; K k;
               if (p.hash == hash &&
                   ((k = p.key) == key || (key != null && key.equals(k))))
                   e = p;
               else if (p instanceof TreeNode)
                   e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
               else {
                   for (int binCount = 0; ; ++binCount) {
                       if ((e = p.next) == null) {
                           p.next = newNode(hash, key, value, null);
                           if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                               treeifyBin(tab, hash);
                           break;
                       }
                       if (e.hash == hash &&
                           ((k = e.key) == key || (key != null && key.equals(k))))
                           break;
                       p = e;
                   }
               }
               if (e != null) { // existing mapping for key
                   V oldValue = e.value;
                   if (!onlyIfAbsent || oldValue == null)
                       e.value = value;
                   afterNodeAccess(e);
                   return oldValue;
               }
           }
           ++modCount;
           if (++size > threshold)
               resize();
           afterNodeInsertion(evict);
           return null;
       }
```

## resize方法解析
``` java
    /**
    * 重新调整table长度
    */
    final Node<K,V>[] resize() {
        //旧表格
        Node<K,V>[] oldTab = table;
        //获取旧长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //旧
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            //如果旧长度大于最大允许的值，直接返回不需要调整
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //判断新容量长度=旧容量的2倍并小雨最大允许的值，并且旧长度大于等于默认初始化容量=1<<4=16
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        //如果旧的threshold大于0 ，新的容量直接赋值
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else { 
                      // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
            //计算新的threshold=默认加载银子*默认初始化量，新的容量直接赋值默认容量值，
        }
        //如果此时的threshold等于0，重新计算
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        //重新创建一个节点数组
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        //把旧表格的数据填充到新表格中
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                //释放内存
                    oldTab[j] = null;
                    if (e.next == null)
                        //
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```