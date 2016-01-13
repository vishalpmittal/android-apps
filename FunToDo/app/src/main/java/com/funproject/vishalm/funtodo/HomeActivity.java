package com.funproject.vishalm.funtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> toDoItems = new ArrayList<String>();
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItems;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateTodoItems();
        lvItems = (ListView) findViewById(R.id.id_home_listView);
        lvItems.setAdapter(aToDoAdapter);

        etEditText = (EditText) findViewById(R.id.id_newItemText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                toDoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void populateTodoItems(){
        readItems();
        aToDoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);
    }

    public void onAddItem(View view) {
        if (etEditText.getText().toString().trim().compareToIgnoreCase("")==0){
            Toast.makeText(this, "No text to add...", Toast.LENGTH_SHORT).show();
        }
        else{
            aToDoAdapter.add(etEditText.getText().toString());
            etEditText.setText("");
            writeItems();
        }
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "funtodo.txt");
        try{
            toDoItems = new ArrayList<String>(FileUtils.readLines(file));
        }catch (IOException e){
            System.out.println("Can not find the app file");
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "funtodo.txt");
        try{
            FileUtils.writeLines(file, toDoItems);
        }catch (IOException e){
            System.out.println("Can not find the app file");
        }
    }
}
