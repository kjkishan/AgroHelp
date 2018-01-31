package com.example.kishanjha.agrohelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chat extends AppCompatActivity {
    EditText subject,message;
    Button submit;
    String subjects,messages;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        subject = (EditText)findViewById(R.id.Sub);
        message = (EditText)findViewById(R.id.Mess);
        submit = (Button) findViewById(R.id.Submit);
        subjects = subject.getText().toString();
        messages = message.getText().toString();

    }
    @Override
    public void onStart(){
        super.onStart();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                subjects = subject.getText().toString();
                DatabaseReference myRef = database.getReference(subjects);
                messages = message.getText().toString();
                myRef.setValue(messages);

            }
        });


    }
}
