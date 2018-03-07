package com.facebook.user.cache;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: is_local_build */
public class UserCache implements IHaveUserData {
    private static final Object f9991c = new Object();
    private final LoggedInUserSessionManager f9992a;
    public final ConcurrentMap<UserKey, User> f9993b = Maps.e();

    private static UserCache m10372b(InjectorLike injectorLike) {
        return new UserCache(LoggedInUserSessionManager.a(injectorLike));
    }

    @Inject
    public UserCache(LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f9992a = loggedInUserSessionManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.user.cache.UserCache m10371a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9991c;	 Catch:{ all -> 0x006c }
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
        r1 = m10372b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9991c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.user.cache.UserCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.user.cache.UserCache) r0;	 Catch:{  }
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
        r0 = f9991c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.user.cache.UserCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.cache.UserCache.a(com.facebook.inject.InjectorLike):com.facebook.user.cache.UserCache");
    }

    @Nullable
    public final User m10373a(UserKey userKey) {
        if (userKey == null) {
            return null;
        }
        return (User) this.f9993b.get(userKey);
    }

    public final void m10375a(Collection<User> collection) {
        for (User user : collection) {
            User user2 = (User) this.f9993b.get(user.T);
            if (user2 == null || user2.L < user.L) {
                LoggedInUserSessionManager loggedInUserSessionManager = this.f9992a;
                User c = loggedInUserSessionManager.c();
                if (c != null && Objects.equal(c.T, user.T)) {
                    loggedInUserSessionManager.a(user);
                }
                this.f9993b.put(user.T, user);
            }
        }
    }

    public final ImmutableList<User> m10374a(ImmutableList<UserKey> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User a = m10373a((UserKey) immutableList.get(i));
            if (a != null) {
                builder.c(a);
            }
        }
        return builder.b();
    }

    public void clearUserData() {
        this.f9993b.clear();
    }
}
