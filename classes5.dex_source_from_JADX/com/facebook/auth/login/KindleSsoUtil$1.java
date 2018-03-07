package com.facebook.auth.login;

import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: syncObjectUUIDs */
class KindleSsoUtil$1 implements FutureCallback<String> {
    final /* synthetic */ KindleSsoUtil f2297a;

    KindleSsoUtil$1(KindleSsoUtil kindleSsoUtil) {
        this.f2297a = kindleSsoUtil;
    }

    public void onSuccess(Object obj) {
        m3190b();
    }

    public void onFailure(Throwable th) {
        m3190b();
    }

    private void m3190b() {
        synchronized (this.f2297a) {
            ServiceConnectionDetour.a(this.f2297a.d, this.f2297a.h, -653854969);
            KindleSsoUtil.a(this.f2297a, null);
            KindleSsoUtil.a(this.f2297a, null);
        }
    }
}
