package hyz;

public class DoubleLinList{

    //头指针
    private DNode head;
    //当前节点位置
    private DNode current;
    //数据元素个数
    private int size;


    public static void main(String[] args) throws Exception {
        DoubleLinList dl = new DoubleLinList();
        System.out.println("向双链表中依次添加11，22，33");
//        下标从0开始
//        向双链表中新增第一个数据
        dl.add(11);
//        向双链表中新增第二个数据
        dl.add(22);
//        向双链表中新增第三个数据
        dl.add(33);
        dl.output();


        System.out.println("向双链表中第二个位置插入44");
//        向双链表中第二个位置插入第四个数据
        dl.insert(1, 44);
        dl.output();

//        输出链表长度
        System.out.println("输出链表的长度：" + dl.size);

//        获取下表为2的节点中的数据
        System.out.println("获取下表为2的节点中的数据：" + dl.getData(2));

//        删除下表为1的节点
        dl.delete(1);

//        输出删除后链表的长度
        System.out.println("删除下表为1的节点后链表长度：" + dl.size);
        dl.output();
    }

    /**
     * 删除某位置的元素
     * @param i 索引
     * @return 被删除元素
     * @throws Exception    抛出异常
     */
    private Object delete(int i) throws Exception {
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误");
        }
        index(i);
        Object obj = current.getElement();
        current.getPrior().setNext(current.getNext());
        current.getNext().setPrior(current.getPrior());
        size--;
        return obj;
    }

    /**
     * 获取某索引位置的数据
     *
     * @param i 索引
     * @return 数据
     * @throws Exception 抛出异常
     */
    private Object getData(int i) throws Exception {
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误");
        }
//        修改，增加一个变量记录 current 地址
        DNode t = new DNode();
        t.setElement(current.getElement());
        t.setNext(current.getNext());
        t.setPrior(current.getPrior());
        current.getPrior().setNext(t);

        index(i);
        Object obj = current.getElement();
//        新增后把 current 地址还原
        current = t;
        return obj;
    }


    /**
     * 插入数据
     *
     * @param i   插入位置
     * @param obj 插入对象
     * @throws Exception 抛出异常
     */
    private void insert(int i, Object obj) throws Exception {
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误");
        }
//        添加一个变量记录 current 地址
        DNode t = new DNode();
        t.setElement(current.getElement());
        t.setNext(current.getNext());
        t.setPrior(current.getPrior());
        current.getPrior().setNext(t);
        index(i);

        DNode node = new DNode(obj);
        node.setPrior(current.getPrior());
        current.getPrior().setNext(node);
        node.setNext(current);
        current.setPrior(node);
//        新增后把 current 地址还原
        current = t;
        size++;
    }

    /**
     * 获取索引
     *
     * @param i 位置
     * @throws Exception 抛出异常
     */
    private void index(int i) throws Exception {
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误");
        }

        if (i < (size >> 2)) {
            current = head.getNext();
            for (int num = 0; num < i; num++) {
                current = current.getNext();
            }
        } else {
            for (int num = size - 1; num > i; num--) {
                current = current.getPrior();
            }
        }
    }

    /**
     * 输出链表数据
     */
    private void output() {
        DNode t = head.getNext();
        for (; t != null; t = t.getNext()) {
            System.out.print(t.getElement() + "");
        }
        System.out.println();
    }

    /**
     * 新增数据
     *
     * @param obj 插入数据
     * @return 插入结果 true/false
     */
    public boolean add(Object obj) {
        DNode node = new DNode(obj);
        if (current.getPrior() == null) {
            head = current;
            node.setPrior(current);
            current.setNext(node);
            current = node;
            head.setPrior(node);
        } else {
            node.setPrior(current);
            current.setPrior(node);
            current = node;
        }
        size++;
        return true;
    }

    /**
     * 初始化链表时头指针和current指针都指向头结点
     */
    public DoubleLinList() {
        head = current = new DNode(null);
        head.setNext(head);
        size = 0;
    }
}
