package com.motoacademy.lablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    public static final String EXTRA_FNAME = "package com.motoacademy.lablogin.FNAME";
    public static final String EXTRA_LNAME = "package com.motoacademy.lablogin.LNAME";
    public static final String EXTRA_MYEAR= "package com.motoacademy.lablogin.MYEAR";
    EditText mFname;
    EditText mLname;
    EditText mYear;
    Button mButtonSave;
    Button mButtonDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFname  = findViewById(R.id.main_frame);
        mLname  = findViewById(R.id.second_frame);
        mYear  = findViewById(R.id.tree_frame);
        mButtonSave = findViewById(R.id.btn);
        mButtonDisplay = findViewById(R.id.scdbtn);

        mButtonSave.setEnabled(false);
        mLname.setEnabled(false);

        mFname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mLname.setEnabled(!editable.toString().isEmpty());
            }
        });

        mLname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mButtonSave.setEnabled(!editable.toString().isEmpty());
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fName = mFname.getText().toString();
                String lName = mLname.getText().toString();
                String mYear = mYear.getText().toString();

                MyDatabaseHelper myDB = new MyDatabaseHelper(FormularioActivity.this);
                myDB.addPerson(fName.trim(), lName.trim(), mYear);



            }
        });

        mButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(FormularioActivity.this);

                Intent intent = new Intent(FormularioActivity.this, DisplayActivity.class);
                startActivity(intent);

            }
        });

    }
}