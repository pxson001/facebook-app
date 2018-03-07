package com.facebook.messaging.linkhandling;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.ForSecureIntentHandlerActivity;

@InjectorModule
/* compiled from: onBatchCompleteUI */
public class LinkHandlingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ForSecureIntentHandlerActivity
    static ComponentName m9459a(Context context) {
        return new ComponentName(context, "com.facebook.messenger.intents.SecureIntentHandlerActivity");
    }
}
