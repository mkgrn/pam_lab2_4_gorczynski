package pl.gorczynski.bookweb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.gorczynski.bookweb.models.Book;
import pl.gorczynski.bookweb.R;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private ArrayList<Book> books;

    public BookListAdapter(ArrayList<Book> Books) {
        books = Books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_list_element, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);

        holder.mImageView.setImageResource(book.getImageResource());
        holder.mTextView1.setText(book.getTitle());
        holder.mTextView2.setText(book.getAuthor());
        holder.mTextView3.setText(book.getDateToString());
    }


    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textViewB1);
            mTextView2 = itemView.findViewById(R.id.textViewB2);
            mTextView3 = itemView.findViewById(R.id.textViewB3);
        }
    }


}
