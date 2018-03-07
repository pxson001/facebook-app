package com.facebook.wifiscan;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.time.MonotonicClock;
import com.facebook.wifiscan.WifiScanOperationException.Type;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: is_list */
public class WifiScanOperation extends AbstractFuture<List<ScanResult>> {
    private final Handler f19064a;
    private final WifiScanEligibilityUtil f19065b;
    private final WifiManager f19066c;
    private final MonotonicClock f19067d;
    private final BaseFbBroadcastManager f19068e;
    public final ScheduledExecutorService f19069f;
    public WifiScanOperationParams f19070g;
    private boolean f19071h;
    public ScheduledFuture f19072i;
    private SelfRegistrableReceiverImpl f19073j;

    @Inject
    public WifiScanOperation(Handler handler, WifiScanEligibilityUtil wifiScanEligibilityUtil, WifiManager wifiManager, MonotonicClock monotonicClock, BaseFbBroadcastManager baseFbBroadcastManager, ScheduledExecutorService scheduledExecutorService) {
        this.f19064a = handler;
        this.f19065b = wifiScanEligibilityUtil;
        this.f19066c = wifiManager;
        this.f19067d = monotonicClock;
        this.f19068e = baseFbBroadcastManager;
        this.f19069f = scheduledExecutorService;
    }

    public final synchronized void m26786a(WifiScanOperationParams wifiScanOperationParams) {
        try {
            m26781b(wifiScanOperationParams);
        } catch (Throwable e) {
            m26782b(e);
        }
    }

    private void m26781b(WifiScanOperationParams wifiScanOperationParams) {
        boolean z;
        Preconditions.checkNotNull(wifiScanOperationParams);
        Preconditions.checkState(!this.f19071h, "already running");
        if (isDone()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "already done");
        this.f19071h = true;
        this.f19070g = wifiScanOperationParams;
        if (!this.f19065b.m21750a()) {
            throw new WifiScanOperationException(Type.NOT_SUPPORTED);
        } else if (!WifiScanEligibilityUtil.m21747b()) {
            throw new WifiScanOperationException(Type.NOT_SUPPORTED);
        } else if (!this.f19065b.m21751c()) {
            throw new WifiScanOperationException(Type.PERMISSION_DENIED);
        } else if (this.f19065b.m21752d() || this.f19065b.m21753e().asBoolean(false)) {
            List a = ScanResultAgeUtil.m27027a(this.f19066c.getScanResults(), this.f19070g.f16579b, this.f19067d.now());
            if (a != null && !a.isEmpty()) {
                m26780a(a);
            } else if (this.f19070g.f16578a == 0) {
                throw new WifiScanOperationException(Type.TIMEOUT);
            } else {
                this.f19072i = this.f19069f.schedule(new 2(this), this.f19070g.f16578a, TimeUnit.MILLISECONDS);
                this.f19073j = this.f19068e.m2951a().mo505a(this.f19064a).mo506a("android.net.wifi.SCAN_RESULTS", new 1(this)).mo503a();
                this.f19073j.m3296b();
                if (!this.f19066c.startScan()) {
                    throw new WifiScanOperationException(Type.UNKNOWN_ERROR);
                }
            }
        } else {
            throw new WifiScanOperationException(Type.USER_DISABLED);
        }
    }

    public static synchronized void m26783f(WifiScanOperation wifiScanOperation) {
        synchronized (wifiScanOperation) {
            if (wifiScanOperation.f19071h) {
                List a = ScanResultAgeUtil.m27027a(wifiScanOperation.f19066c.getScanResults(), wifiScanOperation.f19070g.f16579b, wifiScanOperation.f19067d.now());
                if (!(a == null || a.isEmpty())) {
                    wifiScanOperation.m26780a(a);
                }
            }
        }
    }

    public static synchronized void m26784g(WifiScanOperation wifiScanOperation) {
        synchronized (wifiScanOperation) {
            if (wifiScanOperation.f19071h) {
                wifiScanOperation.m26782b(new WifiScanOperationException(Type.TIMEOUT));
            }
        }
    }

    private void m26780a(List<ScanResult> list) {
        m26785j();
        mo221a((Object) list);
    }

    private void m26782b(Throwable th) {
        m26785j();
        mo222a(th);
    }

    private void m26785j() {
        this.f19071h = false;
        this.f19070g = null;
        if (this.f19073j != null) {
            if (this.f19073j.m3295a()) {
                this.f19073j.m3297c();
            }
            this.f19073j = null;
        }
        if (this.f19072i != null) {
            this.f19072i.cancel(false);
            this.f19072i = null;
        }
    }
}
