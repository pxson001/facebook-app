package com.facebook.analytics.anrwatchdog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.AndroidReliabilityXConfig;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.xconfig.core.XConfigReader;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_get_media_fbid_failed */
public class ANRDetectorController implements INeedInit {
    private final Provider<ANRDetector> f7988a;
    private final ActionReceiver f7989b = new C03891(this);
    private final ActionReceiver f7990c = new C03902(this);
    private final BaseFbBroadcastManager f7991d;
    private final AppStateManager f7992e;
    private final Provider<TriState> f7993f;
    @BackgroundBroadcastThread
    private final Handler f7994g;
    private final AbstractFbErrorReporter f7995h;
    private final XConfigReader f7996i;
    @GuardedBy("this")
    private ANRDetectorThread f7997j;

    /* compiled from: messenger_get_media_fbid_failed */
    class C03891 implements ActionReceiver {
        final /* synthetic */ ANRDetectorController f7998a;

        C03891(ANRDetectorController aNRDetectorController) {
            this.f7998a = aNRDetectorController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1651746466);
            this.f7998a.m8316b();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1971150254, a);
        }
    }

    /* compiled from: messenger_get_media_fbid_failed */
    class C03902 implements ActionReceiver {
        final /* synthetic */ ANRDetectorController f7999a;

        C03902(ANRDetectorController aNRDetectorController) {
            this.f7999a = aNRDetectorController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1827856569);
            this.f7999a.m8314a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -609615700, a);
        }
    }

    @Inject
    public ANRDetectorController(Provider<ANRDetector> provider, FbBroadcastManager fbBroadcastManager, AppStateManager appStateManager, Provider<TriState> provider2, Handler handler, FbErrorReporter fbErrorReporter, XConfigReader xConfigReader) {
        this.f7988a = provider;
        this.f7991d = fbBroadcastManager;
        this.f7992e = appStateManager;
        this.f7993f = provider2;
        this.f7994g = handler;
        this.f7995h = fbErrorReporter;
        this.f7996i = xConfigReader;
    }

    public void init() {
        if (!this.f7992e.j()) {
            m8316b();
        }
        this.f7991d.a().a(AppStateManager.b, this.f7989b).a(this.f7994g).a().b();
        this.f7991d.a().a(AppStateManager.c, this.f7990c).a(this.f7994g).a().b();
    }

    public final void m8319a(Throwable th) {
        m8314a();
        this.f7995h.a("ANRDetectorController.onDetectorError", th);
    }

    private synchronized void m8314a() {
        if (this.f7997j != null) {
            this.f7997j.a();
            this.f7997j = null;
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    private synchronized void m8316b() {
        if (this.f7997j == null && m8318c()) {
            int a = this.f7996i.a(AndroidReliabilityXConfig.f1649d, 5);
            Integer.valueOf(a);
            this.f7995h.c("anr_timeout_delay", String.valueOf(a));
            this.f7997j = new ANRDetectorThread(this, (ANRDetector) this.f7988a.get(), (long) a);
            this.f7997j.start();
        }
    }

    private boolean m8318c() {
        return ((TriState) this.f7993f.get()).asBoolean(false);
    }
}
