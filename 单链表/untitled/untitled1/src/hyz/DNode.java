package hyz;

public class DNode {
    private Object element;
    private DNode prior;
    private DNode next;

    public DNode() {
        this.element = null;
        this.prior = null;
        this.next = null;
    }

    public DNode(Object element) {
        this.element = element;
        this.prior = null;
        this.next = null;
    }

    public DNode(Object element, DNode prior, DNode next) {
        super();
        this.element = element;
        this.prior = prior;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public DNode getPrior() {
        return prior;
    }

    public void setPrior(DNode prior) {
        this.prior = prior;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
