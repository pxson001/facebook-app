package com.facebook.directinstall.appdetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.directinstall.appdetails.analytics.AppDetailsLogger;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallIntentUtils;
import com.facebook.inject.FbInjector;
import com.facebook.payments.paymentsflow.uicomponents.ScreenshotsAdapter;
import com.facebook.widget.ListViewFriendlyViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onError=%s */
public class ScreenshotFullscreenActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    public AppDetailsLogger f8714p;
    public DirectInstallAppData f8715q;
    public Map<String, Object> f8716r;

    /* compiled from: onError=%s */
    class C05801 extends SimpleOnPageChangeListener {
        final /* synthetic */ ScreenshotFullscreenActivity f8713a;

        C05801(ScreenshotFullscreenActivity screenshotFullscreenActivity) {
            this.f8713a = screenshotFullscreenActivity;
        }

        public final void e_(int i) {
            this.f8713a.f8714p.m12511c(this.f8713a.f8715q.f8768b.f8773a, this.f8713a.f8715q.f8768b.f8777e, i, this.f8713a.f8716r);
        }
    }

    private static <T extends Context> void m12499a(Class<T> cls, T t) {
        m12500a((Object) t, (Context) t);
    }

    public static void m12500a(Object obj, Context context) {
        ((ScreenshotFullscreenActivity) obj).f8714p = AppDetailsLogger.m12505a(FbInjector.get(context));
    }

    private void m12498a(AppDetailsLogger appDetailsLogger) {
        this.f8714p = appDetailsLogger;
    }

    protected final void m12502b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = ScreenshotFullscreenActivity.class;
        m12500a((Object) this, (Context) this);
        Intent intent = getIntent();
        this.f8715q = DirectInstallIntentUtils.m12552a(getIntent().getExtras());
        this.f8716r = DirectInstallIntentUtils.m12556b(getIntent().getExtras());
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("screenshot_url_list");
        int intExtra = intent.getIntExtra("screenshot_current_position", -1);
        if (parcelableArrayListExtra != null && intExtra >= 0) {
            Collection arrayList = new ArrayList();
            for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                arrayList.add((Uri) parcelableArrayListExtra.get(i));
            }
            setContentView(2130903094);
            ListViewFriendlyViewPager listViewFriendlyViewPager = (ListViewFriendlyViewPager) findViewById(2131559243);
            ScreenshotsAdapter screenshotsAdapter = new ScreenshotsAdapter(kO_(), this);
            screenshotsAdapter.f12304b.clear();
            screenshotsAdapter.f12304b.addAll(arrayList);
            screenshotsAdapter.kR_();
            listViewFriendlyViewPager.setAdapter(screenshotsAdapter);
            listViewFriendlyViewPager.a(intExtra, false);
            listViewFriendlyViewPager.setOnPageChangeListener(new C05801(this));
        }
    }

    public final String am_() {
        return "neko_di_app_details_screenshots";
    }
}
