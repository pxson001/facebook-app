package com.facebook.reaction.placetips;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.bootstrap.PagePresenceProviderFuture;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.settings.PlaceTipsLocationData;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.constants.ReactionIntentConstants.EntryPoint;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: max_connection_retry_count */
public class PlaceTipsReactionManager {
    private static final Object f14894q = new Object();
    public final Set<Callback> f14895a = Sets.m1313a();
    private final Runnable f14896b = new C06371(this);
    private final Lazy<PagePresenceProviderFuture> f14897c;
    @ForUiThread
    public final Executor f14898d;
    private final Lazy<ReactionSessionHelper> f14899e;
    public final Lazy<ReactionSessionManager> f14900f;
    public final Lazy<ReactionUtil> f14901g;
    private final PlaceTipsAnalyticsLogger f14902h;
    private final PlaceTipsLocalLogger f14903i;
    public final ReactionExperimentController f14904j;
    private final ReactionPerfLogger f14905k;
    private final Lazy<SearchResultsIntentBuilder> f14906l;
    private final Lazy<SecureContextHelper> f14907m;
    @Nullable
    private ListenableFuture<Optional<PresenceDescription>> f14908n = null;
    @Nonnull
    public Optional<PresenceDescription> f14909o = Absent.INSTANCE;
    @Nullable
    public String f14910p = null;

    /* compiled from: max_connection_retry_count */
    class C06371 implements Runnable {
        final /* synthetic */ PlaceTipsReactionManager f14914a;

        C06371(PlaceTipsReactionManager placeTipsReactionManager) {
            this.f14914a = placeTipsReactionManager;
        }

        public void run() {
            if (this.f14914a.f14909o.isPresent()) {
                PlaceTipsReactionManager.m21350i(this.f14914a);
            }
        }
    }

    /* compiled from: max_connection_retry_count */
    public interface Callback {
        void mo2829a();
    }

    /* compiled from: max_connection_retry_count */
    class C06436 implements Runnable {
        final /* synthetic */ PlaceTipsReactionManager f14974a;

        C06436(PlaceTipsReactionManager placeTipsReactionManager) {
            this.f14974a = placeTipsReactionManager;
        }

        public void run() {
            PlaceTipsReactionManager.m21344b(this.f14974a);
        }
    }

    /* compiled from: max_connection_retry_count */
    class C06532 implements Function<PagePresenceProvider, Optional<PresenceDescription>> {
        final /* synthetic */ PlaceTipsReactionManager f15007a;

        C06532(PlaceTipsReactionManager placeTipsReactionManager) {
            this.f15007a = placeTipsReactionManager;
        }

        public Object apply(Object obj) {
            return ((PagePresenceProvider) obj).mo2826a();
        }
    }

    /* compiled from: max_connection_retry_count */
    class C06563 implements FutureCallback<Optional<PresenceDescription>> {
        final /* synthetic */ PlaceTipsReactionManager f15034a;

        C06563(PlaceTipsReactionManager placeTipsReactionManager) {
            this.f15034a = placeTipsReactionManager;
        }

        public void onSuccess(Object obj) {
            PlaceTipsReactionManager.m21345c(this.f15034a, (Optional) obj);
        }

        public void onFailure(Throwable th) {
            throw new Error(th);
        }
    }

    private static PlaceTipsReactionManager m21343b(InjectorLike injectorLike) {
        return new PlaceTipsReactionManager(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3011), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), IdBasedLazy.m1808a(injectorLike, 9835), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9836), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9839), PlaceTipsAnalyticsLogger.m21246a(injectorLike), PlaceTipsLocalLoggerImpl.m4594a(injectorLike), ReactionExperimentController.m21318a(injectorLike), ReactionPerfLogger.m21357a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3375), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.reaction.placetips.PlaceTipsReactionManager m21341a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f14894q;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m21343b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14894q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.reaction.placetips.PlaceTipsReactionManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.reaction.placetips.PlaceTipsReactionManager) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f14894q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.reaction.placetips.PlaceTipsReactionManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.placetips.PlaceTipsReactionManager.a(com.facebook.inject.InjectorLike):com.facebook.reaction.placetips.PlaceTipsReactionManager");
    }

    @Inject
    public PlaceTipsReactionManager(Lazy<PagePresenceProviderFuture> lazy, Executor executor, Lazy<ReactionSessionHelper> lazy2, Lazy<ReactionSessionManager> lazy3, Lazy<ReactionUtil> lazy4, PlaceTipsAnalyticsLogger placeTipsAnalyticsLogger, PlaceTipsLocalLogger placeTipsLocalLogger, ReactionExperimentController reactionExperimentController, ReactionPerfLogger reactionPerfLogger, Lazy<SearchResultsIntentBuilder> lazy5, Lazy<SecureContextHelper> lazy6) {
        this.f14897c = lazy;
        this.f14898d = executor;
        this.f14899e = lazy2;
        this.f14900f = lazy3;
        this.f14901g = lazy4;
        this.f14902h = placeTipsAnalyticsLogger;
        this.f14903i = placeTipsLocalLogger;
        this.f14904j = reactionExperimentController;
        this.f14905k = reactionPerfLogger;
        this.f14906l = lazy5;
        this.f14907m = lazy6;
    }

    public static boolean m21344b(PlaceTipsReactionManager placeTipsReactionManager) {
        if (placeTipsReactionManager.m21346c()) {
            return false;
        }
        placeTipsReactionManager.f14908n = Futures.m2450a((ListenableFuture) placeTipsReactionManager.f14897c.get(), new C06532(placeTipsReactionManager), MoreExecutors.m1813a());
        Futures.m2458a(placeTipsReactionManager.f14908n, new C06563(placeTipsReactionManager), placeTipsReactionManager.f14898d);
        return true;
    }

    private boolean m21346c() {
        return this.f14908n != null;
    }

    public final void m21353a(Callback callback) {
        this.f14895a.add(callback);
        if (!m21346c()) {
            ExecutorDetour.a(this.f14898d, new C06436(this), 1844978817);
        }
    }

    public final void m21355b(Callback callback) {
        this.f14895a.remove(callback);
    }

    private boolean m21347d() {
        return this.f14909o.isPresent();
    }

    public final boolean m21354a(@Nullable ConfidenceLevel confidenceLevel) {
        if (!m21347d()) {
            return false;
        }
        return confidenceLevel == null || ((PresenceDescription) this.f14909o.get()).q().isEqualOrGreaterThan(confidenceLevel);
    }

    @Nullable
    public final PresenceDescription m21351a() {
        return (PresenceDescription) this.f14909o.orNull();
    }

    public final void m21352a(FbFragment fbFragment, EntryPoint entryPoint) {
        if (m21347d()) {
            String str = this.f14910p;
            PresenceDescription presenceDescription = (PresenceDescription) this.f14909o.get();
            long parseLong = Long.parseLong(presenceDescription.i());
            Surface a = m21340a(presenceDescription);
            PresenceSource k = presenceDescription.k();
            if (ReactionSurfaceUtil.k(a)) {
                String a2 = m21342a(str, Long.valueOf(parseLong), a);
                this.f14905k.m21363b(1966082, a2, a);
                this.f14905k.m21360a(1966090, a2, a);
                ((SecureContextHelper) this.f14907m.get()).mo661a(((SearchResultsIntentBuilder) this.f14906l.get()).m26295b(presenceDescription.i(), presenceDescription.h(), a2, SearchResultsSource.y, a, null), 11111, (Fragment) fbFragment);
                return;
            }
            double doubleValue;
            ReactionSession a3;
            Bundle bundle = new Bundle();
            bundle.putString("place_id", presenceDescription.i());
            bundle.putString("place_name", presenceDescription.h());
            bundle.putString("gravity_suggestifier_id", presenceDescription.o());
            bundle.putInt("entry_point", entryPoint.ordinal());
            PlaceTipsLocationData c = new PlaceTipsLocationData().c(k.b() != null ? k.b().intValue() : 0);
            if (k.c() != null) {
                doubleValue = k.c().doubleValue();
            } else {
                doubleValue = 0.0d;
            }
            c = c.b(doubleValue);
            if (k.d() != null) {
                doubleValue = k.d().doubleValue();
            } else {
                doubleValue = 0.0d;
            }
            PlaceTipsLocationData b = c.c(doubleValue).a(0).b((int) (presenceDescription.a() / 1000));
            if (k.e() != null) {
                b.d(k.e().doubleValue()).a(k.e().doubleValue());
            } else {
                b.a(0.0d).d(0.0d);
            }
            bundle.putParcelable("gravity_location_data", b);
            ReactionSession b2 = ((ReactionSessionManager) this.f14900f.get()).b(str);
            if (b2 == null) {
                a3 = ((ReactionSessionManager) this.f14900f.get()).a(str, a);
            } else {
                a3 = b2;
            }
            ((ReactionSessionManager) this.f14900f.get()).c(str);
            a3.b().mo223a(this.f14896b, MoreExecutors.m1813a());
            ((ReactionSessionManager) this.f14900f.get()).a(str, fbFragment, new 7(this, parseLong, str, a), bundle);
        }
    }

    private Surface m21340a(PresenceDescription presenceDescription) {
        if (this.f14904j.m21325i()) {
            switch (8.a[presenceDescription.k().a().ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                case 3:
                    return Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_LOCATION;
                default:
                    return Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS;
            }
        }
        switch (8.a[presenceDescription.k().a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Surface.ANDROID_FEED_CHECKIN_SUGGESTION;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Surface.ANDROID_GRAVITY_SUGGESTION;
            case 3:
                return Surface.ANDROID_GPS_LOCATION_SUGGESTION;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return Surface.ANDROID_RAGE_SHAKE_PLACE_TIPS;
            default:
                return Surface.ANDROID_GPS_LOCATION_SUGGESTION;
        }
    }

    public static void m21345c(PlaceTipsReactionManager placeTipsReactionManager, Optional optional) {
        if (m21348d(placeTipsReactionManager, optional)) {
            for (Callback a : placeTipsReactionManager.f14895a) {
                a.mo2829a();
            }
        }
    }

    public static boolean m21348d(PlaceTipsReactionManager placeTipsReactionManager, Optional optional) {
        if (m21344b(placeTipsReactionManager)) {
            return false;
        }
        if (placeTipsReactionManager.f14910p != null) {
            ((ReactionSessionManager) placeTipsReactionManager.f14900f.get()).a(placeTipsReactionManager.f14910p);
            placeTipsReactionManager.f14910p = null;
        }
        placeTipsReactionManager.f14909o = optional;
        if (optional.isPresent()) {
            placeTipsReactionManager.m21349g();
            placeTipsReactionManager.f14902h.m21256a(PlaceTipsAnalyticsEvent.PAGE_NEARBY_INSERTED, ((PresenceDescription) optional.get()).l());
            placeTipsReactionManager.f14902h.m21257a(PlaceTipsAnalyticsEvent.PAGE_NEARBY_INSERTED_2, ((PresenceDescription) optional.get()).l(), ((PresenceDescription) optional.get()).i(), ((PresenceDescription) optional.get()).d());
        }
        return true;
    }

    private void m21349g() {
        PresenceDescription presenceDescription = (PresenceDescription) this.f14909o.get();
        ReactionStories n = presenceDescription.n();
        if (n == null || n.a().isEmpty()) {
            String p = ((PresenceDescription) this.f14909o.get()).p();
            if (Strings.isNullOrEmpty(p)) {
                m21350i(this);
                return;
            } else {
                this.f14910p = p;
                return;
            }
        }
        String str = (String) Preconditions.checkNotNull(n.d());
        Surface a = m21340a(presenceDescription);
        this.f14910p = str;
        this.f14903i.mo654a("Initialize reaction with %d cached stories", Integer.valueOf(n.a().size()));
        ReactionSessionManager reactionSessionManager = (ReactionSessionManager) this.f14900f.get();
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.l = Long.valueOf(Long.parseLong(presenceDescription.i()));
        ReactionSession a2 = reactionSessionManager.a(reactionQueryParams, n, a);
        a2.a(presenceDescription.m());
        ((ReactionUtil) this.f14901g.get()).a(a2);
    }

    public static void m21350i(PlaceTipsReactionManager placeTipsReactionManager) {
        placeTipsReactionManager.f14910p = SafeUUIDGenerator.m2795a().toString();
        placeTipsReactionManager.f14903i.mo653a("Initialize empty reaction");
    }

    private String m21342a(@Nullable String str, Long l, Surface surface) {
        if (((ReactionSessionManager) this.f14900f.get()).b(str) != null) {
            ((ReactionSessionManager) this.f14900f.get()).a(str);
        }
        String uuid = SafeUUIDGenerator.m2795a().toString();
        if (this.f14904j.m21326j()) {
            ReactionSessionHelper reactionSessionHelper = (ReactionSessionHelper) this.f14899e.get();
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.l = l;
            reactionQueryParams = reactionQueryParams;
            reactionQueryParams.t = l;
            reactionSessionHelper.a(uuid, surface, reactionQueryParams);
        }
        return uuid;
    }
}
