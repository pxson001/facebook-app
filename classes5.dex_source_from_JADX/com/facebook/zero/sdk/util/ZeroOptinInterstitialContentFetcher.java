package com.facebook.zero.sdk.util;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.android.internal.os.BatteryStatsImpl$Timer */
public class ZeroOptinInterstitialContentFetcher {
    public final Lazy<ZeroNetworkAndTelephonyHelper> f5931a;
    private final Lazy<ZeroRequestHandler> f5932b;
    public final Set<ZeroOptinInterstitialContentFetchListener> f5933c = new HashSet();

    /* compiled from: com.android.internal.os.BatteryStatsImpl$Timer */
    class C05471 implements FutureCallback<FetchZeroInterstitialContentResult> {
        final /* synthetic */ ZeroOptinInterstitialContentFetcher f5930a;

        C05471(ZeroOptinInterstitialContentFetcher zeroOptinInterstitialContentFetcher) {
            this.f5930a = zeroOptinInterstitialContentFetcher;
        }

        public void onSuccess(@Nullable Object obj) {
            FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult = (FetchZeroInterstitialContentResult) obj;
            Iterator it = new HashSet(this.f5930a.f5933c).iterator();
            while (it.hasNext()) {
                ((ZeroOptinInterstitialContentFetchListener) it.next()).m10712a(fetchZeroInterstitialContentResult);
            }
        }

        public void onFailure(Throwable th) {
            Iterator it = new HashSet(this.f5930a.f5933c).iterator();
            while (it.hasNext()) {
                ((ZeroOptinInterstitialContentFetchListener) it.next()).m10713a(th);
            }
        }
    }

    public static ZeroOptinInterstitialContentFetcher m10714b(InjectorLike injectorLike) {
        return new ZeroOptinInterstitialContentFetcher(IdBasedLazy.a(injectorLike, 3799), IdBasedLazy.a(injectorLike, 3804));
    }

    @Inject
    public ZeroOptinInterstitialContentFetcher(Lazy<ZeroNetworkAndTelephonyHelper> lazy, Lazy<ZeroRequestHandler> lazy2) {
        this.f5931a = lazy;
        this.f5932b = lazy2;
    }

    public final void m10715a(ZeroOptinInterstitialContentFetchListener zeroOptinInterstitialContentFetchListener) {
        this.f5933c.add(zeroOptinInterstitialContentFetchListener);
    }

    public final void m10717b(ZeroOptinInterstitialContentFetchListener zeroOptinInterstitialContentFetchListener) {
        this.f5933c.remove(zeroOptinInterstitialContentFetchListener);
    }

    public final void m10716a(String str, String str2, String str3) {
        ((ZeroRequestHandler) this.f5932b.get()).a(new FetchZeroInterstitialContentParams(((ZeroNetworkAndTelephonyHelper) this.f5931a.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f5931a.get()).b(), str, str2, str3), new C05471(this));
    }
}
