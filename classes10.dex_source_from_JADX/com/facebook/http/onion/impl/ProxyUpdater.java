package com.facebook.http.onion.impl;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import java.net.Proxy;
import javax.inject.Inject;

/* compiled from: Successful fetch w/o ThreadSummary */
public class ProxyUpdater {
    AbstractFbErrorReporter f23374a;

    @Inject
    public ProxyUpdater(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f23374a = abstractFbErrorReporter;
    }

    public final void m24691a(Proxy proxy) {
        this.f23374a.a(proxy);
    }
}
