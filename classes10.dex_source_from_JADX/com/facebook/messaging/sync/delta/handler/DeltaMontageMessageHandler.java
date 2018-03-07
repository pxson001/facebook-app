package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@UserScoped
/* compiled from: privacy_critical/ */
public class DeltaMontageMessageHandler extends SingleThreadDeltaHandler {
    private static final Object f4525f = new Object();
    private final ThriftModelUtil f4526a;
    private final DefaultThreadKeyFactory f4527b;
    private final DataCache f4528c;
    private final DbCache f4529d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<DeltaNewMessageHandler> f4530e = UltralightRuntime.b;

    private static DeltaMontageMessageHandler m4097b(InjectorLike injectorLike) {
        DeltaMontageMessageHandler deltaMontageMessageHandler = new DeltaMontageMessageHandler(IdBasedLazy.a(injectorLike, 11051), ThriftModelUtil.m4260a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), DataCache.a(injectorLike), DbCache.a(injectorLike));
        deltaMontageMessageHandler.f4530e = IdBasedLazy.a(injectorLike, 8518);
        return deltaMontageMessageHandler;
    }

    @Inject
    public DeltaMontageMessageHandler(com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy, ThriftModelUtil thriftModelUtil, ThreadKeyFactory threadKeyFactory, DataCache dataCache, DbCache dbCache) {
        super(lazy);
        this.f4526a = thriftModelUtil;
        this.f4527b = threadKeyFactory;
        this.f4528c = dataCache;
        this.f4529d = dbCache;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler m4096a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4525f;	 Catch:{ all -> 0x006c }
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
        r1 = m4097b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4525f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler) r0;	 Catch:{  }
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
        r0 = f4525f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaMontageMessageHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4526a.m4262a(deltaWrapper.A().newMessage.messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return !m4098f(deltaWrapper);
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        if (m4098f((DeltaWrapper) deltaWithSequenceId.a)) {
            return new Bundle();
        }
        return ((DeltaNewMessageHandler) this.f4530e.get()).m4105a(threadSummary, ((DeltaWrapper) deltaWithSequenceId.a).A().newMessage, deltaWithSequenceId.b);
    }

    public final void m4101a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((DeltaNewMessageHandler) this.f4530e.get()).m4109a(((DeltaWrapper) deltaWithSequenceId.a).A().newMessage, newMessageResult, deltaWithSequenceId.b);
        }
    }

    private boolean m4098f(DeltaWrapper deltaWrapper) {
        ThreadKey a = this.f4527b.a(deltaWrapper.A().newMessage.messageMetadata.actorFbId.longValue());
        return this.f4528c.a(a) == null && this.f4529d.a(a) == null;
    }
}
