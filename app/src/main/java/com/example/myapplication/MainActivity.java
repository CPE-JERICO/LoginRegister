package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);
        ed3 = findViewById(R.id.compass);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insert();


            }

        });
    }

    public void insert()
    {
        try
        {
            String username = ed1.getText().toString();
            String password = ed2.getText().toString();
            String confirmpass = ed3.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase( "toy", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR,pass VARCHAR,compass VARCHAR)");

            if (!password.equals(confirmpass)){
                Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_LONG).show();
            }
            else{
                String sql = "Insert into user(user,pass,compass)values(?,?,?)";
                SQLiteStatement statement = db.compileStatement(sql);
                statement.bindString(1, username);
                statement.bindString(2, password);
                statement.bindString(3, confirmpass);
                statement.execute();
                Toast.makeText(this, "Record added",Toast.LENGTH_LONG).show();

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed1.requestFocus();
            }
        }
        catch (Exception ex)
        {

        }
    }
}
