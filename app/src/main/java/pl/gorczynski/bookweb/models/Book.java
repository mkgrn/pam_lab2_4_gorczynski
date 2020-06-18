package pl.gorczynski.bookweb.models;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Book {
    private int mImageResource;
    private String mTitle;
    private String mAuthor;
    private Date mDate;

    public Book(int imageResource, String title, String author, Date date) {
        mImageResource = imageResource;
        mTitle = title;
        mAuthor = author;
        mDate = date;




    }

    @Override
    public String toString() {
        return "Book{" +
                "mImageResource=" + mImageResource +
                ", mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mDate=" + mDate +
                '}';
    }

    public int getImageResource() {

        return mImageResource;
    }

    public String getTitle() {

        return mTitle;
    }

    public String getAuthor() {

        return mAuthor;
    }


    public Date getDate() {

        return mDate;
    }

    public String getDateToString() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat xDate = new SimpleDateFormat(pattern);

        String strDate = mDate.toString();
        strDate = xDate.format(mDate);
        return strDate;
    }

}