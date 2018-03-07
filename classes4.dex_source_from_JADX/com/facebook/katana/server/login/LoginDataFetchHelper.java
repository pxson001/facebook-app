package com.facebook.katana.server.login;

import com.facebook.auth.component.LoginComponent;
import com.facebook.auth.component.STATICDI_MULTIBIND_PROVIDER$LoginComponent;
import com.facebook.auth.component.persistent.PersistentComponentManager;
import com.facebook.auth.component.persistent.STATICDI_MULTIBIND_PROVIDER$PersistentComponent;
import com.facebook.auth.login.AuthStateMachineMonitor;
import com.facebook.auth.login.AuthStateMachineMonitorMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.http.protocol.BootstrapTierUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: taggable_object_profile_picture */
public class LoginDataFetchHelper {
    public final Set<LoginComponent> f1320a;
    public final ExecutorService f1321b;
    public final AuthStateMachineMonitor f1322c;
    public final PersistentComponentManager f1323d;
    public final BootstrapTierUtil f1324e;
    public final BatchComponentRunner f1325f;
    public final QuickPerformanceLogger f1326g;

    /* compiled from: taggable_object_profile_picture */
    public class C01031 implements Runnable {
        final /* synthetic */ CallerContext f2041a;
        final /* synthetic */ LoginDataFetchHelper f2042b;

        public C01031(LoginDataFetchHelper loginDataFetchHelper, CallerContext callerContext) {
            this.f2042b = loginDataFetchHelper;
            this.f2041a = callerContext;
        }

        public void run() {
            try {
                this.f2042b.f1326g.b(2293770);
                List arrayList = new ArrayList();
                for (LoginComponent a : this.f2042b.f1320a) {
                    BatchComponent a2 = a.mo143a();
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                this.f2042b.f1325f.m1567a("fetchLoginData-batch", this.f2041a, arrayList, this.f2042b.f1324e.a());
                this.f2042b.f1326g.b(2293770, (short) 2);
            } catch (Exception e) {
                this.f2042b.f1326g.b(2293770, (short) 87);
            }
            this.f2042b.f1322c.b();
        }
    }

    public static LoginDataFetchHelper m1560a(InjectorLike injectorLike) {
        return new LoginDataFetchHelper(STATICDI_MULTIBIND_PROVIDER$LoginComponent.m1561a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), AuthStateMachineMonitorMethodAutoProvider.a(injectorLike), new PersistentComponentManager(STATICDI_MULTIBIND_PROVIDER$PersistentComponent.m1528a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2283), IdBasedSingletonScopeProvider.b(injectorLike, 3841), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494)), BootstrapTierUtil.a(injectorLike), BatchComponentRunner.m1565a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LoginDataFetchHelper(Set<LoginComponent> set, ExecutorService executorService, AuthStateMachineMonitor authStateMachineMonitor, PersistentComponentManager persistentComponentManager, BootstrapTierUtil bootstrapTierUtil, BatchComponentRunner batchComponentRunner, QuickPerformanceLogger quickPerformanceLogger) {
        this.f1320a = set;
        this.f1321b = executorService;
        this.f1322c = authStateMachineMonitor;
        this.f1323d = persistentComponentManager;
        this.f1324e = bootstrapTierUtil;
        this.f1325f = batchComponentRunner;
        this.f1326g = quickPerformanceLogger;
    }
}
