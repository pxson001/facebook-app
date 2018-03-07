package com.facebook.messaging.send.client;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@UserScoped
/* compiled from: delete_mutation */
public class ExponentialBackoffRetryManager {
    private static final Object f16656e = new Object();
    public final ScheduledExecutorService f16657a;
    public final DefaultAndroidThreadUtil f16658b;
    @GuardedBy("ui_thread")
    public Future f16659c;
    @GuardedBy("ui_thread")
    public long f16660d;

    /* compiled from: delete_mutation */
    public class C19621 implements Runnable {
        final /* synthetic */ Runnable f16654a;
        final /* synthetic */ ExponentialBackoffRetryManager f16655b;

        public C19621(ExponentialBackoffRetryManager exponentialBackoffRetryManager, Runnable runnable) {
            this.f16655b = exponentialBackoffRetryManager;
            this.f16654a = runnable;
        }

        public void run() {
            Long.valueOf(this.f16655b.f16660d);
            this.f16654a.run();
            this.f16655b.f16659c = null;
        }
    }

    private static ExponentialBackoffRetryManager m16656b(InjectorLike injectorLike) {
        return new ExponentialBackoffRetryManager((ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public ExponentialBackoffRetryManager(ScheduledExecutorService scheduledExecutorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f16657a = scheduledExecutorService;
        this.f16658b = defaultAndroidThreadUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.ExponentialBackoffRetryManager m16655a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16656e;	 Catch:{ all -> 0x006c }
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
        r1 = m16656b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16656e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.ExponentialBackoffRetryManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.ExponentialBackoffRetryManager) r0;	 Catch:{  }
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
        r0 = f16656e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.ExponentialBackoffRetryManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.ExponentialBackoffRetryManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.ExponentialBackoffRetryManager");
    }

    public final void m16657b() {
        this.f16658b.a();
        this.f16660d = 0;
        if (this.f16659c != null) {
            this.f16659c.cancel(false);
        }
        this.f16659c = null;
    }
}
