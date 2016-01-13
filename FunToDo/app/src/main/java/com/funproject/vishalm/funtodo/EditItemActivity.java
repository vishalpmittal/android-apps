package com.funproject.vishalm.funtodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {

    EditText editItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editItemText = (EditText) findViewById(R.id.id_editItem_text);
        editItemText.setText(getIntent().getStringExtra("itemText"));


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    public void saveEditedItem (View view){
        Intent data = new Intent();
        String editedText = editItemText.getText().toString();
        if (editedText.trim().compareTo("")== 0){
            Toast.makeText(this, "Enter a todo item...", Toast.LENGTH_SHORT).show();
        }
        else{
            data.putExtra("editedText", editedText);
            data.putExtra("code", 200);
            setResult(RESULT_OK, data);
            this.finish();
        }
    }
}
