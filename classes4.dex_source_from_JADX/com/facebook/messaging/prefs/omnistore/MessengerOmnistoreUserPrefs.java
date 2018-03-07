package com.facebook.messaging.prefs.omnistore;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Cursor;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.nio.ByteBuffer;
import javax.inject.Inject;

@UserScoped
/* compiled from: groups */
public class MessengerOmnistoreUserPrefs {
    private static final Object f10946b = new Object();
    private final MessengerUserPrefsOmnistoreComponent f10947a;

    private static MessengerOmnistoreUserPrefs m11389b(InjectorLike injectorLike) {
        return new MessengerOmnistoreUserPrefs(MessengerUserPrefsOmnistoreComponent.m10091a(injectorLike));
    }

    @Inject
    public MessengerOmnistoreUserPrefs(MessengerUserPrefsOmnistoreComponent messengerUserPrefsOmnistoreComponent) {
        this.f10947a = messengerUserPrefsOmnistoreComponent;
    }

    public final Optional<Boolean> m11390a(MessengerOmnistoreUserPrefsKey messengerOmnistoreUserPrefsKey) {
        Optional b = m11393b(messengerOmnistoreUserPrefsKey);
        if (!b.isPresent()) {
            return Absent.INSTANCE;
        }
        return Optional.of(Boolean.valueOf(((Integer) b.get()).intValue() > 0));
    }

    public final void m11392a(MessengerOmnistoreUserPrefsKey messengerOmnistoreUserPrefsKey, boolean z) {
        m11391a(messengerOmnistoreUserPrefsKey, z ? 1 : 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs m11388a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10946b;	 Catch:{ all -> 0x006c }
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
        r1 = m11389b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10946b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs) r0;	 Catch:{  }
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
        r0 = f10946b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs");
    }

    public final Optional<Integer> m11393b(MessengerOmnistoreUserPrefsKey messengerOmnistoreUserPrefsKey) {
        Collection collection = this.f10947a.f9659d;
        if (collection == null) {
            return Absent.INSTANCE;
        }
        Cursor object = collection.getObject(messengerOmnistoreUserPrefsKey.keyString);
        return object.step() ? Optional.of(Integer.valueOf(object.getBlob().getInt())) : Absent.INSTANCE;
    }

    public final void m11391a(MessengerOmnistoreUserPrefsKey messengerOmnistoreUserPrefsKey, int i) {
        Collection collection = this.f10947a.f9659d;
        if (collection == null) {
            throw new MessengerOmnistoreUserPrefsException("Unable to access messenger_user_prefs collection to write");
        }
        collection.saveObject(messengerOmnistoreUserPrefsKey.keyString, "", ByteBuffer.allocate(4).putInt(i).array());
    }
}
