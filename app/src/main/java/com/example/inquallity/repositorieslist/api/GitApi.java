package com.example.inquallity.repositorieslist.api;

import com.example.inquallity.repositorieslist.model.RepositoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Inquallity on 20-Nov-17.
 */

public interface GitApi {
    @GET("search/repositories")
    Call<RepositoryResponse> getRepository(@Query("q") String repositoryName);
}
