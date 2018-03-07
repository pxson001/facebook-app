package com.facebook.messaging.cache;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserNameUtil;
import javax.inject.Inject;

@UserScoped
/* compiled from: is_location_history_enabled */
public class MessengerUserNameUtil {
    private static final Object f9988c = new Object();
    private final UserCache f9989a;
    private final UserNameUtil f9990b;

    private static MessengerUserNameUtil m10368b(InjectorLike injectorLike) {
        return new MessengerUserNameUtil(UserCache.m10371a(injectorLike), UserNameUtil.m10377a(injectorLike));
    }

    @Inject
    public MessengerUserNameUtil(UserCache userCache, UserNameUtil userNameUtil) {
        this.f9989a = userCache;
        this.f9990b = userNameUtil;
    }

    public final String m10369a(ParticipantInfo participantInfo) {
        UserKey userKey = participantInfo.b;
        String a = this.f9990b.m10383a(userKey != null ? this.f9989a.m10373a(userKey) : null);
        return StringUtil.a(a) ? participantInfo.c : a;
    }

    public final String m10370b(ParticipantInfo participantInfo) {
        String i;
        if (participantInfo.b != null) {
            User a = this.f9989a.m10373a(participantInfo.b);
            if (a != null) {
                i = a.e.i();
            } else {
                i = participantInfo.c;
            }
        } else {
            i = participantInfo.c;
        }
        if (i == null) {
            return participantInfo.d;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.cache.MessengerUserNameUtil m10367a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9988c;	 Catch:{ all -> 0x006c }
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
        r1 = m10368b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9988c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.MessengerUserNameUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.cache.MessengerUserNameUtil) r0;	 Catch:{  }
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
        r0 = f9988c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.cache.MessengerUserNameUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.cache.MessengerUserNameUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.cache.MessengerUserNameUtil");
    }
}
