package com.facebook.messaging.contactsyoumayknow;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@UserScoped
/* compiled from: system_locale */
public class ContactsYouMayKnowCache {
    private static final Object f2090d = new Object();
    @Nullable
    public ContactsYouMayKnowData f2091a;
    private final DefaultAndroidThreadUtil f2092b;
    @GuardedBy("this")
    private boolean f2093c;

    private static ContactsYouMayKnowCache m1908b(InjectorLike injectorLike) {
        return new ContactsYouMayKnowCache(DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public ContactsYouMayKnowCache(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f2092b = defaultAndroidThreadUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache m1906a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f2090d;	 Catch:{ all -> 0x006c }
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
        r1 = m1908b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2090d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache) r0;	 Catch:{  }
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
        r0 = f2090d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowCache");
    }

    public final synchronized void m1910a(boolean z) {
        this.f2093c = z;
    }

    public final synchronized boolean m1912c() {
        return this.f2093c;
    }

    public final void m1909a(String str) {
        this.f2092b.a();
        if (this.f2091a != null) {
            this.f2091a = new ContactsYouMayKnowData(m1907a(this.f2091a.f2094a, str), this.f2091a.f2095b);
        }
    }

    public final void m1911b(String str) {
        this.f2092b.a();
        if (this.f2091a != null) {
            this.f2091a = new ContactsYouMayKnowData(m1907a(this.f2091a.f2094a, str), this.f2091a.f2095b);
        }
    }

    private ImmutableList<ContactSuggestion> m1907a(ImmutableList<ContactSuggestion> immutableList, final String str) {
        return ImmutableList.copyOf(Iterables.c(immutableList, new Predicate<ContactSuggestion>(this) {
            final /* synthetic */ ContactsYouMayKnowCache f2089b;

            public boolean apply(Object obj) {
                return !Objects.equal(((ContactSuggestion) obj).f2078a.a, str);
            }
        }));
    }
}
