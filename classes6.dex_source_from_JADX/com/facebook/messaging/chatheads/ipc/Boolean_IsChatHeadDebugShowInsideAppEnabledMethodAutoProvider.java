package com.facebook.messaging.chatheads.ipc;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: video_mms */
public class Boolean_IsChatHeadDebugShowInsideAppEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ChatHeadsIpcModule.m757a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
