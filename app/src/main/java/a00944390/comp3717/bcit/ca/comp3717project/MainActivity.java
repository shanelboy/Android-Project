package a00944390.comp3717.bcit.ca.comp3717project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String KEY_SENT_TEXT = "text";
    private static final int CODE_DISPLAY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void search(final View view){
        final EditText textToSearch;
        final String text;
        final Intent intent;

        textToSearch = (EditText) findViewById(R.id.textToSearch);
        text = textToSearch.getText().toString();
        intent = new Intent(this, search_result.class);
        intent.putExtra(KEY_SENT_TEXT, text);
        startActivityForResult(intent, CODE_DISPLAY);

    }
    public void nearby(final View view){
        final Intent intent;
        intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent, CODE_DISPLAY);
    }
    public void list(final View view){
        final Intent intent;
        intent = new Intent(this, listOfParks.class);
        startActivityForResult(intent, CODE_DISPLAY);
    }
    public void credits(final View view){
        final Intent intent;
        intent = new Intent(this, credits.class);
        startActivityForResult(intent, CODE_DISPLAY);
    }
}
