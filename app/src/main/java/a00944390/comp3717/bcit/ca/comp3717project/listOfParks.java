package a00944390.comp3717.bcit.ca.comp3717project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class listOfParks extends AppCompatActivity {

    private final int CODE_DISPLAY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_parks);
    }


    public void backHome(final View view){
        final Intent result;

        result = new Intent();
        setResult(Activity.RESULT_CANCELED, result);
        finish();
    }

    public void park2(final View view){
        final Intent intent;

        intent = new Intent(this, ParkInfo.class);
        startActivityForResult(intent, CODE_DISPLAY);

    }
}
