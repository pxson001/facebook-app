package com.facebook.messaging.ui.name;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ThreadDisplayCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: checking CURRENT */
public class MessengerThreadNameViewDataFactory {
    private static final Object f18238c = new Object();
    private final ThreadDisplayCache f18239a;
    private final ThreadParticipantUtils f18240b;

    private static MessengerThreadNameViewDataFactory m18196b(InjectorLike injectorLike) {
        return new MessengerThreadNameViewDataFactory(ThreadDisplayCache.m10136a(injectorLike), ThreadParticipantUtils.m10155a(injectorLike));
    }

    @Inject
    public MessengerThreadNameViewDataFactory(ThreadDisplayCache threadDisplayCache, ThreadParticipantUtils threadParticipantUtils) {
        this.f18239a = threadDisplayCache;
        this.f18240b = threadParticipantUtils;
    }

    @Nullable
    public final MessengerThreadNameViewData m18197a(@Nullable ThreadSummary threadSummary) {
        MessengerThreadNameViewData messengerThreadNameViewData = null;
        TracerDetour.a("MTNVD.getThreadNameViewData", 590693418);
        if (threadSummary == null) {
            TracerDetour.a(-1722340207);
        } else {
            try {
                ThreadParticipant b = this.f18240b.m10160b(threadSummary);
                messengerThreadNameViewData = new MessengerThreadNameViewData(threadSummary.a(), threadSummary.g, ImmutableList.copyOf(this.f18239a.m10141a(threadSummary)), b != null ? b.a : null, b != null ? b.b : -1);
            } finally {
                int i = -1802508269;
                TracerDetour.a(-1802508269);
            }
        }
        return messengerThreadNameViewData;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory m18195a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f18238c;	 Catch:{ all -> 0x006c }
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
        r1 = m18196b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18238c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory) r0;	 Catch:{  }
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
        r0 = f18238c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory");
    }

    public static MessengerThreadNameViewData m18194a(User user) {
        if (user == null) {
            return null;
        }
        String k = user.k();
        return new MessengerThreadNameViewData(false, null, ImmutableList.of(k), new ParticipantInfo(user.T, k), -1);
    }
}
