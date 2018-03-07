package com.facebook.rtc.fbwebrtc;

import android.content.Context;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

@UserScoped
/* compiled from: audio/mid */
public class VoipStatusHandler {
    private static final Object f19379c = new Object();
    private Context f19380a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19381b = UltralightRuntime.b;

    private static VoipStatusHandler m19363b(InjectorLike injectorLike) {
        VoipStatusHandler voipStatusHandler = new VoipStatusHandler((Context) injectorLike.getInstance(Context.class));
        voipStatusHandler.f19381b = IdBasedLazy.a(injectorLike, 10375);
        return voipStatusHandler;
    }

    @Inject
    private VoipStatusHandler(Context context) {
        this.f19380a = context;
    }

    public final boolean m19364a() {
        if (((WebrtcUiHandler) this.f19381b.get()).ak == 0 || ((WebrtcUiHandler) this.f19381b.get()).ak == 1) {
            return false;
        }
        if (((WebrtcUiHandler) this.f19381b.get()).aH()) {
            return false;
        }
        if (((WebrtcUiHandler) this.f19381b.get()).m19478k()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.rtc.fbwebrtc.VoipStatusHandler m19362a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f19379c;	 Catch:{ all -> 0x006c }
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
        r1 = m19363b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19379c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtc.VoipStatusHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.rtc.fbwebrtc.VoipStatusHandler) r0;	 Catch:{  }
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
        r0 = f19379c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.rtc.fbwebrtc.VoipStatusHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.VoipStatusHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.VoipStatusHandler");
    }

    public final String m19365b() {
        String string;
        if (((WebrtcUiHandler) this.f19381b.get()).aB()) {
            if (((WebrtcUiHandler) this.f19381b.get()).aA()) {
                string = this.f19380a.getString(2131232003);
            } else {
                string = this.f19380a.getString(2131232004);
            }
        } else if (((WebrtcUiHandler) this.f19381b.get()).aH) {
            string = this.f19380a.getString(2131232092);
        } else {
            string = ((WebrtcUiHandler) this.f19381b.get()).m19438O();
        }
        return this.f19380a.getString(2131232034, new Object[]{string});
    }

    public final void m19366c() {
        ((WebrtcUiHandler) this.f19381b.get()).aG();
    }
}
