package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.database.handlers.DbFetchThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaReplaceMessage;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@UserScoped
/* compiled from: preview_image_thumb_height */
public class DeltaReplaceMessageHandler extends SingleThreadDeltaHandler {
    private static final Object f4584e = new Object();
    private final DbFetchThreadsHandler f4585a;
    private final Lazy<DeltaNewMessageHandler> f4586b;
    private final ThriftModelUtil f4587c;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<DeltaMessageDeleteHandler> f4588d = UltralightRuntime.b;

    private static DeltaReplaceMessageHandler m4151b(InjectorLike injectorLike) {
        DeltaReplaceMessageHandler deltaReplaceMessageHandler = new DeltaReplaceMessageHandler(IdBasedLazy.a(injectorLike, 11051), DbFetchThreadsHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 8518), ThriftModelUtil.m4260a(injectorLike));
        deltaReplaceMessageHandler.f4588d = IdBasedLazy.a(injectorLike, 8516);
        return deltaReplaceMessageHandler;
    }

    @Inject
    public DeltaReplaceMessageHandler(Lazy<MessageSyncAnalyticsLogger> lazy, DbFetchThreadsHandler dbFetchThreadsHandler, Lazy<DeltaNewMessageHandler> lazy2, ThriftModelUtil thriftModelUtil) {
        super(lazy);
        this.f4585a = dbFetchThreadsHandler;
        this.f4586b = lazy2;
        this.f4587c = thriftModelUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler m4150a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4584e;	 Catch:{ all -> 0x006c }
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
        r1 = m4151b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4584e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler) r0;	 Catch:{  }
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
        r0 = f4584e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaReplaceMessageHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4587c.m4262a(deltaWrapper.y().newMessage.messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaReplaceMessage y = ((DeltaWrapper) deltaWithSequenceId.a).y();
        ImmutableList a = this.f4585a.a(mo126a((DeltaWrapper) deltaWithSequenceId.a));
        if (a.isEmpty()) {
            return new Bundle();
        }
        ThreadSummary threadSummary2 = (ThreadSummary) a.get(0);
        DeleteMessagesResult a2 = ((DeltaMessageDeleteHandler) this.f4588d.get()).m4091a(ImmutableList.of(y.replacedMessageId), deltaWithSequenceId.b, threadSummary2.a);
        if (a2.e.size() == 0) {
            return new Bundle();
        }
        ThreadSummary threadSummary3;
        ((DeltaMessageDeleteHandler) this.f4588d.get()).m4094a(a2);
        if (a2.b != null) {
            threadSummary3 = a2.b;
        } else {
            threadSummary3 = threadSummary2;
        }
        return ((DeltaNewMessageHandler) this.f4586b.get()).m4105a(threadSummary3, y.newMessage, deltaWithSequenceId.b);
    }

    public final void m4154a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((DeltaNewMessageHandler) this.f4586b.get()).m4109a(((DeltaWrapper) deltaWithSequenceId.a).y().newMessage, newMessageResult, deltaWithSequenceId.b);
        }
    }
}
