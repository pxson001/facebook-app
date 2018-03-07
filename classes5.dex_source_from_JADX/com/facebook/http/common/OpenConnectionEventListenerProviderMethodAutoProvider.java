package com.facebook.http.common;

import com.facebook.http.enginehooks.OpenConnectionEventListenerProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: downgrade */
public class OpenConnectionEventListenerProviderMethodAutoProvider extends AbstractProvider<OpenConnectionEventListenerProvider> {
    public Object get() {
        return FbHttpModule.a();
    }
}
