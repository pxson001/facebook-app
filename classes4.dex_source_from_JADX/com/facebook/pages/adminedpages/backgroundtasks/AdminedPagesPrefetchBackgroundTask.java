package com.facebook.pages.adminedpages.backgroundtasks;

import android.os.Bundle;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.AdminedPagesModule;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.annotation.AdminedPagesTaskTag;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Params;
import com.facebook.pages.adminedpages.protocol.PagesAccessTokenPrefetchMethod;
import com.facebook.pages.adminedpages.service.AdminedPagesOperationConstants;
import com.facebook.pages.adminedpages.service.LoadAdminedPagesParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_isc_frms */
public class AdminedPagesPrefetchBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12408a = AdminedPagesPrefetchBackgroundTask.class;
    private static volatile AdminedPagesPrefetchBackgroundTask f12409l;
    private final DefaultBlueServiceOperationFactory f12410b;
    private final Clock f12411c;
    private final AdminedPagesPrefetchBackgroundTaskConfig f12412d;
    public final AbstractFbErrorReporter f12413e;
    private final FbSharedPreferences f12414f;
    public final AdminedPagesRamCache f12415g;
    private volatile long f12416h = -1;
    private final Params f12417i = new Params(128);
    private final PagesAccessTokenPrefetchMethod.Params f12418j = new PagesAccessTokenPrefetchMethod.Params(128);
    private final Bundle f12419k = new Bundle();

    /* compiled from: fa_isc_frms */
    class C06141 implements FutureCallback<OperationResult> {
        final /* synthetic */ AdminedPagesPrefetchBackgroundTask f12808a;

        C06141(AdminedPagesPrefetchBackgroundTask adminedPagesPrefetchBackgroundTask) {
            this.f12808a = adminedPagesPrefetchBackgroundTask;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            int b = this.f12808a.f12415g.m13136b();
            this.f12808a.f12415g.clearUserData();
            this.f12808a.f12413e.a("page_data_fetch", "Prefetch admined Pages fail, number of entries cleared: " + b, th);
        }
    }

    public static com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTask m13111a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12409l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12409l;	 Catch:{ all -> 0x003a }
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
        r0 = m13112b(r0);	 Catch:{ all -> 0x0035 }
        f12409l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12409l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.pages.adminedpages.backgroundtasks.AdminedPagesPrefetchBackgroundTask");
    }

    private static AdminedPagesPrefetchBackgroundTask m13112b(InjectorLike injectorLike) {
        return new AdminedPagesPrefetchBackgroundTask(DefaultBlueServiceOperationFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), AdminedPagesModule.m13120a(), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AdminedPagesRamCache.m13121a(injectorLike));
    }

    @Inject
    public AdminedPagesPrefetchBackgroundTask(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Clock clock, AdminedPagesPrefetchBackgroundTaskConfig adminedPagesPrefetchBackgroundTaskConfig, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, AdminedPagesRamCache adminedPagesRamCache) {
        super("ADMINED_PAGES_PREFETCH_TASK");
        this.f12410b = defaultBlueServiceOperationFactory;
        this.f12411c = clock;
        this.f12412d = adminedPagesPrefetchBackgroundTaskConfig;
        this.f12419k.putParcelable("adminedPagesPrefetchParams", this.f12417i);
        this.f12419k.putParcelable("pagesAccessTokenPrefetchParams", this.f12418j);
        this.f12413e = abstractFbErrorReporter;
        this.f12414f = fbSharedPreferences;
        this.f12415g = adminedPagesRamCache;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(AdminedPagesTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final boolean mo595i() {
        if (!m13113k()) {
            return false;
        }
        if (this.f12416h == -1 || this.f12414f.a(AdminedPagesOperationConstants.f12806b, 0) == 0) {
            return true;
        }
        if (this.f12416h + this.f12412d.f12421b < this.f12411c.a()) {
            return true;
        }
        return false;
    }

    public final long mo593f() {
        if (m13113k()) {
            return this.f12416h + this.f12412d.f12421b;
        }
        return -1;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        DataFreshnessParam dataFreshnessParam;
        this.f12416h = this.f12411c.a();
        if (this.f12411c.a() - this.f12414f.a(AdminedPagesOperationConstants.f12806b, 0) < 86400000) {
            dataFreshnessParam = DataFreshnessParam.STALE_DATA_OKAY;
        } else {
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        }
        this.f12419k.putParcelable("loadAdminedPagesParam", new LoadAdminedPagesParams(dataFreshnessParam));
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f12410b, "admined_pages_prefetch", this.f12419k, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(AdminedPagesPrefetchBackgroundTask.class), -28485829).a();
        Futures.a(a, new C06141(this), MoreExecutors.a());
        SimpleBackgroundResultFutureCallback simpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(f12408a);
        Futures.a(a, simpleBackgroundResultFutureCallback, MoreExecutors.a());
        return simpleBackgroundResultFutureCallback;
    }

    private boolean m13113k() {
        return this.f12412d.f12420a;
    }
}
