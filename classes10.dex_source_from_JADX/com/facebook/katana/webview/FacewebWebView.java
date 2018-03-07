package com.facebook.katana.webview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.http.SslError;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.diagnostics.NetAccessLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.common.util.Tuple;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.debug.log.BLog;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.katana.activity.faceweb.FacewebFragment.AnonymousClass10;
import com.facebook.katana.activity.faceweb.FacewebFragment.C01122;
import com.facebook.katana.constants.Constants.URL;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession.LogoutReason;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.katana.useragent.UserAgent;
import com.facebook.katana.util.MSiteUrlUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.WeakRef;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Key;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Listener;
import com.facebook.katana.webview.FacewebComponentsStoreCache.LoadError;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Value;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer.C02232;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer.ContentState;
import com.facebook.manageddatastore.ManagedDataStore$ClearType;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.Toaster;
import com.facebook.webview.BasicWebView;
import com.facebook.webview.FacebookJsBridge;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.FacebookWebViewClient;
import com.facebook.webview.FacebookWebView.JsReturnHandler;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.webview.FacebookWebView.RPCChromeClient;
import com.facebook.webview.FacewebPalCall;
import com.facebook.webview.FacewebUriPalCall;
import com.facebook.webview.FacewebUriPalCall.JsVariable;
import com.facebook.webview.auth.AuthCallback;
import com.facebook.webview.auth.Authenticator;
import com.facebook.webview.eventbus.FacewebEventBus;
import com.facebook.webview.eventbus.FacewebEvents.BootstrapExecutionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: timeline_next_section_not_found */
public class FacewebWebView extends FacebookWebView {
    public static final Class<?> f1281B = FacewebWebView.class;
    protected static Set<WeakRef<FacewebWebView>> f1282i = new HashSet();
    public static final ImmutableSet<String> f1283j = ImmutableSet.a(new String[]{"fb", "dialtone"});
    public String f1284A = null;
    private boolean f1285C = false;
    public List<FacewebPalCall> f1286D = new ArrayList();
    public boolean f1287E = false;
    public AnonymousClass10 f1288F;
    protected Listener f1289k;
    protected AuthCallback f1290l;
    public C02232 f1291m;
    public AddressBookPeriodicRunner f1292n;
    protected Fb4aUriIntentMapper f1293o;
    protected SecureContextHelper f1294p;
    protected IntentHandlerUtil f1295q;
    protected Authenticator f1296r;
    protected MSiteUrlUtils f1297s;
    protected InterstitialStartHelper f1298t;
    protected FacewebEventBus f1299u;
    protected TriState f1300v;
    protected boolean f1301w;
    protected boolean f1302x;
    protected PageState f1303y = PageState.PAGE_STATE_UINITIALIZED;
    protected FacewebErrorType f1304z;

    /* compiled from: timeline_next_section_not_found */
    class C02082 implements AuthCallback {
        final /* synthetic */ FacewebWebView f1264a;

        C02082(FacewebWebView facewebWebView) {
            this.f1264a = facewebWebView;
        }

        public final void m1312a() {
            this.f1264a.m1343c();
        }

        public final void m1313b() {
            this.f1264a.m1341a(FacewebErrorType.AUTHENTICATION_ERROR, LogoutReason.FORCED_FACEWEB_AUTHENTICATION_FAILED);
        }

        public final void m1314c() {
            this.f1264a.m1341a(FacewebErrorType.AUTHENTICATION_NETWORK_ERROR, LogoutReason.FACEWEB_NONSPECIFIC);
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02104 implements NativeCallHandler {
        final /* synthetic */ FacewebWebView f1268a;

        C02104(FacewebWebView facewebWebView) {
            this.f1268a = facewebWebView;
        }

        public final void m1316a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            facebookWebView.j = true;
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02115 implements NativeCallHandler {
        final /* synthetic */ FacewebWebView f1269a;

        public final void m1317a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String a = facewebPalCall.a(facebookWebView.k, "version");
            if (a != null) {
                MFacewebVersion.m1349a(context, a);
            }
            FacewebComponentsStoreCache.m1298d(context).a(ManagedDataStore$ClearType.CLEAR_ALL, 3600);
        }

        C02115(FacewebWebView facewebWebView) {
            this.f1269a = facewebWebView;
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02126 implements NativeCallHandler {
        final /* synthetic */ FacewebWebView f1270a;

        C02126(FacewebWebView facewebWebView) {
            this.f1270a = facewebWebView;
        }

        public final void m1318a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            FacewebWebView facewebWebView = this.f1270a;
            FacewebWebView.m1339q(facewebWebView);
            facewebWebView.f1291m.m1362a(PageState.PAGE_STATE_UINITIALIZED);
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02137 implements Listener {
        final /* synthetic */ FacewebWebView f1271a;

        C02137(FacewebWebView facewebWebView) {
            this.f1271a = facewebWebView;
        }

        public final void mo51a(FacewebComponentsStore facewebComponentsStore) {
        }

        public final void mo52a(LoadError loadError, String str) {
            if (loadError == LoadError.NETWORK_ERROR) {
                this.f1271a.m1341a(FacewebErrorType.AUTHENTICATION_NETWORK_ERROR, LogoutReason.FACEWEB_NONSPECIFIC);
            } else {
                this.f1271a.m1341a(FacewebErrorType.AUTHENTICATION_ERROR, LogoutReason.FORCED_FACEWEB_COMPONENTS_STORE_ERROR);
            }
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02148 implements OnTouchListener {
        final /* synthetic */ FacewebWebView f1272a;

        C02148(FacewebWebView facewebWebView) {
            this.f1272a = facewebWebView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f1272a.m1347g();
            if (!this.f1272a.f1301w && motionEvent.getAction() == 2) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class C02159 implements JsReturnHandler {
        final /* synthetic */ FacewebWebView f1273a;

        C02159(FacewebWebView facewebWebView) {
            this.f1273a = facewebWebView;
        }

        public final void m1321a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            if ("1".equals(str2)) {
                this.f1273a.f1301w = true;
                FacewebWebView facewebWebView = this.f1273a;
                facewebWebView.setVerticalScrollBarEnabled(true);
                facewebWebView.setHorizontalScrollBarEnabled(true);
                return;
            }
            this.f1273a.f1301w = false;
            facewebWebView = this.f1273a;
            facewebWebView.setVerticalScrollBarEnabled(false);
            facewebWebView.setHorizontalScrollBarEnabled(false);
        }
    }

    /* compiled from: timeline_next_section_not_found */
    class BroadcastScriptHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebWebView f1276b;

        public final void m1322a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            final String a = facewebPalCall.a(facebookWebView.k, "script");
            int parseInt = Integer.parseInt(facewebPalCall.a(facebookWebView.k, "delay"));
            if (URL.d(facebookWebView.getUrl())) {
                HandlerDetour.b(this.a, new Runnable(this) {
                    final /* synthetic */ BroadcastScriptHandler f1275b;

                    public void run() {
                        for (FacewebWebView facewebWebView : FacewebWebView.getRegisteredFacewebWebViews()) {
                            if (URL.d(facewebWebView.getUrl())) {
                                facewebWebView.a(a, null);
                            } else {
                                Class cls = FacewebWebView.f1281B;
                                new StringBuilder("Skipped broadcast to non-FB url: ").append(facewebWebView.getUrl());
                            }
                        }
                    }
                }, (long) parseInt, -514272268);
            } else {
                BLog.b(FacewebWebView.f1281B, "Page with Non-facebook URL (" + facebookWebView.getUrl() + ") attempting to invoke broadcastScript");
            }
        }

        public BroadcastScriptHandler(FacewebWebView facewebWebView, Handler handler) {
            this.f1276b = facewebWebView;
            super(handler);
        }
    }

    /* compiled from: timeline_next_section_not_found */
    public enum FacewebErrorType {
        AUTHENTICATION_NETWORK_ERROR(2131236566),
        AUTHENTICATION_ERROR,
        UNKNOWN_ERROR(2131236567),
        SSL_ERROR(2131236565),
        CONNECTION_ERROR(2131230760),
        SITE_ERROR(2131236567),
        INVALID_HTML_ERROR(2131236567);
        
        private int mErrorMessageId;

        private FacewebErrorType(int i) {
            this.mErrorMessageId = i;
        }

        public final int getErrorMessageId() {
            return this.mErrorMessageId;
        }
    }

    /* compiled from: timeline_next_section_not_found */
    public class FacewebGeolocationWebChromeClient extends RPCChromeClient {
        final /* synthetic */ FacewebWebView f1277b;

        protected FacewebGeolocationWebChromeClient(FacewebWebView facewebWebView) {
            this.f1277b = facewebWebView;
            super(facewebWebView);
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
            if (URL.d(str)) {
                callback.invoke(str, true, true);
            } else {
                callback.invoke(str, false, false);
            }
        }
    }

    /* compiled from: timeline_next_section_not_found */
    public class FacewebWebViewClient extends FacebookWebViewClient {
        final /* synthetic */ FacewebWebView f1280a;

        public void onLoadResource(WebView webView, String str) {
            if (BuildConstants.i && str.startsWith("http://")) {
                this.f1280a.c.a("Webview", "Webview attempted to load a resource over http: " + webView.getUrl() + ":" + str);
            }
        }

        public FacewebWebViewClient(FacewebWebView facewebWebView, Context context, Authenticator authenticator, AuthCallback authCallback, FbSharedPreferences fbSharedPreferences, NetAccessLogger netAccessLogger, TriState triState, SecureWebViewHelper secureWebViewHelper) {
            this.f1280a = facewebWebView;
            super(context, authenticator, authCallback, fbSharedPreferences, netAccessLogger, triState, secureWebViewHelper);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f1280a.f1291m.m1362a(this.f1280a.f1303y);
            webView.getSettings().setBlockNetworkImage(true);
        }

        private void m1329b() {
            if (this.f1280a.f1303y == PageState.PAGE_STATE_UINITIALIZED) {
                this.f1280a.f1287E = true;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (!FacewebWebView.m1335a(this.f1280a, parse.getScheme())) {
                this.f1280a.c.a(FacewebWebView.f1281B.getName(), "Rejecting invalid URI scheme: " + str);
                return true;
            } else if (this.f1280a.f1287E) {
                return true;
            } else {
                if (super.shouldOverrideUrlLoading(webView, str)) {
                    m1329b();
                    return true;
                } else if (this.f1280a.f1303y != PageState.PAGE_STATE_SUCCESS && FacebookUriUtil.c(parse) && !FacebookUriUtil.a(parse)) {
                    return false;
                } else {
                    if (m1326a(str)) {
                        Activity activity = (Activity) ContextUtils.a(webView.getContext(), Activity.class);
                        if (activity != null) {
                            activity.onBackPressed();
                            m1329b();
                            return true;
                        }
                    } else if (this.f1280a.f1284A != null && m1330c(str)) {
                        this.f1280a.b(this.f1280a.f1284A, null);
                        m1329b();
                        this.f1280a.f1299u.a(new BootstrapExecutionEvent());
                        return true;
                    }
                    if (this.f1280a.f1293o.a(a(), str) != null) {
                        this.f1280a.f1295q.m1254a(a(), str);
                        m1329b();
                        return true;
                    }
                    if (this.f1280a.f1288F != null) {
                        this.f1280a.f1288F.m750a(str);
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(524288);
                    try {
                        this.f1280a.f1294p.b(intent, a());
                        m1329b();
                    } catch (ActivityNotFoundException e) {
                    }
                    return true;
                }
            }
        }

        private boolean m1326a(String str) {
            return m1327a(FBLinks.cu, str);
        }

        private boolean m1327a(String str, String str2) {
            return m1328b(str).equals(m1328b(str2));
        }

        private static String m1328b(String str) {
            if (str.endsWith("/")) {
                return str;
            }
            return str + "/";
        }

        private boolean m1330c(String str) {
            return m1327a(FBLinks.cv, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f1280a.f1303y = PageState.PAGE_STATE_ERROR;
            this.f1280a.c.a(StringFormatUtil.formatStrLocaleSafe("%s.onReceivedError-%d", FacewebWebView.f1281B, Integer.valueOf(i)), StringFormatUtil.formatStrLocaleSafe("url: %s description: %s", str2, str));
            switch (i) {
                case -15:
                case -8:
                case -6:
                case -5:
                case -2:
                    this.f1280a.f1304z = FacewebErrorType.CONNECTION_ERROR;
                    break;
                case -14:
                case -13:
                case -12:
                case -9:
                case -7:
                case -4:
                    this.f1280a.f1304z = FacewebErrorType.SITE_ERROR;
                    break;
                case -11:
                case -10:
                case -3:
                    this.f1280a.f1304z = FacewebErrorType.SSL_ERROR;
                    break;
                default:
                    this.f1280a.f1304z = FacewebErrorType.SITE_ERROR;
                    break;
            }
            Class cls = FacewebWebView.f1281B;
            new StringBuilder("FacewebWebViewClient: onReceivedError:").append(i).append(":").append(str2).append(":").append(str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!this.f1280a.f1287E) {
                this.f1280a.c.a(StringFormatUtil.formatStrLocaleSafe("%s.onReceivedSSLError", FacewebWebView.f1281B), StringFormatUtil.formatStrLocaleSafe("url: %s", this.f1280a.k));
                if (this.f1280a.g.a(InternalHttpPrefKeys.j, true)) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    this.f1280a.f1303y = PageState.PAGE_STATE_ERROR;
                    this.f1280a.f1304z = FacewebErrorType.SSL_ERROR;
                    C02232 c02232 = this.f1280a.f1291m;
                    FacewebErrorType facewebErrorType = this.f1280a.f1304z;
                    PageState pageState = this.f1280a.f1303y;
                    c02232.m1361a(facewebErrorType);
                    m1331d(this, webView.getUrl());
                    Class cls = FacewebWebView.f1281B;
                    new StringBuilder("FacewebWebViewClient: onReceivedSslError:").append(sslError.toString());
                    return;
                }
                sslErrorHandler.proceed();
            }
        }

        private void m1324a(WebView webView) {
            this.f1280a.f1303y = PageState.PAGE_STATE_SUCCESS;
            this.f1280a.f1304z = null;
            FacewebWebView.m1332a((FacewebWebView) webView);
            C02232 c02232 = this.f1280a.f1291m;
            PageState pageState = this.f1280a.f1303y;
            c02232.f1327a.m1373a(ContentState.CONTENT_STATE_WEBVIEW);
            C01122 c01122 = c02232.f1327a.f1354q;
            FacewebFragment.aA(c01122.f746a);
            if (FacewebFragment.aI(c01122.f746a) && !FacewebFragment.aJ(c01122.f746a)) {
                FacewebFragment.aH(c01122.f746a);
            }
        }

        public void onPageFinished(WebView webView, final String str) {
            webView.getSettings().setBlockNetworkImage(false);
            if (!this.f1280a.f1287E) {
                FacebookWebView facebookWebView = (FacebookWebView) webView;
                StringBuilder stringBuilder = new StringBuilder("function() {window.__fbNative = {};window.__fbNative.nativeReady = true;");
                Map hashMap = new HashMap();
                hashMap.put("url", new JsVariable("url"));
                facebookWebView.a(stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("window.__fbNative.open = function(%1$s) {window.prompt(%2$s);var dialog = window.__fbNative.dialog = {close: function() {window.prompt(%3$s);},closed: false,postMessage: function(message, targetOrigin) {window.__fbNative.postMessage(message, targetOrigin);}};return dialog;};", "url", FacewebUriPalCall.a("fbrpc", "facebook", null, null, "openDialogWebview", hashMap), FacewebUriPalCall.a("fbrpc", "facebook", null, null, "closeDialogWebview", new HashMap()))).append("}();").toString(), null);
                super.onPageFinished(webView, str);
                if (this.f1280a.f1303y == PageState.PAGE_STATE_ERROR) {
                    C02232 c02232 = this.f1280a.f1291m;
                    FacewebErrorType facewebErrorType = this.f1280a.f1304z;
                    PageState pageState = this.f1280a.f1303y;
                    c02232.m1361a(facewebErrorType);
                    m1331d(this, str);
                    return;
                }
                if (str == null || !URL.b(str)) {
                    m1324a(webView);
                } else {
                    this.f1280a.a("(function(){if (window.FW_ENABLED) { return '1'; }; return null;})()", new JsReturnHandler(this) {
                        final /* synthetic */ FacewebWebViewClient f1279b;

                        public final void m1323a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
                            if (str2 == null || str2.length() <= 0 || !str2.equals("1")) {
                                this.f1279b.f1280a.c.a(StringFormatUtil.formatStrLocaleSafe("%s.onPageFinished-Error", FacewebWebView.f1281B), StringFormatUtil.formatStrLocaleSafe("url: %s", str));
                                this.f1279b.f1280a.f1303y = PageState.PAGE_STATE_ERROR;
                                this.f1279b.f1280a.f1304z = FacewebErrorType.INVALID_HTML_ERROR;
                                C02232 c02232 = this.f1279b.f1280a.f1291m;
                                FacewebErrorType facewebErrorType = this.f1279b.f1280a.f1304z;
                                PageState pageState = this.f1279b.f1280a.f1303y;
                                c02232.m1361a(facewebErrorType);
                                FacewebWebViewClient.m1331d(this.f1279b, str);
                                Class cls = FacewebWebView.f1281B;
                                return;
                            }
                            this.f1279b.m1324a((WebView) facebookWebView);
                        }
                    });
                }
                String a = StringUtils.a(str);
                if (a != null) {
                    this.f1280a.h.c(2359299, "FacewebPageNetworkLoad:" + a);
                    this.f1280a.h.d(2359302, "FacewebPageSession:" + a);
                }
            }
        }

        public static void m1331d(FacewebWebViewClient facewebWebViewClient, String str) {
            String a = StringUtils.a(str);
            if (a != null) {
                facewebWebViewClient.f1280a.h.a(2359299, "FacewebPageNetworkLoad:" + a);
                facewebWebViewClient.f1280a.h.a(2359300, "FacewebPageRPCLoadCompleted:" + a);
            }
        }
    }

    /* compiled from: timeline_next_section_not_found */
    public enum PageState {
        PAGE_STATE_ERROR,
        PAGE_STATE_SUCCESS,
        PAGE_STATE_UINITIALIZED
    }

    public static void m1334a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FacewebWebView) obj).m1333a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AddressBookPeriodicRunner.a(injectorLike), Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IntentHandlerUtil.m1246a(injectorLike), (Authenticator) FacebookAuthentication.m1284a(injectorLike), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(injectorLike), MSiteUrlUtils.b(injectorLike), InterstitialStartHelper.b(injectorLike), FacewebEventBus.m13014a(injectorLike));
    }

    public void destroy() {
        this.f1302x = true;
        if (this.j && AppSession.a(getContext(), false) != null) {
            this.f1292n.a();
        }
        m1339q(this);
        super.destroy();
    }

    public void loadUrl(String str) {
        if (!this.f1302x) {
            super.loadUrl(str);
        }
    }

    public final void m1342a(String str, boolean z) {
        m1337b(m1336b(str), z);
    }

    private String m1336b(String str) {
        if (URL.a(str)) {
            return this.f1297s.a(getContext(), str);
        }
        return str;
    }

    private void m1337b(String str, boolean z) {
        Uri parse = Uri.parse(str);
        final String builder = new Builder().encodedPath(parse.getPath()).encodedQuery(parse.getEncodedQuery()).encodedFragment(parse.getFragment()).toString();
        if (builder != null) {
            Object obj;
            m1338m();
            String a = StringUtils.a(str);
            if (a != null) {
                this.h.d(2359299, "FacewebPageNetworkLoad:" + a);
                this.h.d(2359300, "FacewebPageRPCLoadCompleted:" + a);
            }
            if (z) {
                this.k = builder;
            }
            Context context = getContext();
            Listener c02071 = new Listener(this) {
                final /* synthetic */ FacewebWebView f1263b;

                public final void mo51a(FacewebComponentsStore facewebComponentsStore) {
                    try {
                        Collection a = facewebComponentsStore.a(builder);
                        synchronized (this.f1263b) {
                            this.f1263b.f1286D.addAll(a);
                            this.f1263b.m1345e();
                        }
                    } catch (Throwable e) {
                        this.f1263b.c.a(FacewebWebView.f1281B.getSimpleName(), "FacewebComponentsStore failed to deserialize skeleton.", e);
                    }
                }

                public final void mo52a(LoadError loadError, String str) {
                    BLog.b(FacewebWebView.f1281B, "Failed to load components store. Error: %s   Message: %s", new Object[]{loadError.toString(), str});
                }
            };
            String a2 = MFacewebVersion.m1348a(context);
            if (a2 == null) {
                a2 = "";
            }
            Value a3 = FacewebComponentsStoreCache.m1298d(context).m1306a(new Key(URL.n(context), a2), c02071);
            if (a3 != null) {
                if (a3.m1295c()) {
                    Tuple tuple = (Tuple) a3.a;
                    c02071.mo52a((LoadError) tuple.a, (String) tuple.b);
                } else {
                    c02071.mo51a(a3.m1294b());
                }
            }
            if (builder == null || !builder.startsWith("/ads/manage/")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f1298t.a(getContext(), new InterstitialTrigger(Action.TO_ADS_MANAGER_M_SITE), InterstitialController.class, null);
            }
            this.b.a(this, str);
        }
    }

    public final void m1343c() {
        m1338m();
        m1342a(Uri.parse(this.k).buildUpon().appendQueryParameter("fb4ar", Long.toString(System.currentTimeMillis() / 1000)).build().toString(), false);
    }

    public final void m1344d() {
        m1338m();
        super.reload();
    }

    private void m1338m() {
        this.f1303y = PageState.PAGE_STATE_UINITIALIZED;
        this.f1304z = null;
    }

    protected final void m1340a(final Context context) {
        super.a(context);
        Class cls = FacewebWebView.class;
        m1334a((Object) this, getContext());
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        settings.setUserAgentString(BasicWebView.i + " " + UserAgent.a(context, Boolean.valueOf(true)));
        this.f1290l = new C02082(this);
        setWebViewClient(new FacewebWebViewClient(this, context, this.f1296r, this.f1290l, this.g, this.a, this.f1300v, this.b));
        setWebChromeClient(new FacewebGeolocationWebChromeClient(this));
        Handler handler = new Handler();
        a("resetCache", new NativeCallHandler(this) {
            protected Queue<Long> f1265a = new LinkedList();
            final /* synthetic */ FacewebWebView f1267c;

            public final synchronized void m1315a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
                if (facewebPalCall.a(facebookWebView.getMobilePage(), "clearHttpCache") != null) {
                    this.f1267c.clearCache(true);
                    FacewebComponentsStoreCache.m1296a(this.f1267c.getContext());
                    this.f1265a.clear();
                }
                if (facewebPalCall.a(facebookWebView.getMobilePage(), "clearLocalStorage") != null) {
                    FacebookJsBridge.a(context);
                    this.f1267c.clearCache(true);
                }
                if (facewebPalCall.a(facebookWebView.getMobilePage(), "clearCookies") != null) {
                    CookieManager.getInstance().removeAllCookie();
                    this.f1267c.f1296r.a(context, this.f1267c.f1290l);
                }
            }
        });
        a("startSyncFriends", new C02104(this));
        a("setRootVersion", new C02115(this));
        a("reloadCurrent", new C02126(this));
        a("broadcastScript", new BroadcastScriptHandler(this, handler));
    }

    protected static void m1332a(FacewebWebView facewebWebView) {
        synchronized (f1282i) {
            f1282i.add(new WeakRef(facewebWebView));
            new StringBuilder("mRegisteredWebviews has ").append(f1282i.size()).append(" items");
        }
    }

    public static void m1339q(FacewebWebView facewebWebView) {
        synchronized (f1282i) {
            f1282i.remove(new WeakRef(facewebWebView));
            new StringBuilder("mRegisteredWebviews has ").append(f1282i.size()).append(" items");
        }
    }

    static List<FacewebWebView> getRegisteredFacewebWebViews() {
        List<FacewebWebView> arrayList = new ArrayList();
        synchronized (f1282i) {
            int size = f1282i.size();
            Iterator it = f1282i.iterator();
            while (it.hasNext()) {
                FacewebWebView facewebWebView = (FacewebWebView) ((WeakRef) it.next()).get();
                if (facewebWebView == null) {
                    it.remove();
                } else {
                    arrayList.add(facewebWebView);
                }
            }
            new StringBuilder("mRegisteredWebviews gc'ed from ").append(size).append(" to ").append(f1282i.size()).append(" items");
        }
        return arrayList;
    }

    public FacewebWebView(Context context, C02232 c02232) {
        super(context);
        m1338m();
        this.f1291m = c02232;
        this.f1289k = new C02137(this);
        this.f1301w = true;
        this.f1302x = false;
        setOnTouchListener(new C02148(this));
    }

    @Inject
    private void m1333a(FbSharedPreferences fbSharedPreferences, AddressBookPeriodicRunner addressBookPeriodicRunner, Fb4aUriIntentMapper fb4aUriIntentMapper, SecureContextHelper secureContextHelper, IntentHandlerUtil intentHandlerUtil, Authenticator authenticator, TriState triState, MSiteUrlUtils mSiteUrlUtils, InterstitialStartHelper interstitialStartHelper, FacewebEventBus facewebEventBus) {
        this.g = fbSharedPreferences;
        this.f1292n = addressBookPeriodicRunner;
        this.f1293o = fb4aUriIntentMapper;
        this.f1294p = secureContextHelper;
        this.f1295q = intentHandlerUtil;
        this.f1296r = authenticator;
        this.f1300v = triState;
        this.f1297s = mSiteUrlUtils;
        this.f1298t = interstitialStartHelper;
        this.f1299u = facewebEventBus;
    }

    public final synchronized void m1345e() {
        if (this.f1285C) {
            for (FacewebPalCall a : this.f1286D) {
                a(getContext(), a);
            }
            this.f1286D.clear();
        }
    }

    public final synchronized void m1346f() {
        this.f1285C = true;
        m1345e();
    }

    static /* synthetic */ boolean m1335a(FacewebWebView facewebWebView, String str) {
        boolean z = SecureWebViewHelper.a.contains(str) || f1283j.contains(str);
        return z;
    }

    protected final void m1341a(FacewebErrorType facewebErrorType, LogoutReason logoutReason) {
        Context context = getContext();
        if (facewebErrorType == FacewebErrorType.AUTHENTICATION_NETWORK_ERROR) {
            Toaster.a(context, context.getString(facewebErrorType.getErrorMessageId()));
        } else if (facewebErrorType == FacewebErrorType.AUTHENTICATION_ERROR) {
            AppSession a = AppSession.a(context, false);
            if (a != null) {
                a.b(context, logoutReason);
            }
        }
    }

    public final void m1347g() {
        a("(function(){try {if (window.fwHaveLoadedPage && fwHaveLoadedPage()) {return '1';}} catch (e) {return '0';}})()", new C02159(this));
    }
}
