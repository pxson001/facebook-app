package com.facebook.omnistore.module;

import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;

/* compiled from: test_type */
public class C0165xfb54c9d8 extends AbstractProvider<OmnistoreComponentManagerBroadcastReceiverRegistration> {
    public /* bridge */ /* synthetic */ Object get() {
        return new OmnistoreComponentManagerBroadcastReceiverRegistration(IdBasedSingletonScopeProvider.b(this, 2868), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(this));
    }
}
