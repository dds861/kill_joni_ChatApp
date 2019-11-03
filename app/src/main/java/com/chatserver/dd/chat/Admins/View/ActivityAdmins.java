package com.chatserver.dd.chat.Admins.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chatserver.dd.chat.Admins.Model.ModelAdmins;
import com.chatserver.dd.chat.Admins.Presenter.PresenterAdmins;
import com.chatserver.dd.chat.R;

import java.util.List;

public class ActivityAdmins extends AppCompatActivity implements IViewAdmins {

    private RecyclerView mRecyclerViewMain;
    private PresenterAdmins presenterAllWords;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admins);
        initView();

        presenterAllWords = new PresenterAdmins(this, new ModelAdmins());
        presenterAllWords.requestDataFromServer();

        getUserList();
    }

    private void getUserList() {

    }


    RecyclerItemClickListenerAdmins recyclerItemClickListener = new RecyclerItemClickListenerAdmins() {
        @Override
        public void onItemClick(UsersAdmins usersAllWords) {
            Toast.makeText(ActivityAdmins.this,
                    "Message:  " + usersAllWords.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    };

    private void initView() {

        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recyclerViewMain);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void setDataToRecyclerView(List<UsersAdmins> userList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityAdmins.this);
        mRecyclerViewMain.setLayoutManager(layoutManager);
        AdapterAdmins recyclerViewAdapter = new AdapterAdmins(userList, recyclerItemClickListener);
        mRecyclerViewMain.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
