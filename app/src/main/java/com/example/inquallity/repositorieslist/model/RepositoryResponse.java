package com.example.inquallity.repositorieslist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Inquallity on 24-Nov-17.
 */

public class RepositoryResponse {

    @SerializedName("items")
    private List<Repository> mRepositoryList;

    public  List<Repository> getRepositoryList(){
        return mRepositoryList;
    }
}
