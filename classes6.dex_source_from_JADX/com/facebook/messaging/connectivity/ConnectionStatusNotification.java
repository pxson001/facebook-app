package com.facebook.messaging.connectivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BannerNotification;
import com.facebook.common.banner.BannerNotificationAnalyticsHelper;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.common.banner.BasicBannerNotificationView.Params.DisplayMode;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.captiveportal.CaptivePortalUtil;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.State;
import com.facebook.messaging.connectivity.ConnectivityBannerDisplayTracker.DisplayStatus;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_override */
public class ConnectionStatusNotification extends AbstractBannerNotification {
    public final ConnectionStatusMonitor f12008a;
    public final BaseFbBroadcastManager f12009b;
    private final ScheduledExecutorService f12010c;
    public final BaseFbBroadcastManager f12011d;
    private final LayoutInflater f12012e;
    public final BannerNotificationAnalyticsHelper f12013f;
    public final Context f12014g;
    public final SecureContextHelper f12015h;
    public final CaptivePortalUtil f12016i;
    private final ConnectivityBannerDisplayTracker f12017j;
    private ConnectionStatusSurface f12018k;
    public SelfRegistrableReceiverImpl f12019l;
    public SelfRegistrableReceiverImpl f12020m;
    private boolean f12021n;
    private final Provider<SimplifiedConnectivityBannerExperimentController> f12022o;

    /* compiled from: is_override */
    class C07672 implements OnClickListener {
        final /* synthetic */ ConnectionStatusNotification f12001a;

        C07672(ConnectionStatusNotification connectionStatusNotification) {
            this.f12001a = connectionStatusNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1858933591);
            AbstractBannerNotification abstractBannerNotification = this.f12001a;
            Map hashMap = new HashMap();
            hashMap.put("airplane_mode", Boolean.valueOf(abstractBannerNotification.f12008a.d()));
            abstractBannerNotification.f12013f.m11008a("view", "button", abstractBannerNotification.mo921d(), hashMap);
            abstractBannerNotification.f12015h.b(new Intent("android.intent.action.VIEW", abstractBannerNotification.f12016i.a()), abstractBannerNotification.f12014g);
            Logger.a(2, EntryType.UI_INPUT_END, 2011770500, a);
        }
    }

    /* compiled from: is_override */
    public class C07683 implements DialogInterface.OnClickListener {
        final /* synthetic */ ConnectionStatusNotification f12002a;

        public C07683(ConnectionStatusNotification connectionStatusNotification) {
            this.f12002a = connectionStatusNotification;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: is_override */
    public class C07705 implements ActionReceiver {
        final /* synthetic */ ConnectionStatusNotification f12005a;

        public C07705(ConnectionStatusNotification connectionStatusNotification) {
            this.f12005a = connectionStatusNotification;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1004218222);
            ConnectionStatusNotification.m18923l(this.f12005a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1855966725, a);
        }
    }

    /* compiled from: is_override */
    public class C07716 implements ActionReceiver {
        final /* synthetic */ ConnectionStatusNotification f12006a;

        public C07716(ConnectionStatusNotification connectionStatusNotification) {
            this.f12006a = connectionStatusNotification;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 291819369);
            ConnectionStatusNotification.m18923l(this.f12006a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 188942974, a);
        }
    }

    /* compiled from: is_override */
    /* synthetic */ class C07727 {
        static final /* synthetic */ int[] f12007a = new int[State.values().length];

        static {
            try {
                f12007a[State.NO_INTERNET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12007a[State.WAITING_TO_CONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12007a[State.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12007a[State.CONNECTED_CAPTIVE_PORTAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12007a[State.CONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static void m18919f(ConnectionStatusNotification connectionStatusNotification) {
        connectionStatusNotification.f7685a.m11019b((BannerNotification) connectionStatusNotification);
        connectionStatusNotification.f12017j.m18936a(connectionStatusNotification.f12018k, DisplayStatus.HIDDEN);
    }

    private void m18920g() {
        this.f7685a.m11015a((BannerNotification) this);
        final ConnectionStatusMonitor connectionStatusMonitor = this.f12008a;
        if (connectionStatusMonitor.b() && !m18921j(this)) {
            this.f12010c.schedule(new Runnable(this) {
                final /* synthetic */ ConnectionStatusNotification f12004b;

                public void run() {
                    if (connectionStatusMonitor.a() == State.CONNECTED && !ConnectionStatusNotification.m18921j(this.f12004b)) {
                        ConnectionStatusNotification.m18919f(this.f12004b);
                    }
                }
            }, 3000, TimeUnit.MILLISECONDS);
        }
    }

    @Inject
    public ConnectionStatusNotification(ConnectionStatusMonitor connectionStatusMonitor, FbBroadcastManager fbBroadcastManager, FbBroadcastManager fbBroadcastManager2, ScheduledExecutorService scheduledExecutorService, LayoutInflater layoutInflater, BannerNotificationAnalyticsHelper bannerNotificationAnalyticsHelper, Context context, SecureContextHelper secureContextHelper, CaptivePortalUtil captivePortalUtil, Provider<SimplifiedConnectivityBannerExperimentController> provider, ConnectivityBannerDisplayTracker connectivityBannerDisplayTracker, @Assisted ConnectionStatusSurface connectionStatusSurface) {
        super(null);
        this.f12008a = connectionStatusMonitor;
        this.f12009b = fbBroadcastManager;
        this.f12011d = fbBroadcastManager2;
        this.f12012e = layoutInflater;
        this.f12010c = scheduledExecutorService;
        this.f12013f = bannerNotificationAnalyticsHelper;
        this.f12014g = context;
        this.f12015h = secureContextHelper;
        this.f12016i = captivePortalUtil;
        this.f12022o = provider;
        this.f12018k = connectionStatusSurface;
        this.f12017j = connectivityBannerDisplayTracker;
    }

    public final void mo920c() {
        this.f12019l.c();
        this.f12020m.c();
    }

    public final View mo1084a(ViewGroup viewGroup) {
        DisplayStatus displayStatus;
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f12012e.inflate(2130903387, viewGroup, false);
        ConnectionStatusMonitor connectionStatusMonitor = this.f12008a;
        SimplifiedConnectivityBannerExperimentController simplifiedConnectivityBannerExperimentController = (SimplifiedConnectivityBannerExperimentController) this.f12022o.get();
        CharSequence a;
        Builder builder;
        Builder builder2;
        switch (C07727.f12007a[connectionStatusMonitor.a().ordinal()]) {
            case 1:
                if (!connectionStatusMonitor.d()) {
                    final Params a2 = simplifiedConnectivityBannerExperimentController.a();
                    basicBannerNotificationView.setParams(a2);
                    displayStatus = DisplayStatus.NO_INTERNET;
                    if (a2.f7703e) {
                        basicBannerNotificationView.setOnBannerButtonClickListener(new OnClickListener(this) {
                            final /* synthetic */ ConnectionStatusNotification f12000b;

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, -532715052);
                                ConnectionStatusNotification connectionStatusNotification = this.f12000b;
                                new FbAlertDialogBuilder(connectionStatusNotification.f12014g).a(a2.f7699a).b(2131231849).a(2131230726, new C07683(connectionStatusNotification)).b();
                                Logger.a(2, EntryType.UI_INPUT_END, 1484237299, a);
                            }
                        });
                        break;
                    }
                }
                basicBannerNotificationView.setParams(simplifiedConnectivityBannerExperimentController.b());
                displayStatus = DisplayStatus.AIRPLANE_MODE;
                break;
                break;
            case 2:
                if (!connectionStatusMonitor.d()) {
                    a = simplifiedConnectivityBannerExperimentController.a.a(ExperimentsForMessagesConnectivityModule.j, simplifiedConnectivityBannerExperimentController.c.getString(2131231842));
                    builder = simplifiedConnectivityBannerExperimentController.d;
                    builder.a = a;
                    builder2 = builder;
                    builder2.c = simplifiedConnectivityBannerExperimentController.c.getDrawable(2131362430);
                    builder2 = builder2;
                    builder2.h = DisplayMode.ALWAYS;
                    builder2 = builder2;
                    builder2.d = false;
                    basicBannerNotificationView.setParams(builder2.a());
                    displayStatus = DisplayStatus.WAITING_TO_CONNECT;
                    break;
                }
                basicBannerNotificationView.setParams(simplifiedConnectivityBannerExperimentController.b());
                displayStatus = DisplayStatus.AIRPLANE_MODE;
                break;
            case 3:
                if (!m18922k()) {
                    a = simplifiedConnectivityBannerExperimentController.a.a(ExperimentsForMessagesConnectivityModule.f, simplifiedConnectivityBannerExperimentController.c.getString(2131230808));
                    builder = simplifiedConnectivityBannerExperimentController.d;
                    builder.a = a;
                    builder2 = builder;
                    builder2.c = simplifiedConnectivityBannerExperimentController.c.getDrawable(2131362431);
                    builder2 = builder2;
                    builder2.h = DisplayMode.ALWAYS;
                    builder2 = builder2;
                    builder2.b = true;
                    builder2 = builder2;
                    builder2.d = false;
                    basicBannerNotificationView.setParams(builder2.a());
                    displayStatus = DisplayStatus.CONNECTING;
                    break;
                }
                basicBannerNotificationView.setParams(simplifiedConnectivityBannerExperimentController.b());
                displayStatus = DisplayStatus.AIRPLANE_MODE;
                break;
            case 4:
                a = simplifiedConnectivityBannerExperimentController.a.a(ExperimentsForMessagesConnectivityModule.b, simplifiedConnectivityBannerExperimentController.c.getString(2131231844));
                builder = simplifiedConnectivityBannerExperimentController.d;
                builder.a = a;
                builder2 = builder;
                builder2.c = simplifiedConnectivityBannerExperimentController.c.getDrawable(2131362433);
                builder2 = builder2;
                builder2.h = DisplayMode.ALWAYS;
                builder2 = builder2;
                builder2.b = false;
                builder2 = builder2;
                builder2.d = true;
                builder2 = builder2;
                builder2.e = simplifiedConnectivityBannerExperimentController.b.getString(2131231845);
                basicBannerNotificationView.setParams(builder2.a());
                basicBannerNotificationView.setOnBannerButtonClickListener(new C07672(this));
                displayStatus = DisplayStatus.CAPTIVE_PORTAL;
                break;
            default:
                if (!m18922k()) {
                    a = simplifiedConnectivityBannerExperimentController.a.a(ExperimentsForMessagesConnectivityModule.e, simplifiedConnectivityBannerExperimentController.c.getString(2131230809));
                    builder = simplifiedConnectivityBannerExperimentController.d;
                    builder.a = a;
                    builder2 = builder;
                    builder2.c = simplifiedConnectivityBannerExperimentController.c.getDrawable(2131362432);
                    builder2 = builder2;
                    builder2.h = DisplayMode.ALWAYS;
                    builder2 = builder2;
                    builder2.b = false;
                    builder2 = builder2;
                    builder2.d = false;
                    basicBannerNotificationView.setParams(builder2.a());
                    displayStatus = DisplayStatus.CONNECTED;
                    break;
                }
                basicBannerNotificationView.setParams(simplifiedConnectivityBannerExperimentController.b());
                displayStatus = DisplayStatus.AIRPLANE_MODE;
                break;
        }
        this.f12017j.m18936a(this.f12018k, displayStatus);
        return basicBannerNotificationView;
    }

    public final String mo921d() {
        switch (C07727.f12007a[this.f12008a.a().ordinal()]) {
            case 1:
                return "ConnectionStatusNotification - No Internet";
            case 2:
                return "ConnectionStatusNotification - Waiting To Connect";
            case 3:
                return "ConnectionStatusNotification - Connecting";
            case 4:
                return "ConnectionStatusNotification - Connected To Captive Portal";
            default:
                return "ConnectionStatusNotification - Connected";
        }
    }

    public final void m18925a(boolean z) {
        this.f12021n = z;
        m18918e();
    }

    private void m18918e() {
        if (!this.f12008a.b() || m18921j(this)) {
            m18920g();
        } else {
            m18919f(this);
        }
    }

    public final void mo919b() {
        if (this.f12019l == null) {
            this.f12019l = this.f12009b.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", new C07705(this)).a();
        }
        if (this.f12020m == null) {
            this.f12020m = this.f12011d.a().a("android.intent.action.AIRPLANE_MODE", new C07716(this)).a();
        }
        this.f12019l.b();
        this.f12020m.b();
        m18918e();
    }

    public static void m18923l(ConnectionStatusNotification connectionStatusNotification) {
        Object obj;
        ConnectionStatusMonitor connectionStatusMonitor = connectionStatusNotification.f12008a;
        if (connectionStatusMonitor.b() && connectionStatusMonitor.c() && !m18921j(connectionStatusNotification)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            connectionStatusNotification.m18920g();
        } else {
            m18919f(connectionStatusNotification);
        }
    }

    public static boolean m18921j(ConnectionStatusNotification connectionStatusNotification) {
        return connectionStatusNotification.m18922k() || connectionStatusNotification.f12008a.a() == State.CONNECTED_CAPTIVE_PORTAL;
    }

    private boolean m18922k() {
        return this.f12021n && this.f12008a.d();
    }
}
