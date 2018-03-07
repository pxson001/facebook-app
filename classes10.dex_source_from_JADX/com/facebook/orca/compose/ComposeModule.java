package com.facebook.orca.compose;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.media.upload.config.MediaUploadConfiguration;
import com.facebook.orca.compose.annotations.IsMediaTrayEnabled;
import com.facebook.orca.compose.annotations.IsVoiceClipEnabled;
import javax.inject.Provider;

@InjectorModule
/* compiled from: org.torproject.android.intent.extra.SOCKS_PROXY_PORT */
public class ComposeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static MediaUploadConfiguration m5011a(Provider<Boolean> provider) {
        if (((Boolean) provider.get()).booleanValue()) {
            return new MediaUploadConfiguration(true);
        }
        return new MediaUploadConfiguration(false);
    }

    @ProviderMethod
    @IsMediaTrayEnabled
    public static Boolean m5012a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsVoiceClipEnabled
    public static Boolean m5013b() {
        return Boolean.valueOf(true);
    }
}
