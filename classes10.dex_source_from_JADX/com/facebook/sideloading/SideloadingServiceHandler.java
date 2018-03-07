package com.facebook.sideloading;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.server.ServerConfig;
import com.facebook.downloader.DownloadRequest.Builder;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.DownloadRequestFactory;
import com.facebook.downloader.FbDownloadManager;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.orca.FbandroidProductionConfig;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.selfupdate.OxygenApiMethod;
import com.facebook.selfupdate.OxygenQueryParams;
import com.facebook.selfupdate.OxygenQueryResponse;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hasClickedOnCoverPhotoSelector */
public class SideloadingServiceHandler implements BlueServiceHandler {
    private static final Class<?> f10088a = SideloadingServiceHandler.class;
    private static SideloadingServiceHandler f10089k;
    private static final Object f10090l = new Object();
    private final Resources f10091b;
    private final FbDownloadManager f10092c;
    private final AbstractSingleMethodRunner f10093d;
    private final OxygenApiMethod f10094e;
    private final ServerConfig f10095f;
    private final DownloadRequestFactory f10096g;
    private final SideloadingChecker f10097h;
    private final FbSharedPreferences f10098i;
    private final SideloadingLogger f10099j;

    private static SideloadingServiceHandler m10169b(InjectorLike injectorLike) {
        return new SideloadingServiceHandler(ResourcesMethodAutoProvider.a(injectorLike), FbDownloadManager.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), OxygenApiMethod.b(injectorLike), (ServerConfig) FbandroidProductionConfig.a(injectorLike), DownloadRequestFactory.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SideloadingChecker.m10113b(injectorLike), SideloadingLogger.m10126b(injectorLike));
    }

    public final OperationResult m10170a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("sideload_app".equals(str)) {
            return m10168b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    @Inject
    public SideloadingServiceHandler(Resources resources, FbDownloadManager fbDownloadManager, AbstractSingleMethodRunner abstractSingleMethodRunner, OxygenApiMethod oxygenApiMethod, ServerConfig serverConfig, DownloadRequestFactory downloadRequestFactory, FbSharedPreferences fbSharedPreferences, SideloadingChecker sideloadingChecker, SideloadingLogger sideloadingLogger) {
        this.f10091b = resources;
        this.f10092c = fbDownloadManager;
        this.f10093d = abstractSingleMethodRunner;
        this.f10094e = oxygenApiMethod;
        this.f10095f = serverConfig;
        this.f10096g = downloadRequestFactory;
        this.f10097h = sideloadingChecker;
        this.f10098i = fbSharedPreferences;
        this.f10099j = sideloadingLogger;
    }

    public static SideloadingServiceHandler m10165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SideloadingServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10090l) {
                SideloadingServiceHandler sideloadingServiceHandler;
                if (a2 != null) {
                    sideloadingServiceHandler = (SideloadingServiceHandler) a2.a(f10090l);
                } else {
                    sideloadingServiceHandler = f10089k;
                }
                if (sideloadingServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10169b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10090l, b3);
                        } else {
                            f10089k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sideloadingServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m10168b(OperationParams operationParams) {
        if (this.f10097h.m10114a()) {
            Bundle bundle = operationParams.c;
            m10167a(bundle.getString("package_name"), Boolean.valueOf(bundle.getBoolean("force_download")).booleanValue());
        }
        return OperationResult.a;
    }

    private void m10167a(String str, boolean z) {
        OxygenQueryResponse a = m10164a(str);
        String string = this.f10091b.getString(2131241332);
        if (a != null && a.f9958c != null) {
            a.f9957b.name();
            Boolean.valueOf(z);
            this.f10099j.m10127a("sideloading_queue_download");
            long a2 = m10163a(a.f9958c, a.f9957b.asInt(), a.f9959d, string, z);
            Long.valueOf(a2);
            m10166a(a, a2);
        }
    }

    @TargetApi(11)
    private long m10163a(String str, int i, long j, String str2, boolean z) {
        Builder a = Builder.a();
        a.a = DownloadType.SIDELOADING;
        a = a;
        a.b = str;
        a = a;
        a.c = DownloadRequestFactory.a(i);
        a = a;
        a.d = str2;
        a = a;
        a.e = j;
        a = a;
        a.f = z;
        a = a;
        a.h = this.f10095f.d();
        return this.f10092c.a(a.b());
    }

    @Nullable
    private OxygenQueryResponse m10164a(String str) {
        try {
            OxygenQueryParams oxygenQueryParams = new OxygenQueryParams(str, "ijxLJi1yGs1JpL-X1SExmchvork", 0);
            this.f10099j.m10127a("sideloading_send_request_to_oxygen");
            return (OxygenQueryResponse) this.f10093d.a(this.f10094e, oxygenQueryParams, CallerContext.a(getClass()));
        } catch (NameNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    private void m10166a(OxygenQueryResponse oxygenQueryResponse, long j) {
        if (j != -1) {
            String str = "com.facebook.orca";
            this.f10098i.edit().a(SideloadingPrefKeys.m10158b(str), j).a((PrefKey) SideloadingPrefKeys.m10157a(str).a("download_url"), oxygenQueryResponse.f9958c).a(SideloadingPrefKeys.m10161f(str), oxygenQueryResponse.f9965j).a(SideloadingPrefKeys.m10160e(str), oxygenQueryResponse.f9959d).a(SideloadingPrefKeys.m10162g(str), 1).commit();
        }
    }
}
