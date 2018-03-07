package com.facebook.messaging.video.config;

import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsVideoSendingEnabled;
import com.facebook.messaging.media.upload.config.IsVideoTranscodingEnabled;
import javax.inject.Provider;

@InjectorModule
/* compiled from: character  */
public class MessagesVideoConfigModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsVideoSendingEnabled
    public static Boolean m18341a(Product product, Provider<TriState> provider, Provider<Boolean> provider2) {
        if (product != Product.MESSENGER) {
            return Boolean.valueOf(false);
        }
        TriState triState = (TriState) provider.get();
        if (triState.isSet()) {
            return Boolean.valueOf(triState.asBoolean());
        }
        return (Boolean) provider2.get();
    }

    @ProviderMethod
    @IsVideoTranscodingEnabled
    public static Boolean m18342b(Product product, Provider<TriState> provider, Provider<Boolean> provider2) {
        if (product != Product.MESSENGER) {
            return Boolean.valueOf(false);
        }
        TriState triState = (TriState) provider.get();
        if (triState.isSet()) {
            return Boolean.valueOf(triState.asBoolean());
        }
        return (Boolean) provider2.get();
    }
}
