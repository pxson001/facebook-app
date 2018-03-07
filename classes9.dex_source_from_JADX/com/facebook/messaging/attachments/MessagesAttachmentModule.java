package com.facebook.messaging.attachments;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: p2p_cancel_history */
public class MessagesAttachmentModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPopOutVideoPlayerSupported
    public static Boolean m8029a(Provider<Boolean> provider, Provider<Boolean> provider2) {
        boolean z = ((Boolean) provider.get()).booleanValue() && ((Boolean) provider2.get()).booleanValue();
        return Boolean.valueOf(z);
    }
}
