package com.facebook.messaging.send.client;

import android.annotation.SuppressLint;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.SmsMessages;
import com.facebook.messaging.cache.ThreadsCache;

@InjectorModule
/* compiled from: delete_msg_id */
public class MessagingSendClientModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    @FacebookMessages
    static PostSendMessageManager m16658a(PostSendMessageManagerProvider postSendMessageManagerProvider, ThreadsCache threadsCache) {
        return postSendMessageManagerProvider.m16738a(threadsCache);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @SmsMessages
    @UserScoped
    static PostSendMessageManager m16659b(PostSendMessageManagerProvider postSendMessageManagerProvider, ThreadsCache threadsCache) {
        return postSendMessageManagerProvider.m16738a(threadsCache);
    }
}
