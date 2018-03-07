package com.facebook.messaging.send.service;

import com.facebook.common.executors.ThreadPriority;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: redirect_to_platform_app */
public class MessagingSendServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @SendQueue
    public static ThreadPriority m3620a(Product product, Provider<Boolean> provider) {
        if (product == Product.MESSENGER && ((Boolean) provider.get()).booleanValue()) {
            return ThreadPriority.URGENT;
        }
        return ThreadPriority.NORMAL;
    }

    @ProviderMethod
    @PendingSendQueue
    public static ThreadPriority m3621b(Product product, Provider<Boolean> provider) {
        if (product == Product.MESSENGER && ((Boolean) provider.get()).booleanValue()) {
            return ThreadPriority.URGENT;
        }
        return ThreadPriority.NORMAL;
    }
}
