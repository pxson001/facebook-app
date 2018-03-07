package com.facebook.messaging.cache;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messaging.model.messages.MessageUserUtil;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: messenger_valentines_2016 */
public class ThreadUnreadCountUtil {
    private static final Object f9580f = new Object();
    private final DataCache f9581a;
    private final MessageUserUtil f9582b;
    private final ThreadParticipantUtils f9583c;
    private final StatefulPeerManagerImpl f9584d;
    private final Provider<UserKey> f9585e;

    private static ThreadUnreadCountUtil m10185b(InjectorLike injectorLike) {
        return new ThreadUnreadCountUtil(DataCache.a(injectorLike), MessageUserUtil.a(injectorLike), ThreadParticipantUtils.m10155a(injectorLike), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3597));
    }

    @Inject
    public ThreadUnreadCountUtil(DataCache dataCache, MessageUserUtil messageUserUtil, ThreadParticipantUtils threadParticipantUtils, StatefulPeerManager statefulPeerManager, Provider<UserKey> provider) {
        this.f9581a = dataCache;
        this.f9582b = messageUserUtil;
        this.f9583c = threadParticipantUtils;
        this.f9584d = statefulPeerManager;
        this.f9585e = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.ThreadUnreadCountUtil m10184a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9580f;	 Catch:{ all -> 0x006c }
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
        r1 = m10185b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9580f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadUnreadCountUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.ThreadUnreadCountUtil) r0;	 Catch:{  }
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
        r0 = f9580f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadUnreadCountUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.ThreadUnreadCountUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.ThreadUnreadCountUtil");
    }

    public final boolean m10186a(ThreadSummary threadSummary) {
        ThreadSummary a = this.f9581a.a(threadSummary.a);
        if (a == null) {
            return threadSummary.f();
        }
        return a.f();
    }

    public final boolean m10187b(ThreadSummary threadSummary) {
        long j = threadSummary.k;
        if (threadSummary.a.a == Type.ONE_TO_ONE) {
            ThreadParticipant b = this.f9583c.m10160b(threadSummary);
            if (b == null || b.b < j) {
                return false;
            }
            return true;
        }
        UserKey userKey = (UserKey) this.f9585e.get();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (!Objects.equal(userKey, threadParticipant.b()) && threadParticipant.b < j) {
                return false;
            }
        }
        return true;
    }
}
