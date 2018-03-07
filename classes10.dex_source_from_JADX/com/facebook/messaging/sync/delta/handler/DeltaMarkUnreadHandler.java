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
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.Mark;
import com.facebook.messaging.service.model.MarkThreadFields.MarkThreadFieldsBuilder;
import com.facebook.messaging.service.model.MarkThreadsParams.MarkThreadsParamsBuilder;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaMarkUnread;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: privacy_review_lightweight */
public class DeltaMarkUnreadHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4512g = new Object();
    private final CacheFetchThreadsHandler f4513a;
    private final DbFetchThreadsHandler f4514b;
    private final DbInsertThreadsHandler f4515c;
    private final DeltaUiChangesCache f4516d;
    private final ThriftModelUtil f4517e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4518f = UltralightRuntime.b;

    private static DeltaMarkUnreadHandler m4083b(InjectorLike injectorLike) {
        DeltaMarkUnreadHandler deltaMarkUnreadHandler = new DeltaMarkUnreadHandler(CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), DbFetchThreadsHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike));
        deltaMarkUnreadHandler.f4518f = IdBasedLazy.a(injectorLike, 7693);
        return deltaMarkUnreadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler m4082a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4512g;	 Catch:{ all -> 0x006c }
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
        r1 = m4083b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4512g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler) r0;	 Catch:{  }
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
        r0 = f4512g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaMarkUnreadHandler");
    }

    @Inject
    private DeltaMarkUnreadHandler(CacheFetchThreadsHandler cacheFetchThreadsHandler, DbFetchThreadsHandler dbFetchThreadsHandler, DbInsertThreadsHandler dbInsertThreadsHandler, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil) {
        this.f4513a = cacheFetchThreadsHandler;
        this.f4514b = dbFetchThreadsHandler;
        this.f4515c = dbInsertThreadsHandler;
        this.f4516d = deltaUiChangesCache;
        this.f4517e = thriftModelUtil;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.copyOf(this.f4517e.m4263a(deltaWrapper.f().threadKeys));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaMarkUnread f = ((DeltaWrapper) deltaWithSequenceId.a).f();
        ImmutableList a = this.f4517e.m4263a(f.threadKeys);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ThreadKey threadKey = (ThreadKey) a.get(i);
            DbInsertThreadsHandler dbInsertThreadsHandler = this.f4515c;
            MarkThreadsParamsBuilder markThreadsParamsBuilder = new MarkThreadsParamsBuilder();
            markThreadsParamsBuilder.a = Mark.READ;
            markThreadsParamsBuilder = markThreadsParamsBuilder;
            MarkThreadFieldsBuilder markThreadFieldsBuilder = new MarkThreadFieldsBuilder();
            markThreadFieldsBuilder.a = threadKey;
            MarkThreadFieldsBuilder markThreadFieldsBuilder2 = markThreadFieldsBuilder;
            markThreadFieldsBuilder2.b = false;
            markThreadFieldsBuilder2 = markThreadFieldsBuilder2;
            markThreadFieldsBuilder2.d = deltaWithSequenceId.b;
            dbInsertThreadsHandler.a(markThreadsParamsBuilder.a(markThreadFieldsBuilder2.a()).a());
        }
        if (f.folders != null) {
            for (Integer intValue : f.folders) {
                for (ThreadKey threadKey2 : this.f4514b.a(ThriftModelUtil.m4259a(intValue.intValue()), -1, -1).keySet()) {
                    DbInsertThreadsHandler dbInsertThreadsHandler2 = this.f4515c;
                    MarkThreadsParamsBuilder markThreadsParamsBuilder2 = new MarkThreadsParamsBuilder();
                    markThreadsParamsBuilder2.a = Mark.READ;
                    markThreadsParamsBuilder2 = markThreadsParamsBuilder2;
                    MarkThreadFieldsBuilder markThreadFieldsBuilder3 = new MarkThreadFieldsBuilder();
                    markThreadFieldsBuilder3.a = threadKey2;
                    markThreadFieldsBuilder2 = markThreadFieldsBuilder3;
                    markThreadFieldsBuilder2.b = false;
                    markThreadFieldsBuilder2 = markThreadFieldsBuilder2;
                    markThreadFieldsBuilder2.d = deltaWithSequenceId.b;
                    dbInsertThreadsHandler2.a(markThreadsParamsBuilder2.a(markThreadFieldsBuilder2.a()).a());
                }
            }
        }
        return new Bundle();
    }

    public final void m4086a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        int i;
        DeltaMarkUnread f = ((DeltaWrapper) deltaWithSequenceId.a).f();
        ImmutableList a = this.f4517e.m4263a(f.threadKeys);
        int size = a.size();
        for (i = 0; i < size; i++) {
            ThreadKey threadKey = (ThreadKey) a.get(i);
            ((CacheInsertThreadsHandler) this.f4518f.get()).a(threadKey);
            this.f4516d.m3967c(threadKey);
        }
        if (f.folders != null) {
            for (Integer intValue : f.folders) {
                a = this.f4513a.a(ThriftModelUtil.m4259a(intValue.intValue())).c.c;
                size = a.size();
                for (i = 0; i < size; i++) {
                    ThreadSummary threadSummary = (ThreadSummary) a.get(i);
                    ((CacheInsertThreadsHandler) this.f4518f.get()).a(threadSummary.a);
                    this.f4516d.m3967c(threadSummary.a);
                }
            }
        }
    }
}
