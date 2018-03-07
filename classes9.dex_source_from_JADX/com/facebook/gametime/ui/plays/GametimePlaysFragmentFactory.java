package com.facebook.gametime.ui.plays;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Start */
public class GametimePlaysFragmentFactory implements IFragmentFactory {
    public final Fragment m27239a(Intent intent) {
        GametimePlaysFragment gametimePlaysFragment = new GametimePlaysFragment();
        gametimePlaysFragment.g(intent.getExtras());
        return gametimePlaysFragment;
    }
}
