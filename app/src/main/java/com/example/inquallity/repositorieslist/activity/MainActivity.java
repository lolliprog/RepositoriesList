package com.example.inquallity.repositorieslist.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inquallity.repositorieslist.AppDelegate;
import com.example.inquallity.repositorieslist.R;
import com.example.inquallity.repositorieslist.RecAdapter;
import com.example.inquallity.repositorieslist.model.Repository;
import com.example.inquallity.repositorieslist.model.RepositoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Inquallity on 17-Nov-17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    @NonNull
    private RecAdapter mRecAdapter = new RecAdapter();
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvRepList);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecAdapter);

        mEditText = (EditText) findViewById(R.id.etEnterName);
        findViewById(R.id.btnShow).setOnClickListener(this);
    }


    public void executeRequest() {
        final String repoInput = mEditText.getText().toString();
        if (TextUtils.isEmpty(repoInput)) {
            Toast.makeText(this, "Please specify repo name", Toast.LENGTH_SHORT).show();
        } else {
            AppDelegate.getmGitApi().getRepository(repoInput).enqueue(new Callback<RepositoryResponse>() {
                @Override
                public void onResponse(Call<RepositoryResponse> call, Response<RepositoryResponse> response) {
                    final RepositoryResponse body = response.body();
                    if (body != null) {
                        final List<Repository> repoList = body.getRepositoryList();
                        mRecAdapter.changeDataSet(repoList);
                    }
                }

                @Override
                public void onFailure(Call<RepositoryResponse> call, Throwable t) {
                    Log.d("MY_TAG", "An error occurred during networking\n" + t.getMessage());
                }
            });
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnShow) {
            executeRequest();
        }
    }
}
