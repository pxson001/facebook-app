package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData;
import com.facebook.messaging.model.threads.ThreadRtcCallInfoData.Builder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaRtcCallData;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.rtc.models.RecentCallsDb;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import javax.inject.Provider;

@UserScoped
/* compiled from: preselected_ids */
public class DeltaThreadRtcCallInfoHandler extends SingleThreadDeltaHandler {
    private static final Object f4632j = new Object();
    private final DbInsertThreadsHandler f4633a;
    private final DbFetchThreadHandler f4634b;
    private final DeltaUiChangesCache f4635c;
    private final ThriftModelUtil f4636d;
    private final Clock f4637e;
    private final RecentCallsDb f4638f;
    private final Provider<Boolean> f4639g;
    private final Provider<ViewerContext> f4640h;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4641i = UltralightRuntime.b;

    private static DeltaThreadRtcCallInfoHandler m4203b(InjectorLike injectorLike) {
        DeltaThreadRtcCallInfoHandler deltaThreadRtcCallInfoHandler = new DeltaThreadRtcCallInfoHandler(DbInsertThreadsHandler.a(injectorLike), DbFetchThreadHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), RecentCallsDb.a(injectorLike), IdBasedProvider.a(injectorLike, 4213), IdBasedProvider.a(injectorLike, 372), IdBasedLazy.a(injectorLike, 11051));
        deltaThreadRtcCallInfoHandler.f4641i = IdBasedLazy.a(injectorLike, 7693);
        return deltaThreadRtcCallInfoHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler m4202a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4632j;	 Catch:{ all -> 0x006c }
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
        r1 = m4203b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4632j;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler) r0;	 Catch:{  }
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
        r0 = f4632j;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaThreadRtcCallInfoHandler");
    }

    @Inject
    private DeltaThreadRtcCallInfoHandler(DbInsertThreadsHandler dbInsertThreadsHandler, DbFetchThreadHandler dbFetchThreadHandler, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, Clock clock, RecentCallsDb recentCallsDb, Provider<Boolean> provider, Provider<ViewerContext> provider2, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy) {
        super(lazy);
        this.f4633a = dbInsertThreadsHandler;
        this.f4634b = dbFetchThreadHandler;
        this.f4635c = deltaUiChangesCache;
        this.f4637e = clock;
        this.f4636d = thriftModelUtil;
        this.f4638f = recentCallsDb;
        this.f4639g = provider;
        this.f4640h = provider2;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4636d.m4262a(deltaWrapper.E().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        boolean z = false;
        Bundle bundle = new Bundle();
        DeltaRtcCallData E = ((DeltaWrapper) deltaWithSequenceId.a).E();
        FetchThreadResult a = this.f4634b.a(this.f4636d.m4262a(E.messageMetadata.threadKey), 0);
        ThreadSummary threadSummary2 = a.c;
        if (threadSummary2 == null) {
            return bundle;
        }
        String str;
        if (E.initiator == null) {
            str = null;
        } else {
            str = Long.toString(E.initiator.userFbId.longValue());
        }
        Builder a2 = ThreadRtcCallInfoData.newBuilder().a(E.callState);
        a2.b = E.serverInfoData;
        a2 = a2;
        a2.c = str;
        ThreadRtcCallInfoData d = a2.d();
        if (((Boolean) this.f4639g.get()).booleanValue()) {
            if (str != null && str.contentEquals(((ViewerContext) this.f4640h.get()).mUserId)) {
                z = true;
            }
            if (d.a()) {
                this.f4638f.a(Long.toString(threadSummary2.a.i()), this.f4637e.a(), d.b(), z, true);
            } else {
                this.f4638f.a(Long.toString(threadSummary2.a.i()), true);
            }
        }
        ThreadSummary a3 = this.f4633a.a(threadSummary2, d, a.f);
        if (a3 != null) {
            bundle.putParcelable("rtc_call_info", a3);
        }
        return bundle;
    }

    public final void m4206a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary = (ThreadSummary) bundle.getParcelable("rtc_call_info");
        if (threadSummary != null) {
            ((CacheInsertThreadsHandler) this.f4641i.get()).c(threadSummary, this.f4637e.a());
            this.f4635c.m3964a(threadSummary.a);
        }
    }
}
