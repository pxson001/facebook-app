package com.facebook.messaging.contacts.loader;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.presence.PayForPlayPresence;
import com.facebook.rtc.models.RtcCallLogInfo;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: emoji_like */
public class ContactListsCache implements IHaveUserData {
    private static final Object f13134E = new Object();
    private static final Class<?> f13135a = ContactListsCache.class;
    private ImmutableList<RtcCallLogInfo> f13136A;
    private long f13137B;
    private ImmutableList<RtcCallLogInfo> f13138C;
    private long f13139D;
    private final Clock f13140b;
    private final Provider<PayForPlayPresence> f13141c;
    private ImmutableList<User> f13142d;
    private long f13143e;
    private ImmutableList<User> f13144f;
    private long f13145g;
    private ImmutableList<User> f13146h;
    private long f13147i;
    private ImmutableList<User> f13148j;
    private long f13149k;
    private ImmutableList<User> f13150l;
    private long f13151m;
    private ImmutableList<User> f13152n;
    private long f13153o;
    private ImmutableList<User> f13154p;
    private long f13155q;
    private ImmutableList<User> f13156r;
    private long f13157s;
    private ImmutableList<User> f13158t;
    private long f13159u;
    private ImmutableList<User> f13160v;
    private long f13161w;
    private ImmutableList<User> f13162x;
    private ImmutableList<User> f13163y;
    private long f13164z;

    private static ContactListsCache m14004b(InjectorLike injectorLike) {
        return new ContactListsCache((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3089));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.contacts.loader.ContactListsCache m14003a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f13134E;	 Catch:{ all -> 0x006c }
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
        r1 = m14004b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f13134E;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.contacts.loader.ContactListsCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.contacts.loader.ContactListsCache) r0;	 Catch:{  }
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
        r0 = f13134E;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.contacts.loader.ContactListsCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.loader.ContactListsCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.contacts.loader.ContactListsCache");
    }

    @Inject
    public ContactListsCache(Clock clock, Provider<PayForPlayPresence> provider) {
        this.f13140b = clock;
        this.f13141c = provider;
    }

    public final synchronized void m14007a(ImmutableList<User> immutableList) {
        this.f13142d = immutableList;
        this.f13143e = this.f13140b.a();
    }

    public final synchronized void m14009b(ImmutableList<User> immutableList) {
        this.f13152n = immutableList;
        this.f13153o = this.f13140b.a();
    }

    public final synchronized void m14011c(ImmutableList<RtcCallLogInfo> immutableList) {
        this.f13136A = immutableList;
        this.f13137B = this.f13140b.a();
    }

    public final synchronized void m14013d(ImmutableList<RtcCallLogInfo> immutableList) {
        this.f13138C = immutableList;
        this.f13139D = this.f13140b.a();
    }

    public final synchronized void m14014e(ImmutableList<User> immutableList) {
        this.f13154p = immutableList;
        this.f13155q = this.f13140b.a();
    }

    public final synchronized void m14015f(ImmutableList<User> immutableList) {
        if (((PayForPlayPresence) this.f13141c.get()).shouldShowPresence()) {
            this.f13144f = immutableList;
            this.f13145g = this.f13140b.a();
        }
    }

    public final synchronized void m14016g(ImmutableList<User> immutableList) {
        if (((PayForPlayPresence) this.f13141c.get()).shouldShowPresence()) {
            this.f13146h = immutableList;
            this.f13147i = this.f13140b.a();
        }
    }

    public final synchronized void m14017h(ImmutableList<User> immutableList) {
        this.f13148j = immutableList;
        this.f13149k = this.f13140b.a();
    }

    public final synchronized void m14018i(ImmutableList<User> immutableList) {
        this.f13150l = immutableList;
        this.f13151m = this.f13140b.a();
    }

    public final synchronized void m14019j(ImmutableList<User> immutableList) {
        this.f13156r = immutableList;
        this.f13157s = this.f13140b.a();
    }

    public final synchronized void m14020k(ImmutableList<User> immutableList) {
        this.f13158t = immutableList;
        this.f13159u = this.f13140b.a();
    }

    public final synchronized void m14021l(ImmutableList<User> immutableList) {
        this.f13160v = immutableList;
        this.f13161w = this.f13140b.a();
    }

    public final synchronized void m14022m(ImmutableList<User> immutableList) {
        this.f13162x = immutableList;
    }

    public final void m14023n(ImmutableList<User> immutableList) {
        this.f13163y = immutableList;
        this.f13164z = this.f13140b.a();
    }

    public final synchronized ImmutableList<User> m14006a() {
        m14005e();
        return this.f13144f;
    }

    public final synchronized ImmutableList<User> m14008b() {
        m14005e();
        return this.f13148j;
    }

    public final synchronized ImmutableList<User> m14010c() {
        m14005e();
        return this.f13150l;
    }

    public final synchronized void m14012d() {
        this.f13142d = null;
        this.f13152n = null;
        this.f13144f = null;
        this.f13146h = null;
        this.f13148j = null;
        this.f13150l = null;
        this.f13156r = null;
        this.f13158t = null;
        this.f13160v = null;
        this.f13162x = null;
        this.f13163y = null;
        this.f13136A = null;
        this.f13138C = null;
        this.f13143e = 0;
        this.f13153o = 0;
        this.f13145g = 0;
        this.f13147i = 0;
        this.f13149k = 0;
        this.f13151m = 0;
        this.f13157s = 0;
        this.f13159u = 0;
        this.f13161w = 0;
        this.f13164z = 0;
        this.f13137B = 0;
        this.f13139D = 0;
    }

    private void m14005e() {
        if (this.f13142d != null && this.f13140b.a() - this.f13143e > 3600000) {
            this.f13142d = null;
        }
        if (this.f13152n != null && this.f13140b.a() - this.f13153o > 300000) {
            this.f13152n = null;
        }
        if (this.f13154p != null && this.f13140b.a() - this.f13155q > 3600000) {
            this.f13154p = null;
        }
        if (this.f13144f != null) {
            if (!((PayForPlayPresence) this.f13141c.get()).shouldShowPresence()) {
                this.f13144f = null;
            } else if (this.f13140b.a() - this.f13145g > 300000) {
                this.f13144f = null;
            }
        }
        if (this.f13146h != null) {
            if (!((PayForPlayPresence) this.f13141c.get()).shouldShowPresence()) {
                this.f13146h = null;
            } else if (this.f13140b.a() - this.f13147i > 300000) {
                this.f13146h = null;
            }
        }
        if (this.f13148j != null && this.f13140b.a() - this.f13149k > 3600000) {
            this.f13148j = null;
        }
        if (this.f13150l != null && this.f13140b.a() - this.f13151m > 3600000) {
            this.f13150l = null;
        }
        if (this.f13156r != null && this.f13140b.a() - this.f13157s > 3600000) {
            this.f13156r = null;
        }
        if (this.f13158t != null && this.f13140b.a() - this.f13159u > 3600000) {
            this.f13158t = null;
        }
        if (this.f13160v != null && this.f13140b.a() - this.f13161w > 3600000) {
            this.f13160v = null;
        }
        if (this.f13163y != null && this.f13140b.a() - this.f13164z > 3600000) {
            this.f13163y = null;
        }
        if (this.f13136A != null && this.f13140b.a() - this.f13137B > 300000) {
            this.f13136A = null;
        }
        if (this.f13138C != null && this.f13140b.a() - this.f13139D > 300000) {
            this.f13138C = null;
        }
    }

    public void clearUserData() {
        m14012d();
    }
}
