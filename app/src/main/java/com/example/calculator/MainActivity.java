package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculator.databinding.ActivityMainBinding;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String data;
    TextView input , output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        binding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"0");
            }
        });
        binding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"1");
            }
        });
        binding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"2");
            }
        });
        binding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"3");
            }
        });
        binding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"4");
            }
        });
        binding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"5");
            }
        });
        binding.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"6");
            }
        });
        binding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"7");
            }
        });
        binding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"8");
            }
        });
        binding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"9");
            }
        });
        binding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+".");
            }
        });

        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"+");
            }
        });
        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"-");
            }
        });
        binding.multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"*");
            }
        });
        binding.divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"÷");
            }
        });
        binding.modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText(data+"%");
            }
        });
        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                input.setText("");
                output.setText("");
            }
        });
        binding.equalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                data = data.replaceAll("x","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("÷","/");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult="";
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();
                output.setText(finalResult);

            }
        });
        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = input.getText().toString();
                if(data.length() > 0){
                    String newData = data.substring(0,data.length()-1);
                    input.setText(newData);
                }
            }
        });
    }
}