package pl.gorczynski.bookweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.ArrayList;

import pl.gorczynski.bookweb.adapters.BookListAdapter;
import pl.gorczynski.bookweb.models.Book;

public class BooksListActivity extends AppCompatActivity {

    private static final String TAG = "Zawartość listy ";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        setTitle("Lista książek");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(R.drawable.ic_book, "Nie czytaj tej książki", "X Y", new Date(117, 11, 8)));
        books.add(new Book(R.drawable.ic_book, "Kolejna książka", "Jakiś Facet", new Date(119,11,13)));
        books.add(new Book(R.drawable.ic_book, "Jeszcze jedna książka", "Autor Książki", new Date(118,11,14)));
        books.add(new Book(R.drawable.ic_book, "Tytuł 3", "Autor 3", new Date( 119,1,16)));
        books.add(new Book(R.drawable.ic_book, "Tytuł 4", "Autor 4", new Date(117,9,27)));
        books.add(new Book(R.drawable.ic_book, "Tytuł 5", "Autor 5", new Date(119,7,20)));


        for (Book b: books){
            Log.i(TAG,b.toString());
        }

        mRecyclerView = findViewById(R.id.books_list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BookListAdapter(books);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
