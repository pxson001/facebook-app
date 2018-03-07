package com.facebook.offers.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: current_slide */
public class OffersWalletFragmentFactory implements IFragmentFactory {
    public final Fragment m19042a(Intent intent) {
        OffersWalletFragment offersWalletFragment = new OffersWalletFragment();
        offersWalletFragment.g(intent.getExtras());
        return offersWalletFragment;
    }
}
