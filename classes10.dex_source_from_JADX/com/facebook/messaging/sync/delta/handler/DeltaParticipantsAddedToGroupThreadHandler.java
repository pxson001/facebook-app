package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheFetchThreadsHandler;
import com.facebook.messaging.cache.CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaParticipantsAddedToGroupThread;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.model.thrift.ParticipantInfo;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.messaging.sync.util.DeltaParticipantsUtil;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableSet;
import java.util.List;

@UserScoped
/* compiled from: preview_images_count */
public class DeltaParticipantsAddedToGroupThreadHandler extends SingleThreadDeltaHandler {
    private static final Object f4559k = new Object();
    private final DbInsertThreadsHandler f4560a;
    private final DbFetchThreadHandler f4561b;
    private final MessageFromDeltaFactory f4562c;
    private final DeltaUiChangesCache f4563d;
    private final ThriftModelUtil f4564e;
    private final UncommittedThreadModificationsCache f4565f;
    private final CacheFetchThreadsHandler f4566g;
    private final Clock f4567h;
    private final String f4568i;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4569j = UltralightRuntime.b;

    private static DeltaParticipantsAddedToGroupThreadHandler m4132b(InjectorLike injectorLike) {
        DeltaParticipantsAddedToGroupThreadHandler deltaParticipantsAddedToGroupThreadHandler = new DeltaParticipantsAddedToGroupThreadHandler(DbInsertThreadsHandler.a(injectorLike), DbFetchThreadHandler.a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), UncommittedThreadModificationsCache.m4224a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 11051), CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike));
        deltaParticipantsAddedToGroupThreadHandler.f4569j = IdBasedLazy.a(injectorLike, 7693);
        return deltaParticipantsAddedToGroupThreadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler m4131a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4559k;	 Catch:{ all -> 0x006c }
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
        r1 = m4132b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4559k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler) r0;	 Catch:{  }
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
        r0 = f4559k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaParticipantsAddedToGroupThreadHandler");
    }

    @Inject
    private DeltaParticipantsAddedToGroupThreadHandler(DbInsertThreadsHandler dbInsertThreadsHandler, DbFetchThreadHandler dbFetchThreadHandler, MessageFromDeltaFactory messageFromDeltaFactory, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, Clock clock, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy, CacheFetchThreadsHandler cacheFetchThreadsHandler, String str) {
        super(lazy);
        this.f4560a = dbInsertThreadsHandler;
        this.f4561b = dbFetchThreadHandler;
        this.f4562c = messageFromDeltaFactory;
        this.f4563d = deltaUiChangesCache;
        this.f4564e = thriftModelUtil;
        this.f4565f = uncommittedThreadModificationsCache;
        this.f4566g = cacheFetchThreadsHandler;
        this.f4567h = clock;
        this.f4568i = str;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4564e.m4262a(deltaWrapper.i().messageMetadata.threadKey));
    }

    public final boolean mo130e(DeltaWrapper deltaWrapper) {
        for (ParticipantInfo participantInfo : deltaWrapper.i().addedParticipants) {
            if (participantInfo.userFbId != null && this.f4568i.equals(Long.toString(participantInfo.userFbId.longValue()))) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaParticipantsAddedToGroupThread i = ((DeltaWrapper) deltaWithSequenceId.a).i();
        if (mo130e((DeltaWrapper) deltaWithSequenceId.a)) {
            return new Bundle();
        }
        ThreadSummary threadSummary2 = this.f4561b.a(this.f4564e.m4262a(i.messageMetadata.threadKey), 0).c;
        Bundle bundle = new Bundle();
        if (threadSummary2 == null) {
            return bundle;
        }
        NewMessageResult a = m4130a(i, threadSummary2, deltaWithSequenceId.b);
        bundle.putParcelable("newMessageResult", a);
        if (a == null) {
            return bundle;
        }
        bundle.putParcelable("threadSummary", a.c);
        return bundle;
    }

    public final void m4135a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((CacheInsertThreadsHandler) this.f4569j.get()).a(newMessageResult, deltaWithSequenceId.b);
            ((CacheInsertThreadsHandler) this.f4569j.get()).c(newMessageResult.c, newMessageResult.clientTimeMs);
            for (User a : DeltaParticipantsUtil.m4236c(((DeltaWrapper) deltaWithSequenceId.a).i().addedParticipants)) {
                ((CacheInsertThreadsHandler) this.f4569j.get()).a(a);
            }
            this.f4563d.m3964a(newMessageResult.a.b);
        }
    }

    private NewMessageResult m4130a(DeltaParticipantsAddedToGroupThread deltaParticipantsAddedToGroupThread, ThreadSummary threadSummary, long j) {
        List b = DeltaParticipantsUtil.m4235b(deltaParticipantsAddedToGroupThread.addedParticipants);
        List a = DeltaParticipantsUtil.m4234a(b);
        List c = DeltaParticipantsUtil.m4236c(deltaParticipantsAddedToGroupThread.addedParticipants);
        NewMessageResult a2 = this.f4560a.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, this.f4562c.m4253a(deltaParticipantsAddedToGroupThread, threadSummary, b), null, null, this.f4567h.a()), j);
        return new NewMessageResult(a2.a(), a2.c(), a2.d(), this.f4560a.a(threadSummary, a, c), a2.b());
    }
}
