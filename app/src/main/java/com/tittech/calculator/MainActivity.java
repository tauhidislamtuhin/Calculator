package com.tittech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    ImageView button0,button00,button1,button2,button3,button4,button5,button6,button7,button8,button9,
            buttonc,buttonparcent,buttoncross,buttondivision,buttonento,buttonsub,buttonsum,buttondot,buttonequeal;

    EditText input ,output;
    String num;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 =findViewById(R.id.button0);
        button00 =findViewById(R.id.button00);
        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);
        button3 =findViewById(R.id.button3);
        button4 =findViewById(R.id.button4);
        button5 =findViewById(R.id.button5);
        button6 =findViewById(R.id.button6);
        button7 =findViewById(R.id.button7);
        button8 =findViewById(R.id.button8);
        button9 =findViewById(R.id.button9);
        buttonc =findViewById(R.id.buttonc);
        buttonparcent =findViewById(R.id.buttonparcent);
        buttoncross =findViewById(R.id.buttoncross);
        buttondivision =findViewById(R.id.buttondivision);
        buttonento =findViewById(R.id.buttonento);
        buttonsub =findViewById(R.id.buttonsub);
        buttonsum =findViewById(R.id.buttonsum);
        buttondot = findViewById(R.id.buttondot);
        buttonequeal = findViewById(R.id.buttonequal);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_in);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"0");

            }
        });
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"00");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"7");;
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"9");
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");

            }
        });
        buttonsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"+");


            }
        });
        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"-");
            }
        });
        buttondivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"÷");
            }
        });
        buttonento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"×");
            }
        });
        buttonparcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+"%");
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();
                input.setText(num+".");
            }
        });


        buttonequeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=input.getText().toString();

                num = num.replaceAll("×","*");
                num = num.replaceAll("%","/1000");
                num = num.replaceAll("÷","/");


                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                Scriptable scriptable=rhino.initStandardObjects();

                String result = rhino.evaluateString(scriptable, num, "javasscript", 1, null).toString();

                output.setText(result);
                output.startAnimation(animation);




            }
        });
        buttoncross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=input.getText().toString();
                newText = newText.substring(0,newText.length()-1);
                input.setText(newText);

            }
        });



    }
}