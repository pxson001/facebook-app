package com.facebook.offers.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: customData */
public class OffersDetailPageFragmentFactory implements IFragmentFactory {
    public final Fragment m19024a(Intent intent) {
        OfferDetailPageFragment offerDetailPageFragment = new OfferDetailPageFragment();
        offerDetailPageFragment.g(intent.getExtras());
        return offerDetailPageFragment;
    }
}
