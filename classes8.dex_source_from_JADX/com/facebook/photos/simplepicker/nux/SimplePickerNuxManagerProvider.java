package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.photos.simplepicker.controller.SimplePickerSlideshowEntrypointController;

/* compiled from: setUserVisibleHint failed FragmentManager is null */
public class SimplePickerNuxManagerProvider extends AbstractAssistedProvider<SimplePickerNuxManager> {
    public final SimplePickerNuxManager m3185a(View view, boolean z, boolean z2, int i, boolean z3, int i2, SimplePickerSlideshowEntrypointController simplePickerSlideshowEntrypointController, String str) {
        return new SimplePickerNuxManager((Context) getInstance(Context.class), InterstitialManager.a(this), view, z, z2, i, z3, i2, simplePickerSlideshowEntrypointController, str);
    }
}
