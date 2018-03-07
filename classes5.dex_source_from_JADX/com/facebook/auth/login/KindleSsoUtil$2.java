package com.facebook.auth.login;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;

/* compiled from: syncObjectUUIDs */
class KindleSsoUtil$2 implements ServiceConnection {
    final /* synthetic */ KindleSsoUtil f2298a;

    KindleSsoUtil$2(KindleSsoUtil kindleSsoUtil) {
        this.f2298a = kindleSsoUtil;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f2298a) {
            KindleSsoUtil.a(this.f2298a, iBinder);
            ExecutorDetour.a(this.f2298a.b, this.f2298a.i, -1198992373);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
