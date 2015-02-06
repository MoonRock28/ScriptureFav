package com.example.braden.scripturefav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public static final String EXTRA_MESSAGE = "potatoes";

    /**
     * This sets up the MainActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This adds items to the action bar if it is present
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles the action bar item clicks.
     * @param item
     * @return
     */
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

    /**
     * share - This function takes the user input and puts it into EXTRA_MESSAGE.
     * Then it starts the next activity.
     * @param view
     */
    public void share(View view) {
        Intent intent = new Intent(this, Result.class);
        EditText book = (EditText) findViewById(R.id.editBook);
        EditText chapter = (EditText) findViewById(R.id.editChapter);
        EditText verse = (EditText) findViewById(R.id.editVerse);
        String scripture = book.getText().toString() + " " +
                chapter.getText().toString() + ": " +
                verse.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, scripture);
        startActivity(intent);
    }
}
