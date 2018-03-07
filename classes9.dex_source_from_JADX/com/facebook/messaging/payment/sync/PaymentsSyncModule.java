package com.facebook.messaging.payment.sync;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.payment.sync.annotations.PaymentsSyncApiVersion;

@InjectorModule
/* compiled from: fetchMoreThreadsParams */
public class PaymentsSyncModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PaymentsSyncApiVersion
    static Integer m15239a(Boolean bool) {
        if (bool.booleanValue()) {
            return Integer.valueOf(3);
        }
        return Integer.valueOf(1);
    }
}
