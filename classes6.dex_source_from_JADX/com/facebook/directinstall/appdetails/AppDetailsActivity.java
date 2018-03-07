package com.facebook.directinstall.appdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.directinstall.appdetails.analytics.AppDetailsLogger;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onUploadOptions */
public class AppDetailsActivity extends FbFragmentActivity implements AnalyticsActivity, IAuthNotRequired {
    @Inject
    public AppDetailsLogger f8679p;
    private DirectInstallAppData f8680q;

    /* compiled from: onUploadOptions */
    class C05741 implements OnClickListener {
        final /* synthetic */ AppDetailsActivity f8678a;

        C05741(AppDetailsActivity appDetailsActivity) {
            this.f8678a = appDetailsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 827228616);
            this.f8678a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1842470678, a);
        }
    }

    private static <T extends Context> void m12479a(Class<T> cls, T t) {
        m12480a((Object) t, (Context) t);
    }

    public static void m12480a(Object obj, Context context) {
        ((AppDetailsActivity) obj).f8679p = AppDetailsLogger.m12505a(FbInjector.get(context));
    }

    private void m12478a(AppDetailsLogger appDetailsLogger) {
        this.f8679p = appDetailsLogger;
    }

    protected final void m12481b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = AppDetailsActivity.class;
        m12480a((Object) this, (Context) this);
        setContentView(2130903086);
        FbTitleBarUtil.m8799b(this);
        View a = a(2131558563);
        a.setBackgroundColor(getResources().getColor(2131363181));
        FbTitleBar fbTitleBar = (FbTitleBar) a;
        fbTitleBar.setHasFbLogo(true);
        fbTitleBar.a(new C05741(this));
        this.f8680q = DirectInstallIntentUtils.m12552a(getIntent().getExtras());
        if (!(this.f8680q == null || this.f8680q.f8769c == null)) {
            fbTitleBar.setTitle(this.f8680q.f8769c.f8799a);
        }
        Bundle bundle2 = new Bundle();
        Intent intent = getIntent();
        String str = "app_data";
        String str2 = "install_surface";
        String str3 = "analytics";
        bundle2.putParcelable(str, intent.getParcelableExtra(str));
        bundle2.putString(str2, intent.getStringExtra(str2));
        bundle2.putBundle(str3, intent.getBundleExtra(str3));
        AppDetailsFragment appDetailsFragment = new AppDetailsFragment();
        appDetailsFragment.g(bundle2);
        kO_().a().a(2131559220, appDetailsFragment).b();
        this.f8679p.m12509a("neko_di_app_details_loaded", this.f8680q.f8768b.f8773a, this.f8680q.f8768b.f8777e, DirectInstallIntentUtils.m12556b(getIntent().getExtras()));
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f8679p.m12509a("neko_di_app_details_back_pressed", this.f8680q.f8768b.f8773a, this.f8680q.f8768b.f8777e, DirectInstallIntentUtils.m12556b(getIntent().getExtras()));
    }

    public final String am_() {
        return "neko_di_app_details";
    }
}
