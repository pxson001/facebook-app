package com.facebook.photos.base.analytics.efficiency;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.internal.FbCacheKeyFactory;
import com.facebook.imagepipeline.internal.FbImageFetchListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: seen */
public class PhotosEvictionLogger implements IHaveUserData, DiskTrimmable, FbImageFetchListener {
    private static volatile PhotosEvictionLogger f2886E;
    @VisibleForTesting
    static final long f2887a = TimeUnit.DAYS.toMillis(5);
    @VisibleForTesting
    static final PrefKey f2888b;
    private static final String f2889c = PhotosEvictionLogger.class.getSimpleName();
    private static final PrefKey f2890d;
    private static final PrefKey f2891e;
    private static final PrefKey f2892f = ((PrefKey) f2891e.a("size_bytes"));
    private static final PrefKey f2893g = ((PrefKey) f2891e.a("logout_detected"));
    private static final PrefKey f2894h = ((PrefKey) f2891e.a("trim_time"));
    private static final PrefKey f2895i = ((PrefKey) f2891e.a("min_trim_time"));
    private static final PrefKey f2896j = ((PrefKey) f2891e.a("o_calling_class"));
    private static final PrefKey f2897k = ((PrefKey) f2891e.a("o_analytics_tag"));
    private static final PrefKey f2898l = ((PrefKey) f2891e.a("o_is_prefetch"));
    private static final PrefKey f2899m = ((PrefKey) f2891e.a("o_cancel_req"));
    private static final PrefKey f2900n = ((PrefKey) f2891e.a("o_user_id"));
    private static final PrefKey f2901o = ((PrefKey) f2891e.a("o_unix_time"));
    private static final PrefKey f2902p = ((PrefKey) f2891e.a("r_count"));
    private static final PrefKey f2903q = ((PrefKey) f2891e.a("r_calling_class"));
    private static final PrefKey f2904r = ((PrefKey) f2891e.a("r_analytics_tag"));
    private static final PrefKey f2905s = ((PrefKey) f2891e.a("r_is_prefetch"));
    private static final PrefKey f2906t = ((PrefKey) f2891e.a("r_cancel_req"));
    private static final PrefKey f2907u = ((PrefKey) f2891e.a("r_user_id"));
    private static final PrefKey f2908v = ((PrefKey) f2891e.a("r_unix_time"));
    private static final PrefKey f2909w = ((PrefKey) f2891e.a("total_bytes"));
    private static final PrefKey f2910x = ((PrefKey) f2891e.a("total_requests"));
    private final ViewerContextManager f2911A;
    private final Clock f2912B;
    private final DefaultCacheKeyFactory f2913C;
    private final Random f2914D;
    private final AnalyticsLogger f2915y;
    private final FbSharedPreferences f2916z;

    public static com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger m3148a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2886E;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger.class;
        monitor-enter(r1);
        r0 = f2886E;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3152b(r0);	 Catch:{ all -> 0x0035 }
        f2886E = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2886E;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger.a(com.facebook.inject.InjectorLike):com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger");
    }

    private static PhotosEvictionLogger m3152b(InjectorLike injectorLike) {
        return new PhotosEvictionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (DefaultCacheKeyFactory) FbCacheKeyFactory.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), DiskCacheManager.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("photos_eviction");
        f2890d = prefKey;
        prefKey = (PrefKey) prefKey.a("tracking_state");
        f2891e = prefKey;
        f2888b = (PrefKey) prefKey.a("cache_key");
    }

    @Inject
    public PhotosEvictionLogger(AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, ViewerContextManager viewerContextManager, Clock clock, DefaultCacheKeyFactory defaultCacheKeyFactory, Random random, DiskCacheManager diskCacheManager) {
        this.f2915y = analyticsLogger;
        this.f2916z = fbSharedPreferences;
        this.f2911A = viewerContextManager;
        this.f2912B = clock;
        this.f2913C = defaultCacheKeyFactory;
        this.f2914D = random;
        diskCacheManager.a(this);
    }

    public final synchronized void m3155a(ImageRequest imageRequest, CallerContext callerContext, int i, boolean z, boolean z2) {
        String cacheKey = this.f2913C.a(imageRequest).toString();
        if (!this.f2916z.a(f2888b)) {
            m3151a(cacheKey, callerContext, (long) i, z, z2);
        } else if (this.f2912B.a() - this.f2916z.a(f2901o, 0) > f2887a) {
            m3153c();
            m3151a(cacheKey, callerContext, (long) i, z, z2);
        } else {
            m3149a((long) i);
            if (this.f2916z.a(f2888b, "").equals(cacheKey)) {
                m3150a(callerContext, z, z2);
            }
        }
    }

    public synchronized void clearUserData() {
        if (this.f2916z.a(f2888b) && !this.f2916z.a(f2908v)) {
            this.f2916z.edit().putBoolean(f2893g, true).commit();
        }
    }

    private void m3149a(long j) {
        Preconditions.checkState(this.f2916z.a(f2888b));
        long a = this.f2916z.a(f2910x, 0) + 1;
        this.f2916z.edit().a(f2909w, this.f2916z.a(f2909w, 0) + j).a(f2910x, a).commit();
    }

    public final synchronized void ai_() {
        if (this.f2916z.a(f2888b)) {
            this.f2916z.edit().a(f2895i, this.f2912B.a() - this.f2916z.a(f2901o, 0)).commit();
        }
    }

    public final synchronized void m3156b() {
        if (this.f2916z.a(f2888b)) {
            this.f2916z.edit().a(f2894h, this.f2912B.a() - this.f2916z.a(f2901o, 0)).commit();
        }
    }

    private void m3151a(String str, CallerContext callerContext, long j, boolean z, boolean z2) {
        Preconditions.checkState(!this.f2916z.a(f2888b));
        if (this.f2914D.nextInt() % 30 == 0) {
            this.f2916z.edit().a(f2888b, str).a(f2892f, j).a(f2896j, callerContext.b).a(f2897k, callerContext.c()).putBoolean(f2898l, z).putBoolean(f2899m, z2).a(f2901o, this.f2912B.a()).a(f2900n, m3154d()).commit();
            m3149a(j);
            Preconditions.checkState(this.f2916z.a(f2888b));
            Object[] objArr = new Object[]{str, callerContext.b, callerContext.c(), Integer.valueOf(m3154d()), Long.valueOf(j)};
        }
    }

    private void m3153c() {
        boolean z = false;
        Preconditions.checkState(this.f2916z.a(f2888b));
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photos_eviction_tracking");
        honeyClientEvent.a("bytes", this.f2916z.a(f2892f, -1));
        honeyClientEvent.b("original_calling_class", this.f2916z.a(f2896j, null));
        honeyClientEvent.b("original_analytics_tag", this.f2916z.a(f2897k, null));
        honeyClientEvent.a("original_is_prefetch", this.f2916z.a(f2898l, false));
        honeyClientEvent.a("original_cancel_requested", this.f2916z.a(f2899m, false));
        if (this.f2916z.a(f2908v)) {
            honeyClientEvent.a("refetch_count", this.f2916z.a(f2902p, 0));
            honeyClientEvent.b("refetch_calling_class", this.f2916z.a(f2903q, null));
            honeyClientEvent.b("refetch_analytics_tag", this.f2916z.a(f2904r, null));
            honeyClientEvent.a("refetch_is_prefetch", this.f2916z.a(f2905s, false));
            honeyClientEvent.a("refetch_cancel_requested", this.f2916z.a(f2906t, false));
            honeyClientEvent.a("refetched_after", this.f2916z.a(f2908v, 0) - this.f2916z.a(f2901o, 0));
            honeyClientEvent.a("diferent_user", this.f2916z.a(f2900n, -1) != this.f2916z.a(f2907u, -1));
        }
        honeyClientEvent.a("logout_detected", this.f2916z.a(f2893g, false));
        honeyClientEvent.a("trim_to_nothing_time", this.f2916z.a(f2894h, -1));
        honeyClientEvent.a("trim_to_min_time", this.f2916z.a(f2895i, -1));
        honeyClientEvent.a("total_bytes", this.f2916z.a(f2909w, 0));
        honeyClientEvent.a("total_requests", this.f2916z.a(f2910x, 0));
        this.f2915y.a(honeyClientEvent);
        this.f2916z.edit().b(f2891e).commit();
        if (!this.f2916z.a(f2888b)) {
            z = true;
        }
        Preconditions.checkState(z);
    }

    private void m3150a(CallerContext callerContext, boolean z, boolean z2) {
        Preconditions.checkState(this.f2916z.a(f2888b));
        this.f2916z.edit().a(f2902p, this.f2916z.a(f2902p, 0) + 1).commit();
        if (!this.f2916z.a(f2908v)) {
            this.f2916z.edit().a(f2903q, callerContext.b).a(f2904r, callerContext.c()).putBoolean(f2905s, z).putBoolean(f2906t, z2).a(f2908v, this.f2912B.a()).a(f2907u, m3154d()).commit();
            String str = callerContext.b;
            callerContext.c();
            Integer.valueOf(m3154d());
        }
    }

    private int m3154d() {
        ViewerContext a = this.f2911A.a();
        if (a == null || Strings.isNullOrEmpty(a.mUserId)) {
            return -1;
        }
        return a.mUserId.hashCode();
    }
}
