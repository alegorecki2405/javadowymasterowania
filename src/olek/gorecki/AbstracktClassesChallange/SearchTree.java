package olek.gorecki.AbstracktClassesChallange;

public class SearchTree implements NodeList{

    private ListItem root;

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
            // lista jest pusta wiec item staje się jej pierwszym elementem
            this.root = listItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if(comparison < 0) {
                // nowy element jest "wiekszy" więc idziemy w prawo jeśli to możliwe
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //dotarliśmy do końca listy
                    currentItem.setNext(listItem);
                    listItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if(currentItem.previous() != null) {
                    currentItem.previous().setNext(listItem);
                    listItem.setPrevious(currentItem.previous());
                    listItem.setNext(currentItem);
                    currentItem.setPrevious(listItem);
                } else {
                    // coś bez poprzednika jest rootem;
                    listItem.setNext(this.root);
                    this.root.setPrevious(listItem);
                    this.root = listItem;
                }
                return true;
            } else {
                System.out.println(listItem.getValue() +" is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (this.root == null) {
            return false;
        } else {
            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = currentItem.compareTo(listItem);
                if (comparison == 0) {
                    // znaleziono item do usuniecia
                    if (currentItem == this.root) {
                        this.root = currentItem.next();
                    } else {
                        currentItem.previous().setNext(currentItem.next());
                        if (currentItem.next() != null) {
                            currentItem.next().setPrevious(currentItem.previous());
                        }
                    }
                    return true;
                } else if (comparison <0) {
                    currentItem = currentItem.next();
                } else {
                    //comparison >0
                    //zaszliśmy dalej niż jest możliwe usunięcie bo obiekty są wielkością po kolei
                    return false;
                }
            }
            return false;
        }
    }

    @Override
    public void traverse(ListItem root) {
        System.out.println(root.getValue());
        if(root.next() != null) {
            traverse(root.next());
        }
        return;
    }

    private void performRemoval(ListItem parent, ListItem itemToRemove) {

    }
}
