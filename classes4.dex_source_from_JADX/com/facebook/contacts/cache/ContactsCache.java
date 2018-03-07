package com.facebook.contacts.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.cache.CacheSizeHelper;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactUserKey;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.UserKey;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: rtc_log.txt */
public class ContactsCache implements IHaveUserData {
    private static final Object f3263b = new Object();
    private final Cache<UserKey, Contact> f3264a;

    private static ContactsCache m3456b(InjectorLike injectorLike) {
        return new ContactsCache(CacheSizeHelper.m12985a(injectorLike));
    }

    @Inject
    public ContactsCache(CacheSizeHelper cacheSizeHelper) {
        this.f3264a = CacheBuilder.newBuilder().a(600, TimeUnit.SECONDS).a((long) cacheSizeHelper.m12987a(60, 100)).q();
    }

    public final void m3458a() {
        this.f3264a.a();
    }

    public final Contact m3457a(UserKey userKey) {
        if (userKey == null) {
            return null;
        }
        return (Contact) this.f3264a.a(userKey);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.cache.ContactsCache m3455a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3263b;	 Catch:{ all -> 0x006c }
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
        r1 = m3456b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3263b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.cache.ContactsCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.cache.ContactsCache) r0;	 Catch:{  }
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
        r0 = f3263b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.cache.ContactsCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.cache.ContactsCache.a(com.facebook.inject.InjectorLike):com.facebook.contacts.cache.ContactsCache");
    }

    public final void m3459a(Contact contact) {
        Iterator it = ContactUserKey.a(contact).iterator();
        while (it.hasNext()) {
            this.f3264a.a((UserKey) it.next(), contact);
        }
    }

    public final void m3460a(Iterable<UserKey> iterable) {
        this.f3264a.a(iterable);
    }

    public void clearUserData() {
        m3458a();
    }
}
