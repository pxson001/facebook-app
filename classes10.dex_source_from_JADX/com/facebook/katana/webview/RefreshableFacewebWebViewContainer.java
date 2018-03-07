package com.facebook.katana.webview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.faceweb.FacewebFragment.C01122;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.webview.FacewebWebView.FacewebErrorType;
import com.facebook.katana.webview.FacewebWebView.PageState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacewebPalCall;
import com.facebook.widget.CustomViewUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: timeline_invalid_meuser */
public class RefreshableFacewebWebViewContainer extends SwipeRefreshLayout {
    public static final Class<?> f1338l = RefreshableFacewebWebViewContainer.class;
    private ContentFlags f1339A = ContentFlags.UNDEFINED;
    public final OnScrollChangedListener f1340B = new OnScrollChangedListener(this) {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1324a;

        {
            this.f1324a = r1;
        }

        public void onScrollChanged() {
            if (this.f1324a.f1350m.getScrollY() == 0) {
                this.f1324a.setEnabled(true);
            } else {
                this.f1324a.setEnabled(false);
            }
        }
    };
    public AlertDialog f1341c;
    @Inject
    public AnalyticsLogger f1342d;
    @Inject
    InteractionLogger f1343e;
    @Inject
    MonotonicClock f1344f;
    @Inject
    AbstractFbErrorReporter f1345g;
    @Inject
    ImpressionManager f1346h;
    @Inject
    public PerformanceLogger f1347i;
    public boolean f1348j = false;
    public boolean f1349k = false;
    public FacewebWebView f1350m;
    public View f1351n;
    public View f1352o;
    public FrameLayout f1353p;
    public C01122 f1354q;
    private C02232 f1355r;
    public Handler f1356s;
    public int f1357t = 0;
    private long f1358u = 0;
    public boolean f1359v = false;
    public boolean f1360w = true;
    private String f1361x;
    public ContentState f1362y = ContentState.CONTENT_STATE_LOADING;
    private ContentState f1363z = ContentState.CONTENT_STATE_LOADING;

    /* compiled from: timeline_invalid_meuser */
    class C02211 implements OnRefreshListener {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1325a;

        C02211(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1325a = refreshableFacewebWebViewContainer;
        }

        public final void m1360a() {
            this.f1325a.m1374b();
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public class C02232 {
        public final /* synthetic */ RefreshableFacewebWebViewContainer f1327a;

        /* compiled from: timeline_invalid_meuser */
        class C02221 implements Runnable {
            final /* synthetic */ C02232 f1326a;

            C02221(C02232 c02232) {
                this.f1326a = c02232;
            }

            public void run() {
                this.f1326a.f1327a.f1350m.m1344d();
            }
        }

        C02232(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1327a = refreshableFacewebWebViewContainer;
        }

        public final void m1362a(PageState pageState) {
            if (pageState != PageState.PAGE_STATE_SUCCESS) {
                this.f1327a.m1373a(ContentState.CONTENT_STATE_LOADING);
            }
        }

        public final void m1361a(FacewebErrorType facewebErrorType) {
            if (this.f1327a.f1357t < 3) {
                Runnable c02221 = new C02221(this);
                HandlerDetour.a(this.f1327a.f1356s, c02221);
                HandlerDetour.b(this.f1327a.f1356s, c02221, 200, 1716692802);
                Class cls = RefreshableFacewebWebViewContainer.f1338l;
                Integer.valueOf(this.f1327a.f1357t);
                RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.f1327a;
                refreshableFacewebWebViewContainer.f1357t++;
                return;
            }
            TextView textView = (TextView) this.f1327a.f1352o.findViewById(2131561724);
            if (textView != null) {
                if (facewebErrorType == null) {
                    textView.setText("");
                } else {
                    textView.setText(facewebErrorType.getErrorMessageId());
                }
            }
            this.f1327a.m1373a(ContentState.CONTENT_STATE_ERROR);
        }
    }

    /* compiled from: timeline_invalid_meuser */
    class C02243 implements NativeCallHandler {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1328a;

        C02243(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1328a = refreshableFacewebWebViewContainer;
        }

        public final void m1363a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            RefreshableFacewebWebViewContainer.setEnable(this.f1328a, true);
        }
    }

    /* compiled from: timeline_invalid_meuser */
    class C02254 implements NativeCallHandler {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1329a;

        C02254(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1329a = refreshableFacewebWebViewContainer;
        }

        public final void m1364a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            RefreshableFacewebWebViewContainer.setEnable(this.f1329a, false);
        }
    }

    /* compiled from: timeline_invalid_meuser */
    class C02265 implements NativeCallHandler {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1330a;

        C02265(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1330a = refreshableFacewebWebViewContainer;
        }

        public final void m1365a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.f1330a;
            refreshableFacewebWebViewContainer.f1349k = false;
            refreshableFacewebWebViewContainer.f1360w = true;
            if (!refreshableFacewebWebViewContainer.f1359v) {
                refreshableFacewebWebViewContainer.f1359v = true;
            }
            String a = StringUtils.a(refreshableFacewebWebViewContainer.f1350m.getUrl());
            if (a != null) {
                refreshableFacewebWebViewContainer.f1347i.c(2359300, "FacewebPageRPCLoadCompleted:" + a);
            }
            refreshableFacewebWebViewContainer.m1373a(ContentState.CONTENT_STATE_LOAD_COMPLETE);
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public class C02276 implements OnCancelListener {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1331a;

        public C02276(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1331a = refreshableFacewebWebViewContainer;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f1331a.f1341c = null;
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public class C02287 implements OnClickListener {
        final /* synthetic */ List f1332a;
        final /* synthetic */ Context f1333b;
        final /* synthetic */ String f1334c;
        final /* synthetic */ RefreshableFacewebWebViewContainer f1335d;

        public C02287(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer, List list, Context context, String str) {
            this.f1335d = refreshableFacewebWebViewContainer;
            this.f1332a = list;
            this.f1333b = context;
            this.f1334c = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int intValue = ((Integer) this.f1332a.get(i)).intValue();
            if (intValue == 2131236572) {
                try {
                    RefreshableFacewebWebViewContainer.m1370b(this.f1333b, this.f1334c);
                } catch (Throwable e) {
                    this.f1335d.f1345g.a("RefreshableFacewebWebViewContainer", "copy link failed", e);
                }
            } else if (intValue == 2131236573) {
                this.f1333b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f1334c)));
            }
            this.f1335d.f1341c = null;
            dialogInterface.dismiss();
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public class C02298 implements OnLongClickListener {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1336a;

        public C02298(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1336a = refreshableFacewebWebViewContainer;
        }

        public boolean onLongClick(View view) {
            if (!this.f1336a.f) {
                HitTestResult hitTestResult = ((WebView) view).getHitTestResult();
                if (hitTestResult.getType() == 7) {
                    String extra = hitTestResult.getExtra();
                    if (extra.startsWith("http")) {
                        RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.f1336a;
                        if (extra != null) {
                            Context context = refreshableFacewebWebViewContainer.getContext();
                            String a = RefreshableFacewebWebViewContainer.m1367a(extra);
                            List arrayList = new ArrayList();
                            List arrayList2 = new ArrayList();
                            arrayList.add(context.getString(2131236572));
                            arrayList2.add(Integer.valueOf(2131236572));
                            arrayList.add(context.getString(2131236573));
                            arrayList2.add(Integer.valueOf(2131236573));
                            refreshableFacewebWebViewContainer.f1341c = new Builder(context).a((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]), new C02287(refreshableFacewebWebViewContainer, arrayList2, context, a)).a(new C02276(refreshableFacewebWebViewContainer)).b();
                        }
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public class C02309 implements View.OnClickListener {
        final /* synthetic */ RefreshableFacewebWebViewContainer f1337a;

        public C02309(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer) {
            this.f1337a = refreshableFacewebWebViewContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1023483923);
            this.f1337a.f1350m.m1344d();
            Logger.a(2, EntryType.UI_INPUT_END, 1292162848, a);
        }
    }

    /* compiled from: timeline_invalid_meuser */
    public enum ContentState {
        CONTENT_STATE_WEBVIEW,
        CONTENT_STATE_LOADING,
        CONTENT_STATE_ERROR,
        CONTENT_STATE_LOAD_COMPLETE
    }

    public static void m1369a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RefreshableFacewebWebViewContainer) obj).m1368a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), InteractionLogger.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), ImpressionManager.a(fbInjector), (PerformanceLogger) DelegatingPerformanceLogger.a(fbInjector));
    }

    public RefreshableFacewebWebViewContainer(Context context) {
        super(context);
        m1371g();
    }

    private void m1371g() {
        Class cls = RefreshableFacewebWebViewContainer.class;
        m1369a(this, getContext());
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131362148)));
        setColorSchemeResources(new int[]{2131361916});
        this.f1356s = new Handler();
        this.e = new C02211(this);
        this.f1355r = new C02232(this);
        this.f1350m = new FacewebWebView(getContext(), this.f1355r);
        this.f1350m.setFocusable(true);
        this.f1350m.setFocusableInTouchMode(true);
        Drawable colorDrawable = new ColorDrawable(getResources().getColor(2131362148));
        if (VERSION.SDK_INT > 16) {
            this.f1350m.setBackground(colorDrawable);
        } else {
            this.f1350m.setBackgroundDrawable(colorDrawable);
        }
        this.f1350m.setScrollContainer(false);
        this.f1350m.setLongClickable(true);
        this.f1350m.setOnLongClickListener(new C02298(this));
        this.f1350m.a("enablePullToRefresh", new C02243(this));
        this.f1350m.a("disablePullToRefresh", new C02254(this));
        this.f1350m.a("loadCompleted", new C02265(this));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f1353p = new FrameLayout(getContext());
        addView(this.f1353p, layoutParams);
        this.f1353p.addView(this.f1350m, new FrameLayout.LayoutParams(-1, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f1351n = from.inflate(2130904237, this.f1353p, false);
        this.f1351n.setVisibility(8);
        this.f1353p.addView(this.f1351n, new LayoutParams(-1, -1));
        this.f1352o = from.inflate(2130904235, this.f1353p, false);
        this.f1352o.setOnClickListener(new C02309(this));
        this.f1353p.addView(this.f1352o, new RelativeLayout.LayoutParams(-1, -1));
        if (!this.f1360w) {
            m1372h();
        }
    }

    public final void m1374b() {
        this.f1350m.scrollTo(0, 0);
        m1372h();
        this.f1350m.m1343c();
        this.f1350m.setVerticalScrollBarEnabled(true);
    }

    private void m1372h() {
        this.f1349k = true;
        setRefreshing(false);
    }

    public static String m1367a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getHost().equals("m.facebook.com") && parse.getPath().equals("/l.php")) {
                str = parse.getQueryParameter("u");
            }
        } catch (NullPointerException e) {
        }
        return str;
    }

    public static void m1370b(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }

    public final void m1373a(ContentState contentState) {
        if (this.f1362y != contentState) {
            this.f1363z = this.f1362y;
        }
        this.f1362y = contentState;
        if (contentState != ContentState.CONTENT_STATE_LOADING) {
            if (this.f1358u != 0 && this.f1343e.a(this.f1344f.now() - this.f1358u, this.f1351n)) {
                this.f1358u = 0;
            }
            this.f1351n.setVisibility(8);
        }
        if (!(contentState == ContentState.CONTENT_STATE_WEBVIEW || contentState == ContentState.CONTENT_STATE_LOAD_COMPLETE)) {
            this.f1350m.setVisibility(8);
        }
        if (contentState != ContentState.CONTENT_STATE_ERROR) {
            this.f1352o.setVisibility(8);
        }
        ContentFlags contentFlags = ContentFlags.UNDEFINED;
        if (contentState == ContentState.CONTENT_STATE_LOADING) {
            if (InteractionLogger.a(this.f1351n)) {
                this.f1358u = this.f1344f.now();
            }
            this.f1351n.setVisibility(0);
            this.f1351n.bringToFront();
            contentFlags = ContentFlags.LOCAL_DATA;
        } else if (contentState == ContentState.CONTENT_STATE_ERROR) {
            this.f1352o.setVisibility(0);
            this.f1352o.bringToFront();
            HoneyClientEventFast a = this.f1342d.a(FB4A_AnalyticEntities.a, false);
            if (a.a()) {
                a.b();
            }
            contentFlags = ContentFlags.NETWORK_DATA;
        } else if (this.f1363z == ContentState.CONTENT_STATE_LOADING && (contentState == ContentState.CONTENT_STATE_WEBVIEW || contentState == ContentState.CONTENT_STATE_LOAD_COMPLETE)) {
            this.f1350m.setVisibility(0);
            this.f1350m.bringToFront();
            contentFlags = ContentFlags.NETWORK_DATA;
        }
        if (contentFlags != ContentFlags.UNDEFINED) {
            if (!(getContext() == null || contentFlags == this.f1339A)) {
                this.f1343e.a(contentFlags, m1366a(getContext()), this.f1346h.b(getContext()));
            }
            this.f1339A = contentFlags;
        }
        if (contentState == ContentState.CONTENT_STATE_WEBVIEW || contentState == ContentState.CONTENT_STATE_ERROR || contentState == ContentState.CONTENT_STATE_LOAD_COMPLETE) {
            setRefreshing(false);
        }
    }

    private String m1366a(Context context) {
        if (this.f1361x == null) {
            Activity activity = (Activity) context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(activity.getClass().getSimpleName());
            String a = ActivityLaunchIntentUtil.a(activity.getIntent());
            if (a != null) {
                stringBuilder.append('@');
                stringBuilder.append(a);
            }
            this.f1361x = stringBuilder.toString();
        }
        return this.f1361x;
    }

    public static void setEnable(RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer, final boolean z) {
        Runnable anonymousClass10 = new Runnable(refreshableFacewebWebViewContainer) {
            final /* synthetic */ RefreshableFacewebWebViewContainer f1323b;

            public void run() {
                this.f1323b.f1348j = z;
                ViewCompat.a.c(this.f1323b.f1350m, 2);
            }
        };
        if (VERSION.SDK_INT < 18 || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass10.run();
        } else {
            refreshableFacewebWebViewContainer.post(anonymousClass10);
        }
    }

    private void m1368a(AnalyticsLogger analyticsLogger, InteractionLogger interactionLogger, MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter, ImpressionManager impressionManager, PerformanceLogger performanceLogger) {
        this.f1342d = analyticsLogger;
        this.f1343e = interactionLogger;
        this.f1344f = monotonicClock;
        this.f1345g = abstractFbErrorReporter;
        this.f1346h = impressionManager;
        this.f1347i = performanceLogger;
    }
}
