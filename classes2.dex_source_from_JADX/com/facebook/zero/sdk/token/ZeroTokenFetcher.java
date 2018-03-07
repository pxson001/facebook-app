package com.facebook.zero.sdk.token;

import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroTokenRequestParams;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sort_name */
public class ZeroTokenFetcher {
    private static final Class<?> f4322a = ZeroTokenFetcher.class;
    private final Lazy<Clock> f4323b;
    public final Lazy<ZeroNetworkAndTelephonyHelper> f4324c;
    private final Lazy<ZeroRequestHandler> f4325d;
    private final ZeroSharedPreferences f4326e;
    private final Provider<TriState> f4327f;
    public final Map<ZeroTokenType, ListenableFuture<?>> f4328g = new HashMap();
    private final Set<ZeroTokenFetchListener> f4329h = new HashSet();

    @Inject
    public ZeroTokenFetcher(Lazy<Clock> lazy, Lazy<ZeroNetworkAndTelephonyHelper> lazy2, Lazy<ZeroRequestHandler> lazy3, Provider<TriState> provider, ZeroSharedPreferences zeroSharedPreferences) {
        this.f4323b = lazy;
        this.f4324c = lazy2;
        this.f4325d = lazy3;
        this.f4327f = provider;
        this.f4326e = zeroSharedPreferences;
    }

    public final void m7993a(ZeroTokenFetchListener zeroTokenFetchListener) {
        this.f4329h.add(zeroTokenFetchListener);
    }

    public final void m7997b(ZeroTokenFetchListener zeroTokenFetchListener) {
        this.f4329h.remove(zeroTokenFetchListener);
    }

    public void mo1200a(Throwable th, ZeroTokenType zeroTokenType) {
        this.f4328g.remove(zeroTokenType);
        Iterator it = new HashSet(this.f4329h).iterator();
        while (it.hasNext()) {
            ((ZeroTokenFetchListener) it.next()).mo1183a(th, zeroTokenType);
        }
    }

    protected void mo1199a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
        this.f4328g.remove(zeroTokenType);
        Iterator it = new HashSet(this.f4329h).iterator();
        while (it.hasNext()) {
            ((ZeroTokenFetchListener) it.next()).mo1182a(zeroToken, zeroTokenType);
        }
    }

    public final void m7991a(final ZeroTokenType zeroTokenType, TokenRequestReason tokenRequestReason) {
        if (this.f4327f.get() == TriState.YES && !this.f4328g.containsKey(zeroTokenType)) {
            this.f4326e.mo1195a().mo2849a(zeroTokenType.getLastTimeCheckedKey(), ((Clock) this.f4323b.get()).mo211a()).mo2852a();
            this.f4328g.put(zeroTokenType, ((ZeroRequestHandler) this.f4325d.get()).mo3444a(m7995b(zeroTokenType, tokenRequestReason), new FutureCallback<ZeroToken>(this) {
                final /* synthetic */ ZeroTokenFetcher f23523b;

                public void onSuccess(Object obj) {
                    this.f23523b.mo1199a((ZeroToken) obj, zeroTokenType);
                }

                public void onFailure(Throwable th) {
                    ZeroTokenFetcher zeroTokenFetcher = this.f23523b;
                    ZeroTokenType zeroTokenType = zeroTokenType;
                    String b = ((ZeroNetworkAndTelephonyHelper) zeroTokenFetcher.f4324c.get()).m22189b();
                    if (!(th instanceof CancellationException) && !b.equals("none")) {
                        zeroTokenFetcher.mo1200a(th, zeroTokenType);
                    }
                }
            }));
        }
    }

    public final void m7990a() {
        for (ListenableFuture listenableFuture : this.f4328g.values()) {
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
        }
        this.f4328g.clear();
    }

    public final void m7996b(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
        zeroToken.toString();
        mo1199a(zeroToken, zeroTokenType);
    }

    public final FetchZeroTokenRequestParams m7995b(ZeroTokenType zeroTokenType, TokenRequestReason tokenRequestReason) {
        return new FetchZeroTokenRequestParams(((ZeroNetworkAndTelephonyHelper) this.f4324c.get()).m22188a(), ((ZeroNetworkAndTelephonyHelper) this.f4324c.get()).m22189b(), zeroTokenType, !this.f4326e.mo1197a(zeroTokenType.getBackupRewriteRulesKey()), this.f4326e.mo1196a(zeroTokenType.getTokenHashKey(), ""), tokenRequestReason);
    }
}
