package com.facebook.auth.userscope;

import javax.inject.Provider;

/* compiled from: suggested_groups */
class UserScopedProvider<T> implements Provider<T> {
    private static final Class<?> f2399a = UserScopedProvider.class;
    private static final byte[] f2400b = new byte[]{(byte) 1, (byte) 8};
    private final UserScope f2401c;
    private final Provider<T> f2402d;

    UserScopedProvider(UserScope userScope, Provider<T> provider) {
        this.f2401c = userScope;
        this.f2402d = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T get() {
        /*
        r7 = this;
        r1 = 4;
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = f2400b;
        r2.a(r1, r0);
        r0 = r7.f2401c;
        r0 = r0.getContext();
        if (r0 != 0) goto L_0x001a;
    L_0x0012:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001a:
        r1 = r7.f2401c;
        r3 = r1.a(r0);
        r4 = r3.b();	 Catch:{ all -> 0x0062 }
        r0 = r4.get(r7);	 Catch:{ all -> 0x0062 }
        r1 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x0062 }
        if (r0 != r1) goto L_0x0031;
    L_0x002c:
        r3.c();
        r0 = 0;
    L_0x0030:
        return r0;
    L_0x0031:
        if (r0 != 0) goto L_0x0054;
    L_0x0033:
        r0 = 4;
        r5 = r2.b(r0);	 Catch:{  }
        r0 = r7.f2401c;	 Catch:{ all -> 0x005d }
        r6 = r0.a(r3);	 Catch:{ all -> 0x005d }
        r0 = r7.f2402d;	 Catch:{ all -> 0x0058 }
        r1 = r0.get();	 Catch:{ all -> 0x0058 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0067;
    L_0x0049:
        r0 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r7, r0);	 Catch:{  }
    L_0x004f:
        if (r0 == 0) goto L_0x006c;
    L_0x0051:
        r2.c(r5);	 Catch:{  }
    L_0x0054:
        r3.c();
        goto L_0x0030;
    L_0x0058:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x005d:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0062:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0067:
        r0 = r4.putIfAbsent(r7, r1);	 Catch:{  }
        goto L_0x004f;
    L_0x006c:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.userscope.UserScopedProvider.get():T");
    }
}
