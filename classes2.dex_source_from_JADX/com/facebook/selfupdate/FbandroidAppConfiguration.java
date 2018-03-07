package com.facebook.selfupdate;

import android.content.Context;
import com.facebook.appupdate.AppInstallCallback;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rating */
public class FbandroidAppConfiguration {
    private final Context f8233a;
    public final Provider<ViewerContext> f8234b;
    private final Provider<String> f8235c;
    private final AppUpdateLoggerFbImpl f8236d;
    private final Provider<Long> f8237e;

    /* compiled from: rating */
    class C03551 implements Provider<String> {
        final /* synthetic */ FbandroidAppConfiguration f8284a;

        C03551(FbandroidAppConfiguration fbandroidAppConfiguration) {
            this.f8284a = fbandroidAppConfiguration;
        }

        public Object get() {
            return ((ViewerContext) this.f8284a.f8234b.get()).mAuthToken;
        }
    }

    public static FbandroidAppConfiguration m12742b(InjectorLike injectorLike) {
        return new FbandroidAppConfiguration((Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedProvider.m1811a(injectorLike, 372), IdBasedProvider.m1811a(injectorLike, 4455), new AppUpdateLoggerFbImpl(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), SelfUpdateLogger.m12754b(injectorLike)), IdBasedProvider.m1811a(injectorLike, 4433));
    }

    @Inject
    public FbandroidAppConfiguration(@ForAppContext Context context, Provider<ViewerContext> provider, Provider<String> provider2, AppUpdateLoggerFbImpl appUpdateLoggerFbImpl, Provider<Long> provider3) {
        this.f8233a = context;
        this.f8234b = provider;
        this.f8235c = provider2;
        this.f8236d = appUpdateLoggerFbImpl;
        this.f8237e = provider3;
    }

    public final Context m12743a() {
        return this.f8233a;
    }

    public final Provider<String> m12744b() {
        return this.f8235c;
    }

    public final Provider<String> m12745c() {
        return new C03551(this);
    }

    public final AppUpdateLoggerFbImpl m12746d() {
        return this.f8236d;
    }

    @Nullable
    public final AppInstallCallback m12747e() {
        return null;
    }

    public final Provider<Long> m12748g() {
        return this.f8237e;
    }
}
