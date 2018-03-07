package com.facebook.photos.simplepicker.nux;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: setSlideshowData */
class SimplePickerSouvenirInterstitialController$3 implements OnClickListener {
    final /* synthetic */ SimplePickerSouvenirInterstitialController f3228a;

    SimplePickerSouvenirInterstitialController$3(SimplePickerSouvenirInterstitialController simplePickerSouvenirInterstitialController) {
        this.f3228a = simplePickerSouvenirInterstitialController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -654854320);
        this.f3228a.f();
        Logger.a(2, EntryType.UI_INPUT_END, -360728425, a);
    }
}
