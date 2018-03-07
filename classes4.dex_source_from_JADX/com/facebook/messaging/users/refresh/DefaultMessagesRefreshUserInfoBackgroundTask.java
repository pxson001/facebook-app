package com.facebook.messaging.users.refresh;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesDataTaskTag;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: failures */
public class DefaultMessagesRefreshUserInfoBackgroundTask extends AbstractBackgroundTask implements BackgroundTask {
    private static final Object f12223i = new Object();
    private final long f12224a = 172800000;
    private final GatekeeperStoreImpl f12225b;
    private final ListeningExecutorService f12226c;
    private final Clock f12227d;
    private final Provider<DbThreadsPropertyUtil> f12228e;
    private final Provider<Boolean> f12229f;
    private final Provider<Boolean> f12230g;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagesUserInfoRefresher> f12231h = UltralightRuntime.b;

    private static DefaultMessagesRefreshUserInfoBackgroundTask m12896b(InjectorLike injectorLike) {
        DefaultMessagesRefreshUserInfoBackgroundTask defaultMessagesRefreshUserInfoBackgroundTask = new DefaultMessagesRefreshUserInfoBackgroundTask(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 7808), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4163));
        defaultMessagesRefreshUserInfoBackgroundTask.f12231h = IdBasedLazy.a(injectorLike, 8593);
        return defaultMessagesRefreshUserInfoBackgroundTask;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask m12895a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12223i;	 Catch:{ all -> 0x006c }
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
        r1 = m12896b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12223i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask) r0;	 Catch:{  }
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
        r0 = f12223i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.messaging.users.refresh.DefaultMessagesRefreshUserInfoBackgroundTask");
    }

    @Inject
    public DefaultMessagesRefreshUserInfoBackgroundTask(GatekeeperStore gatekeeperStore, ListeningExecutorService listeningExecutorService, Clock clock, Provider<DbThreadsPropertyUtil> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        super("SYNC_FETCH_USER_INFO");
        this.f12225b = gatekeeperStore;
        this.f12226c = listeningExecutorService;
        this.f12227d = clock;
        this.f12228e = provider;
        this.f12229f = provider2;
        this.f12230g = provider3;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesDataTaskTag.class);
    }

    public final boolean mo595i() {
        if (!((Boolean) this.f12229f.get()).booleanValue()) {
            return false;
        }
        if (((Boolean) this.f12230g.get()).booleanValue()) {
            return false;
        }
        return ((DbThreadsPropertyUtil) this.f12228e.get()).a(DbThreadProperties.h, 0) + 172800000 < this.f12227d.a();
    }

    public final long mo593f() {
        return this.f12227d.a() + 172800000;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        ((DbThreadsPropertyUtil) this.f12228e.get()).b(DbThreadProperties.h, this.f12227d.a());
        return this.f12226c.a(new 1(this));
    }
}
