package a00944390.comp3717.bcit.ca.comp3717project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    public void backToHome(final View view){
        final Intent result;

        result = new Intent();
        setResult(Activity.RESULT_CANCELED, result);
        finish();
    }
}
