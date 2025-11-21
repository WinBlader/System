package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot;
    Button bplus,bminus,bmul,bdiv,beql,bclear;
    EditText ET_Result;
    Float v1, v2;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // EditText
        ET_Result = findViewById(R.id.ET_Result);

        // digit buttons
        b0 = findViewById(R.id.btn_zero);
        b1 = findViewById(R.id.btn_one);
        b2 = findViewById(R.id.btn_two);
        b3 = findViewById(R.id.btn_three);
        b4 = findViewById(R.id.btn_four);
        b5 = findViewById(R.id.btn_five);
        b6 = findViewById(R.id.btn_six);
        b7 = findViewById(R.id.btn_seven);
        b8 = findViewById(R.id.btn_eight);
        b9 = findViewById(R.id.btn_nine);
        bdot = findViewById(R.id.btn_dot);

        // operator buttons
        bplus = findViewById(R.id.btn_plus);
        bminus = findViewById(R.id.btn_minus);
        bmul = findViewById(R.id.btn_mult);
        bdiv = findViewById(R.id.btn_div);
        beql = findViewById(R.id.btn_eql);
        bclear = findViewById(R.id.btn_clear);

        // ---------------- DIGIT BUTTONS ----------------

        b0.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+"9");
            }
        });

        bdot.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText(ET_Result.getText().toString()+".");
            }
        });

        // ---------------- OPERATOR BUTTONS ----------------

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                v1 = Float.parseFloat(ET_Result.getText().toString());
                add = true;
                ET_Result.setText(null);

            }
        });

        bminus.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                v1 = Float.parseFloat(ET_Result.getText().toString());
                sub = true;
                ET_Result.setText(null);

            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                v1 = Float.parseFloat(ET_Result.getText().toString());
                mul = true;
                ET_Result.setText(null);

            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                v1 = Float.parseFloat(ET_Result.getText().toString());
                div = true;
                ET_Result.setText(null);

            }
        });

        // ---------------- CLEAR BUTTON ----------------

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ET_Result.setText("");
                add = sub = mul = div = false;
            }
        });

        // ---------------- EQUALS BUTTON ----------------

        beql.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                v2 = Float.parseFloat(ET_Result.getText().toString());

                if (add) {
                    ET_Result.setText(v1 + v2 + "");
                    add = false;
                }

                else if (sub) {
                    ET_Result.setText(v1 - v2 + "");
                    sub = false;
                }

                else if (mul) {
                    ET_Result.setText(v1 * v2 + "");
                    mul = false;
                }

                else if (div) {

                    if (v2 == 0) {
                        ET_Result.setText("Error");
                    } else {
                        ET_Result.setText(v1 / v2 + "");
                    }

                    div = false;
                }

            }
        });

    }
}
