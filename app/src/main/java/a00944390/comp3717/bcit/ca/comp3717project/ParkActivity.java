package a00944390.comp3717.bcit.ca.comp3717project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ParkActivity extends AppCompatActivity {
    public static final String KEY_SENT_TEXT = "text";
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        text = (TextView) findViewById(R.id.parkview) ;
        final Intent intent;
        intent = getIntent();
        String newText;
        newText = intent.getStringExtra(KEY_SENT_TEXT);
        text.setText(newText);
    }
}
