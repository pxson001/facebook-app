package com.facebook.privacy.checkup.manager;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.facebook.privacy.checkup.protocol.PrivacyCheckupClient;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: Successful ad request with 0 fill */
public class PrivacyCheckupSingleStepManager {
    private static final Object f10939f = new Object();
    public final TasksManager f10940a;
    public final ExecutorService f10941b;
    public final PrivacyOperationsClient f10942c;
    public final PrivacyCheckupClient f10943d;
    public final PrivacyCheckupStepDataPager f10944e;

    /* compiled from: Successful ad request with 0 fill */
    public class C12991 implements Callable<ListenableFuture> {
        final /* synthetic */ String f10932a;
        final /* synthetic */ String f10933b;
        final /* synthetic */ int f10934c;
        final /* synthetic */ PrivacyCheckupSingleStepManager f10935d;

        /* compiled from: Successful ad request with 0 fill */
        class C12981 implements Function<GraphQLResult<FetchGenericPrivacyReviewQueryModel>, PrivacyCheckupStepData> {
            final /* synthetic */ C12991 f10931a;

            C12981(C12991 c12991) {
                this.f10931a = c12991;
            }

            @Nullable
            public Object apply(@Nullable Object obj) {
                return this.f10931a.f10935d.f10944e.m11379a((GraphQLResult) obj, this.f10931a.f10932a);
            }
        }

        public C12991(PrivacyCheckupSingleStepManager privacyCheckupSingleStepManager, String str, String str2, int i) {
            this.f10935d = privacyCheckupSingleStepManager;
            this.f10932a = str;
            this.f10933b = str2;
            this.f10934c = i;
        }

        public Object call() {
            return Futures.a(this.f10935d.f10943d.m5810a(1, this.f10932a, this.f10933b, this.f10934c, null), new C12981(this), this.f10935d.f10941b);
        }
    }

    /* compiled from: Successful ad request with 0 fill */
    public class C13002 implements Callable<ListenableFuture<OperationResult>> {
        final /* synthetic */ String f10936a;
        final /* synthetic */ ImmutableList f10937b;
        final /* synthetic */ PrivacyCheckupSingleStepManager f10938c;

        public C13002(PrivacyCheckupSingleStepManager privacyCheckupSingleStepManager, String str, ImmutableList immutableList) {
            this.f10938c = privacyCheckupSingleStepManager;
            this.f10936a = str;
            this.f10937b = immutableList;
        }

        public Object call() {
            return this.f10938c.f10942c.a(this.f10936a, this.f10937b, false);
        }
    }

    /* compiled from: Successful ad request with 0 fill */
    public enum Task {
        FETCH_REVIEW_DATA,
        SEND_PRIVACY_EDITS
    }

    private static PrivacyCheckupSingleStepManager m11365b(InjectorLike injectorLike) {
        return new PrivacyCheckupSingleStepManager(TasksManager.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PrivacyOperationsClient.a(injectorLike), PrivacyCheckupClient.m5808a(injectorLike), PrivacyCheckupStepDataPager.m11372a(injectorLike));
    }

    @Inject
    PrivacyCheckupSingleStepManager(TasksManager tasksManager, ExecutorService executorService, PrivacyOperationsClient privacyOperationsClient, PrivacyCheckupClient privacyCheckupClient, PrivacyCheckupStepDataPager privacyCheckupStepDataPager) {
        this.f10940a = tasksManager;
        this.f10941b = executorService;
        this.f10942c = privacyOperationsClient;
        this.f10943d = privacyCheckupClient;
        this.f10944e = privacyCheckupStepDataPager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager m11364a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10939f;	 Catch:{ all -> 0x006c }
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
        r1 = m11365b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10939f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager) r0;	 Catch:{  }
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
        r0 = f10939f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.manager.PrivacyCheckupSingleStepManager");
    }

    public final void m11366b() {
        this.f10940a.c(Task.SEND_PRIVACY_EDITS);
    }
}
