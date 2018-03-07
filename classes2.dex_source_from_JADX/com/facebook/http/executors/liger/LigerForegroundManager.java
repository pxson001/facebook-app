package com.facebook.http.executors.liger;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPClient;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.List;
import javax.inject.Inject;

/* compiled from: number_resolvers */
public class LigerForegroundManager {
    private static final String[] f11843a = new String[0];
    private final MostRecentHostsStorage f11844b;
    private final QeAccessor f11845c;
    private final HTTPClient f11846d;
    public final AnalyticsLogger f11847e;
    public final AppStateManager f11848f;
    private final SelfRegistrableReceiverImpl f11849g;

    /* compiled from: number_resolvers */
    public class C04922 implements ActionReceiver {
        final /* synthetic */ LigerForegroundManager f11850a;

        public C04922(LigerForegroundManager ligerForegroundManager) {
            this.f11850a = ligerForegroundManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1285645664);
            LigerForegroundManager.m17175a(this.f11850a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1222963687, a);
        }
    }

    /* compiled from: number_resolvers */
    class C04951 implements Runnable {
        final /* synthetic */ LigerForegroundManager f11877a;

        C04951(LigerForegroundManager ligerForegroundManager) {
            this.f11877a = ligerForegroundManager;
        }

        public void run() {
            LigerForegroundManager.m17175a(this.f11877a);
        }
    }

    @Inject
    public LigerForegroundManager(BaseFbBroadcastManager baseFbBroadcastManager, MostRecentHostsStorage mostRecentHostsStorage, Handler handler, AppStateManager appStateManager, QeAccessor qeAccessor, AnalyticsLogger analyticsLogger, @Assisted HTTPClient hTTPClient) {
        this.f11844b = mostRecentHostsStorage;
        this.f11845c = qeAccessor;
        this.f11846d = hTTPClient;
        this.f11847e = analyticsLogger;
        this.f11848f = appStateManager;
        this.f11849g = baseFbBroadcastManager.m2951a().mo506a(AppStateManager.f1110b, new C04922(this)).mo505a(handler).mo503a();
        this.f11849g.m3296b();
        if (this.f11848f.m2264l()) {
            HandlerDetour.a(handler, new C04951(this), 1798663113);
        }
    }

    public static void m17175a(LigerForegroundManager ligerForegroundManager) {
        if (ligerForegroundManager.f11845c.mo596a(ExperimentsForHttpQeModule.aY, false)) {
            List<String> a = ligerForegroundManager.f11844b.m13634a(ligerForegroundManager.f11845c.mo572a(ExperimentsForHttpQeModule.aZ, 0));
            if (!a.isEmpty()) {
                ligerForegroundManager.f11846d.connect((String[]) a.toArray(f11843a));
            }
            for (String str : a) {
                HoneyClientEventFast a2 = ligerForegroundManager.f11847e.mo535a("liger_foreground_preconnect", false);
                if (a2.m17388a()) {
                    a2.m17385a("host", str);
                    a2.m17382a("time_since_init", ligerForegroundManager.f11848f.m2258d());
                    a2.m17390b();
                }
            }
        }
    }
}
