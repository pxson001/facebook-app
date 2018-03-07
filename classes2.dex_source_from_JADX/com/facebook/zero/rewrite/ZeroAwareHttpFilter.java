package com.facebook.zero.rewrite;

import com.facebook.common.util.TriState;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpRequestFilter;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriter;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.impl.client.RequestWrapper;

/* compiled from: registerAccount */
public class ZeroAwareHttpFilter implements HttpRequestFilter {
    private final Provider<TriState> f7789a;
    private final Provider<Boolean> f7790b;
    private final Lazy<ZeroUrlRewriter> f7791c;

    @Inject
    public ZeroAwareHttpFilter(Provider<TriState> provider, Provider<Boolean> provider2, Lazy<ZeroUrlRewriter> lazy) {
        this.f7789a = provider;
        this.f7790b = provider2;
        this.f7791c = lazy;
    }

    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        if (this.f7789a.get() == TriState.YES || ((Boolean) this.f7790b.get()).booleanValue()) {
            m12327a(requestWrapper);
        }
    }

    @VisibleForTesting
    private void m12327a(RequestWrapper requestWrapper) {
        requestWrapper.setURI(((ZeroUrlRewriter) this.f7791c.get()).m31804a(requestWrapper.getURI()));
    }

    public final int mo1679a() {
        return 0;
    }
}
