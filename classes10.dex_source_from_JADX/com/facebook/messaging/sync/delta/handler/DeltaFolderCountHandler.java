package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaFolderCount;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.Iterator;

@UserScoped
/* compiled from: profile/{#%s}/friends/{%s}?source_ref={%s %s} */
public class DeltaFolderCountHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4484d = new Object();
    private final DbThreadsPropertyUtil f4485a;
    private final MessageRequestsSnippetFetcher f4486b;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4487c = UltralightRuntime.b;

    private static DeltaFolderCountHandler m4048b(InjectorLike injectorLike) {
        DeltaFolderCountHandler deltaFolderCountHandler = new DeltaFolderCountHandler(DbThreadsPropertyUtil.a(injectorLike), MessageRequestsSnippetFetcher.m3174a(injectorLike));
        deltaFolderCountHandler.f4487c = IdBasedLazy.a(injectorLike, 7693);
        return deltaFolderCountHandler;
    }

    @Inject
    private DeltaFolderCountHandler(DbThreadsPropertyUtil dbThreadsPropertyUtil, MessageRequestsSnippetFetcher messageRequestsSnippetFetcher) {
        this.f4485a = dbThreadsPropertyUtil;
        this.f4486b = messageRequestsSnippetFetcher;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return RegularImmutableSet.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler m4046a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4484d;	 Catch:{ all -> 0x006c }
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
        r1 = m4048b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4484d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler) r0;	 Catch:{  }
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
        r0 = f4484d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaFolderCountHandler");
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        if (m4047a(((DeltaWrapper) deltaWithSequenceId.a).x())) {
            Iterator it = FolderName.CONVERSATION_REQUEST_FOLDERS.iterator();
            while (it.hasNext()) {
                this.f4485a.b(DbThreadProperties.c((FolderName) it.next()), true);
            }
        }
        return new Bundle();
    }

    public final void m4051a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        if (m4047a(((DeltaWrapper) deltaWithSequenceId.a).x())) {
            this.f4486b.m3182c();
            Iterator it = FolderName.CONVERSATION_REQUEST_FOLDERS.iterator();
            while (it.hasNext()) {
                ((CacheInsertThreadsHandler) this.f4487c.get()).a.c((FolderName) it.next());
            }
        }
    }

    private static boolean m4047a(DeltaFolderCount deltaFolderCount) {
        if (deltaFolderCount.threadFolder.intValue() != 4 || deltaFolderCount.counts == null) {
            return false;
        }
        if (deltaFolderCount.counts.containsKey(Integer.valueOf(2)) || deltaFolderCount.counts.containsKey(Integer.valueOf(1))) {
            return true;
        }
        return false;
    }
}
