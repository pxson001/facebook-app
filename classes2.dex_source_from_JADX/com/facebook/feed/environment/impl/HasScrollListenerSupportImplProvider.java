package com.facebook.feed.environment.impl;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: new_status */
public class HasScrollListenerSupportImplProvider extends AbstractAssistedProvider<HasScrollListenerSupportImpl> {
    public final HasScrollListenerSupportImpl m18353a(Delegate delegate) {
        return new HasScrollListenerSupportImpl(delegate, FbErrorReporterImpl.m2317a((InjectorLike) this));
    }
}
