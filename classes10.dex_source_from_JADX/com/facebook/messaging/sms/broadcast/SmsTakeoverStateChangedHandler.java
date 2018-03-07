package com.facebook.messaging.sms.broadcast;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.contacts.picker.SuggestionsCache;
import com.facebook.messaging.sms.defaultapp.action.MmsSmsCacheUpdateAction;
import com.facebook.messaging.sms.defaultapp.send.MmsSmsPendingSendQueue;
import javax.inject.Inject;

/* compiled from: qrcode_import_pressed */
public class SmsTakeoverStateChangedHandler {
    public final Context f4086a;
    public final SuggestionsCache f4087b;
    public final MmsSmsCacheUpdateAction f4088c;
    public final BaseFbBroadcastManager f4089d;
    public final MmsSmsPendingSendQueue f4090e;

    @Inject
    public SmsTakeoverStateChangedHandler(Context context, SuggestionsCache suggestionsCache, MmsSmsCacheUpdateAction mmsSmsCacheUpdateAction, BaseFbBroadcastManager baseFbBroadcastManager, MmsSmsPendingSendQueue mmsSmsPendingSendQueue) {
        this.f4086a = context;
        this.f4087b = suggestionsCache;
        this.f4088c = mmsSmsCacheUpdateAction;
        this.f4089d = baseFbBroadcastManager;
        this.f4090e = mmsSmsPendingSendQueue;
    }
}
