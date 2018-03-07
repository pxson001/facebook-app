package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.wifiscan.ConnectedWifis;
import com.facebook.wifiscan.WifiScanCache;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hw_au_md_cfg */
public class BackgroundLocationReportingUtils {
    private static final String f10577a = BackgroundLocationReportingUtils.class.getSimpleName();
    private final Context f10578b;
    private final QeAccessor f10579c;
    private final WifiScanCache f10580d;

    public static BackgroundLocationReportingUtils m11115b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingUtils((Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), WifiScanCache.m11118a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingUtils(Context context, QeAccessor qeAccessor, WifiScanCache wifiScanCache) {
        this.f10578b = context;
        this.f10579c = qeAccessor;
        this.f10580d = wifiScanCache;
    }

    @Nullable
    public final WifiInfo m11116a() {
        return this.f10579c.a(ExperimentsForBackgroundLocationReportingModule.f9737g, false) ? ConnectedWifis.a(this.f10578b) : null;
    }

    @Nullable
    public final List<ScanResult> m11117b() {
        if (!this.f10579c.a(ExperimentsForBackgroundLocationReportingModule.f9738h, false)) {
            return null;
        }
        return this.f10580d.m11120a(this.f10579c.a(ExperimentsForBackgroundLocationReportingModule.f9742l, Long.MAX_VALUE));
    }
}
