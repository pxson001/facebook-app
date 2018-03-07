package com.facebook.privacy.checkup.manager;

import android.support.annotation.Nullable;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckup.FetchPrivacyCheckupAppsStepQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckup.FetchPrivacyCheckupComposerStepQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckup.FetchPrivacyCheckupProfileStepQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupAppsStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupComposerStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupProfileStepQueryModel;
import com.facebook.privacy.checkup.protocol.PrivacyCheckupClient;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.Event;
import com.facebook.privacy.checkup.ui.PrivacyCheckupActivity.PrivacyCheckupState;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepFragment.StepDataFetchedListener;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.protocol.ReportPrivacyCheckupActionsParams.PrivacyCheckupEvent;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
public class PrivacyCheckupManager {
    private static final Object f10893m = new Object();
    public final Clock f10894a;
    public final TasksManager f10895b;
    public final ExecutorService f10896c;
    public final PrivacyCheckupClient f10897d;
    public final PrivacyCheckupRequestDispatcher f10898e;
    public final PrivacyCheckupStepDataPager f10899f;
    public final PrivacyOperationsClient f10900g;
    public final AbstractFbErrorReporter f10901h;
    private final HashMap<PrivacyCheckupStepType, PrivacyCheckupStepData> f10902i = new HashMap();
    public boolean f10903j;
    public SelectablePrivacyData f10904k;
    public long f10905l;

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    public class C12902 implements Callable<ListenableFuture> {
        final /* synthetic */ PrivacyCheckupManager f10879a;

        /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
        class C12891 implements Function<GraphQLResult<FetchPrivacyCheckupComposerStepQueryModel>, PrivacyCheckupStepData> {
            final /* synthetic */ C12902 f10878a;

            C12891(C12902 c12902) {
                this.f10878a = c12902;
            }

            public Object apply(@Nullable Object obj) {
                return this.f10878a.f10879a.f10899f.m11378a((GraphQLResult) obj);
            }
        }

        public C12902(PrivacyCheckupManager privacyCheckupManager) {
            this.f10879a = privacyCheckupManager;
        }

        public Object call() {
            PrivacyCheckupClient privacyCheckupClient = this.f10879a.f10897d;
            return Futures.a(privacyCheckupClient.f4548a.a(GraphQLRequest.a(new FetchPrivacyCheckupComposerStepQueryString())), new C12891(this), this.f10879a.f10896c);
        }
    }

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    public class C12923 implements Callable<ListenableFuture> {
        final /* synthetic */ PrivacyCheckupStepData f10881a;
        final /* synthetic */ PrivacyCheckupManager f10882b;

        /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
        class C12911 implements Function<GraphQLResult<FetchPrivacyCheckupAppsStepQueryModel>, PrivacyCheckupStepData> {
            final /* synthetic */ C12923 f10880a;

            C12911(C12923 c12923) {
                this.f10880a = c12923;
            }

            public Object apply(@Nullable Object obj) {
                return this.f10880a.f10882b.f10899f.m11381b((GraphQLResult) obj);
            }
        }

        public C12923(PrivacyCheckupManager privacyCheckupManager, PrivacyCheckupStepData privacyCheckupStepData) {
            this.f10882b = privacyCheckupManager;
            this.f10881a = privacyCheckupStepData;
        }

        public Object call() {
            PrivacyCheckupClient privacyCheckupClient = this.f10882b.f10897d;
            String str = this.f10881a.f10974j;
            GraphQLRequest a = GraphQLRequest.a(new FetchPrivacyCheckupAppsStepQueryString());
            a.a(new FetchPrivacyCheckupAppsStepQueryString().a("first", String.valueOf(15)).a("after", str).a);
            return Futures.a(privacyCheckupClient.f4548a.a(a), new C12911(this), this.f10882b.f10896c);
        }
    }

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    public class C12944 implements Callable<ListenableFuture> {
        final /* synthetic */ PrivacyCheckupStepData f10884a;
        final /* synthetic */ PrivacyCheckupManager f10885b;

        /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
        class C12931 implements Function<GraphQLResult<FetchPrivacyCheckupProfileStepQueryModel>, PrivacyCheckupStepData> {
            final /* synthetic */ C12944 f10883a;

            C12931(C12944 c12944) {
                this.f10883a = c12944;
            }

            public Object apply(@Nullable Object obj) {
                return this.f10883a.f10885b.f10899f.m11382c((GraphQLResult) obj);
            }
        }

        public C12944(PrivacyCheckupManager privacyCheckupManager, PrivacyCheckupStepData privacyCheckupStepData) {
            this.f10885b = privacyCheckupManager;
            this.f10884a = privacyCheckupStepData;
        }

        public Object call() {
            PrivacyCheckupClient privacyCheckupClient = this.f10885b.f10897d;
            String str = this.f10884a.f10974j;
            GraphQLRequest a = GraphQLRequest.a(new FetchPrivacyCheckupProfileStepQueryString());
            a.a(new FetchPrivacyCheckupProfileStepQueryString().a("first", String.valueOf(15)).a("after", str).a);
            return Futures.a(privacyCheckupClient.f4548a.a(a), new C12931(this), this.f10885b.f10896c);
        }
    }

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    class FetchComposerOptionsCallback extends AbstractDisposableFutureCallback<PrivacyOptionsResult> {
        final /* synthetic */ PrivacyCheckupManager f10888a;
        private StepDataFetchedListener f10889b;
        private boolean f10890c;

        protected final void m11331a(Object obj) {
            PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
            if (privacyOptionsResult == null) {
                this.f10888a.f10901h.a("privacy_checkup_manager_null_composer_options", "Composer options are null! Did the parse fail?");
            } else {
                PrivacyCheckupManager privacyCheckupManager = this.f10888a;
                Builder builder = new Builder();
                builder.a = privacyOptionsResult;
                privacyCheckupManager.f10904k = builder.a(privacyOptionsResult.selectedPrivacyOption).b();
            }
            this.f10889b.m11582a();
        }

        FetchComposerOptionsCallback(PrivacyCheckupManager privacyCheckupManager, StepDataFetchedListener stepDataFetchedListener, boolean z) {
            this.f10888a = privacyCheckupManager;
            this.f10889b = stepDataFetchedListener;
            this.f10890c = z;
        }

        protected final void m11332a(Throwable th) {
            if (this.f10890c) {
                this.f10888a.f10901h.a("privacy_checkup_manager_composer_options_server_fetch_failed", "Failed to get composer options from server", th);
                this.f10888a.m11342a(this.f10889b, false);
                return;
            }
            this.f10888a.f10901h.a("privacy_checkup_manager_composer_options_fetch_failed", "Failed to get composer options from server or cache: ", th);
        }
    }

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    public class FetchDataCallback extends AbstractDisposableFutureCallback<PrivacyCheckupStepData> {
        final /* synthetic */ PrivacyCheckupManager f10891a;
        private StepDataFetchedListener f10892b;

        protected final void m11333a(Object obj) {
            PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) obj;
            PrivacyCheckupManager privacyCheckupManager = this.f10891a;
            if (privacyCheckupStepData != null) {
                privacyCheckupManager.m11344b(privacyCheckupStepData.f10967c).m11368a(privacyCheckupStepData);
            }
            this.f10892b.m11582a();
        }

        public FetchDataCallback(PrivacyCheckupManager privacyCheckupManager, StepDataFetchedListener stepDataFetchedListener) {
            this.f10891a = privacyCheckupManager;
            this.f10892b = stepDataFetchedListener;
        }

        protected final void m11334a(Throwable th) {
            this.f10891a.f10901h.b("privacy_checkup_manager_fetch_data_failed", "Data fetch failed", th);
        }
    }

    /* compiled from: SurfaceFirstCardCachedWithEarlyFetcher */
    public enum Task {
        FETCH_COMPOSER_INFO,
        FETCH_COMPOSER_PRIVACY_OPTIONS,
        FETCH_APP_INFO,
        FETCH_PROFILE_INFO
    }

    private static PrivacyCheckupManager m11336b(InjectorLike injectorLike) {
        return new PrivacyCheckupManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PrivacyCheckupClient.m5808a(injectorLike), PrivacyCheckupRequestDispatcher.m11350a(injectorLike), PrivacyCheckupStepDataPager.m11372a(injectorLike), PrivacyOperationsClient.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.privacy.checkup.manager.PrivacyCheckupManager m11335a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10893m;	 Catch:{ all -> 0x006c }
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
        r1 = m11336b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10893m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupManager) r0;	 Catch:{  }
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
        r0 = f10893m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.manager.PrivacyCheckupManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.manager.PrivacyCheckupManager");
    }

    @Inject
    PrivacyCheckupManager(Clock clock, TasksManager tasksManager, ExecutorService executorService, PrivacyCheckupClient privacyCheckupClient, PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher, PrivacyCheckupStepDataPager privacyCheckupStepDataPager, PrivacyOperationsClient privacyOperationsClient, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10894a = clock;
        this.f10895b = tasksManager;
        this.f10896c = executorService;
        this.f10897d = privacyCheckupClient;
        this.f10898e = privacyCheckupRequestDispatcher;
        this.f10899f = privacyCheckupStepDataPager;
        this.f10900g = privacyOperationsClient;
        this.f10901h = abstractFbErrorReporter;
        m11337g();
    }

    public final void m11343a(@Nullable String str) {
        this.f10898e.m11359a(PrivacyCheckupEvent.INTRO_STEP_EXPOSED, str);
    }

    public final void m11341a(PrivacyCheckupState privacyCheckupState) {
        switch (privacyCheckupState) {
            case INTRODUCTION:
                this.f10898e.m11359a(PrivacyCheckupEvent.INTRO_STEP_CLOSED, "navigation");
                break;
            case CONCLUSION:
                this.f10898e.m11359a(PrivacyCheckupEvent.REVIEW_STEP_CLOSED, "navigation");
                break;
            default:
                BLog.c(getClass(), "Exiting privacy checkup in one of the checkup steps");
                break;
        }
        this.f10898e.m11357a();
        m11337g();
    }

    public final void m11339a(PrivacyCheckupStepType privacyCheckupStepType, String str) {
        switch (privacyCheckupStepType) {
            case COMPOSER_STEP:
                this.f10898e.m11359a(PrivacyCheckupEvent.COMPOSER_STEP_EXPOSED, str);
                return;
            case PROFILE_STEP:
                this.f10898e.m11359a(PrivacyCheckupEvent.PROFILE_STEP_EXPOSED, str);
                return;
            case APPS_STEP:
                this.f10898e.m11359a(PrivacyCheckupEvent.APP_STEP_EXPOSED, str);
                return;
            default:
                return;
        }
    }

    public final void m11338a(PrivacyCheckupStepType privacyCheckupStepType) {
        m11339a(privacyCheckupStepType, "navigation");
    }

    public final void m11345b() {
        this.f10898e.m11362a(false);
    }

    public final PrivacyCheckupStepData m11344b(PrivacyCheckupStepType privacyCheckupStepType) {
        PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) this.f10902i.get(privacyCheckupStepType);
        Preconditions.checkNotNull(privacyCheckupStepData);
        return privacyCheckupStepData;
    }

    private void m11337g() {
        this.f10902i.clear();
        for (PrivacyCheckupStepType privacyCheckupStepType : PrivacyCheckupStepType.values()) {
            this.f10902i.put(privacyCheckupStepType, new PrivacyCheckupStepData(privacyCheckupStepType));
        }
        this.f10903j = false;
        this.f10898e.m11363b();
        this.f10905l = Long.valueOf(this.f10894a.a() / 1000).longValue();
        this.f10898e.f10928t = this.f10905l;
    }

    public final void m11342a(StepDataFetchedListener stepDataFetchedListener, final boolean z) {
        this.f10895b.a(Task.FETCH_COMPOSER_PRIVACY_OPTIONS, new Callable<ListenableFuture>(this) {
            final /* synthetic */ PrivacyCheckupManager f10877b;

            public Object call() {
                return this.f10877b.f10900g.a(z ? DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA : DataFreshnessParam.STALE_DATA_OKAY);
            }
        }, new FetchComposerOptionsCallback(this, stepDataFetchedListener, z));
    }

    public final void m11340a(Event event) {
        this.f10898e.m11358a(event);
    }
}
