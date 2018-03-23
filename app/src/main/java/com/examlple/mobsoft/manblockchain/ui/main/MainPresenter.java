package com.examlple.mobsoft.manblockchain.ui.main;

import com.examlple.mobsoft.manblockchain.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showArtistsSearchList(
            String artistSearchTerm) {
        screen.showArtists(artistSearchTerm);
    }
}
