package com.facebook.messaging.send.client;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: deletePaymentCardParams */
public class PendingThreadsManager implements IHaveUserData {
    private static final Object f16694d = new Object();
    private final Lazy<ThreadKeyFactory> f16695a;
    private final MessagesBroadcaster f16696b;
    private final Map<ThreadKey, PendingThreadSummary> f16697c = new HashMap();

    /* compiled from: deletePaymentCardParams */
    public class PendingThreadException extends Exception {
        private PendingThreadException(String str) {
            super(str);
        }

        public static PendingThreadException m16718a(ThreadKey threadKey) {
            throw new PendingThreadException(StringFormatUtil.formatStrLocaleSafe("Pending thread with the following id does not exist: %s", threadKey.toString()));
        }

        public static PendingThreadException m16719a(ThreadKey threadKey, ThreadKey threadKey2) {
            throw new PendingThreadException(StringFormatUtil.formatStrLocaleSafe("Pending thread has already been created on the server: %s --> %s", threadKey.toString(), threadKey2.toString()));
        }

        public static PendingThreadException m16720b(ThreadKey threadKey) {
            return new PendingThreadException(StringFormatUtil.formatStrLocaleSafe("Pending thread was marked as failed: %s", threadKey.toString()));
        }
    }

    /* compiled from: deletePaymentCardParams */
    public class PendingThreadSummary {
        public final ThreadKey f16690a;
        public final ImmutableList<ParticipantInfo> f16691b;
        @Nullable
        public ThreadKey f16692c;
        public boolean f16693d;
    }

    private static PendingThreadsManager m16722b(InjectorLike injectorLike) {
        return new PendingThreadsManager(IdBasedLazy.a(injectorLike, 2665), MessagesBroadcaster.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.PendingThreadsManager m16721a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16694d;	 Catch:{ all -> 0x006c }
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
        r1 = m16722b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16694d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.PendingThreadsManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.PendingThreadsManager) r0;	 Catch:{  }
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
        r0 = f16694d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.PendingThreadsManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.PendingThreadsManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.PendingThreadsManager");
    }

    @Inject
    public PendingThreadsManager(Lazy<ThreadKeyFactory> lazy, MessagesBroadcaster messagesBroadcaster) {
        this.f16695a = lazy;
        this.f16696b = messagesBroadcaster;
    }

    public final boolean m16725a(ThreadKey threadKey) {
        Preconditions.checkArgument(threadKey.f());
        return this.f16697c.containsKey(threadKey);
    }

    public final void m16726b(ThreadKey threadKey) {
        PendingThreadSummary e = m16723e(threadKey);
        if (e.f16693d) {
            PendingThreadException.m16720b(e.f16690a);
        }
        Preconditions.checkState(!e.f16693d);
        e.f16693d = true;
        this.f16696b.b(threadKey);
    }

    public final ImmutableList<ParticipantInfo> m16727c(ThreadKey threadKey) {
        return m16723e(threadKey).f16691b;
    }

    @Nullable
    public final ThreadKey m16728d(ThreadKey threadKey) {
        return m16723e(threadKey).f16692c;
    }

    public final void m16724a(ThreadKey threadKey, ThreadKey threadKey2) {
        PendingThreadSummary e = m16723e(threadKey);
        if (e.f16693d) {
            PendingThreadException.m16720b(e.f16690a);
        }
        ThreadKey threadKey3 = e.f16692c;
        if (threadKey3 != null) {
            PendingThreadException.m16719a(e.f16690a, threadKey3);
        }
        Preconditions.checkState(!e.f16693d);
        Preconditions.checkNotNull(threadKey2);
        e.f16692c = threadKey2;
        this.f16696b.a(threadKey, threadKey2);
    }

    public void clearUserData() {
        this.f16697c.clear();
    }

    private PendingThreadSummary m16723e(ThreadKey threadKey) {
        Preconditions.checkArgument(threadKey.f());
        PendingThreadSummary pendingThreadSummary = (PendingThreadSummary) this.f16697c.get(threadKey);
        if (pendingThreadSummary == null) {
            PendingThreadException.m16718a(threadKey);
        }
        return pendingThreadSummary;
    }
}
