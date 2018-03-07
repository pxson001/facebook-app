package com.facebook.katana.net;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.accessibility.AccessibilityManager;
import com.facebook.common.process.ProcessName;
import com.facebook.debug.log.BLog;
import com.facebook.inject.AbstractProvider;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: send_to_pending_thread */
public class Fb4aUserAgentOptionsProvider extends AbstractProvider<String> {
    private final ProcessName f5588a;
    private final ProcessName f5589b;
    private final ApplicationInfo f5590c;
    private final AccessibilityManager f5591d;

    public /* synthetic */ Object get() {
        return m9545a();
    }

    public Fb4aUserAgentOptionsProvider(ProcessName processName, ProcessName processName2, ApplicationInfo applicationInfo, Context context) {
        this.f5588a = processName;
        this.f5589b = processName2;
        this.f5590c = applicationInfo;
        this.f5591d = m9544a(context);
    }

    private static AccessibilityManager m9544a(Context context) {
        try {
            return (AccessibilityManager) context.getSystemService("accessibility");
        } catch (Throwable e) {
            BLog.b("Fb4aUserAgentOptionsProvider", "Could not initialize accessibility manager", e);
            return null;
        }
    }

    public final String m9545a() {
        int i = 1;
        String c = this.f5588a.c();
        if (c != null && c.compareToIgnoreCase(this.f5589b.c()) == 0) {
            i = 3;
        }
        if ((this.f5590c.flags & 1) != 0) {
            i |= 8;
        }
        if ((this.f5590c.flags & HTTPTransportCallback.BODY_BYTES_RECEIVED) != 0) {
            i |= 16;
        }
        if (this.f5591d != null && this.f5591d.isEnabled() && this.f5591d.isTouchExplorationEnabled()) {
            i |= 64;
        }
        return Integer.toHexString(i);
    }
}
