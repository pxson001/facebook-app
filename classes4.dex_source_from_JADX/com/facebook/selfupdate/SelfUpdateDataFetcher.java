package com.facebook.selfupdate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_full_list */
public class SelfUpdateDataFetcher {
    private static final Class<?> f12502a = SelfUpdateDataFetcher.class;
    private final AppApiMethod f12503b;
    private final AppInfo f12504c;
    private final AppVersionInfo f12505d;
    private final Context f12506e;
    private final OxygenApiMethod f12507f;
    private final PlatformAppConfig f12508g;
    private final SelfUpdateLogger f12509h;
    private final AbstractSingleMethodRunner f12510i;

    public static SelfUpdateDataFetcher m13254b(InjectorLike injectorLike) {
        return new SelfUpdateDataFetcher(new AppApiMethod(), AppInfo.a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), OxygenApiMethod.m13259b(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), SelfUpdateLogger.b(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike));
    }

    @Inject
    public SelfUpdateDataFetcher(AppApiMethod appApiMethod, AppInfo appInfo, AppVersionInfo appVersionInfo, Context context, OxygenApiMethod oxygenApiMethod, PlatformAppConfig platformAppConfig, SelfUpdateLogger selfUpdateLogger, AbstractSingleMethodRunner abstractSingleMethodRunner) {
        this.f12503b = appApiMethod;
        this.f12504c = appInfo;
        this.f12505d = appVersionInfo;
        this.f12506e = context;
        this.f12507f = oxygenApiMethod;
        this.f12508g = platformAppConfig;
        this.f12509h = selfUpdateLogger;
        this.f12510i = abstractSingleMethodRunner;
    }

    @Nullable
    public final AppServerResponse m13255a(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = this.f12505d.b();
        }
        try {
            return (AppServerResponse) this.f12510i.a(this.f12503b, new AppServerParams(this.f12508g.c(), i, this.f12506e.getPackageName()));
        } catch (IOException e) {
            return null;
        } catch (Throwable e2) {
            this.f12509h.a("Failed to fetch update information from server", e2);
            return null;
        }
    }

    @Nullable
    public final OxygenQueryResponse m13256b(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = this.f12505d.b();
        }
        String packageName = this.f12506e.getPackageName();
        try {
            OxygenQueryParams oxygenQueryParams = new OxygenQueryParams(packageName, m13253a(this.f12504c.c(packageName, 64)), i);
            this.f12509h.a("selfupdate_send_request_to_oxygen", null);
            Integer.valueOf(i);
            return (OxygenQueryResponse) this.f12510i.a(this.f12507f, oxygenQueryParams);
        } catch (NameNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } catch (Throwable e3) {
            this.f12509h.a("Failed to fetch update information from server", e3);
            return null;
        }
    }

    private static String m13253a(PackageInfo packageInfo) {
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
            return null;
        }
        return SecureHashUtil.a(packageInfo.signatures[0].toByteArray());
    }
}
