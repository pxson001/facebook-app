package com.facebook.contacts.iterator;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserPhoneNumber;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@UserScoped
/* compiled from: payment */
public class PhoneContactFacebookUserDeduper implements IHaveUserData {
    private static final Object f8249c = new Object();
    @Inject
    public UserIterators f8250a;
    private final Map<UserKey, ImmutableList<UserKey>> f8251b = new HashMap();

    private static PhoneContactFacebookUserDeduper m12097b(InjectorLike injectorLike) {
        PhoneContactFacebookUserDeduper phoneContactFacebookUserDeduper = new PhoneContactFacebookUserDeduper();
        phoneContactFacebookUserDeduper.f8250a = UserIterators.a(injectorLike);
        return phoneContactFacebookUserDeduper;
    }

    public final boolean m12100a(User user) {
        Preconditions.checkArgument(user.b());
        return !m12098b(user).isEmpty();
    }

    private ImmutableList<UserKey> m12098b(User user) {
        ImmutableList<UserKey> immutableList = (ImmutableList) this.f8251b.get(user.T);
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = m12099c(user);
        this.f8251b.put(user.T, immutableList);
        return immutableList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper m12096a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8249c;	 Catch:{ all -> 0x006c }
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
        r1 = m12097b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8249c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper) r0;	 Catch:{  }
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
        r0 = f8249c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.PhoneContactFacebookUserDeduper");
    }

    private ImmutableList<UserKey> m12099c(User user) {
        Throwable th;
        Builder builder = ImmutableList.builder();
        ImmutableList r = user.r();
        int size = r.size();
        for (int i = 0; i < size; i++) {
            UserIterator a = this.f8250a.a(ContactCursorsQuery.a().b(((UserPhoneNumber) r.get(i)).b()).e(true));
            Throwable th2 = null;
            while (a.hasNext()) {
                try {
                    builder.c(((User) a.next()).e());
                } catch (Throwable th22) {
                    Throwable th3 = th22;
                    th22 = th;
                    th = th3;
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return builder.b();
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    public void clearUserData() {
        this.f8251b.clear();
    }
}
