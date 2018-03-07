package com.facebook.http.executors.liger;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellSignalStrength;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.carrier.CarrierMonitor;
import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.observer.TimeInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.AnalyticsLogger;
import com.facebook.proxygen.EventBase;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.proxygen.NetworkStatus;
import com.facebook.proxygen.NetworkStatusMonitor;
import com.facebook.proxygen.NetworkType$CellularType;
import com.facebook.proxygen.NetworkType$ConnectivityType;
import com.google.common.base.Optional;

/* compiled from: profile_self */
public class LigerNetworkStatusMonitor extends NetworkStatusMonitor implements NetworkInfoCollector {
    private final int f8809a;
    private final int f8810b;
    private final int f8811c;
    private final CarrierMonitor f8812d;
    public final FbNetworkManager f8813e;
    private final CellDiagnosticsSerializer f8814f;
    private final Context f8815g;
    private BaseFbBroadcastManager f8816h;
    private AppStateManager f8817i;
    private int f8818j;
    private int f8819k;
    private int f8820l;
    private int f8821m;

    /* compiled from: profile_self */
    class C03811 implements ActionReceiver {
        final /* synthetic */ LigerNetworkStatusMonitor f8826a;

        C03811(LigerNetworkStatusMonitor ligerNetworkStatusMonitor) {
            this.f8826a = ligerNetworkStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -158298559);
            this.f8826a.m13648a(this.f8826a.f8813e.m3833i());
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 656361074, a);
        }
    }

    /* compiled from: profile_self */
    class C03822 implements ActionReceiver {
        final /* synthetic */ LigerNetworkStatusMonitor f8827a;

        C03822(LigerNetworkStatusMonitor ligerNetworkStatusMonitor) {
            this.f8827a = ligerNetworkStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -45440076);
            this.f8827a.setAppForegrounded(true);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -680445147, a);
        }
    }

    /* compiled from: profile_self */
    class C03833 implements ActionReceiver {
        final /* synthetic */ LigerNetworkStatusMonitor f8828a;

        C03833(LigerNetworkStatusMonitor ligerNetworkStatusMonitor) {
            this.f8828a = ligerNetworkStatusMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1429230265);
            this.f8828a.setAppForegrounded(false);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1228357572, a);
        }
    }

    public LigerNetworkStatusMonitor(Context context, EventBase eventBase, int i, int i2, int i3, CarrierMonitor carrierMonitor, FbNetworkManager fbNetworkManager, BaseFbBroadcastManager baseFbBroadcastManager, CellDiagnosticsSerializer cellDiagnosticsSerializer, boolean z, String str, int i4, String str2, int i5, int i6, AppStateManager appStateManager, AnalyticsLogger analyticsLogger, boolean z2) {
        super(eventBase);
        this.f8815g = context;
        this.f8809a = i;
        this.f8811c = i2;
        this.f8810b = i3;
        this.f8812d = carrierMonitor;
        this.f8813e = fbNetworkManager;
        this.f8816h = baseFbBroadcastManager;
        this.f8814f = cellDiagnosticsSerializer;
        this.f8817i = appStateManager;
        setAnalyticsLogger(analyticsLogger);
        setRadioMonitorEnabled(z2);
        setDNSReachabilityEnabled(z);
        setDNSServer(str);
        setDNSPort(i4);
        setHostname(str2);
        setDNSReachabilityIntervalMs(i5);
        setDNSReachabilityDefaultTimeoutMs(i6);
        setCacheDuration(this.f8811c);
        init(this.f8809a);
        m13648a(this.f8813e.m3833i());
        m13646j();
    }

    public final void m13655g() {
        ActionReceiver c03811 = new C03811(this);
        ActionReceiver c03822 = new C03822(this);
        ActionReceiver c03833 = new C03833(this);
        this.f8816h.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", c03811).mo503a().m3296b();
        this.f8816h.m2951a().mo506a(AppStateManager.f1110b, c03822).mo503a().m3296b();
        this.f8816h.m2951a().mo506a(AppStateManager.f1111c, c03833).mo503a().m3296b();
    }

    private void m13646j() {
        try {
            if (VERSION.SDK_INT >= 17) {
                this.f8818j = Global.getInt(this.f8815g.getContentResolver(), "auto_time");
                this.f8819k = Global.getInt(this.f8815g.getContentResolver(), "auto_time_zone");
                return;
            }
            this.f8818j = System.getInt(this.f8815g.getContentResolver(), "auto_time");
            this.f8819k = System.getInt(this.f8815g.getContentResolver(), "auto_time_zone");
        } catch (Exception e) {
        }
    }

    @TargetApi(18)
    public final void m13648a(NetworkInfo networkInfo) {
        this.f8820l = -1;
        this.f8821m = 0;
        NetworkType$ConnectivityType networkType$ConnectivityType = NetworkType$ConnectivityType.NOCONN;
        NetworkType$CellularType networkType$CellularType = NetworkType$CellularType.NOT_CELLULAR;
        if (networkInfo != null && networkInfo.isConnected()) {
            this.f8820l = networkInfo.getType();
            this.f8821m = networkInfo.getSubtype();
            switch (this.f8820l) {
                case 0:
                    networkType$ConnectivityType = NetworkType$ConnectivityType.CELLULAR;
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    networkType$ConnectivityType = NetworkType$ConnectivityType.WIFI;
                    break;
                case 6:
                    networkType$ConnectivityType = NetworkType$ConnectivityType.CELLULAR;
                    networkType$CellularType = NetworkType$CellularType.G4;
                    break;
                default:
                    networkType$ConnectivityType = NetworkType$ConnectivityType.OTHER;
                    break;
            }
            if (this.f8820l == 0) {
                switch (this.f8821m) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    case 7:
                    case 11:
                        networkType$CellularType = NetworkType$CellularType.G2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        networkType$CellularType = NetworkType$CellularType.G3;
                        break;
                    case 13:
                        networkType$CellularType = NetworkType$CellularType.G4;
                        break;
                    default:
                        networkType$CellularType = NetworkType$CellularType.UNKNOWN;
                        break;
                }
            }
        }
        setNetworkType(networkType$ConnectivityType.value, networkType$CellularType.value);
    }

    public final void mo496a(NetworkInfoCollector networkInfoCollector) {
    }

    public final int mo498c() {
        return this.f8809a;
    }

    public final int mo499d() {
        return this.f8811c;
    }

    public final int mo500e() {
        return this.f8810b;
    }

    public final boolean mo501f() {
        return true;
    }

    @TargetApi(18)
    public final com.facebook.http.observer.NetworkInfo mo495a() {
        NetworkStatus networkStatus = getNetworkStatus();
        if (networkStatus == null) {
            return null;
        }
        int i;
        int i2;
        int i3;
        int s;
        long j;
        long j2;
        long j3;
        Long valueOf;
        Long valueOf2;
        Double valueOf3;
        Long valueOf4;
        Long valueOf5;
        Long valueOf6;
        Optional f = this.f8813e.m3830f();
        Optional d = this.f8812d.m12311d();
        boolean z = f.isPresent() ? ((Long) f.get()).longValue() < ((long) (this.f8809a * 1000)) : false;
        boolean z2 = d.isPresent() ? ((Long) d.get()).longValue() < ((long) (this.f8809a * 1000)) : false;
        int i4 = 0;
        int i5 = 0;
        if (this.f8820l == 1) {
            int i6;
            WifiInfo o = this.f8813e.m3838o();
            if (o != null) {
                i4 = o.getRssi();
                if (VERSION.SDK_INT >= 21) {
                    i5 = o.getFrequency();
                }
                i6 = i5;
                i5 = o.getLinkSpeed();
            } else {
                i6 = 0;
                i5 = 0;
            }
            i = i5;
            i2 = i6;
            i3 = i4;
            s = this.f8813e.m3842s();
        } else {
            if (this.f8820l == 0) {
                CellSignalStrength a = this.f8814f.m13585a(this.f8821m);
                if (a != null) {
                    int level = a.getLevel();
                    i = 0;
                    i2 = 0;
                    i3 = a.getDbm();
                    s = level;
                }
            }
            i = 0;
            i2 = 0;
            i3 = 0;
            s = 0;
        }
        String str = "disabled";
        if (isDNSReachabilityEnabled()) {
            str = networkStatus.getDNSReachability();
        }
        long[] priReqInflight = networkStatus.getPriReqInflight();
        if (priReqInflight == null || priReqInflight.length < 3) {
            j = -1;
            j2 = -1;
            j3 = -1;
        } else {
            long j4 = priReqInflight[2];
            long j5 = priReqInflight[1];
            j = priReqInflight[0];
            j2 = j5;
            j3 = j4;
        }
        Long valueOf7 = Long.valueOf(networkStatus.getIngressAvg());
        Long valueOf8 = Long.valueOf(networkStatus.getIngressMax());
        Long valueOf9 = Long.valueOf(networkStatus.getEgressAvg());
        Long valueOf10 = Long.valueOf(networkStatus.getEgressMax());
        Long valueOf11 = Long.valueOf(networkStatus.getReadCount());
        Long valueOf12 = Long.valueOf(networkStatus.getWriteCount());
        if (networkStatus.getRttAvg() != -1) {
            valueOf = Long.valueOf(networkStatus.getRttAvg());
        } else {
            valueOf = null;
        }
        if (networkStatus.getRttMax() != -1) {
            valueOf2 = Long.valueOf(networkStatus.getRttMax());
        } else {
            valueOf2 = null;
        }
        if (Math.abs(-1.0d - networkStatus.getRttStdDev()) > Math.ulp(1.0d)) {
            valueOf3 = Double.valueOf(networkStatus.getRttStdDev());
        } else {
            valueOf3 = null;
        }
        Boolean valueOf13 = Boolean.valueOf(z);
        Boolean valueOf14 = Boolean.valueOf(z2);
        Long valueOf15 = Long.valueOf(networkStatus.getOpenedConn());
        Long valueOf16 = Long.valueOf(networkStatus.getClosedConn());
        Long valueOf17 = Long.valueOf(networkStatus.getInflightConn());
        Long valueOf18 = Long.valueOf(networkStatus.getEnqueuedReq());
        Long valueOf19 = Long.valueOf(networkStatus.getDequeuedReq());
        Long valueOf20 = Long.valueOf(networkStatus.getFinishedReq());
        Long valueOf21 = Long.valueOf(networkStatus.getInflightReq());
        Long valueOf22 = Long.valueOf(networkStatus.getInQueueReq());
        if (j3 != -1) {
            valueOf4 = Long.valueOf(j3);
        } else {
            valueOf4 = null;
        }
        if (j2 != -1) {
            valueOf5 = Long.valueOf(j2);
        } else {
            valueOf5 = null;
        }
        if (j != -1) {
            valueOf6 = Long.valueOf(j);
        } else {
            valueOf6 = null;
        }
        return new com.facebook.http.observer.NetworkInfo(valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, valueOf, valueOf2, valueOf3, valueOf13, valueOf14, valueOf15, valueOf16, valueOf17, valueOf18, valueOf19, valueOf20, valueOf21, valueOf22, valueOf4, valueOf5, valueOf6, str, Long.valueOf(networkStatus.getDNSResolutionTime()), Integer.valueOf(s), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i), Boolean.valueOf(this.f8817i.m2262j()), Long.valueOf(this.f8817i.m2257c()), Long.valueOf(this.f8817i.m2258d()), Boolean.valueOf(networkStatus.getMayHaveNetwork()), Long.valueOf(networkStatus.getMayHaveIdledMS()), Long.valueOf(networkStatus.getActiveReadSeconds()), Long.valueOf(networkStatus.getActiveWriteSeconds()), Long.valueOf(networkStatus.getReqBwIngressSize()), Long.valueOf(networkStatus.getReqBwIngressAvg()), Long.valueOf(networkStatus.getReqBwIngressMax()), Double.valueOf(networkStatus.getReqBwIngressStdDev()), Long.valueOf(networkStatus.getReqBwEgressSize()), Long.valueOf(networkStatus.getReqBwEgressAvg()), Long.valueOf(networkStatus.getReqBwEgressMax()), Double.valueOf(networkStatus.getReqBwEgressStdDev()), networkStatus.getLatencyQuality(), networkStatus.getUploadBwQuality(), networkStatus.getDownloadBwQuality());
    }

    public final TimeInfo mo497b() {
        m13646j();
        return new TimeInfo(Integer.valueOf(this.f8818j), Integer.valueOf(this.f8819k));
    }
}
