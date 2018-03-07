package com.facebook.messaging.send.client;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: delete_payment_cards */
public class CreateThreadManager {
    public static final Class<?> f16645a = CreateThreadManager.class;
    private static final Object f16646f = new Object();
    private final DefaultAndroidThreadUtil f16647b;
    private final DefaultBlueServiceOperationFactory f16648c;
    private final ExecutorService f16649d;
    public final Cache<Long, FutureAndCallbackHolder<OperationResult>> f16650e = CacheBuilder.newBuilder().a(600, TimeUnit.SECONDS).q();

    /* compiled from: delete_payment_cards */
    class C19612 implements Function<OperationResult, FetchThreadResult> {
        final /* synthetic */ CreateThreadManager f16644a;

        C19612(CreateThreadManager createThreadManager) {
            this.f16644a = createThreadManager;
        }

        public Object apply(Object obj) {
            return (FetchThreadResult) ((OperationResult) obj).k();
        }
    }

    private static CreateThreadManager m16652b(InjectorLike injectorLike) {
        return new CreateThreadManager(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public CreateThreadManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f16648c = defaultBlueServiceOperationFactory;
        this.f16649d = executorService;
        this.f16647b = defaultAndroidThreadUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.CreateThreadManager m16650a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16646f;	 Catch:{ all -> 0x006c }
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
        r1 = m16652b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16646f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.CreateThreadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.CreateThreadManager) r0;	 Catch:{  }
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
        r0 = f16646f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.CreateThreadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.CreateThreadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.CreateThreadManager");
    }

    public final ListenableFuture<FetchThreadResult> m16654a(final long j, SendMessageByRecipientsParams sendMessageByRecipientsParams) {
        Long.valueOf(j);
        this.f16647b.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("createThreadParams", sendMessageByRecipientsParams);
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(this.f16648c, "create_thread", bundle, ErrorPropagation.BY_EXCEPTION, -1394288474).a();
        C19601 c19601 = new OperationResultFutureCallback2(this) {
            final /* synthetic */ CreateThreadManager f16643b;

            protected final void m16647a(OperationResult operationResult) {
                Class cls = CreateThreadManager.f16645a;
                Long.valueOf(j);
                this.f16643b.f16650e.b(Long.valueOf(j));
            }

            protected final void m16649a(Throwable th) {
                Class cls = CreateThreadManager.f16645a;
                new Object[1][0] = Long.valueOf(j);
                this.f16643b.f16650e.b(Long.valueOf(j));
            }
        };
        Futures.a(a, c19601, this.f16649d);
        this.f16650e.a(Long.valueOf(j), FutureAndCallbackHolder.a(a, c19601));
        return m16651a(a);
    }

    public final ListenableFuture<FetchThreadResult> m16653a(long j) {
        this.f16647b.a();
        FutureAndCallbackHolder futureAndCallbackHolder = (FutureAndCallbackHolder) this.f16650e.a(Long.valueOf(j));
        if (futureAndCallbackHolder == null) {
            return null;
        }
        return m16651a(futureAndCallbackHolder.a);
    }

    private ListenableFuture<FetchThreadResult> m16651a(ListenableFuture<OperationResult> listenableFuture) {
        return Futures.a(listenableFuture, new C19612(this), this.f16649d);
    }
}
