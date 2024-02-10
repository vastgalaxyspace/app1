package com.example.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.myapplication2.data.Bio;
import com.example.myapplication2.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Bio bio=new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Dhiraj chavan");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(this::addhobbies);

    }

    public void addhobbies(View view) {
        bio.setHobbies(String.format("hobbies :%s ",binding.enterHobies.getText().toString().trim()));
//        binding.hobbiesText.setText(String.format("hobbies :%s ",binding.enterHobies.getText().toString().trim()));
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);

        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}