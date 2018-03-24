package hu.bme.aut.mobsoft.manblockchain.manblockchain.ui;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
