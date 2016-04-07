package org.puder.sugartest;

import java.util.List;

public class OrderedBook extends Book {
    public int orderId;

    public List<Category> categories;

    public OrderedBook() {

    }

    public OrderedBook(int orderId, List<Category> categories, String isbn, String title, String edition) {
        super(isbn, title, edition);
        this.orderId = orderId;
        this.categories = categories;
    }

}
