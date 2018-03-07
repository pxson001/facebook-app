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
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaThreadFolder;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: press_text_button */
public class DeltaThreadFolderHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4608d = new Object();
    private final DbInsertThreadsHandler f4609a;
    private final ThriftModelUtil f4610b;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4611c = UltralightRuntime.b;

    private static DeltaThreadFolderHandler m4175b(InjectorLike injectorLike) {
        DeltaThreadFolderHandler deltaThreadFolderHandler = new DeltaThreadFolderHandler(DbInsertThreadsHandler.a(injectorLike), ThriftModelUtil.m4260a(injectorLike));
        deltaThreadFolderHandler.f4611c = IdBasedLazy.a(injectorLike, 7693);
        return deltaThreadFolderHandler;
    }

    @Inject
    private DeltaThreadFolderHandler(DbInsertThreadsHandler dbInsertThreadsHandler, ThriftModelUtil thriftModelUtil) {
        this.f4609a = dbInsertThreadsHandler;
        this.f4610b = thriftModelUtil;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4610b.m4262a(deltaWrapper.o().threadKey));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler m4174a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4608d;	 Catch:{ all -> 0x006c }
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
        r1 = m4175b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4608d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler) r0;	 Catch:{  }
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
        r0 = f4608d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaThreadFolderHandler");
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final boolean mo130e(DeltaWrapper deltaWrapper) {
        return deltaWrapper.o().folder.intValue() == 1;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        if (!mo130e((DeltaWrapper) deltaWithSequenceId.a)) {
            this.f4609a.a(this.f4610b.m4262a(((DeltaWrapper) deltaWithSequenceId.a).o().threadKey));
        }
        return new Bundle();
    }

    public final void m4178a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaThreadFolder o = ((DeltaWrapper) deltaWithSequenceId.a).o();
        if (!mo130e((DeltaWrapper) deltaWithSequenceId.a)) {
            ((CacheInsertThreadsHandler) this.f4611c.get()).a(FolderName.INBOX, this.f4610b.m4262a(o.threadKey));
        }
    }
}
