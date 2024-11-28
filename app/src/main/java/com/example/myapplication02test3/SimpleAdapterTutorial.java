package com.example.myapplication02test3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterTutorial extends AppCompatActivity {

    private ListView listView;
    private int[] images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_tutorial);

        listView = findViewById(R.id.listView);


        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", images[i]);
            item.put("text", names[i]);
            data.add(item);
        }

        SimpleAdapter simpleAdapter= new SimpleAdapter(
                this,
                data,
                R.layout.list_item, // 列表项布局
                new String[]{"image", "text"}, // 数据源中的键
                new int[]{R.id.image, R.id.text} // 布局文件中的视图ID
        );

        listView.setAdapter(simpleAdapter);

        // 设置列表项点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(SimpleAdapterTutorial.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });




    }
}

