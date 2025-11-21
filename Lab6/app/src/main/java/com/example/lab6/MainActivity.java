package com.example.lab6;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText medname, meddate;
    Button insert, fetch;
    Spinner day;
    Switch switch1;
    TextView medtxt;
    DatabaseConnection dbconnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        medname = findViewById(R.id.medicinename);
        meddate = findViewById(R.id.date);
        insert = findViewById(R.id.insert);
        fetch = findViewById(R.id.fetch);
        day = findViewById(R.id.spinner);
        switch1 = findViewById(R.id.switch1);
        medtxt = findViewById(R.id.medtext);

        // Initialize the database helper
        dbconnection = new DatabaseConnection(this);

        // Set initial visibility
        fetch.setVisibility(View.INVISIBLE);

        // Listener for the switch to toggle between insert and fetch modes
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) { // Fetch mode is on
                    fetch.setVisibility(View.VISIBLE);
                    insert.setVisibility(View.INVISIBLE);
                    medname.setVisibility(View.INVISIBLE);
                    medtxt.setVisibility(View.INVISIBLE);
                } else { // Insert mode is on
                    fetch.setVisibility(View.INVISIBLE);
                    insert.setVisibility(View.VISIBLE);
                    medname.setVisibility(View.VISIBLE);
                    medtxt.setVisibility(View.VISIBLE);
                }
            }
        });

        // Listener for the insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = medname.getText().toString().trim();
                String date = meddate.getText().toString().trim();
                String time = day.getSelectedItem().toString().trim();

                boolean isInserted = dbconnection.insertvalues(name, date, time);

                if (isInserted) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    medname.setText("");
                    meddate.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Listener for the fetch button
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = meddate.getText().toString().trim();
                String time = day.getSelectedItem().toString().trim();

                // Use try-with-resources to automatically close the cursor
                try (Cursor c = dbconnection.FetchData(date, time)) {
                    if (c != null && c.moveToFirst()) {
                        StringBuilder med = new StringBuilder();
                        int medicineNameIndex = c.getColumnIndexOrThrow("MedicineName");
                        do {
                            med.append(c.getString(medicineNameIndex)).append('\n');
                        } while (c.moveToNext());
                        Toast.makeText(getApplicationContext(), med.toString().trim(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "No Entries Found in Database", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Database error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
