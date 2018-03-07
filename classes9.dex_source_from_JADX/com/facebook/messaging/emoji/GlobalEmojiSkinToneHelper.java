package com.facebook.messaging.emoji;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefs;
import com.facebook.messaging.prefs.omnistore.MessengerOmnistoreUserPrefsKey;
import com.google.common.base.Optional;
import javax.inject.Inject;

@UserScoped
/* compiled from: mangle_accept_crypto */
public class GlobalEmojiSkinToneHelper {
    private static final String f10972a = GlobalEmojiSkinToneHelper.class.getSimpleName();
    private static final Object f10973c = new Object();
    private MessengerOmnistoreUserPrefs f10974b;

    private static GlobalEmojiSkinToneHelper m11382b(InjectorLike injectorLike) {
        return new GlobalEmojiSkinToneHelper(MessengerOmnistoreUserPrefs.a(injectorLike));
    }

    @Inject
    public GlobalEmojiSkinToneHelper(MessengerOmnistoreUserPrefs messengerOmnistoreUserPrefs) {
        this.f10974b = messengerOmnistoreUserPrefs;
    }

    public final int m11383a() {
        Optional b = this.f10974b.b(MessengerOmnistoreUserPrefsKey.EMOJI_COLOR_PREF);
        return b.isPresent() ? ((Integer) b.get()).intValue() : 0;
    }

    public final void m11384a(int i) {
        try {
            this.f10974b.a(MessengerOmnistoreUserPrefsKey.EMOJI_COLOR_PREF, i);
        } catch (Throwable e) {
            BLog.a(f10972a, "Failed to save emoji color pref to omnistore.", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper m11381a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10973c;	 Catch:{ all -> 0x006c }
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
        r1 = m11382b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10973c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper) r0;	 Catch:{  }
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
        r0 = f10973c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.emoji.GlobalEmojiSkinToneHelper");
    }
}
