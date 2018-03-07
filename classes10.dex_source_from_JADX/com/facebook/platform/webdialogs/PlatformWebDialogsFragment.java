package com.facebook.platform.webdialogs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.PlatformAnalyticsEventBuilder;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.common.util.PlatformBundleToJSONConverter;
import com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsBridgeApi;
import com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsOpenDialogBridgeApiFactory.Api;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.webview.FacebookWebView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: location_has_inconsistent_timestamp */
public class PlatformWebDialogsFragment extends FbFragment {
    @Inject
    AnalyticsLogger f8502a;
    public PlatformWebViewActionManifest al;
    public FrameLayout am;
    public ProgressBar an;
    public FacebookWebView ao;
    public PlatformWebDialogsBridgeApi ap;
    public Api aq;
    public boolean ar;
    public boolean as;
    public boolean at;
    @Inject
    PlatformBundleToJSONConverter f8503b;
    @Inject
    public PlatformWebViewClient f8504c;
    @Inject
    SecureWebViewHelper f8505d;
    @Inject
    public SecureContextHelper f8506e;
    @Inject
    public PlatformWebDialogsManifest f8507f;
    @Inject
    public PlatformWebDialogsPerformanceLogger f8508g;
    public C12672 f8509h;
    public PlatformAppCall f8510i;

    /* compiled from: location_has_inconsistent_timestamp */
    public class C12661 implements Runnable {
        final /* synthetic */ PlatformWebDialogsFragment f8497a;

        public C12661(PlatformWebDialogsFragment platformWebDialogsFragment) {
            this.f8497a = platformWebDialogsFragment;
        }

        public void run() {
            if (!this.f8497a.at) {
                Intent intent = new Intent();
                intent.putExtras(PlatformAppResults.a(this.f8497a.f8510i, "UserCanceled", "User cancelled the dialog"));
                PlatformWebDialogsFragment.m8400a(this.f8497a, 0, intent);
                PlatformWebDialogsPerformanceLogger platformWebDialogsPerformanceLogger = this.f8497a.f8508g;
                platformWebDialogsPerformanceLogger.f8513a.d(platformWebDialogsPerformanceLogger.f8514b);
            }
        }
    }

    /* compiled from: location_has_inconsistent_timestamp */
    class C12683 implements OnTouchListener {
        final /* synthetic */ PlatformWebDialogsFragment f8501a;

        C12683(PlatformWebDialogsFragment platformWebDialogsFragment) {
            this.f8501a = platformWebDialogsFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            return false;
        }
    }

    public static void m8403a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlatformWebDialogsFragment) obj).m8399a(AnalyticsLoggerMethodAutoProvider.a(injectorLike), PlatformBundleToJSONConverter.a(injectorLike), PlatformWebViewClient.m8436a(injectorLike), SecureWebViewHelper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PlatformWebDialogsManifest.a(injectorLike), PlatformWebDialogsPerformanceLogger.m8413a(injectorLike));
    }

    private void m8399a(AnalyticsLogger analyticsLogger, PlatformBundleToJSONConverter platformBundleToJSONConverter, PlatformWebViewClient platformWebViewClient, SecureWebViewHelper secureWebViewHelper, SecureContextHelper secureContextHelper, PlatformWebDialogsManifest platformWebDialogsManifest, PlatformWebDialogsPerformanceLogger platformWebDialogsPerformanceLogger) {
        this.f8502a = analyticsLogger;
        this.f8503b = platformBundleToJSONConverter;
        this.f8504c = platformWebViewClient;
        this.f8505d = secureWebViewHelper;
        this.f8506e = secureContextHelper;
        this.f8507f = platformWebDialogsManifest;
        this.f8508g = platformWebDialogsPerformanceLogger;
    }

    public final void m8407a(PlatformWebDialogsBridgeApi platformWebDialogsBridgeApi, Bundle bundle) {
        String str = platformWebDialogsBridgeApi.f8537b;
        if (!Strings.isNullOrEmpty(str)) {
            this.f8504c.m8439a(this.ao, str, this.f8503b.a(bundle));
        }
    }

    public final void m8408c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformWebDialogsFragment.class;
        m8403a((Object) this, getContext());
        this.f8508g.m8424c();
        this.f8510i = (PlatformAppCall) o().getIntent().getParcelableExtra("com.facebook.platform.webdialogs.APPCALL_PARCEL");
        if (this.f8510i == null) {
            av(this);
            return;
        }
        if (bundle != null) {
            this.al = (PlatformWebViewActionManifest) bundle.getParcelable("com.facebook.platform.webdialogs.ACTION_MANIFEST_PARCEL");
        }
        this.f8508g.m8425d();
    }

    public final View m8405a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -643602638);
        this.f8508g.m8426e();
        this.am = new FrameLayout(getContext());
        this.ao = new FacebookWebView(getContext());
        this.ao.setVisibility(4);
        this.am.addView(this.ao, new LayoutParams(-1, -1));
        WebViewClient webViewClient = this.f8504c;
        FacebookWebView facebookWebView = this.ao;
        facebookWebView.setWebViewClient(webViewClient);
        if (facebookWebView.a("fbplatdialog") == null) {
            facebookWebView.a("fbplatdialog", webViewClient.f8534i);
        }
        this.f8508g.m8427f();
        View view = this.am;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1465161530, a);
        return view;
    }

    public final void m8409d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1719927362);
        super.d(bundle);
        if (this.al == null) {
            final String str = this.f8510i.i;
            this.f8508g.m8428g();
            this.al = this.f8507f.a(str);
            if (this.al != null) {
                this.f8508g.m8422a(this.al, false, false);
                m8401a(this, this.al);
            } else {
                this.an = new ProgressBar(getContext());
                this.am.addView(this.an, new LayoutParams(-2, -2, 17));
                this.f8509h = new Object(this) {
                    public final /* synthetic */ PlatformWebDialogsFragment f8499b;
                    private boolean f8500c = false;

                    public final void m8397a() {
                        PlatformWebDialogsFragment.m8402a(this.f8499b, "platform_webview_manifest_refresh_succeeded");
                        if (!this.f8500c) {
                            PlatformWebDialogsFragment.av(this.f8499b);
                        }
                    }

                    public final void m8398a(PlatformWebViewActionManifest platformWebViewActionManifest, boolean z) {
                        if (platformWebViewActionManifest.a().equalsIgnoreCase(str)) {
                            this.f8499b.f8508g.m8422a(platformWebViewActionManifest, true, z);
                            PlatformWebDialogsFragment.m8402a(this.f8499b, "platform_webview_method_refresh_succeeded");
                            this.f8500c = true;
                            PlatformWebDialogsFragment.m8401a(this.f8499b, platformWebViewActionManifest);
                        }
                    }
                };
                this.f8507f.a(str, this.f8509h);
            }
        } else {
            m8401a(this, this.al);
        }
        LogUtils.f(1594311757, a);
    }

    public final void m8410e(Bundle bundle) {
        if (this.al != null) {
            bundle.putParcelable("com.facebook.platform.webdialogs.ACTION_MANIFEST_PARCEL", this.al);
        }
    }

    public final void m8404I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1338666518);
        ax();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2010511252, a);
    }

    public final void m8406a(PlatformWebDialogsBridgeApi platformWebDialogsBridgeApi) {
        this.ap = platformWebDialogsBridgeApi;
        platformWebDialogsBridgeApi.mo371a(this, this);
    }

    public static void m8401a(PlatformWebDialogsFragment platformWebDialogsFragment, PlatformWebViewActionManifest platformWebViewActionManifest) {
        platformWebDialogsFragment.al = platformWebViewActionManifest;
        if (platformWebDialogsFragment.al == null) {
            av(platformWebDialogsFragment);
            return;
        }
        platformWebDialogsFragment.f8508g.m8420a(platformWebDialogsFragment.f8510i, platformWebViewActionManifest);
        String c = platformWebViewActionManifest.c();
        Intent intent = platformWebDialogsFragment.o().getIntent();
        JSONObject a = platformWebDialogsFragment.f8503b.a(intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS"));
        JSONObject a2 = platformWebDialogsFragment.f8503b.a(intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS"));
        JSONObject a3 = platformWebDialogsFragment.f8503b.a(intent.getBundleExtra("com.facebook.platform.webdialogs.HOST_ARGS"));
        if (Strings.isNullOrEmpty(c) || a == null || a3 == null) {
            av(platformWebDialogsFragment);
            return;
        }
        if (a2 == null) {
            a2 = new JSONObject();
        }
        boolean contains = c.contains("#");
        StringBuilder stringBuilder = new StringBuilder(c);
        stringBuilder.append(contains ? "&" : "#");
        stringBuilder.append("bridge_args=");
        stringBuilder.append(Uri.encode(a.toString()));
        stringBuilder.append("&method_args").append("=");
        stringBuilder.append(Uri.encode(a2.toString()));
        stringBuilder.append("&host_app_args").append("=");
        stringBuilder.append(Uri.encode(a3.toString()));
        stringBuilder.append("&app_id").append("=");
        stringBuilder.append(platformWebDialogsFragment.f8510i.e);
        stringBuilder.append("&version").append("=");
        stringBuilder.append(platformWebDialogsFragment.f8510i.b);
        platformWebDialogsFragment.ao.setFocusable(true);
        platformWebDialogsFragment.ao.setFocusableInTouchMode(true);
        platformWebDialogsFragment.ao.setOnTouchListener(new C12683(platformWebDialogsFragment));
        PlatformWebViewClient platformWebViewClient = platformWebDialogsFragment.f8504c;
        FacebookWebView facebookWebView = platformWebDialogsFragment.ao;
        Preconditions.checkNotNull(facebookWebView);
        Preconditions.checkNotNull(platformWebDialogsFragment);
        if (!platformWebViewClient.f8533h.containsKey(facebookWebView)) {
            platformWebViewClient.f8533h.put(facebookWebView, platformWebDialogsFragment);
        }
        platformWebDialogsFragment.f8508g.m8429h();
        platformWebDialogsFragment.f8505d.a(platformWebDialogsFragment.ao, stringBuilder.toString());
    }

    public static void av(PlatformWebDialogsFragment platformWebDialogsFragment) {
        Intent intent = new Intent();
        intent.putExtras(PlatformAppResults.a(platformWebDialogsFragment.f8510i, "UnknownError", "Dialog failed with unknown error"));
        m8400a(platformWebDialogsFragment, 0, intent);
        platformWebDialogsFragment.f8508g.m8433l();
    }

    public static void aw(PlatformWebDialogsFragment platformWebDialogsFragment) {
        Intent intent = new Intent();
        intent.putExtras(PlatformAppResults.a(platformWebDialogsFragment.f8510i, "NetworkError", "Could not load the dialog from network"));
        m8400a(platformWebDialogsFragment, 0, intent);
        platformWebDialogsFragment.f8508g.m8433l();
    }

    public static void m8400a(PlatformWebDialogsFragment platformWebDialogsFragment, int i, Intent intent) {
        if (!platformWebDialogsFragment.at) {
            platformWebDialogsFragment.at = true;
            platformWebDialogsFragment.ax();
            platformWebDialogsFragment.o().setResult(i, intent);
            platformWebDialogsFragment.o().finish();
        }
    }

    private void ax() {
        PlatformWebViewClient platformWebViewClient = this.f8504c;
        FacebookWebView facebookWebView = this.ao;
        Preconditions.checkNotNull(facebookWebView);
        if (platformWebViewClient.f8533h.containsKey(facebookWebView) && platformWebViewClient.f8533h.remove(facebookWebView) != null) {
        }
        PlatformWebDialogsManifest platformWebDialogsManifest = this.f8507f;
        C12672 c12672 = this.f8509h;
        platformWebDialogsManifest.t.a();
        platformWebDialogsManifest.h.remove(c12672);
    }

    public static void m8402a(PlatformWebDialogsFragment platformWebDialogsFragment, String str) {
        AnalyticsLogger analyticsLogger = platformWebDialogsFragment.f8502a;
        PlatformAnalyticsEventBuilder platformAnalyticsEventBuilder = new PlatformAnalyticsEventBuilder(str, "platform_web_view");
        platformAnalyticsEventBuilder.i = Integer.MIN_VALUE;
        platformAnalyticsEventBuilder = platformAnalyticsEventBuilder;
        platformAnalyticsEventBuilder.h = "webdialog";
        PlatformAnalyticsEventBuilder platformAnalyticsEventBuilder2 = platformAnalyticsEventBuilder;
        platformAnalyticsEventBuilder2.b = platformWebDialogsFragment.f8510i.a;
        platformAnalyticsEventBuilder2 = platformAnalyticsEventBuilder2;
        platformAnalyticsEventBuilder2.c = platformWebDialogsFragment.f8510i.e;
        platformAnalyticsEventBuilder2 = platformAnalyticsEventBuilder2;
        platformAnalyticsEventBuilder2.g = platformWebDialogsFragment.f8510i.i;
        analyticsLogger.c(platformAnalyticsEventBuilder2.a());
    }
}
