package hu.bme.aut.mobsoft.manblockchain.ui.about;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.AboutInfo;

/**
 * Created by Antal János Benjamin on 2018. 03. 25..
 */

public class AboutFragment extends Fragment implements AboutScreen {

    @Inject
    AboutPresenter aboutPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        return view;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        ManBlockchainApplication.injector.inject(this);
        aboutPresenter.attachScreen(this);
    }


    @Override
    public void showAbout(AboutInfo aboutInfo) {
        // TODO
    }
}
