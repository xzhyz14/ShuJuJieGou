package Test3;

public class DanLianBiao {
    private static JieDian head; //头
    private static JieDian current; //当前位置的指针
    static int size; //数据的个数

    /**
     * 带头节点
     */
    public DanLianBiao() {
        head = current = new JieDian();
        size = 0;
    }

    public static void main(String[] args) {
        DanLianBiao danLianBiao = new DanLianBiao();
        System.out.println("顺序添加数据：");
        endAdd(1);
        endAdd(2);
        endAdd(3);
        out();
        System.out.println("==================");

        System.out.println("逆序添加数据：");
        startAdd(1);
        startAdd(2);
        startAdd(3);
        out();
        System.out.println("==================");

        System.out.println("将第一个数改为6");
        alterIndex(0, 6);
        System.out.println("将第二个数改为6");
        alterIndex(1, 6);
        System.out.println("将最后一个数改为6");
        alterIndex(size - 1, 6);
        out();
        System.out.println("==================");

        System.out.println("在第一个数字前面插入7");
        insert(0, 7);
        out();
        System.out.println("在第三个数字前面插入7");
        insert(2, 7);
        out();
        System.out.println("=======================");

        System.out.println("删除第一个数");
        indexDelete(0);
        out();
        System.out.println("删除所有的数：");
        allDelete();
        out();


    }

    /**
     * 修改指定位置的节点数据
     */
    private static void alterIndex(int index, Object data) {
        if (index < 0 || index >= size) {
            System.out.println("参数错误!!!");
            return;
        }else {
            seleteIndexJieDian(index).setData(data);
            return;
        }
    }

    /**
     * 在指定位置插入数据
     *
     * @param index 插入位置
     * @param data  插入数据
     */
    private static void insert(int index, Object data) {
        if (index == 0) {
            startAdd(data);
            size++;
            return;
        } else if (index == size) {
            endAdd(data);
            size++;
            return;
        } else if (index > 0 && index < size) {
            JieDian temp = seleteIndexJieDian(index);
            endAdd(temp.getData());
            temp.setData(data);
            size++;
            return;
        } else {
            System.out.println("参数错误！！！" + index + "处不能插入数据！");
            return;
        }
    }

    /**
     * 指定“索引”删除节点
     */
    private static void indexDelete(int index) {
        if (index == 0) {//删除头
            JieDian temp = DanLianBiao.head.getNext();
            JieDian temp1 = seleteIndexJieDian(index + 1);
            temp.setNext(null);
            DanLianBiao.head.setNext(temp1);
            size--;
            return;
        } else if (index == size - 1) {//删除尾
            seleteIndexJieDian(index - 1).setNext(null);
            size--;
            return;
        } else if (index > 0 && index < size - 1) {//删除中间
            JieDian startIndexJieDIan = seleteIndexJieDian(index - 1);
            JieDian indexJieDian = seleteIndexJieDian(index);
            JieDian endIndexJieDian = seleteIndexJieDian(index + 1);
            indexJieDian.setNext(null);
            startIndexJieDIan.setNext(endIndexJieDian);
            size--;
            return;
        } else {
            System.out.println("参数错误！！！");
            return;
        }
    }

    /**
     * 全部删除
     */
    private static void allDelete() {
        DanLianBiao.head.setNext(null);
        size = 0;
        return;
    }

    /**
     * 从单链表最后一个节点增加
     */
    private static void endAdd(Object data) {
        if (size == 0 && DanLianBiao.head.getNext() == null) {
            DanLianBiao.head.setNext(new JieDian(data));
            size++;
            return;
        }else {
            JieDian temp = DanLianBiao.head.getNext();
            int tempIndex = 0;
            while (temp != null){
                temp = temp.getNext();
                tempIndex++;
            }
            seleteIndexJieDian(tempIndex-1).setNext(new JieDian(data));
            size++;
            return;
        }
    }


    /**
     * 从头节点开始增加数据
     */
    private static void startAdd(Object data) {
        JieDian temp = new JieDian(data);
        if (size == 0 && DanLianBiao.head.getNext() == null) {
            DanLianBiao.head.setNext(temp);
            size++;
            return;
        } else {
            JieDian temp2 = DanLianBiao.head.getNext();
            DanLianBiao.head.setNext(temp);
            temp.setNext(temp2);
            size++;
            return;
        }


    }

    /**
     * 查找指定位置的节点
     *
     * @param index 指定位置
     * @return 返回查找节点
     */
    private static JieDian seleteIndexJieDian(int index) {
        JieDian temp = DanLianBiao.head;
        if (index == 0) {
            return temp.getNext();
        } else if (index > 0 && index < size) {
            int indexTemp = 0;
            while (indexTemp <= index) {
                temp = temp.getNext();
                indexTemp++;
            }
            return temp;
        } else if (index < 0 || index >= size) {
            System.out.println("参数错误！");
        }
        return null;
    }

    /**
     * 遍历单链表并打印
     */
    private static void out() {
        JieDian temp = DanLianBiao.head.getNext();
        if (temp == null) {
            System.out.println("该单链表为空！！");
            return;
        }
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        return;
    }


}
