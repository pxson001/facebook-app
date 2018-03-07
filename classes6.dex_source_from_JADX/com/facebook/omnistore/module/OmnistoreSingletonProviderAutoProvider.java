package com.facebook.omnistore.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;

/* compiled from: targeted */
public class OmnistoreSingletonProviderAutoProvider extends AbstractProvider<OmnistoreSingletonProvider> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreSingletonProvider(IdBasedProvider.a(this, 2863));
    }
}
