package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.internal.zzx;

public class zzq extends BroadcastReceiver {
    static final String f258a = zzq.class.getName();
    public final zzt f259b;
    private boolean f260c;
    private boolean f261d;

    public zzq(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzt);
        this.f259b = com_google_android_gms_measurement_internal_zzt;
    }

    private boolean m545c() {
        this.f259b.m100o();
        return this.f260c;
    }

    private Context m546d() {
        return this.f259b.f29c;
    }

    private zzo m547e() {
        return this.f259b.m93f();
    }

    public final void m548a() {
        this.f259b.m83a();
        this.f259b.m100o();
        if (!this.f260c) {
            m546d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f261d = this.f259b.m96j().m462b();
            m547e().f211m.m356a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f261d));
            this.f260c = true;
        }
    }

    public final void m549b() {
        this.f259b.m83a();
        this.f259b.m100o();
        if (m545c()) {
            m547e().m350t().m355a("Unregistering connectivity change receiver");
            this.f260c = false;
            this.f261d = false;
            try {
                m546d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m547e().m335b().m356a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 226807440);
        this.f259b.m83a();
        String action = intent.getAction();
        m547e().f211m.m356a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean b = this.f259b.m96j().m462b();
            if (this.f261d != b) {
                this.f261d = b;
                this.f259b.m94g().m555a(new 1(this, b));
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -357042370, a);
            return;
        }
        m547e().f206h.m356a("NetworkBroadcastReceiver received unknown action", action);
        LogUtils.a(intent, 394778243, a);
    }
}
