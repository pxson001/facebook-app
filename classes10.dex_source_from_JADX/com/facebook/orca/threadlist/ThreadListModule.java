package com.facebook.orca.threadlist;

import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsStartNewConversationEnabled;

@InjectorModule
/* compiled from: name_thread */
public class ThreadListModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsStartNewConversationEnabled
    static Boolean m6422a(FbAppType fbAppType) {
        return Boolean.valueOf(fbAppType.j != Product.PAA);
    }
}
