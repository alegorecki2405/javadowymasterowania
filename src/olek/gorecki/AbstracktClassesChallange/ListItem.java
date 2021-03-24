package olek.gorecki.AbstracktClassesChallange;

import java.util.List;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem next);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem previous);
    abstract int compareTo(ListItem listItem);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
