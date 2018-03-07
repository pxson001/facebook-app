package com.facebook.messaging.connectivity;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;

/* compiled from: is_page_verified */
public class Boolean_IsConnStatusBannerEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagesConnectivityModule.a((FbAppType) getInstance(FbAppType.class));
    }
}
