package com.example.sqllitedatafatchonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqllitedatafatchonrecyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB=new DatabaseHelper(this);
        binding.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UserDetailActivity.class);
                startActivity(intent);
            }
        });
        binding.btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=binding.ediName.getText().toString();
                String Dept=binding.ediDpt.getText().toString();
                String City=binding.ediCity.getText().toString();
                boolean IsInserted= DB.insertData(Name,Dept,City);
                if(IsInserted==true)
                {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else {


                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}