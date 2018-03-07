package com.facebook.messaging.video.config;

import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: charset */
public class Boolean_IsVideoTranscodingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagesVideoConfigModule.m18342b(ProductMethodAutoProvider.b(this), IdBasedProvider.a(this, 716), IdBasedProvider.a(this, 4221));
    }
}
