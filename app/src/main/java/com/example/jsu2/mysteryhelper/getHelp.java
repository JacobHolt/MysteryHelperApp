package com.example.jsu2.mysteryhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.*;
import java.util.Random.*;

public class getHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_help);
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

    Random random = new Random();

    ArrayList<String> textArr = new ArrayList<String>(Arrays.asList("you get knocked out",
            "you go somewhere else","you find a dead man", "you find a dead woman",
            "you meet a buxom blonde","someone has searched the place", "a crooked cop warns you",
            "you are arrested","you find a gun","you find a knife","you find a frayed rope",
            "a bullet whizzes past your ear!","you are almost run over","you are being followed",
            "you smell familiar perfume","the telephone rings","there is a knock at the door",
            "you hear footsteps behind you","you hear a gunshot!","you hear a scream","you are not alone ...",
            "... forget this story, it stinks!"));

    //Creating a copy of my arraylist to be able to make changes to this one
    ArrayList<String> textArr2 = (ArrayList<String>)textArr.clone();

    public void helpButtonClicked(View v) {
        //Find the text box I wanat to change
        TextView t = (TextView) findViewById(R.id.helpBox);
        //Get a random number
        int select = random.nextInt(textArr2.size());
        //Put the random element into a variable
        String arrElement = textArr2.get(select);

        if(textArr2.size() > 1){
            //Sets the textbox to the random array element and then removes it from the copied array
            t.setText(arrElement);
            textArr2.remove(select);

        }
        else if(textArr2.size() == 1) {
            //Notifies the user that they are out of option and the program is reseting
            t.setText(arrElement + "\n This concludes the helpful tips I have for you. Please click " +
                    "get help again to start over with the help!");
            //Copies all entries from the original arraylist to the clone
            textArr2 = (ArrayList<String>)textArr.clone();
        }
        else {//Copies all entries from the original arraylist to the clone
            textArr2 = (ArrayList<String>)textArr.clone();}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_help, menu);
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
}
