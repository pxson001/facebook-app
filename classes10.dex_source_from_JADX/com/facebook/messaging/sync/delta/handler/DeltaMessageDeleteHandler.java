package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.messaging.service.model.DeleteMessagesResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache.DeletedMessages;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.util.List;

@UserScoped
/* compiled from: privacy_options_viewed */
public class DeltaMessageDeleteHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4519f = new Object();
    private final DbInsertThreadsHandler f4520a;
    private final DeltaUiChangesCache f4521b;
    private final ThriftModelUtil f4522c;
    private final UncommittedThreadModificationsCache f4523d;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4524e = UltralightRuntime.b;

    private static DeltaMessageDeleteHandler m4089b(InjectorLike injectorLike) {
        DeltaMessageDeleteHandler deltaMessageDeleteHandler = new DeltaMessageDeleteHandler(DbInsertThreadsHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), UncommittedThreadModificationsCache.m4224a(injectorLike));
        deltaMessageDeleteHandler.f4524e = IdBasedLazy.a(injectorLike, 7693);
        return deltaMessageDeleteHandler;
    }

    @Inject
    private DeltaMessageDeleteHandler(DbInsertThreadsHandler dbInsertThreadsHandler, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, UncommittedThreadModificationsCache uncommittedThreadModificationsCache) {
        this.f4520a = dbInsertThreadsHandler;
        this.f4521b = deltaUiChangesCache;
        this.f4522c = thriftModelUtil;
        this.f4523d = uncommittedThreadModificationsCache;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler m4088a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4519f;	 Catch:{ all -> 0x006c }
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
        r1 = m4089b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4519f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler) r0;	 Catch:{  }
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
        r0 = f4519f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaMessageDeleteHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4522c.m4262a(deltaWrapper.g().threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeleteMessagesResult a = m4091a(((DeltaWrapper) deltaWithSequenceId.a).g().messageIds, deltaWithSequenceId.b, (ThreadKey) Iterables.a(mo126a((DeltaWrapper) deltaWithSequenceId.a), null));
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteMessagesResult", a);
        return bundle;
    }

    public final void m4093a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeleteMessagesResult deleteMessagesResult = (DeleteMessagesResult) bundle.getParcelable("deleteMessagesResult");
        if (deleteMessagesResult != null) {
            m4094a(deleteMessagesResult);
        }
    }

    final void m4094a(DeleteMessagesResult deleteMessagesResult) {
        ((CacheInsertThreadsHandler) this.f4524e.get()).a(FolderName.INBOX, deleteMessagesResult);
        DeltaUiChangesCache deltaUiChangesCache = this.f4521b;
        ThreadKey threadKey = deleteMessagesResult.c;
        if (threadKey != null) {
            DeletedMessages deletedMessages = (DeletedMessages) deltaUiChangesCache.f4357f.get(threadKey);
            if (deletedMessages == null) {
                deletedMessages = new DeletedMessages(threadKey);
                deltaUiChangesCache.f4357f.put(threadKey, deletedMessages);
            }
            DeletedMessages deletedMessages2 = deletedMessages;
            deletedMessages2.f4349b.addAll(deleteMessagesResult.d);
            deletedMessages2.f4350c.addAll(deleteMessagesResult.e.values());
        }
        this.f4523d.m4231a(deleteMessagesResult.e.values());
    }

    final DeleteMessagesResult m4091a(List<String> list, long j, ThreadKey threadKey) {
        return this.f4520a.a(new DeleteMessagesParams(ImmutableSet.copyOf(list), ServerParam.CLIENT_ONLY, threadKey), j);
    }
}
