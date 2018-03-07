package com.facebook.messaging.business.common.activity;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: numChannels is %d */
public interface BusinessActivityFragment {

    /* compiled from: numChannels is %d */
    public interface Factory {
        String mo307a();

        BusinessActivityFragment mo308b();
    }

    /* compiled from: numChannels is %d */
    public interface EventListener {
        void mo313a();

        void mo314b();
    }

    String mo309a(Context context);

    void mo310a(Parcelable parcelable);

    void mo311a(EventListener eventListener);
}
