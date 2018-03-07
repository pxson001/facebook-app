package com.facebook.push.adm;

import android.content.Intent;
import android.os.IBinder;
import com.amazon.device.messaging.ADM;
import com.facebook.base.service.FbIntentService;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: hvc1 */
public class ADMRegistrarService extends FbIntentService {
    private static final Class<?> f11225a = ADMRegistrarService.class;
    private ADM f11226b;

    public ADMRegistrarService() {
        super("ADMRegistrarService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1698215349);
        super.onCreate();
        try {
            this.f11226b = new ADM(getApplicationContext());
        } catch (Throwable e) {
            BLog.a(f11225a, "Device doesn't support ADM", e);
        }
        LogUtils.d(48354765, a);
    }

    protected final void m13146a(Intent intent) {
        if (this.f11226b != null && this.f11226b.isSupported()) {
            String stringExtra = intent.getStringExtra("REQUEST");
            if ("REGISTER".equals(stringExtra)) {
                m13144b();
            } else if ("UNREGISTER".equals(stringExtra)) {
                m13145c();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1545601860, Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -2037037653));
    }

    private void m13144b() {
        try {
            if (this.f11226b.getRegistrationId() == null) {
                this.f11226b.startRegister();
            }
        } catch (Throwable e) {
            BLog.b(f11225a, "ADM Exception", e);
        }
    }

    private void m13145c() {
        try {
            if (this.f11226b.getRegistrationId() != null) {
                this.f11226b.startUnregister();
            }
        } catch (Throwable e) {
            BLog.b(f11225a, "ADM Exception", e);
        }
    }
}
