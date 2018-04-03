package hu.bme.aut.mobsoft.manblockchain.ui.about;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.model.AboutInfo;

/**
 * Created by Antal János Benjamin on 2018. 03. 25..
 */

public class AboutFragment implements AboutScreen {

    @Inject
    AboutPresenter aboutPresenter;

    @Override
    public void showAbout(AboutInfo aboutInfo) {
        // TODO
    }
}
