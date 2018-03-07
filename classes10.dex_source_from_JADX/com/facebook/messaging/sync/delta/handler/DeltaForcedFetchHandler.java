package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheFetchThreadsHandler;
import com.facebook.messaging.cache.CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaForcedFetch;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import javax.inject.Inject;

@UserScoped
/* compiled from: profile/info_request/{%s}/{%s} */
public class DeltaForcedFetchHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4488e = new Object();
    private final ThriftModelUtil f4489a;
    public final CacheFetchThreadsHandler f4490b;
    public final DbFetchThreadHandler f4491c;
    private final String f4492d;

    private static DeltaForcedFetchHandler m4054b(InjectorLike injectorLike) {
        return new DeltaForcedFetchHandler(ThriftModelUtil.m4260a(injectorLike), CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), DbFetchThreadHandler.a(injectorLike), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public DeltaForcedFetchHandler(ThriftModelUtil thriftModelUtil, CacheFetchThreadsHandler cacheFetchThreadsHandler, DbFetchThreadHandler dbFetchThreadHandler, String str) {
        this.f4489a = thriftModelUtil;
        this.f4490b = cacheFetchThreadsHandler;
        this.f4491c = dbFetchThreadHandler;
        this.f4492d = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler m4053a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4488e;	 Catch:{ all -> 0x006c }
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
        r1 = m4054b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4488e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler) r0;	 Catch:{  }
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
        r0 = f4488e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaForcedFetchHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4489a.m4262a(deltaWrapper.r().threadKey));
    }

    public final ImmutableMap<ThreadKey, String> mo128c(DeltaWrapper deltaWrapper) {
        DeltaForcedFetch r = deltaWrapper.r();
        if (r.messageId == null) {
            return RegularImmutableBiMap.a;
        }
        return ImmutableBiMap.b(this.f4489a.m4262a(r.threadKey), r.messageId);
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final boolean mo129d(DeltaWrapper deltaWrapper) {
        Long l = deltaWrapper.r().threadKey.otherUserFbId;
        if (this.f4492d == null || l == null || !l.equals(Long.valueOf(Long.parseLong(this.f4492d)))) {
            return false;
        }
        return true;
    }

    public final boolean mo130e(DeltaWrapper deltaWrapper) {
        DeltaForcedFetch r = deltaWrapper.r();
        if (r.isLazy == null || Boolean.FALSE.equals(r.isLazy)) {
            return true;
        }
        boolean z;
        if (r.messageId != null) {
            if (this.f4491c.b(r.messageId) != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (r.threadKey == null) {
            return false;
        } else {
            z = true;
            ThreadCriteria a = ThreadCriteria.a(this.f4489a.m4262a(r.threadKey));
            if (this.f4490b.a(a) == null) {
                FetchThreadResult a2 = this.f4491c.a(a, 1);
                if (!(a2.b.l && Objects.equal(FolderName.INBOX, a2.c.A))) {
                    z = false;
                }
            }
            return z;
        }
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        return null;
    }

    public final void m4057a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
    }
}
