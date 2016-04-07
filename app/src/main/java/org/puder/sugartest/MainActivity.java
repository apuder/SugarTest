package org.puder.sugartest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db();
            }
        });
    }

    public void db() {
        Book book = new Book("isbn1", "Title 1", "Edition 1");
        book.save();
        book = new Book("isbn2", "Title 2", "Edition 2");
        book.save();
        book = new Book("isbn3", "Title 3", "Edition 3");
        book.save();

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Category, 1"));
        categories.add(new Category("Category, 2"));
        OrderedBook obook = new OrderedBook(1, categories, "isbn1", "Title 1", "Edition 1");
        obook.save();
        obook = new OrderedBook(2, categories, "isbn2", "Title 2", "Edition 2");
        obook.save();
        obook = new OrderedBook(3, categories, "isbn3", "Title 3", "Edition 3");
        obook.save();

        OrderedBook obook1 = OrderedBook.findById(OrderedBook.class, 4);
        Log.d("Sugar", "Count: " + obook1.categories.size());
        for (Category category : obook1.categories) {
            Log.d("Sugar", category.category);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
