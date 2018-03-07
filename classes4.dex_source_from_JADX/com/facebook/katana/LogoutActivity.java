package com.facebook.katana;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipeline.3;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.dbl.DBLLogoutActivity;
import com.facebook.katana.dbl.FacebookLoginIntentManager;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession$LogoutReason;
import com.facebook.katana.service.AppSessionListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: unmatched */
public class LogoutActivity extends FbFragmentActivity implements AnalyticsActivity, IAuthNotRequired, DBLLogoutActivity {
    @Inject
    Lazy<ImagePipeline> f569p;
    @Inject
    public FacebookLoginIntentManager f570q;
    @Inject
    public QuickPerformanceLogger f571r;
    @Inject
    public Lazy<FbErrorReporter> f572s;
    private boolean f573t;
    public boolean f574u = false;
    private AppSessionListener f575v = new C00451(this);

    /* compiled from: unmatched */
    class C00451 extends AppSessionListener {
        final /* synthetic */ LogoutActivity f576a;

        C00451(LogoutActivity logoutActivity) {
            this.f576a = logoutActivity;
        }

        public final void mo63b(Throwable th) {
            if (this.f576a.f574u) {
                this.f576a.f570q.m13243a(this.f576a);
            } else {
                this.f576a.finish();
            }
            if (th == null) {
                this.f576a.f571r.b(2293778, (short) 2);
            } else {
                this.f576a.f571r.b(2293778, (short) 3);
                ((AbstractFbErrorReporter) this.f576a.f572s.get()).a("LogoutActivity", "Logout failure", th);
            }
            ImagePipeline imagePipeline = (ImagePipeline) this.f576a.f569p.get();
            3 3 = new 3(imagePipeline);
            imagePipeline.e.a(3);
            imagePipeline.f.a(3);
        }
    }

    private static <T extends Context> void m864a(Class<T> cls, T t) {
        m865a((Object) t, (Context) t);
    }

    public static void m865a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LogoutActivity) obj).m863a(FacebookLoginIntentManager.m13240b(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 2309));
    }

    protected final void m870b(Bundle bundle) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(2131362706));
        }
        super.b(bundle);
        Class cls = LogoutActivity.class;
        m865a((Object) this, (Context) this);
        setContentView(2130904260);
        getWindow().setBackgroundDrawable(null);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1265153748);
        super.onResume();
        this.f574u = true;
        if (this.f573t) {
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1871967610, a);
            return;
        }
        AppSession b = AppSession.b(this, false);
        if (b != null) {
            this.f571r.b(2293778);
            b.a(this.f575v);
            b.a(this, AppSession$LogoutReason.USER_INITIATED);
            this.f573t = true;
        } else {
            this.f570q.m13243a(this);
        }
        LogUtils.c(-617958308, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2077722982);
        super.onPause();
        this.f574u = false;
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -607731948, a);
    }

    public final String am_() {
        return "logout";
    }

    private void m863a(FacebookLoginIntentManager facebookLoginIntentManager, QuickPerformanceLogger quickPerformanceLogger, Lazy<FbErrorReporter> lazy, Lazy<ImagePipeline> lazy2) {
        this.f570q = facebookLoginIntentManager;
        this.f571r = quickPerformanceLogger;
        this.f572s = lazy;
        this.f569p = lazy2;
    }
}
