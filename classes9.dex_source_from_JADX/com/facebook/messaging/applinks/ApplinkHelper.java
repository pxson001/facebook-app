package com.facebook.messaging.applinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.analytics.CounterLogger;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.DeviceUtil;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.messaging.applinks.GetUrlApplinkMethod.ApplinkData;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: p2p_edit_card_details */
public class ApplinkHelper {
    private static final Class<?> f7683a = ApplinkHelper.class;
    private final SecureContextHelper f7684b;
    public final ListeningExecutorService f7685c;
    private final PackageManager f7686d;
    private final AbstractFbErrorReporter f7687e;
    public final CounterLogger f7688f;
    public final LocalStatsLoggerImpl f7689g;
    public final ApiMethodRunnerImpl f7690h;
    public final GetUrlApplinkMethod f7691i;
    private final Provider<Boolean> f7692j;
    private final TasksManager<String> f7693k;
    public final ApplinksDataCache f7694l;

    /* compiled from: p2p_edit_card_details */
    class ApplinksResultCallback extends AbstractDisposableFutureCallback<ApplinkData> {
        Uri f7681a;
        final /* synthetic */ ApplinkHelper f7682b;

        protected final void m7984a(Object obj) {
            ApplinkData applinkData = (ApplinkData) obj;
            if (applinkData != null) {
                this.f7682b.f7694l.m7993a(this.f7681a, applinkData);
            }
        }

        public ApplinksResultCallback(ApplinkHelper applinkHelper, Uri uri) {
            this.f7682b = applinkHelper;
            this.f7681a = uri;
        }

        protected final void m7985a(Throwable th) {
            this.f7682b.f7688f.a("[applinks]api_request_failed");
            this.f7682b.f7689g.a(6881281);
        }
    }

    public static ApplinkHelper m7987b(InjectorLike injectorLike) {
        return new ApplinkHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), new GetUrlApplinkMethod(), CounterLogger.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4101), TasksManager.b(injectorLike), ApplinksDataCache.m7990a(injectorLike));
    }

    public static ApplinkHelper m7986a(InjectorLike injectorLike) {
        return m7987b(injectorLike);
    }

    @Inject
    public ApplinkHelper(SecureContextHelper secureContextHelper, ListeningExecutorService listeningExecutorService, PackageManager packageManager, FbErrorReporter fbErrorReporter, ApiMethodRunner apiMethodRunner, GetUrlApplinkMethod getUrlApplinkMethod, CounterLogger counterLogger, LocalStatsLogger localStatsLogger, Provider<Boolean> provider, TasksManager tasksManager, ApplinksDataCache applinksDataCache) {
        this.f7684b = secureContextHelper;
        this.f7685c = listeningExecutorService;
        this.f7686d = packageManager;
        this.f7687e = fbErrorReporter;
        this.f7690h = apiMethodRunner;
        this.f7691i = getUrlApplinkMethod;
        this.f7688f = counterLogger;
        this.f7689g = localStatsLogger;
        this.f7692j = provider;
        this.f7693k = tasksManager;
        this.f7694l = applinksDataCache;
    }

    public final void m7988a(final Uri uri) {
        if (((Boolean) this.f7692j.get()).booleanValue() && FacebookUriUtil.c(uri) && !FacebookUriUtil.a(uri)) {
            this.f7688f.a("[applinks]possible_applinks_url");
            this.f7689g.a(6881286);
            if (!DeviceUtil.a(this.f7686d, "com.facebook.katana") && !DeviceUtil.a(this.f7686d, "com.facebook.wakizashi")) {
                this.f7688f.a("[applinks]katana_and_wakizashi_not_installed");
                this.f7689g.a(6881282);
            } else if (this.f7694l.m7992a(uri) == null) {
                this.f7693k.a(uri.toString(), new Callable<ListenableFuture<ApplinkData>>(this) {
                    final /* synthetic */ ApplinkHelper f7680b;

                    /* compiled from: p2p_edit_card_details */
                    class C08511 implements Callable<ApplinkData> {
                        final /* synthetic */ C08521 f7678a;

                        C08511(C08521 c08521) {
                            this.f7678a = c08521;
                        }

                        public Object call() {
                            return (ApplinkData) this.f7678a.f7680b.f7690h.a(this.f7678a.f7680b.f7691i, uri);
                        }
                    }

                    public Object call() {
                        return this.f7680b.f7685c.a(new C08511(this));
                    }
                }, new ApplinksResultCallback(this, uri));
            }
        }
    }

    public final boolean m7989a(Uri uri, Context context) {
        this.f7688f.a("[applinks]url_clicked");
        this.f7689g.a(6881283);
        ApplinkData a = this.f7694l.m7992a(uri);
        if (a == null) {
            ListenableFuture b = this.f7693k.b(uri.toString());
            if (b == null) {
                return false;
            }
            try {
                a = (ApplinkData) FutureDetour.a(b, 1, TimeUnit.SECONDS, -1854007144);
                if (a == null) {
                    return false;
                }
                this.f7694l.m7993a(uri, a);
            } catch (Exception e) {
                this.f7688f.a("[applinks] skipped_because_data_not_ready");
                this.f7689g.a(6881284);
                return false;
            }
        }
        ApplinkData applinkData = a;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (StringUtil.a(applinkData.f7697a)) {
                return false;
            }
            if (DeviceUtil.a(this.f7686d, applinkData.f7697a)) {
                intent.setPackage(applinkData.f7697a);
            } else if (!"com.facebook.katana".equals(applinkData.f7697a) || !DeviceUtil.a(this.f7686d, "com.facebook.wakizashi")) {
                return false;
            } else {
                intent.setPackage("com.facebook.wakizashi");
            }
            intent.setData(Uri.parse(applinkData.f7698b));
            this.f7684b.b(intent, context);
            this.f7688f.a("[applinks]started_intent_successfully");
            this.f7689g.a(6881287);
            return true;
        } catch (Exception e2) {
            this.f7688f.a("[applinks]failed_to_start_intent");
            this.f7689g.a(6881285);
            this.f7687e.a(SoftError.a(f7683a.getSimpleName(), "Couldn't launch applink intent\noriginal URL: " + uri + "\napplink URL: " + applinkData.f7698b + "\napplink package name: " + applinkData.f7697a + "\nexception: " + e2).g());
            return false;
        }
    }
}
