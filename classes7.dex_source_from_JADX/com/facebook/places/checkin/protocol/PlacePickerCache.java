package com.facebook.places.checkin.protocol;

import android.location.Location;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.FutureUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.SearchResults;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.EvictingQueue;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@UserScoped
@NotThreadSafe
/* compiled from: info_type */
public class PlacePickerCache {
    private static final Object f11105c = new Object();
    public final DefaultAndroidThreadUtil f11106a;
    public final EvictingQueue<Entry> f11107b = EvictingQueue.a(20);

    /* compiled from: info_type */
    public class C09761 implements Predicate<Entry> {
        final /* synthetic */ PlacePickerFetchParams f11100a;
        final /* synthetic */ PlacePickerCache f11101b;

        public C09761(PlacePickerCache placePickerCache, PlacePickerFetchParams placePickerFetchParams) {
            this.f11101b = placePickerCache;
            this.f11100a = placePickerFetchParams;
        }

        public boolean apply(Object obj) {
            Entry entry = (Entry) obj;
            PlacePickerFetchParams placePickerFetchParams = this.f11100a;
            PlacePickerFetchParams placePickerFetchParams2 = entry.f11103a;
            boolean z = false;
            if (placePickerFetchParams.f11108a.equals(placePickerFetchParams2.f11108a) && Objects.equal(placePickerFetchParams.f11112e, placePickerFetchParams2.f11112e) && Objects.equal(placePickerFetchParams.f11113f, placePickerFetchParams2.f11113f)) {
                double d;
                Location location = placePickerFetchParams.f11109b;
                Location location2 = placePickerFetchParams2.f11109b;
                if (location == null && location2 == null) {
                    d = 0.0d;
                } else if (location == null || location2 == null) {
                    d = Double.POSITIVE_INFINITY;
                } else {
                    d = (double) location.distanceTo(location2);
                }
                z = d <= 1200.0d;
            }
            return z;
        }
    }

    /* compiled from: info_type */
    public class C09772 implements Predicate<Entry> {
        final /* synthetic */ PlacePickerCache f11102a;

        public C09772(PlacePickerCache placePickerCache) {
            this.f11102a = placePickerCache;
        }

        public boolean apply(Object obj) {
            return FutureUtils.c(((Entry) obj).f11104b);
        }
    }

    /* compiled from: info_type */
    public class Entry {
        public final PlacePickerFetchParams f11103a;
        public final ListenableFuture<SearchResults> f11104b;

        public Entry(PlacePickerFetchParams placePickerFetchParams, ListenableFuture<SearchResults> listenableFuture) {
            this.f11103a = placePickerFetchParams;
            this.f11104b = listenableFuture;
        }
    }

    private static PlacePickerCache m13055b(InjectorLike injectorLike) {
        return new PlacePickerCache(DefaultAndroidThreadUtil.b(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.places.checkin.protocol.PlacePickerCache m13054a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11105c;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m13055b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11105c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.places.checkin.protocol.PlacePickerCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.places.checkin.protocol.PlacePickerCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11105c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.places.checkin.protocol.PlacePickerCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.protocol.PlacePickerCache.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.protocol.PlacePickerCache");
    }

    @Inject
    public PlacePickerCache(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f11106a = defaultAndroidThreadUtil;
    }

    @Nullable
    public final void m13057a(FutureCallback<SearchResults> futureCallback) {
        Entry entry = (Entry) this.f11107b.peek();
        if (entry != null && entry.f11104b != null) {
            Futures.a(entry.f11104b, futureCallback, MoreExecutors.a());
        }
    }

    public final void m13056a(PlacePickerFetchParams placePickerFetchParams, ListenableFuture<SearchResults> listenableFuture) {
        this.f11106a.a();
        this.f11107b.add(new Entry(placePickerFetchParams, listenableFuture));
    }
}
