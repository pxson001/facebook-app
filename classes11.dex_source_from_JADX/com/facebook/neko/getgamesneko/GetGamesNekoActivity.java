package com.facebook.neko.getgamesneko;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.neko.util.HackWebView;
import com.facebook.neko.util.HackWebViewClient;
import com.facebook.neko.util.LicenseDialog.C01141;
import com.facebook.neko.util.MainActivityFragment.OnAppLogListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: topFocus */
public class GetGamesNekoActivity extends FbFragmentActivity implements OnAppLogListener {
    @Inject
    public AnalyticsLogger f817p;

    /* compiled from: topFocus */
    class C01072 implements OnClickListener {
        final /* synthetic */ GetGamesNekoActivity f816a;

        C01072(GetGamesNekoActivity getGamesNekoActivity) {
            this.f816a = getGamesNekoActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1374808269);
            this.f816a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1486609928, a);
        }
    }

    private static <T extends Context> void m1101a(Class<T> cls, T t) {
        m1102a((Object) t, (Context) t);
    }

    public static void m1102a(Object obj, Context context) {
        ((GetGamesNekoActivity) obj).f817p = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
    }

    private void m1099a(AnalyticsLogger analyticsLogger) {
        this.f817p = analyticsLogger;
    }

    public final void mo7a() {
        m1104b(this, "getgames_no_network_error");
    }

    public final void mo9b() {
        m1104b(this, "getgames_no_fill_error");
    }

    public final void mo8a(Map<String, String> map) {
        m1103a("getgames_scrolled_event", (Map) map);
    }

    protected final void m1108b(Bundle bundle) {
        super.b(bundle);
        Class cls = GetGamesNekoActivity.class;
        m1102a((Object) this, (Context) this);
        setContentView(2130903089);
        ((FbTextView) findViewById(2131562159)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GetGamesNekoActivity f815b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1444934695);
                GetGamesNekoActivity.m1104b(this.f815b, "getgames_ad_choices_tap");
                FragmentActivity fragmentActivity = this;
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(fragmentActivity).inflate(2130905033, null);
                Display defaultDisplay = ((WindowManager) fragmentActivity.getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                HackWebView hackWebView = (HackWebView) frameLayout.findViewById(2131559150);
                hackWebView.getLayoutParams().width = (int) (((float) point.x) * 0.9f);
                ProgressBar progressBar = (ProgressBar) frameLayout.findViewById(2131559418);
                progressBar.getLayoutParams().width = (int) (((float) point.x) * 0.9f);
                String string = fragmentActivity.getResources().getString(2131242235);
                hackWebView.loadUrl(string);
                FbTextView fbTextView = (FbTextView) frameLayout.findViewById(2131563413);
                new Builder(fragmentActivity).setView(frameLayout).setNegativeButton(2131242240, new C01141()).show();
                hackWebView.setWebViewClient(new HackWebViewClient(string, progressBar, fragmentActivity, fbTextView));
                Logger.a(2, EntryType.UI_INPUT_END, -1169996321, a);
            }
        });
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(2131242258);
        fbTitleBar.setHasFbLogo(true);
        fbTitleBar.a(new C01072(this));
        m1104b(this, "getgames_activity_start");
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -112138388);
        super.onResume();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1529773536, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1928823448);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2087643294, a);
    }

    public static void m1104b(GetGamesNekoActivity getGamesNekoActivity, String str) {
        getGamesNekoActivity.f817p.a(new HoneyClientEvent(str));
    }

    private void m1103a(String str, Map<String, String> map) {
        this.f817p.a(str, map);
    }
}
