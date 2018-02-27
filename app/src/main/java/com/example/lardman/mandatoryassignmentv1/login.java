package com.example.lardman.mandatoryassignmentv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    //TODO: login button skal laves.. den kan kun gå til næste side lige nu.. checker intet
    public void LoginButtonClicked(View view)
    {
        Intent intent = new Intent(this, MainMenu.class);
        //startActivity(intent);
        startActivityForResult(intent, 31415);
    }
}
