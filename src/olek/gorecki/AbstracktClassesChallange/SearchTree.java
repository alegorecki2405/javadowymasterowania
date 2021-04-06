package olek.gorecki.AbstracktClassesChallange;

public class SearchTree implements NodeList{

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        if (this.root == null) {
            this.root = listItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if(comparison < 0) {
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(listItem);
                    return true;
                }
            } else if (comparison > 0) {
                if(currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(listItem);
                    return true;
                }
            } else {
                System.out.println(listItem.getValue() +" is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if(listItem != null) {
            System.out.println("Deleting item " + listItem.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // znaleźliśmy item więc do usunięcia
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root.next() != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if(item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                this.root = item.next();
            }
        } else {
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous() != null) {
                leftMostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            if(leftMostParent == item) {
                item.setNext(current.next());
            } else {
                leftMostParent.setPrevious(current.next());
            }
        }
    }
}
