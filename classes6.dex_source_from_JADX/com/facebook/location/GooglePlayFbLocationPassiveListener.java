package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.inject.NeedsApplicationInjector;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: ر.س. */
public class GooglePlayFbLocationPassiveListener implements FbLocationPassiveListener {
    private static final Class<?> f38a = GooglePlayFbLocationPassiveListener.class;
    private final GooglePlayGoogleApiClientFactory f39b;
    private final AbstractFbErrorReporter f40c;
    @GuardedBy("this")
    private long f41d = -1;

    @Inject
    public GooglePlayFbLocationPassiveListener(@NeedsApplicationInjector GooglePlayGoogleApiClientFactory googlePlayGoogleApiClientFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f39b = googlePlayGoogleApiClientFactory;
        this.f40c = abstractFbErrorReporter;
    }
}
