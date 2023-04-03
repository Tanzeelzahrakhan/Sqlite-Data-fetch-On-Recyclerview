package com.example.sqllitedatafatchonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sqllitedatafatchonrecyclerview.databinding.ActivityUserDetailBinding;

import java.util.ArrayList;

public class UserDetailActivity extends AppCompatActivity {
ActivityUserDetailBinding binding;
DatabaseHelper DB;
ArrayList<String>name,dept,city;
MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        binding=ActivityUserDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB=new DatabaseHelper(this);
        name=new ArrayList<>();
        dept=new ArrayList<>();
        city=new ArrayList<>();
        adapter=new MyAdapter(this ,name,dept,city);
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor=DB.getAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                dept.add(cursor.getString(1));
                city.add(cursor.getString(2));
            }
        }
    }
}