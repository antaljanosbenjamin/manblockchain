package com.examlple.mobsoft.manblockchain.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import com.examlple.mobsoft.manblockchain.R;
import com.examlple.mobsoft.manblockchain.ManBlockchainApp;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String KEY_ARTIST = "KEY_ARTIST";

    private EditText etArtist;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ManBlockchainApp.injector.inject(this);

//        etArtist = (EditText) findViewById(R.id.etArtist);
//
//        Button btnShowSongs = (Button) findViewById(R.id.btnShowArtists);
//        btnShowSongs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mainPresenter.showArtistsSearchList(etArtist.getText().toString());
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showArtists(String artistSearchTerm) {

    }
}
