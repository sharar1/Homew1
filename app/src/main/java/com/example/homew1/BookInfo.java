package com.example.homew1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BookInfo extends Fragment {
    private TextView title, description;
    private ArrayList<Book> list = new ArrayList<>();
    private Book book;

    public BookInfo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            book = (Book) bundle.getSerializable("pos");
            list.add(book);
    }
        return inflater.inflate(R.layout.fragment_book_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.titleInfo);
        description = view.findViewById(R.id.descriptionInfo);
        if (book != null) {
            title.setText(book.getTitle());
            description.setText(book.getDescription());
        }
    }
}