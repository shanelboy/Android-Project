package a00944390.comp3717.bcit.ca.comp3717project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class listOfParks extends AppCompatActivity{
    private ListView lvPark;
    private ParkListAdapter adapter;
    //private List<Park> mParkList;
    private final int CODE_DISPLAY = 0;
    DatabaseHandler db = new DatabaseHandler(this);
    
    //// TODO: 2017/2/17 Need to make sure data only add once to database. 
    /*public boolean checkDBIsNull(String table) {
        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM " + table + "", null);
        if (cur != null) {
            cur.moveToFirst();
            System.out.println("record : " + cur.getInt(0));
            if (cur.getInt(0) == 0) {
                System.out.println("Table is Null");
                cur.close();
                return true;
            }
            cur.close();
        } else {
            System.out.println("Cursor is Null");
            return true;
        }
        System.out.println("Table Not Null");
        return false;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_parks);

        lvPark = (ListView)findViewById(R.id.listview_park);


        db.addPark(new Park("Queens Park","51, THIRD AVE", "City Park"));
        db.addPark(new Park("Westminster Pier Park","1, SIXTH ST", "City Park"));
        db.addPark(new Park("Sapperton Landing Park","60, E COLUMBIA ST", "Regional Park"));
        db.addPark(new Park("Old School House Park","51, THIRD AVE", "Neighbourhood Park"));

        List<Park> parks = db.getAllParks();
        //Add sample data for list
        //We can get data from DB here

       /* mParkList.add(new Park(1, "Queens Park","51, THIRD AVE", "City Park" ));
        mParkList.add(new Park(2, "Westminster Pier Park","1, SIXTH ST", "City Park" ));
        mParkList.add(new Park(3, "Sapperton Landing Park","60, E COLUMBIA ST", "Regional Park" ));
        mParkList.add(new Park(4, "Old School House Park","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(5, "Port Royal Riverfront Walk (Dyke Trail)","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(6, "Thompson's Landing Park","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(7, "Sukh Sagar Park","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(8, "Connaught Heights Park","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(9, "Lookout Park","51, THIRD AVE", "Neighbourhood Park" ));
        mParkList.add(new Park(10, "Toronto Place Park","51, THIRD AVE", "Neighbourhood Park" ));*/



        //Init adapter
        adapter = new ParkListAdapter(getApplicationContext(), parks);
        //adapter = new ParkListAdapter(getApplicationContext(), (List<Park>) db);
        lvPark.setAdapter(adapter);

        lvPark.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Use this to open ParkInfo page
                //Test: display msg with park id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked Park id = " + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
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
