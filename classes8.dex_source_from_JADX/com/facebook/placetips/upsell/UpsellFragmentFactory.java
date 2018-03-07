package com.facebook.placetips.upsell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: canViewerAddPollOption */
public class UpsellFragmentFactory implements IFragmentFactory {
    public final Fragment m22463a(Intent intent) {
        PlaceTipsUpsellContainerFragment placeTipsUpsellContainerFragment = new PlaceTipsUpsellContainerFragment();
        placeTipsUpsellContainerFragment.g(new Bundle(intent.getExtras()));
        return placeTipsUpsellContainerFragment;
    }
}
