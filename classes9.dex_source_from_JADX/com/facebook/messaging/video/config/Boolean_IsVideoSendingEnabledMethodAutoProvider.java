package com.facebook.messaging.video.config;

import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: chat */
public class Boolean_IsVideoSendingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagesVideoConfigModule.m18341a(ProductMethodAutoProvider.b(this), IdBasedProvider.a(this, 715), IdBasedProvider.a(this, 4221));
    }
}
