package com.example.inquallity.repositorieslist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inquallity on 26-Nov-17.
 */

public class Repository {

    @SerializedName("full_name")
    private String mName;

    public  String getName(){
        return mName;
    }
}
