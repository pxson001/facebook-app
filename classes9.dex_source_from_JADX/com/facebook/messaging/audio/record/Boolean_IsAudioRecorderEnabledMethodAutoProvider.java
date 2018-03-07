package com.facebook.messaging.audio.record;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: operationParams */
public class Boolean_IsAudioRecorderEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagesAudioRecordModule.m8363a(IdBasedProvider.a(this, 4107), (Context) getInstance(Context.class));
    }
}
