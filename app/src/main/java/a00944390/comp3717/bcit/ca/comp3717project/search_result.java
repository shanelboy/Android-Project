package a00944390.comp3717.bcit.ca.comp3717project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static a00944390.comp3717.bcit.ca.comp3717project.MainActivity.KEY_SENT_TEXT;

public class search_result extends AppCompatActivity {
    private String text;
    private TextView searchAdd;
    private static final int CODE_DISPLAY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        searchAdd = (TextView) findViewById(R.id.address);

        final Intent intent;
        intent = getIntent();
        text = intent.getStringExtra(KEY_SENT_TEXT);

        searchAdd.setText(text);

    }
    public void home(final View view){
        final Intent result;

        result = new Intent();
        setResult(Activity.RESULT_CANCELED, result);
        finish();
    }

    public void park1(final View view){
        final Intent intent;

        intent = new Intent(this, ParkInfo.class);
        startActivityForResult(intent, CODE_DISPLAY);

    }
}
