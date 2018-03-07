package com.facebook.fbservice.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.service.FbService;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: focused_comment_id */
public class BlueService extends FbService {
    private static final Class<?> f23569b = BlueService.class;
    @Inject
    public Lazy<BlueServiceLogic> f23570a;

    private static <T extends Context> void m31905a(Class<T> cls, T t) {
        m31906a((Object) t, (Context) t);
    }

    private static void m31906a(Object obj, Context context) {
        ((BlueService) obj).f23570a = IdBasedSingletonScopeProvider.m1810b(FbInjector.get(context), 1267);
    }

    public final void mo1459a() {
        TracerDetour.a("BlueService.onCreate", -518753481);
        try {
            super.mo1459a();
            m31905a(BlueService.class, (Context) this);
        } finally {
            TracerDetour.a(-341424697);
        }
    }

    public final void mo3462k() {
        super.mo3462k();
        ((BlueServiceLogic) this.f23570a.get()).m32048b();
    }

    public final int mo1458a(Intent intent, int i, int i2) {
        if (intent != null) {
            synchronized (this) {
                String action = intent.getAction();
                if (!"Orca.START".equals(action)) {
                    if ("Orca.STOP".equals(action)) {
                        stopSelf(i2);
                    } else if ("Orca.DRAIN".equals(action)) {
                        ((BlueServiceLogic) this.f23570a.get()).m32044a();
                    }
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return ((BlueServiceLogic) this.f23570a.get()).asBinder();
    }

    public void onRebind(Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1128904757);
        super.onRebind(intent);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -2064956719, a);
    }
}
