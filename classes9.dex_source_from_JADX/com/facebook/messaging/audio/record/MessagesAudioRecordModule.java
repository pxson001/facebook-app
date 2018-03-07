package com.facebook.messaging.audio.record;

import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: opened */
public class MessagesAudioRecordModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAudioRecorderEnabled
    public static Boolean m8363a(Provider<Boolean> provider, Context context) {
        boolean z = ((Boolean) provider.get()).booleanValue() && context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0 && context.getPackageManager().hasSystemFeature("android.hardware.microphone");
        return Boolean.valueOf(z);
    }
}
