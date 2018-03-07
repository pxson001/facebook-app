package com.facebook.messaging.cache;

import com.facebook.auth.module.UserKey_ViewerContextUserKeyMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: messenger_videos/ */
public class ThreadParticipantUtils {
    private static final Object f9561e = new Object();
    public final UserKey f9562a;
    private final DataCache f9563b;
    public final UserCache f9564c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f9565d = UltralightRuntime.b;

    private static ThreadParticipantUtils m10157b(InjectorLike injectorLike) {
        ThreadParticipantUtils threadParticipantUtils = new ThreadParticipantUtils(UserKey_ViewerContextUserKeyMethodAutoProvider.b(injectorLike), DataCache.a(injectorLike), UserCache.a(injectorLike));
        threadParticipantUtils.f9565d = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        return threadParticipantUtils;
    }

    @Inject
    public ThreadParticipantUtils(UserKey userKey, DataCache dataCache, UserCache userCache) {
        this.f9562a = userKey;
        this.f9563b = dataCache;
        this.f9564c = userCache;
    }

    public final ThreadParticipant m10158a(ThreadSummary threadSummary) {
        if (this.f9562a != null) {
            ImmutableList immutableList = threadSummary.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (!Objects.equal(threadParticipant.b(), this.f9562a)) {
                    return threadParticipant;
                }
            }
        }
        return (ThreadParticipant) threadSummary.h.get(0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.ThreadParticipantUtils m10155a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9561e;	 Catch:{ all -> 0x006c }
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
        r1 = m10157b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9561e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadParticipantUtils) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.ThreadParticipantUtils) r0;	 Catch:{  }
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
        r0 = f9561e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.ThreadParticipantUtils) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.ThreadParticipantUtils.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.ThreadParticipantUtils");
    }

    @Nullable
    public final ThreadParticipant m10160b(@Nullable ThreadSummary threadSummary) {
        if (threadSummary != null) {
            if (threadSummary.h.size() <= 0) {
                ((AbstractFbErrorReporter) this.f9565d.get()).a("ThreadParticipantUtils.EMPTY_PARTICIPANTS", "Unable to process participants in Canonical Thread for " + threadSummary);
                return null;
            } else if (threadSummary.a.a == Type.ONE_TO_ONE || (ThreadKey.d(threadSummary.a) && threadSummary.h.size() == 2)) {
                return m10158a(threadSummary);
            }
        }
        return null;
    }

    public final boolean m10161c(ThreadSummary threadSummary) {
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equal(((ThreadParticipant) immutableList.get(i)).b(), this.f9562a)) {
                return true;
            }
        }
        return false;
    }

    public static ParticipantInfo m10156a(List<ThreadParticipant> list, UserKey userKey) {
        for (ThreadParticipant threadParticipant : list) {
            if (userKey.equals(threadParticipant.b())) {
                return threadParticipant.a;
            }
        }
        return null;
    }

    public final boolean m10159a(ThreadKey threadKey) {
        ThreadSummary a = this.f9563b.a(threadKey);
        if (a != null) {
            Object obj;
            ThreadKey threadKey2 = a.a;
            if (!(threadKey2 == null || threadKey2.b() || threadKey2.d())) {
                ImmutableList immutableList = a.h;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    User a2 = this.f9564c.a(((ThreadParticipant) immutableList.get(i)).b());
                    if (a2 != null && a2.A) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
