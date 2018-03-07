package com.facebook.messaging.customthreads.threadsettings;

import android.content.res.Resources;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessengerUserNameUtil;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import javax.inject.Inject;

@UserScoped
/* compiled from: start_fragment */
public class CustomThreadsTextHelper {
    private static final Object f2263e = new Object();
    public final DataCache f2264a;
    private final Resources f2265b;
    public final ThreadParticipantUtils f2266c;
    public final MessengerUserNameUtil f2267d;

    private static CustomThreadsTextHelper m2127b(InjectorLike injectorLike) {
        return new CustomThreadsTextHelper(DataCache.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ThreadParticipantUtils.a(injectorLike), MessengerUserNameUtil.a(injectorLike));
    }

    @Inject
    public CustomThreadsTextHelper(DataCache dataCache, Resources resources, ThreadParticipantUtils threadParticipantUtils, MessengerUserNameUtil messengerUserNameUtil) {
        this.f2264a = dataCache;
        this.f2265b = resources;
        this.f2266c = threadParticipantUtils;
        this.f2267d = messengerUserNameUtil;
    }

    public final String m2128a(ThreadKey threadKey) {
        if (!(threadKey.b() || threadKey.e())) {
            String a;
            ThreadSummary a2 = this.f2264a.a(threadKey);
            if (a2 != null) {
                a = this.f2267d.a(this.f2266c.a(a2).a);
            } else {
                a = null;
            }
            if (a != null) {
                return this.f2265b.getString(2131231852, new Object[]{r0});
            }
        }
        return this.f2265b.getString(2131231853);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper m2126a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f2263e;	 Catch:{ all -> 0x006c }
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
        r1 = m2127b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2263e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper) r0;	 Catch:{  }
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
        r0 = f2263e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper");
    }
}
