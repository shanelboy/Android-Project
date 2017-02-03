package a00944390.comp3717.bcit.ca.comp3717project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ParkInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);
    }

    public void backToSearch(final View view){
        final Intent result;

        result = new Intent();
        setResult(Activity.RESULT_CANCELED, result);
        finish();
    }
}
