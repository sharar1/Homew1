package com.example.homew1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private BookClickListener bookClickListener;

    private ArrayList<Book> list;
    public BookAdapter(ArrayList<Book> list) {
        this.list = list;
    }

    public void setBookClickListener(BookClickListener bookClickListener) {
        this.bookClickListener = bookClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_holder,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookClickListener.onItemClick(getAdapterPosition());
                }
            });
            textTitle = itemView.findViewById(R.id.textTitle);
        }
        public void bind(Book book) {
            textTitle.setText(book.getTitle());
        }
    }
}
