package com.facebook.contacts.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: photo_list */
public class DynamicContactDataCache implements IHaveUserData {
    private static final Object f8133b = new Object();
    private final Map<UserKey, ChatContextForUser> f8134a = new HashMap();

    private static DynamicContactDataCache m11688c() {
        return new DynamicContactDataCache();
    }

    public final synchronized void m11691a(ImmutableMap<UserKey, ? extends ChatContextForUser> immutableMap) {
        this.f8134a.clear();
        this.f8134a.putAll(immutableMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.cache.DynamicContactDataCache m11687a(com.facebook.inject.InjectorLike r7) {
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
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f8133b;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m11688c();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f8133b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.cache.DynamicContactDataCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.contacts.cache.DynamicContactDataCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f8133b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.cache.DynamicContactDataCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.cache.DynamicContactDataCache.a(com.facebook.inject.InjectorLike):com.facebook.contacts.cache.DynamicContactDataCache");
    }

    public final synchronized ImmutableMap<UserKey, ChatContextForUser> m11690a() {
        Builder builder;
        builder = ImmutableMap.builder();
        for (UserKey userKey : this.f8134a.keySet()) {
            builder.b(userKey, (ChatContextForUser) this.f8134a.get(userKey));
        }
        return builder.b();
    }

    public final synchronized ImmutableList<UserKey> m11689a(GraphQLUserChatContextType graphQLUserChatContextType) {
        ImmutableList<UserKey> immutableList;
        if (this.f8134a.isEmpty()) {
            immutableList = null;
        } else {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (UserKey userKey : this.f8134a.keySet()) {
                if (((ChatContextForUser) this.f8134a.get(userKey)).mo935b().m11728b() == graphQLUserChatContextType) {
                    builder.c(userKey);
                }
            }
            immutableList = builder.b();
        }
        return immutableList;
    }

    public final synchronized void m11692b() {
        this.f8134a.clear();
    }

    public synchronized void clearUserData() {
        m11692b();
    }
}
