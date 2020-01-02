package com.example.trainsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.trainsearch.Adapter.TrainListAdapter;
import com.example.trainsearch.app.myApplication;
import com.example.trainsearch.bean.Railway;
import com.example.trainsearch.utilities.NetworkUtils;

import java.net.URL;
import java.util.List;

public class ResultListActivity extends AppCompatActivity {
    private TrainListAdapter mAdapter;
    private TextView errorTextview;
    private ProgressBar progressBar;
    private RecyclerView resultListRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        errorTextview=findViewById(R.id.error_textview);
        progressBar=findViewById(R.id.progressBar);




        resultListRecyclerView=this.findViewById(R.id.all_result_list);
        resultListRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Adapter
        mAdapter=new TrainListAdapter(this);
        resultListRecyclerView.setAdapter(mAdapter);

        //intent
        Intent intent=getIntent();
        String startStation=intent.getStringExtra("start");
        String endStation=intent.getStringExtra("end");
        String date=intent.getStringExtra("date");
        loadTrainData(startStation,endStation,date);
    }

    private void showTrainDataView() {
        /* First, make sure the error is invisible */
        errorTextview.setVisibility(View.INVISIBLE);
        // COMPLETED (44) Show mRecyclerView, not mWeatherTextView
        /* Then, make sure the weather data is visible */
        resultListRecyclerView.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage() {
        // COMPLETED (44) Hide mRecyclerView, not mWeatherTextView
        /* First, hide the currently visible data */
        resultListRecyclerView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        errorTextview.setVisibility(View.VISIBLE);
    }


    private void loadTrainData(String startStation,String endStation,String date){
        new FetchTrainTask().execute(startStation,endStation,date);
    }
    public class FetchTrainTask extends AsyncTask<String, Void, List<Railway>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Railway> doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }
            String startStation=params[0];
            String endStation=params[1];
            String date=params[2];

            URL trainRequestUrl = NetworkUtils.buildUrl(startStation,endStation,date);
            try {
                String jsonTrainResponse = NetworkUtils.getResponseFromHttpUrl(trainRequestUrl);
                List<Railway> simpleJsonWeatherData =NetworkUtils.getData(jsonTrainResponse);
                return simpleJsonWeatherData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(List<Railway> trainData) {
            progressBar.setVisibility(View.INVISIBLE);
            if (trainData != null) {
                showTrainDataView();
                mAdapter.setTrainList(trainData);
            } else {
                showErrorMessage();
            }
        }

    }
}
