package com.facebook.appupdate;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Pair;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: UN_SPECIFIED */
public abstract class WaitForInitService extends Service {
    private boolean f23795a = false;
    public boolean f23796b = false;
    public final List<Pair<Intent, Integer>> f23797c = new ArrayList();
    public final Set<Integer> f23798d = new HashSet();
    public int f23799e = -1;
    public volatile Handler f23800f;
    private final InitWithInjector f23801g = new C28872(this);

    /* compiled from: UN_SPECIFIED */
    class C28872 implements InitWithInjector {
        final /* synthetic */ WaitForInitService f23838a;

        C28872(WaitForInitService waitForInitService) {
            this.f23838a = waitForInitService;
        }

        public final void mo1101a(final AppUpdateInjector appUpdateInjector) {
            appUpdateInjector.e().a();
            this.f23838a.f23800f = appUpdateInjector.i();
            HandlerDetour.a(this.f23838a.f23800f, new Runnable(this) {
                final /* synthetic */ C28872 f23837b;

                public void run() {
                    this.f23837b.f23838a.mo1099a(appUpdateInjector);
                    for (Pair pair : this.f23837b.f23838a.f23797c) {
                        WaitForInitService.m25808a(this.f23837b.f23838a, (Intent) pair.first, ((Integer) pair.second).intValue());
                    }
                    this.f23837b.f23838a.f23796b = true;
                }
            }, -1980536462);
        }
    }

    protected abstract void mo1099a(AppUpdateInjector appUpdateInjector);

    protected abstract boolean mo1100a(Intent intent);

    public int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1660642353);
        super.onStartCommand(intent, i, i2);
        if (this.f23796b) {
            m25808a(this, intent, i2);
        } else {
            if (!this.f23795a) {
                AppUpdateInjector.a(this.f23801g);
                this.f23795a = true;
            }
            this.f23797c.add(new Pair(intent, Integer.valueOf(i2)));
        }
        LogUtils.d(-1591605437, a);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 390726101);
        super.onDestroy();
        AppUpdateInjector.b(this.f23801g);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1514796513, a);
    }

    public static void m25808a(WaitForInitService waitForInitService, Intent intent, int i) {
        waitForInitService.f23799e = Math.max(waitForInitService.f23799e, i);
        waitForInitService.f23798d.add(Integer.valueOf(i));
        if (!waitForInitService.mo1100a(intent)) {
            waitForInitService.f23798d.remove(Integer.valueOf(i));
            if (waitForInitService.f23796b && waitForInitService.f23798d.isEmpty()) {
                waitForInitService.stopSelf(waitForInitService.f23799e);
            }
        }
    }
}
