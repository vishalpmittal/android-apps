package com.example.vishalm.myfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleDisplayActivity extends AppCompatActivity {

    private EditText etWords;
    private TextView tvLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_display);

        // views are created in the layout
        //find reference to those views
        etWords = (EditText) findViewById(R.id.idEtWords);
        tvLabel = (TextView) findViewById(R.id.idTvLabel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    public void onSubmit(View view){
        // show a "Hello World" Message on screen
//        Toast.makeText(SimpleDisplayActivity.this, "Hello World", Toast.LENGTH_SHORT).show();

        // Get the value from the Text field
        String fieldValue = etWords.getText().toString();

        // Set the value into the Label
        tvLabel.setText(fieldValue);

        // display the value as text alert
        Toast.makeText(SimpleDisplayActivity.this, fieldValue, Toast.LENGTH_SHORT).show();
    }
}
