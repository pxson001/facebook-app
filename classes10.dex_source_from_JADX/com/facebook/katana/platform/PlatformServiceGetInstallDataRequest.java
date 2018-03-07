package com.facebook.katana.platform;

import android.os.Message;
import com.facebook.platform.common.service.PlatformServiceRequest;

/* compiled from: turn */
public class PlatformServiceGetInstallDataRequest extends PlatformServiceRequest {
    private String f1144a;

    public final String m1171e() {
        return this.f1144a;
    }

    protected final int m1169a() {
        return 65541;
    }

    protected final boolean m1170a(Message message) {
        this.f1144a = message.getData().getString("com.facebook.platform.extra.INSTALLDATA_PACKAGE");
        return true;
    }

    public static Message m1168b(Message message) {
        Message obtain = Message.obtain(message);
        obtain.setData(message.getData());
        obtain.what = 65541;
        return obtain;
    }
}
