package com.facebook.messaging.shortcuts;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.ForIntentHandlerActivity;
import com.facebook.messaging.annotations.IsMessengerThreadShortcutsEnabled;

@InjectorModule
/* compiled from: qrcode_saved */
public class MessengerShortcutsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsMessengerThreadShortcutsEnabled
    public static Boolean m3760a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @ForIntentHandlerActivity
    static ComponentName m3759a(Context context) {
        return new ComponentName(context, "com.facebook.messenger.intents.IntentHandlerActivity");
    }
}
