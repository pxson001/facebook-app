package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaApprovalMode;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: profile_first_name */
public class DeltaApprovalModeHandler extends SingleThreadDeltaHandler {
    private static final Object f4451g = new Object();
    private final ThriftModelUtil f4452a;
    private final DeltaUiChangesCache f4453b;
    private final DbFetchThreadHandler f4454c;
    private final DbInsertThreadsHandler f4455d;
    private final Clock f4456e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4457f = UltralightRuntime.b;

    private static DeltaApprovalModeHandler m4022b(InjectorLike injectorLike) {
        DeltaApprovalModeHandler deltaApprovalModeHandler = new DeltaApprovalModeHandler(IdBasedLazy.a(injectorLike, 11051), ThriftModelUtil.m4260a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), DbFetchThreadHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        deltaApprovalModeHandler.f4457f = IdBasedLazy.a(injectorLike, 7693);
        return deltaApprovalModeHandler;
    }

    @Inject
    private DeltaApprovalModeHandler(com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy, ThriftModelUtil thriftModelUtil, DeltaUiChangesCache deltaUiChangesCache, DbFetchThreadHandler dbFetchThreadHandler, DbInsertThreadsHandler dbInsertThreadsHandler, Clock clock) {
        super(lazy);
        this.f4452a = thriftModelUtil;
        this.f4453b = deltaUiChangesCache;
        this.f4454c = dbFetchThreadHandler;
        this.f4455d = dbInsertThreadsHandler;
        this.f4456e = clock;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler m4021a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4451g;	 Catch:{ all -> 0x006c }
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
        r1 = m4022b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4451g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler) r0;	 Catch:{  }
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
        r0 = f4451g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaApprovalModeHandler");
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        Bundle bundle = new Bundle();
        DeltaApprovalMode G = ((DeltaWrapper) deltaWithSequenceId.a).G();
        ThreadSummary threadSummary2 = this.f4454c.a(this.f4452a.m4262a(G.messageMetadata.threadKey), 0).c;
        if (threadSummary2 == null) {
            return bundle;
        }
        if (G.mode == null) {
            throw new IllegalArgumentException("DeltaApprovalMode mode is null.");
        }
        ThreadSummary a = this.f4455d.a(threadSummary2, G.mode.equals(Integer.valueOf(1)), this.f4456e.a());
        if (a != null) {
            bundle.putParcelable("approval_mode_thread_summary", a);
        }
        return bundle;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4452a.m4262a(deltaWrapper.G().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final void m4025a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary = (ThreadSummary) bundle.getParcelable("approval_mode_thread_summary");
        if (threadSummary != null) {
            ((CacheInsertThreadsHandler) this.f4457f.get()).c(threadSummary, this.f4456e.a());
            this.f4453b.m3964a(threadSummary.a);
        }
    }
}
