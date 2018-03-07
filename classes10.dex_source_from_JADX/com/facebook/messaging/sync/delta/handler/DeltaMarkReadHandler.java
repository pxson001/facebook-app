package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheFetchThreadsHandler;
import com.facebook.messaging.cache.CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadsHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler.MarkThreadReadResult;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notificationpolicy.NotificationPolicyEngine;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaMarkRead;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

@UserScoped
/* compiled from: privacy_settings */
public class DeltaMarkReadHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4504h = new Object();
    private final DbFetchThreadsHandler f4505a;
    private final DbInsertThreadsHandler f4506b;
    private final CacheFetchThreadsHandler f4507c;
    private final ThriftModelUtil f4508d;
    private final DeltaUiChangesCache f4509e;
    private final NotificationPolicyEngine f4510f;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4511g = UltralightRuntime.b;

    /* compiled from: privacy_settings */
    /* synthetic */ class C06521 {
        static final /* synthetic */ int[] f4503a = new int[MarkThreadReadResult.values().length];

        static {
            try {
                f4503a[MarkThreadReadResult.THREAD_MARKED_READ.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4503a[MarkThreadReadResult.THREAD_NOT_MARKED_READ.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4503a[MarkThreadReadResult.THREAD_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static DeltaMarkReadHandler m4077b(InjectorLike injectorLike) {
        DeltaMarkReadHandler deltaMarkReadHandler = new DeltaMarkReadHandler(DbFetchThreadsHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), ThriftModelUtil.m4260a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), NotificationPolicyEngine.m3311a(injectorLike));
        deltaMarkReadHandler.f4511g = IdBasedLazy.a(injectorLike, 7693);
        return deltaMarkReadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler m4075a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4504h;	 Catch:{ all -> 0x006c }
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
        r1 = m4077b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4504h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler) r0;	 Catch:{  }
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
        r0 = f4504h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaMarkReadHandler");
    }

    @Inject
    private DeltaMarkReadHandler(DbFetchThreadsHandler dbFetchThreadsHandler, DbInsertThreadsHandler dbInsertThreadsHandler, CacheFetchThreadsHandler cacheFetchThreadsHandler, ThriftModelUtil thriftModelUtil, DeltaUiChangesCache deltaUiChangesCache, NotificationPolicyEngine notificationPolicyEngine) {
        this.f4505a = dbFetchThreadsHandler;
        this.f4506b = dbInsertThreadsHandler;
        this.f4507c = cacheFetchThreadsHandler;
        this.f4508d = thriftModelUtil;
        this.f4509e = deltaUiChangesCache;
        this.f4510f = notificationPolicyEngine;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.copyOf(this.f4508d.m4263a(deltaWrapper.e().threadKeys));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaMarkRead e = ((DeltaWrapper) deltaWithSequenceId.a).e();
        long a = m4074a(e);
        ImmutableList a2 = this.f4508d.m4263a(e.threadKeys);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            m4076a((ThreadKey) a2.get(i), a, deltaWithSequenceId.b);
        }
        if (e.folders != null) {
            for (Integer intValue : e.folders) {
                for (ThreadKey a3 : this.f4505a.a(ThriftModelUtil.m4259a(intValue.intValue()), -1, -1).keySet()) {
                    m4076a(a3, a, deltaWithSequenceId.b);
                }
            }
        }
        return new Bundle();
    }

    public final void m4080a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        int i;
        DeltaMarkRead e = ((DeltaWrapper) deltaWithSequenceId.a).e();
        long a = m4074a(e);
        ImmutableList a2 = this.f4508d.m4263a(e.threadKeys);
        int size = a2.size();
        for (i = 0; i < size; i++) {
            ((CacheInsertThreadsHandler) this.f4511g.get()).a((ThreadKey) a2.get(i), a, deltaWithSequenceId.b);
        }
        if (e.folders != null) {
            for (Integer intValue : e.folders) {
                a2 = this.f4507c.a(ThriftModelUtil.m4259a(intValue.intValue())).c.c;
                size = a2.size();
                for (i = 0; i < size; i++) {
                    ((CacheInsertThreadsHandler) this.f4511g.get()).a(((ThreadSummary) a2.get(i)).a, a, deltaWithSequenceId.b);
                }
            }
        }
    }

    private static long m4074a(DeltaMarkRead deltaMarkRead) {
        Preconditions.checkNotNull(deltaMarkRead.watermarkTimestamp);
        return deltaMarkRead.watermarkTimestamp.longValue();
    }

    private void m4076a(ThreadKey threadKey, long j, long j2) {
        DbInsertThreadsHandler dbInsertThreadsHandler = this.f4506b;
        MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
        markThreadFieldsBuilder.a = threadKey;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.b = true;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.e = j;
        markThreadFieldsBuilder = markThreadFieldsBuilder;
        markThreadFieldsBuilder.d = j2;
        switch (C06521.f4503a[dbInsertThreadsHandler.a(markThreadFieldsBuilder.a()).ordinal()]) {
            case 1:
                this.f4510f.m3313a(j);
                DeltaUiChangesCache deltaUiChangesCache = this.f4509e;
                deltaUiChangesCache.f4354c.add(threadKey);
                deltaUiChangesCache.f4353b.put(threadKey, Lists.a());
                return;
            case 2:
                this.f4510f.m3318b();
                return;
            case 3:
                this.f4510f.m3313a(j);
                return;
            default:
                return;
        }
    }
}
