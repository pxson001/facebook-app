package com.facebook.messaging.shortcuts;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: qrcode_share_pressed */
public class ComponentName_ForIntentHandlerActivityMethodAutoProvider extends AbstractProvider<ComponentName> {
    public static ComponentName m3753b(InjectorLike injectorLike) {
        return MessengerShortcutsModule.m3759a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return MessengerShortcutsModule.m3759a((Context) getInstance(Context.class));
    }
}
