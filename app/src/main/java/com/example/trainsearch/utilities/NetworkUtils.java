package com.example.trainsearch.utilities;

import android.net.Uri;
import android.util.Log;

import com.example.trainsearch.bean.Railway;
import com.example.trainsearch.bean.RailwayBean;
import com.example.trainsearch.bean.ResultBean;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class NetworkUtils {
    private static final String STATIC_TRAIN_URL="https://api.jisuapi.com/train/station2s";

    final static String QUERY_APPKEY="appkey";
    final static String QUERY_START="start";
    final static String QUERY_END="end";
    final static String QUERY_ISHIGH="ishigh";
    final static String QUERY_DATE="date";

    final static String APPKEY="653811fb6a7b233d";
    final static String ISHIGH="1";


    public static URL buildUrl(String start,String end,String date){
        Uri builtUri = Uri.parse(STATIC_TRAIN_URL).buildUpon()
                .appendQueryParameter(QUERY_APPKEY, APPKEY)
                .appendQueryParameter(QUERY_START, start)
                .appendQueryParameter(QUERY_END, end)
                .appendQueryParameter(QUERY_ISHIGH,ISHIGH)
                .appendQueryParameter(QUERY_DATE,date)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;

    }
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }
        finally {
            urlConnection.disconnect();
        }
    }
    public static List<Railway> getData(String json){
        List<Railway> railwayList = new ArrayList<>();
        Gson gson = new Gson();
        ResultBean resultBean = gson.fromJson(json,ResultBean.class);

        List<RailwayBean> railwayBeans = new ArrayList<>();
        railwayBeans = resultBean.getResult().getList();
        for(RailwayBean railwayBean:railwayBeans){
            Railway railway = new Railway();
            railway.setRNum(railwayBean.getTrainno());
            railway.setType(railwayBean.getType());
            railway.setStart(railwayBean.getStation());
            railway.setEnd(railwayBean.getendstation());
            railway.setStartTime(railwayBean.getDeparturetime());
            railway.setEndTime(railwayBean.getArrivaltime());
            railway.setOHours(railwayBean.getCosttime());

            String priceyz = railwayBean.getPriceyz();
            String pricerz = railwayBean.getPricerz();
            String priceyw = railwayBean.getPriceyw1();
            String pricerw = railwayBean.getPricerw1();
            String priceyd = railwayBean.getPriceyd();
            String priceed = railwayBean.getPriceed();
            String pricesw = railwayBean.getPricesw();

            if (priceyz!=null&&!priceyz.equals("")){
                railway.setHSPrice(priceyz);
            }
            if(pricerw!=null&&!pricerw.equals("")){
                railway.setSSlPrice(pricerw);
            }
            if (priceyw!=null&&!priceyw.equals("")){
                railway.setHSlPrice(priceyw);
            }
            //because of the change of API
            // that change the parameter of prices of 1st class and 2rd class from priceyd and priceed to pricerz and priceyz
            //this is temp solution
            if (pricerz!=null&&!pricerz.equals("")){
                railway.setFPrice(pricerz);
            }
            if (priceyz!=null&&!priceyz.equals("")){
                railway.setSPrice(priceyz);
            }
//            if (priceyd!=null&&!priceyd.equals("")){
//                railway.setFPrice(priceyd);
//            }
//            if(priceed!=null&&!priceed.equals("")){
//                railway.setSPrice(priceed);
//            }
            if (pricesw!=null&&!pricesw.equals("")){
                railway.setBPrice(pricesw);
            }
            railwayList.add(railway);

        }
        return railwayList;


    }





}
