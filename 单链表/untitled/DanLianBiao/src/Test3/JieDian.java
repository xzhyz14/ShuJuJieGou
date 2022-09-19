package Test3;

public class JieDian {
    private Object data;    //数据
    private JieDian next;   //下一节点位置

    public JieDian() {
        this.next = null;
        this.data = null;
    }

    public JieDian(Object data) {
        this.data = data;
        this.next = null;
    }

    public JieDian(Object data, JieDian next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JieDian getNext() {
        return next;
    }

    public void setNext(JieDian next) {
        this.next = next;
    }
}
