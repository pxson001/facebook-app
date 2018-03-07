package com.facebook.messaging.sms.util;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.sms.sharedutils.SmsUserUtil;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: com.facebook.messaging.sms.MmsFileProvider */
public class SmsContactUtil {
    private static final Object f17783e = new Object();
    private final SmsUserUtil f17784a;
    private final Provider<User> f17785b;
    private final UserCache f17786c;
    private ParticipantInfo f17787d;

    private static SmsContactUtil m17711b(InjectorLike injectorLike) {
        return new SmsContactUtil(SmsUserUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), UserCache.a(injectorLike));
    }

    @Inject
    public SmsContactUtil(SmsUserUtil smsUserUtil, Provider<User> provider, UserCache userCache) {
        this.f17784a = smsUserUtil;
        this.f17785b = provider;
        this.f17786c = userCache;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.util.SmsContactUtil m17710a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f17783e;	 Catch:{ all -> 0x006c }
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
        r1 = m17711b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17783e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.util.SmsContactUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.util.SmsContactUtil) r0;	 Catch:{  }
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
        r0 = f17783e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.util.SmsContactUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.util.SmsContactUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.util.SmsContactUtil");
    }

    public final User m17714a(String str) {
        return this.f17784a.a(str);
    }

    public static ParticipantInfo m17709a(User user) {
        return new ParticipantInfo(new UserKey(user.b, user.a), user.j(), user.u());
    }

    @Nullable
    public final ParticipantInfo m17713a() {
        if (this.f17787d == null) {
            if (this.f17785b.get() != null) {
                this.f17787d = m17709a((User) this.f17785b.get());
            } else {
                this.f17787d = null;
            }
        }
        return this.f17787d;
    }

    @Nullable
    public final String m17715a(@Nullable ThreadSummary threadSummary) {
        if (threadSummary == null || threadSummary.h.size() != 2) {
            return null;
        }
        UserKey b;
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.b().a().isPhoneContact()) {
                b = threadParticipant.b();
                break;
            }
        }
        b = null;
        if (b == null) {
            return null;
        }
        User a = this.f17786c.a(b);
        if (a == null || a.w() == null) {
            return b.g();
        }
        return a.w().b;
    }

    public static boolean m17712b(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return true;
        }
        String trim = str.trim();
        if (trim.startsWith("*") || trim.startsWith("#")) {
            return true;
        }
        return false;
    }
}
