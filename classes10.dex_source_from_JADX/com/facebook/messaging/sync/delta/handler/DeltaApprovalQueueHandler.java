package com.facebook.messaging.sync.delta.handler;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.threads.DbThreadParticipantsUtil;
import com.facebook.messaging.groups.notifications.GroupNotificationsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.JoinRequestNotification;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaApprovalQueue;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: profile_context_query_result_fields */
public class DeltaApprovalQueueHandler extends SingleThreadDeltaHandler {
    private static final Object f4458h = new Object();
    private final ThriftModelUtil f4459a;
    private final DbFetchThreadHandler f4460b;
    private final DeltaUiChangesCache f4461c;
    private final Clock f4462d;
    private final DbThreadParticipantsUtil f4463e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4464f = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupNotificationsHandler> f4465g = UltralightRuntime.b;

    private static DeltaApprovalQueueHandler m4028b(InjectorLike injectorLike) {
        DeltaApprovalQueueHandler deltaApprovalQueueHandler = new DeltaApprovalQueueHandler(IdBasedLazy.a(injectorLike, 11051), ThriftModelUtil.m4260a(injectorLike), DbFetchThreadHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), DbThreadParticipantsUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 7693);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 7870);
        deltaApprovalQueueHandler.f4464f = a;
        deltaApprovalQueueHandler.f4465g = a2;
        return deltaApprovalQueueHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler m4027a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4458h;	 Catch:{ all -> 0x006c }
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
        r1 = m4028b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4458h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler) r0;	 Catch:{  }
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
        r0 = f4458h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaApprovalQueueHandler");
    }

    @Inject
    private DeltaApprovalQueueHandler(com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy, ThriftModelUtil thriftModelUtil, DbFetchThreadHandler dbFetchThreadHandler, DeltaUiChangesCache deltaUiChangesCache, DbThreadParticipantsUtil dbThreadParticipantsUtil, Clock clock) {
        super(lazy);
        this.f4459a = thriftModelUtil;
        this.f4460b = dbFetchThreadHandler;
        this.f4461c = deltaUiChangesCache;
        this.f4463e = dbThreadParticipantsUtil;
        this.f4462d = clock;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        Bundle bundle = new Bundle();
        DeltaApprovalQueue H = ((DeltaWrapper) deltaWithSequenceId.a).H();
        if (H.recipientFbId == null || H.action == null) {
            return bundle;
        }
        ThreadKey a = this.f4459a.m4262a(H.messageMetadata.threadKey);
        if (this.f4460b.a(a, 0).c == null) {
            return bundle;
        }
        UserKey b = UserKey.b(Long.toString(H.recipientFbId.longValue()));
        if (H.action.intValue() == 0) {
            this.f4463e.a(a, b, H.messageMetadata.timestamp.longValue());
        } else if (H.action.intValue() == 1) {
            this.f4463e.a(a, b);
        } else {
            throw new IllegalArgumentException("Inappropriate DeltaApprovalQueueAction: " + H.action);
        }
        ThreadSummary threadSummary2 = this.f4460b.a(a, 0).c;
        if (threadSummary2 != null) {
            bundle.putParcelable("approval_queue_thread_summary", threadSummary2);
        }
        return bundle;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4459a.m4262a(deltaWrapper.H().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final void m4031a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary = (ThreadSummary) bundle.getParcelable("approval_queue_thread_summary");
        if (threadSummary != null) {
            ((CacheInsertThreadsHandler) this.f4464f.get()).c(threadSummary, this.f4462d.a());
            this.f4461c.m3964a(threadSummary.a);
            if (((DeltaWrapper) deltaWithSequenceId.a).H().action.intValue() == 0) {
                GroupNotificationsHandler groupNotificationsHandler = (GroupNotificationsHandler) this.f4465g.get();
                if (groupNotificationsHandler.f2489a.m2482a() && groupNotificationsHandler.f2490b.m2346c(threadSummary)) {
                    MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) groupNotificationsHandler.f2491c.get();
                    JoinRequestNotification joinRequestNotification = new JoinRequestNotification(groupNotificationsHandler.f2492d.getString(2131240809), groupNotificationsHandler.f2492d.getString(2131240818), threadSummary.a);
                    Intent intent = new Intent(MessagesNotificationIntents.z);
                    intent.putExtra("notification", joinRequestNotification);
                    ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
                }
            }
        }
    }
}
