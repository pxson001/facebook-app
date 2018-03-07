package com.facebook.privacy.checkup.manager;

import android.support.annotation.Nullable;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.ReviewTypeInputReviewType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.facebook.privacy.checkup.protocol.PrivacyCheckupClient;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: SurfaceFirstCardFromEarlyFetcher */
public class IDBackedPrivacyCheckupManager {
    public static boolean f10862j = false;
    private static final Object f10863n = new Object();
    Clock f10864a;
    public final TasksManager f10865b;
    public final ExecutorService f10866c;
    public final PrivacyCheckupClient f10867d;
    private final PrivacyCheckupRequestDispatcher f10868e;
    public final PrivacyCheckupStepDataPager f10869f;
    private final AbstractFbErrorReporter f10870g;
    public Map<String, PrivacyOptionFieldsWithExplanation> f10871h;
    public String f10872i;
    public Map<String, PrivacyOptionFieldsWithExplanation> f10873k;
    public final List<PrivacyCheckupStepData> f10874l = new ArrayList();
    public final PrivacyOperationsClient f10875m;

    /* compiled from: SurfaceFirstCardFromEarlyFetcher */
    class FetchDataListCallback extends AbstractDisposableFutureCallback<List<PrivacyCheckupStepData>> {
        final /* synthetic */ IDBackedPrivacyCheckupManager f10860a;
        private OnDataFetchedListener f10861b;

        protected final void m11315a(@Nullable Object obj) {
            List list = (List) obj;
            if (list != null) {
                for (int i = 0; i < Math.min(list.size(), this.f10860a.f10874l.size()); i++) {
                    ((PrivacyCheckupStepData) this.f10860a.f10874l.get(i)).m11368a((PrivacyCheckupStepData) list.get(i));
                }
                for (int size = this.f10860a.f10874l.size(); size < list.size(); size++) {
                    this.f10860a.f10874l.add(list.get(size));
                }
                this.f10861b.mo302a();
            }
        }

        FetchDataListCallback(IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager, OnDataFetchedListener onDataFetchedListener) {
            this.f10860a = iDBackedPrivacyCheckupManager;
            this.f10861b = onDataFetchedListener;
        }

        protected final void m11316a(Throwable th) {
            this.f10861b.mo303b();
        }
    }

    /* compiled from: SurfaceFirstCardFromEarlyFetcher */
    public interface OnDataFetchedListener {
        void mo302a();

        void mo303b();
    }

    /* compiled from: SurfaceFirstCardFromEarlyFetcher */
    public enum Task {
        FETCH_GENERIC_PRIVACY_REVIEW_INFO,
        SEND_PRIVACY_EDITS
    }

    private static IDBackedPrivacyCheckupManager m11320b(InjectorLike injectorLike) {
        return new IDBackedPrivacyCheckupManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PrivacyCheckupClient.m5808a(injectorLike), PrivacyOperationsClient.a(injectorLike), PrivacyCheckupRequestDispatcher.m11350a(injectorLike), PrivacyCheckupStepDataPager.m11372a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager m11319a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10863n;	 Catch:{ all -> 0x006c }
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
        r1 = m11320b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10863n;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager) r0;	 Catch:{  }
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
        r0 = f10863n;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager");
    }

    @Inject
    IDBackedPrivacyCheckupManager(Clock clock, TasksManager tasksManager, ExecutorService executorService, PrivacyCheckupClient privacyCheckupClient, PrivacyOperationsClient privacyOperationsClient, PrivacyCheckupRequestDispatcher privacyCheckupRequestDispatcher, PrivacyCheckupStepDataPager privacyCheckupStepDataPager, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10865b = tasksManager;
        this.f10866c = executorService;
        this.f10867d = privacyCheckupClient;
        this.f10875m = privacyOperationsClient;
        this.f10868e = privacyCheckupRequestDispatcher;
        this.f10868e.m11363b();
        this.f10869f = privacyCheckupStepDataPager;
        this.f10870g = abstractFbErrorReporter;
        this.f10871h = new HashMap();
        this.f10864a = clock;
        this.f10873k = new HashMap();
    }

    public final PrivacyCheckupStepData m11321a(int i) {
        PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) this.f10874l.get(i);
        Preconditions.checkNotNull(privacyCheckupStepData);
        return privacyCheckupStepData;
    }

    public final void m11326b(int i) {
        PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) this.f10874l.get(i);
        for (Entry entry : this.f10873k.entrySet()) {
            ((PrivacyCheckupItemRow) privacyCheckupStepData.f10966b.get((String) entry.getKey())).f10961f.b((PrivacyOptionFieldsWithExplanation) entry.getValue());
        }
        m11322a();
    }

    public final void m11322a() {
        this.f10873k.clear();
        this.f10871h.clear();
    }

    public final int m11325b() {
        if (this.f10871h == null || this.f10871h.size() == 0) {
            return 0;
        }
        return this.f10871h.size();
    }

    public final int m11327c() {
        return this.f10874l.size();
    }

    public final String m11329f() {
        return this.f10872i;
    }

    public final void m11323a(OnDataFetchedListener onDataFetchedListener, final String str, @Nullable final String str2) {
        this.f10865b.a(Task.FETCH_GENERIC_PRIVACY_REVIEW_INFO, new Callable<ListenableFuture>(this) {
            final /* synthetic */ IDBackedPrivacyCheckupManager f10856c;

            /* compiled from: SurfaceFirstCardFromEarlyFetcher */
            class C12851 implements Function<GraphQLResult<FetchGenericPrivacyReviewQueryModel>, List<PrivacyCheckupStepData>> {
                final /* synthetic */ C12861 f10853a;

                C12851(C12861 c12861) {
                    this.f10853a = c12861;
                }

                @Nullable
                public Object apply(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null) {
                        return null;
                    }
                    return this.f10853a.f10856c.f10869f.m11380a((FetchGenericPrivacyReviewQueryModel) graphQLResult.e, ReviewTypeInputReviewType.ID_BACKED_PRIVACY_CHECKUP.toString());
                }
            }

            public Object call() {
                return Futures.a(this.f10856c.f10867d.m5810a(10, ReviewTypeInputReviewType.ID_BACKED_PRIVACY_CHECKUP.toString(), str2, 15, str), new C12851(this), this.f10856c.f10866c);
            }
        }, new FetchDataListCallback(this, onDataFetchedListener));
    }

    public final ImmutableList<ObjectPrivacyEdit> m11328c(int i) {
        if (this.f10871h.isEmpty()) {
            return null;
        }
        PrivacyCheckupStepData privacyCheckupStepData = (PrivacyCheckupStepData) this.f10874l.get(i);
        Builder builder = new Builder();
        for (Entry entry : this.f10871h.entrySet()) {
            PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) privacyCheckupStepData.f10966b.get((String) entry.getKey());
            builder.c(new ObjectPrivacyEdit(privacyCheckupItemRow.f10956a, this.f10864a.a(), privacyCheckupItemRow.f10957b, ((PrivacyOptionFieldsWithExplanation) entry.getValue()).c()));
        }
        return builder.b();
    }

    public final boolean m11324a(final String str, final ImmutableList<ObjectPrivacyEdit> immutableList, AbstractDisposableFutureCallback<OperationResult> abstractDisposableFutureCallback) {
        return this.f10865b.a(Task.SEND_PRIVACY_EDITS, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ IDBackedPrivacyCheckupManager f10859c;

            public Object call() {
                return this.f10859c.f10875m.a(str, immutableList, false);
            }
        }, abstractDisposableFutureCallback);
    }

    public final void m11330h() {
        this.f10865b.c(Task.SEND_PRIVACY_EDITS);
    }
}
