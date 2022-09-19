package com;

public class JieDian {
    //首指针
    private JieDian start;
    //数据
    private Object value;
    //尾指针
    private JieDian end;

    /**
     * 头节点
     */
    public JieDian() {
        this.start = null;
        this.value = null;
        this.end = null;
    }

    /**
     * 占用一定存储单元且存储数据的无指针节点
     * @param value 存储的数据
     */
    public JieDian(Object value) {
        this.start = null;
        this.value = value;
        this.end = null;

    }

    /**
     * 占用一定存储单元且存储数据的双指针节点
     * @param start 首指针
     * @param value 数据
     * @param end 尾指针
     */
    public JieDian(JieDian start, Object value, JieDian end) {
        this.start = start;
        this.value = value;
        this.end = end;
    }

    public JieDian getStart() {
        return start;
    }

    public void setStart(JieDian start) {
        this.start = start;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public JieDian getEnd() {
        return end;
    }

    public void setEnd(JieDian end) {
        this.end = end;
    }
}
