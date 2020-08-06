package com.example.homew1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Book> list;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();

        list.add(new Book("Мастер и Маргарита",
                "Один из самых загадочных и удивительных романов XX века. Роман Мастер и Маргарита -" +
                " визитная карточка Михаила Афанасьевича Булгакова. Более десяти лет Булгаков работал" +
                " над книгой, которая стала его романом-судьбой, романом-завещанием."));
        list.add(new Book("Евгений Онегин", "«Евгений Онегин» — роман в стихах Александра" +
                " Сергеевича Пушкина, написанный в 1823—1831 годах, одно из самых значительных произведений" +
                " русской словесности. Пушкин работал над этим романом свыше семи лет."));
        list.add(new Book("Преступление и наказание", "Ф.М.Достоевский - один из тех" +
                " немногих писателей, которые повлияли на умы не только современников, но и потомков." +
                " В своем творчестве он ставит самые главные, самые трудные - непосильные - вопросы."));
        list.add(new Book("Война и мир", "Война и мир - самый знаменитый роман русской литературы." +
                " Действие начинается в России 1805 года, а затем автор описывает войну 1812 года и послевоенное время."));

        adapter = new BookAdapter(list);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setBookClickListener(new BookClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pos", list.get(position));
                BookInfo info = new BookInfo();
                info.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.container, info)
                        .addToBackStack(null).commit();
            }
        });

    }
}