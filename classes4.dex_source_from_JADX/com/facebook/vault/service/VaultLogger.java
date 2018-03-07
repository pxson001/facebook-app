package com.facebook.vault.service;

import android.content.Context;
import android.net.NetworkInfo;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.provider.VaultImageProviderRow;
import javax.inject.Inject;

/* compiled from: latest_users */
public class VaultLogger extends InteractionLogger {
    public static String f9441a = "nux_shown";
    public static String f9442b = "nux_accept";
    public static String f9443c = "nux_reject";
    public static String f9444d = "sync_start";
    public static String f9445e = "sync_photo_start";
    public static String f9446f = "sync_photo_success";
    public static String f9447g = "sync_photo_failure";
    public static String f9448h = "sync_snap_to_first_sync_time";
    public static String f9449i = "sync_snap_to_success";
    public static String f9450j = "sync_hit_max_sync_failure";
    public static String f9451k = "enable_sync";
    public static String f9452l = "disable_sync";
    public static String f9453m = "connectivity";
    public static String f9454n = "image_observer";
    public static String f9455o = "observer_startup";
    public static String f9456p = "retry";
    public static String f9457q = "setup";
    public static String f9458r = "mobile_highres_pref";
    public static String f9459s = "processor_idle";
    public static String f9460t = "photo_status";
    private final Context f9461u;
    private DeviceIDPref f9462v;
    private VaultLocalImageFetcher f9463w;
    private final AbstractFbErrorReporter f9464x;
    private final AnalyticsLogger f9465y;

    public static VaultLogger m9823c(InjectorLike injectorLike) {
        return new VaultLogger((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), DataUsageCounters.a(injectorLike), DeviceIDPref.m9819a(injectorLike), VaultLocalImageFetcher.m9838c(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NavigationLogger.a(injectorLike));
    }

    @Inject
    public VaultLogger(Context context, AnalyticsLogger analyticsLogger, DataUsageCounters dataUsageCounters, DeviceIDPref deviceIDPref, VaultLocalImageFetcher vaultLocalImageFetcher, AbstractFbErrorReporter abstractFbErrorReporter, NavigationLogger navigationLogger) {
        super(analyticsLogger, navigationLogger, dataUsageCounters, context.getResources());
        this.f9461u = context;
        this.f9465y = analyticsLogger;
        this.f9462v = deviceIDPref;
        this.f9463w = vaultLocalImageFetcher;
        this.f9464x = abstractFbErrorReporter;
    }

    public final void m9825a(int i, int i2) {
        HoneyClientEvent e = m9824e(f9444d);
        switch (i) {
            case 0:
                e.b("reason", f9454n);
                break;
            case 1:
                e.b("reason", f9455o);
                break;
            case 2:
                e.b("reason", f9453m);
                break;
            case 3:
                e.b("reason", f9456p);
                break;
            case 4:
                e.b("reason", f9457q);
                break;
            case 5:
                e.b("reason", f9458r);
                break;
            case 6:
                e.b("reason", f9458r);
                break;
            case 7:
                e.b("reason", f9459s);
                break;
            case 8:
                e.b("reason", f9460t);
                break;
            case 9:
                e.b("reason", "power_plugged_in");
                break;
            case 10:
                e.b("reason", "sync_older_photos");
                e.a("library_size", this.f9463w.m9840a());
                break;
            case 11:
                e.b("reason", "retry_by_hashes");
                break;
            case 12:
                e.b("reason", "pull_to_refresh");
                break;
            case 13:
                e.b("reason", "looking_at_sync_tab");
                break;
            default:
                this.f9464x.b("vault_logger", "unknown sync reason: " + i);
                break;
        }
        e.a("images_queued", i2);
        this.f9465y.c(e);
    }

    public final void m9831b(String str) {
        HoneyClientEvent e;
        if (str.equals("OFF")) {
            e = m9824e(f9452l);
        } else {
            e = m9824e(f9451k);
        }
        e.b("mode", str);
        m9822a(e);
        this.f9465y.c(e);
    }

    public final void m9832c(String str) {
        HoneyClientEvent e = m9824e(f9441a);
        e.b("ref", str);
        this.f9465y.c(e);
    }

    public final void m9833d(String str) {
        HoneyClientEvent e;
        if (str.equals("OFF")) {
            e = m9824e(f9443c);
        } else {
            e = m9824e(f9442b);
        }
        e.b("mode", str);
        this.f9465y.c(e);
    }

    public final void m9829a(VaultImageProviderRow vaultImageProviderRow, boolean z, long j) {
        HoneyClientEvent e = m9824e(f9445e);
        e.b("img_hash", vaultImageProviderRow.a);
        e.b("resolution", z ? "high" : "low");
        e.a("file_size", j);
        m9822a(e);
        this.f9465y.c(e);
    }

    public final void m9827a(VaultImageProviderRow vaultImageProviderRow, long j, long j2, boolean z, String str) {
        HoneyClientEvent e = m9824e(f9446f);
        e.b("img_hash", vaultImageProviderRow.a);
        e.b("resolution", vaultImageProviderRow.f == 0 ? "low" : "high");
        e.a("file_size", j2);
        e.a("upload_time", j);
        e.a("time_to_success", System.currentTimeMillis() - vaultImageProviderRow.c);
        e.a("is_upgrade", z);
        e.a("failures", vaultImageProviderRow.e);
        e.b("file_path", str);
        m9822a(e);
        this.f9465y.c(e);
    }

    public final void m9828a(VaultImageProviderRow vaultImageProviderRow, String str, long j, long j2, String str2) {
        HoneyClientEvent e = m9824e(f9447g);
        e.b("img_hash", vaultImageProviderRow.a);
        e.b("error_msg", str);
        e.a("upload_time", j);
        e.a("file_size", j2);
        e.b("file_path", str2);
        m9822a(e);
        this.f9465y.c(e);
    }

    public final void m9826a(VaultImageProviderRow vaultImageProviderRow, long j) {
        HoneyClientEvent e = m9824e(f9448h);
        e.b("img_hash", vaultImageProviderRow.a);
        e.a("time_to_first_sync", System.currentTimeMillis() - vaultImageProviderRow.c);
        e.a("file_size", j);
        m9822a(e);
        this.f9465y.c(e);
    }

    public final void m9830b(VaultImageProviderRow vaultImageProviderRow, long j) {
        HoneyClientEvent e = m9824e(f9450j);
        e.b("img_hash", vaultImageProviderRow.a);
        e.a("file_size", j);
        m9822a(e);
        this.f9465y.c(e);
    }

    private void m9822a(HoneyClientEvent honeyClientEvent) {
        NetworkInfo b = UploadManagerConnectivity.b(this.f9461u);
        if (b != null) {
            honeyClientEvent.b("connectivity", b.getTypeName());
            honeyClientEvent.b("connectivity_subtype", b.getSubtypeName());
        } else {
            honeyClientEvent.b("connectivity", "NONE");
            honeyClientEvent.b("connectivity_subtype", "NONE");
        }
        this.f9465y.c(honeyClientEvent);
    }

    private HoneyClientEvent m9824e(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "vault";
        honeyClientEvent.a("vault_device_oid", this.f9462v.m9821a());
        return honeyClientEvent;
    }
}
