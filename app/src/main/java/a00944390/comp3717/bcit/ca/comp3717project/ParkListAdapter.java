package a00944390.comp3717.bcit.ca.comp3717project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Benjamin on 2017/2/2.
 */

public class ParkListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Park_List> mParkList;

    public ParkListAdapter(Context mContext, List<Park_List> mParkList) {
        this.mContext = mContext;
        this.mParkList = mParkList;
    }

    //Constructor
    @Override
    public int getCount() {
        return mParkList.size();
    }

    @Override
    public Object getItem(int position) {
        return mParkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.park_list, null);
        TextView parkName = (TextView)v.findViewById(R.id.park_name);
        TextView parkAddress = (TextView)v.findViewById(R.id.park_address);
        TextView parkDescription = (TextView)v.findViewById(R.id.park_description);

        //set text for TextView
        parkName.setText(mParkList.get(position).getName());
        parkAddress.setText(mParkList.get(position).getAddress());
        parkDescription.setText(mParkList.get(position).getDescription());

        //Save product id to tag
        v.setTag(mParkList.get(position).getId());

        return v;
    }
}
