package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaParticipantLeftGroupThread;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: previous_button */
public class DeltaParticipantLeftGroupThreadHandler extends SingleThreadDeltaHandler {
    private static final Object f4551h = new Object();
    private final DbInsertThreadsHandler f4552a;
    private final DbFetchThreadHandler f4553b;
    private final MessageFromDeltaFactory f4554c;
    private final DeltaUiChangesCache f4555d;
    private final ThriftModelUtil f4556e;
    private final Clock f4557f;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4558g = UltralightRuntime.b;

    private static DeltaParticipantLeftGroupThreadHandler m4125b(InjectorLike injectorLike) {
        DeltaParticipantLeftGroupThreadHandler deltaParticipantLeftGroupThreadHandler = new DeltaParticipantLeftGroupThreadHandler(DbInsertThreadsHandler.a(injectorLike), DbFetchThreadHandler.a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 11051));
        deltaParticipantLeftGroupThreadHandler.f4558g = IdBasedLazy.a(injectorLike, 7693);
        return deltaParticipantLeftGroupThreadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler m4124a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4551h;	 Catch:{ all -> 0x006c }
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
        r1 = m4125b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4551h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler) r0;	 Catch:{  }
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
        r0 = f4551h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaParticipantLeftGroupThreadHandler");
    }

    @Inject
    private DeltaParticipantLeftGroupThreadHandler(DbInsertThreadsHandler dbInsertThreadsHandler, DbFetchThreadHandler dbFetchThreadHandler, MessageFromDeltaFactory messageFromDeltaFactory, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, Clock clock, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy) {
        super(lazy);
        this.f4552a = dbInsertThreadsHandler;
        this.f4553b = dbFetchThreadHandler;
        this.f4554c = messageFromDeltaFactory;
        this.f4555d = deltaUiChangesCache;
        this.f4556e = thriftModelUtil;
        this.f4557f = clock;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4556e.m4262a(deltaWrapper.j().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaParticipantLeftGroupThread j = ((DeltaWrapper) deltaWithSequenceId.a).j();
        ThreadSummary threadSummary2 = this.f4553b.a(this.f4556e.m4262a(j.messageMetadata.threadKey), 0).c;
        Bundle bundle = new Bundle();
        if (threadSummary2 != null) {
            bundle.putParcelable("newMessageResult", m4123a(j, threadSummary2, deltaWithSequenceId.b));
        }
        return bundle;
    }

    public final void m4128a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((CacheInsertThreadsHandler) this.f4558g.get()).a(newMessageResult, deltaWithSequenceId.b);
            ((CacheInsertThreadsHandler) this.f4558g.get()).c(newMessageResult.c, newMessageResult.clientTimeMs);
            this.f4555d.m3964a(newMessageResult.a.b);
        }
    }

    private NewMessageResult m4123a(DeltaParticipantLeftGroupThread deltaParticipantLeftGroupThread, ThreadSummary threadSummary, long j) {
        NewMessageResult a = this.f4552a.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, this.f4554c.m4252a(deltaParticipantLeftGroupThread, threadSummary, new ParticipantInfo(new UserKey(Type.FACEBOOK, Long.toString(deltaParticipantLeftGroupThread.leftParticipantFbId.longValue())), null)), null, null, this.f4557f.a()), j);
        return new NewMessageResult(a.freshness, a.a, a.b, this.f4552a.a(threadSummary, UserKey.b(Long.toString(deltaParticipantLeftGroupThread.leftParticipantFbId.longValue()))), a.b());
    }
}
