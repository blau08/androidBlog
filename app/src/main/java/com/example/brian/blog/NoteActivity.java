package com.example.brian.blog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by Brian on 12/6/2015.
 */
public class NoteActivity extends Activity {

    ArrayList<String> mItems = new ArrayList<>();;
    ArrayAdapter<String> mArrayAdapter;
    EditText mNewItemText;
    ListView mItemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mItems);
        mItemsListView = (ListView)findViewById(R.id.itemsListView);
        mItemsListView.setAdapter(mArrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void addItem(View view) {

        LayoutInflater li = LayoutInflater.from(this);
        LinearLayout newNoteBaseLayout = (LinearLayout)li.inflate(R.layout.new_item_dialog, null);

        mNewItemText = (EditText)newNoteBaseLayout.getChildAt(0);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mItems.add(mNewItemText.getText().toString());
                mArrayAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null)
                .setTitle("New Item");


        builder.setView(newNoteBaseLayout);
        builder.show();
    }

}
