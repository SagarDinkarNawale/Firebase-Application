package com.example.firebasedatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtname;
    Spinner spncoursename;
    Button btnadddata;

    DatabaseReference databasestudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasestudent= FirebaseDatabase.getInstance().getReference("students");


        txtname=(EditText)findViewById(R.id.txtname);
//        txtname.setVisibility(View.INVISIBLE);
        spncoursename=(Spinner)findViewById(R.id.spncoursename);
        btnadddata=(Button)findViewById(R.id.btnadddata);
        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addstudent();
            }
        });
    }
    public void addstudent()
    {
        String name=txtname.getText().toString().trim();
        String course=spncoursename.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name))
        {
        String id=databasestudent.push().getKey();
        student  stud=new student(id,name,course);
        databasestudent.child(id).setValue(stud);
        txtname.setText("");
        spncoursename.setSelection(-1);
        Toast.makeText(this,"Student Added !",Toast.LENGTH_LONG).show();

        }
        else
            {
                Toast.makeText(this,"Enter Name please !",Toast.LENGTH_LONG).show();

            }
    }
}
