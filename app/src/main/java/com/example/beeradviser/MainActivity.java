package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        TextView brands = findViewById(R.id.brands);                            // создаем эказемляр объекта TextView (текст)
        Spinner sort = findViewById(R.id.sort);                                 // создаем экземпляр объекта Spinner (выпадающий список)

        String selectedBeer = String.valueOf(sort.getSelectedItem());           // получаем выбранное значение и конвертируем его в строку
        List<String> beerRec = BeerExpert.getBrands(selectedBeer);
        StringBuilder outputBeer = new StringBuilder();
        for (String str : beerRec) {
            outputBeer.append(str).append("\n");
        }
        brands.setText(outputBeer);                                              // устанавливаем Текст в объект TextView
    }
}