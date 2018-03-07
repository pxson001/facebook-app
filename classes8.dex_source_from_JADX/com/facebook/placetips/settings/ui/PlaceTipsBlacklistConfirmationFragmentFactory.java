package com.facebook.placetips.settings.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: caption_credit_style */
public class PlaceTipsBlacklistConfirmationFragmentFactory implements IFragmentFactory {
    public final Fragment m22350a(Intent intent) {
        PlaceTipsBlacklistConfirmationFragment placeTipsBlacklistConfirmationFragment = new PlaceTipsBlacklistConfirmationFragment();
        placeTipsBlacklistConfirmationFragment.g(intent.getExtras());
        return placeTipsBlacklistConfirmationFragment;
    }
}
