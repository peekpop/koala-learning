public class HashMapCapacity {

    public static void main(String[] args) {
        int num = 4;
        //未初始化大小
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            map1.put(i, i);
        }
        long e1 = System.currentTimeMillis();
        System.out.println("未初始化大小："+ (e1 - s1));

        //初始化一半大小
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(num/2);
        long s2 = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            map2.put(i, i);
        }
        long e2 = System.currentTimeMillis();
        System.out.println("初始化一半大小："+ (e2 - s2));

        //初始化一样大小
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>(num);
        long s3 = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            map3.put(i, i);
        }
        long e3 = System.currentTimeMillis();
        System.out.println("初始化一样大小："+ (e3 - s3));

        // 初始化大小考虑到扩容因子，采摘于阿里巴巴手册：
        // initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即 loaderfactor）默认为 0.75，如果暂时无法确定初始值大小，请设置为 16（即默认值）。
        Map<Integer, Integer> map4 = new HashMap<Integer, Integer>((int)(num/0.75+1.0));
        long s4 = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            map4.put(i, i);
        }
        long e4 = System.currentTimeMillis();
        System.out.println("初始化大小考虑到扩容因子："+ (e4 - s4));
    }
}