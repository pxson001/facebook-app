package com.facebook.messaging.sync.connection;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: promote_product */
public class MessagesSyncGroupThreadsFetcher {
    private static final Object f4306h = new Object();
    public final QeAccessor f4307a;
    public final ExecutorService f4308b;
    public final AbstractFbErrorReporter f4309c;
    private final DebugOverlayController f4310d;
    private final Lazy<GQLThreadQueryHelper> f4311e;
    private final Lazy<DbInsertThreadsHandler> f4312f;
    public final GatekeeperStoreImpl f4313g;

    /* compiled from: promote_product */
    public class C06481 implements Runnable {
        final /* synthetic */ CallerContext f4303a;
        final /* synthetic */ int f4304b;
        final /* synthetic */ MessagesSyncGroupThreadsFetcher f4305c;

        public C06481(MessagesSyncGroupThreadsFetcher messagesSyncGroupThreadsFetcher, CallerContext callerContext, int i) {
            this.f4305c = messagesSyncGroupThreadsFetcher;
            this.f4303a = callerContext;
            this.f4304b = i;
        }

        public void run() {
            try {
                MessagesSyncGroupThreadsFetcher.m3915a(this.f4305c, this.f4303a, this.f4304b);
            } catch (Exception e) {
                this.f4305c.f4309c.a("messages_sync_groups_only_threadlist_fetch_error", "Message requests fetch failed");
            }
        }
    }

    private static MessagesSyncGroupThreadsFetcher m3916b(InjectorLike injectorLike) {
        return new MessagesSyncGroupThreadsFetcher((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DebugOverlayController.a(injectorLike), IdBasedLazy.a(injectorLike, 8547), IdBasedSingletonScopeProvider.b(injectorLike, 7797), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher m3914a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4306h;	 Catch:{ all -> 0x006c }
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
        r1 = m3916b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4306h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher) r0;	 Catch:{  }
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
        r0 = f4306h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher");
    }

    @Inject
    public MessagesSyncGroupThreadsFetcher(QeAccessor qeAccessor, ExecutorService executorService, FbErrorReporter fbErrorReporter, DebugOverlayController debugOverlayController, Lazy<GQLThreadQueryHelper> lazy, Lazy<DbInsertThreadsHandler> lazy2, GatekeeperStore gatekeeperStore) {
        this.f4307a = qeAccessor;
        this.f4308b = executorService;
        this.f4309c = fbErrorReporter;
        this.f4310d = debugOverlayController;
        this.f4311e = lazy;
        this.f4312f = lazy2;
        this.f4313g = gatekeeperStore;
    }

    public static void m3915a(@Nullable MessagesSyncGroupThreadsFetcher messagesSyncGroupThreadsFetcher, CallerContext callerContext, int i) {
        messagesSyncGroupThreadsFetcher.f4310d.a(MessagesDebugOverlaySettingsTags.a, "fetchThreadList - Groups Only");
        FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
        newBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        newBuilder = newBuilder;
        newBuilder.b = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.f = i;
        FetchThreadListResult b = ((GQLThreadQueryHelper) messagesSyncGroupThreadsFetcher.f4311e.get()).b(newBuilder.h(), callerContext);
        ((DbInsertThreadsHandler) messagesSyncGroupThreadsFetcher.f4312f.get()).a(b.c.c, b.l);
    }
}
