package com.facebook.messaging.send.client;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.PushedViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.abtest.ExperimentsForMessagingAbTestModule;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbSendHandler;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.model.folders.ThreadsCacheType;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@NotThreadSafe
/* compiled from: is_messenger_capable */
public class StartupRetryManager {
    private static final Object f9960m = new Object();
    private final ViewerContextManager f9961a;
    private final Provider<SendMessageManager> f9962b;
    public final ScheduledExecutorService f9963c;
    public final ListeningExecutorService f9964d;
    private final Clock f9965e;
    public final QeAccessor f9966f;
    public final DbFetchThreadHandler f9967g;
    public final AbstractFbErrorReporter f9968h;
    public final Product f9969i;
    private final SendFailureManager f9970j;
    @GuardedBy("uiThread")
    public InitialSendRetryStatus f9971k = InitialSendRetryStatus.NOT_STARTED;
    public final long f9972l;

    @VisibleForTesting
    /* compiled from: is_messenger_capable */
    public enum InitialSendRetryStatus {
        NOT_STARTED,
        IN_PROGRESS,
        SUCCEEDED,
        FAILED,
        ABORTED;

        public static boolean isCompleted(InitialSendRetryStatus initialSendRetryStatus) {
            return initialSendRetryStatus == SUCCEEDED || initialSendRetryStatus == FAILED || initialSendRetryStatus == ABORTED;
        }
    }

    private static StartupRetryManager m10334b(InjectorLike injectorLike) {
        return new StartupRetryManager(ViewerContextManagerProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 8347), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) DbClock.m9116a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DbFetchThreadHandler.m9097a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), SendFailureManager.m10339a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.StartupRetryManager m10333a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9960m;	 Catch:{ all -> 0x006c }
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
        r1 = m10334b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9960m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.StartupRetryManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.StartupRetryManager) r0;	 Catch:{  }
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
        r0 = f9960m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.StartupRetryManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.StartupRetryManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.StartupRetryManager");
    }

    @Inject
    StartupRetryManager(ViewerContextManager viewerContextManager, Provider<SendMessageManager> provider, ScheduledExecutorService scheduledExecutorService, ListeningExecutorService listeningExecutorService, Clock clock, QeAccessor qeAccessor, DbFetchThreadHandler dbFetchThreadHandler, FbErrorReporter fbErrorReporter, Product product, SendFailureManager sendFailureManager) {
        this.f9961a = viewerContextManager;
        this.f9962b = provider;
        this.f9963c = scheduledExecutorService;
        this.f9964d = listeningExecutorService;
        this.f9965e = clock;
        this.f9966f = qeAccessor;
        this.f9967g = dbFetchThreadHandler;
        this.f9968h = fbErrorReporter;
        this.f9969i = product;
        this.f9970j = sendFailureManager;
        this.f9972l = this.f9965e.a();
    }

    @VisibleForTesting
    final void m10337a(@Nullable LinkedHashMap<String, Message> linkedHashMap) {
        Throwable th;
        Throwable th2;
        PushedViewerContext b;
        if (this.f9971k != InitialSendRetryStatus.ABORTED) {
            this.f9971k = InitialSendRetryStatus.SUCCEEDED;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                b = this.f9961a.b(this.f9961a.a());
                try {
                    for (Message a : linkedHashMap.values()) {
                        ((SendMessageManager) this.f9962b.get()).a(a, "startup_retry", null, null);
                    }
                    if (b != null) {
                        b.close();
                        return;
                    }
                    return;
                } catch (Throwable th22) {
                    Throwable th3 = th22;
                    th22 = th;
                    th = th3;
                }
            } else {
                return;
            }
        }
        return;
        throw th;
        if (b != null) {
            if (th22 != null) {
                try {
                    b.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                b.close();
            }
        }
        throw th;
    }

    @GuardedBy("ui_thread")
    public final void m10338b() {
        if (this.f9969i != Product.PAA) {
            long a = this.f9966f.a(ExperimentsForMessagingAbTestModule.f10048d, 0);
            if ((a > 0 ? 1 : null) != null && !InitialSendRetryStatus.isCompleted(this.f9971k)) {
                this.f9971k = InitialSendRetryStatus.ABORTED;
                ExecutorDetour.a(this.f9964d, new 3(this, a), 895858775);
            }
        }
    }

    public static void m10336e(StartupRetryManager startupRetryManager) {
        SendError a = SendError.a(SendErrorType.PENDING_SEND_ON_STARTUP);
        SendFailureManager sendFailureManager = startupRetryManager.f9970j;
        long j = startupRetryManager.f9972l;
        for (PendingThreadSends pendingThreadSends : ((SendMessageManager) sendFailureManager.f9976c.get()).H.a()) {
            pendingThreadSends.j = true;
        }
        ((DbSendHandler) sendFailureManager.f9975b.get()).a(a, j);
        sendFailureManager.f9974a.m10354a(ThreadsCacheType.FB);
    }

    public static void m10335b(StartupRetryManager startupRetryManager, LinkedHashMap linkedHashMap) {
        SendError a = SendError.a(SendErrorType.PENDING_SEND_ON_STARTUP);
        SendFailureManager sendFailureManager = startupRetryManager.f9970j;
        ImmutableList copyOf = ImmutableList.copyOf(linkedHashMap.values());
        long j = startupRetryManager.f9972l;
        SendMessageManager sendMessageManager = (SendMessageManager) sendFailureManager.f9976c.get();
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            PendingThreadSends a2 = sendMessageManager.H.a(sendMessageManager.e((Message) copyOf.get(i)));
            if (a2 != null) {
                a2.j = true;
            }
        }
        ((DbSendHandler) sendFailureManager.f9975b.get()).a(a, j);
        sendFailureManager.f9974a.m10355a(ThreadsCacheType.FB, copyOf);
    }
}
