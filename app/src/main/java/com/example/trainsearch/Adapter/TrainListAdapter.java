package com.example.trainsearch.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trainsearch.R;
import com.example.trainsearch.bean.Railway;

import java.util.List;

public class TrainListAdapter extends RecyclerView.Adapter<TrainListAdapter.TrainViewHolder> {

    private Context mContext;
    private List<Railway> list;
    public TrainListAdapter(Context context) {
        this.mContext = context;
    }
    @Override
    public TrainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.result_one, parent, false);
        return new TrainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrainViewHolder holder, int position) {

//        String name=mCursor.getString(mCursor.getColumnIndex(WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME));
//
//        int partySize=mCursor.getInt(mCursor.getColumnIndex(WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE));
//
//        holder.nameTextView.setText(name);
//
//        holder.partySizeTextView.setText(String.valueOf(partySize));

        Railway railway=list.get(position);
        String trainNumber=railway.getRNum();
        String startStation=railway.getStart();
        String endStation=railway.getEnd();
        String startTime=railway.getStartTime();
        String endTime=railway.getEndTime();
        String runPeroid=railway.getOHours();
        String priceClassOne=railway.getFPrice();
        String priceClassTwo=railway.getSPrice();
        String priceClassBusiness=railway.getBPrice();



        holder.trainNumberTextview.setText(trainNumber);
        holder.startStationTextview.setText(startStation);
        holder.endStationTextview.setText(endStation);
        holder.startTimeTextview.setText(startTime);
        holder.endTimeTextview.setText(endTime);
        holder.runPeroidTextview.setText(runPeroid);
        holder.priceClassTwoTextview.setText(priceClassTwo);
        holder.priceClassOneTextview.setText(priceClassOne);
        holder.priceClassBusinessTextview.setText(priceClassBusiness);
    }

    @Override
    public int getItemCount() {
        if (null == list) return 0;
        return list.size();
    }

    public void setTrainList(List<Railway> l){
        list=l;
        notifyDataSetChanged();
    }

    class TrainViewHolder extends RecyclerView.ViewHolder {

        //will display start time
        TextView startTimeTextview;
        //will display start station
        TextView startStationTextview;
        //will display train number
        TextView trainNumberTextview;
        //will display run peroid
        TextView runPeroidTextview;
        //will display end time
        TextView endTimeTextview;
        //will display end station
        TextView endStationTextview;
        //will display price of class two
        TextView priceClassTwoTextview;
        //will display price of class one
        TextView priceClassOneTextview;
        //will display price of class business
        TextView priceClassBusinessTextview;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews
         *
         * @param itemView The View that you inflated in
         *                 {@link TrainListAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public TrainViewHolder(View itemView) {
            super(itemView);

            startTimeTextview=itemView.findViewById(R.id.start_time_textview);
            startStationTextview=itemView.findViewById(R.id.start_station_textview);
            trainNumberTextview=itemView.findViewById(R.id.train_number_textview);
            runPeroidTextview=itemView.findViewById(R.id.run_peroid_textview);
            endTimeTextview=itemView.findViewById(R.id.end_time_textview);
            endStationTextview=itemView.findViewById(R.id.end_station_textview);
            priceClassTwoTextview=itemView.findViewById(R.id.price_class_two_textview);
            priceClassOneTextview=itemView.findViewById(R.id.price_class_one_textview);
            priceClassBusinessTextview=itemView.findViewById(R.id.price_class_business_textview);
        }

    }
}
