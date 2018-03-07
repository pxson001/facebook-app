package com.facebook.platform.webdialogs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.platform.webdialogs.bridgeapi.AbstractPlatformWebDialogsBridgeApiFactory;
import com.facebook.platform.webdialogs.bridgeapi.PlatformWebDialogsBridgeApiFactory;
import com.facebook.platform.webdialogs.bridgeapi.STATICDI_MULTIBIND_PROVIDER$PlatformWebDialogsBridgeApiFactory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.Toaster;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.JsReturnHandler;
import com.facebook.webview.FacebookWebView.UrlHandler;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: locationPingParams */
public class PlatformWebViewClient extends WebViewClient {
    public static final Class<?> f8525a = PlatformWebViewClient.class;
    private static volatile PlatformWebViewClient f8526k;
    private final Context f8527b;
    private final PlatformWebDialogsCache f8528c;
    public final Set<PlatformWebDialogsBridgeApiFactory> f8529d;
    private final SecureContextHelper f8530e;
    private final FbSharedPreferences f8531f;
    private final TriState f8532g;
    public HashMap<FacebookWebView, PlatformWebViewBridgeHandler> f8533h = Maps.c();
    public UrlHandler f8534i = new PlatformWebViewUrlHandler(this);
    private JsReturnHandler f8535j = new PlatformWebViewJsReturnHandler(this);

    /* compiled from: locationPingParams */
    public class PlatformWebViewJsReturnHandler implements JsReturnHandler {
        final /* synthetic */ PlatformWebViewClient f8523a;

        protected PlatformWebViewJsReturnHandler(PlatformWebViewClient platformWebViewClient) {
            this.f8523a = platformWebViewClient;
        }

        public final void m8434a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            PlatformWebDialogsFragment platformWebDialogsFragment = (PlatformWebDialogsFragment) this.f8523a.f8533h.get(facebookWebView);
            if (platformWebDialogsFragment != null && !Strings.isNullOrEmpty(str2) && !str2.equalsIgnoreCase("undefined")) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("method");
                    if (!Strings.isNullOrEmpty(string)) {
                        for (AbstractPlatformWebDialogsBridgeApiFactory abstractPlatformWebDialogsBridgeApiFactory : this.f8523a.f8529d) {
                            if (string.equals(abstractPlatformWebDialogsBridgeApiFactory.mo373a())) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                                if (optJSONObject == null) {
                                    optJSONObject = new JSONObject();
                                }
                                platformWebDialogsFragment.m8406a(abstractPlatformWebDialogsBridgeApiFactory.mo372a(optJSONObject));
                            }
                        }
                    }
                    PlatformWebViewClient.m8438d(this.f8523a, facebookWebView);
                } catch (Throwable e) {
                    BLog.b(PlatformWebViewClient.f8525a, e, "Error in parsing de-queued JSON : %1$s", new Object[]{str2});
                }
            }
        }
    }

    /* compiled from: locationPingParams */
    public class PlatformWebViewUrlHandler implements UrlHandler {
        final /* synthetic */ PlatformWebViewClient f8524a;

        protected PlatformWebViewUrlHandler(PlatformWebViewClient platformWebViewClient) {
            this.f8524a = platformWebViewClient;
        }

        public final void m8435a(Context context, FacebookWebView facebookWebView, Uri uri) {
            String scheme = uri.getScheme();
            if (!Strings.isNullOrEmpty(scheme) && scheme.equalsIgnoreCase("fbplatdialog") && this.f8524a.f8533h.containsKey(facebookWebView)) {
                PlatformWebViewClient.m8438d(this.f8524a, facebookWebView);
            }
        }
    }

    public static com.facebook.platform.webdialogs.PlatformWebViewClient m8436a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8526k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.PlatformWebViewClient.class;
        monitor-enter(r1);
        r0 = f8526k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8437b(r0);	 Catch:{ all -> 0x0035 }
        f8526k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8526k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.PlatformWebViewClient.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.PlatformWebViewClient");
    }

    private static PlatformWebViewClient m8437b(InjectorLike injectorLike) {
        return new PlatformWebViewClient((Context) injectorLike.getInstance(Context.class), PlatformWebDialogsCache.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PlatformWebDialogsBridgeApiFactory(injectorLike)), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PlatformWebViewClient(Context context, PlatformWebDialogsCache platformWebDialogsCache, Set<PlatformWebDialogsBridgeApiFactory> set, SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences, TriState triState) {
        this.f8527b = context;
        this.f8528c = platformWebDialogsCache;
        this.f8529d = set;
        this.f8530e = secureContextHelper;
        this.f8531f = fbSharedPreferences;
        this.f8532g = triState;
    }

    public void onPageFinished(WebView webView, String str) {
        FacebookWebView facebookWebView = (FacebookWebView) webView;
        if (this.f8533h.containsKey(facebookWebView)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (AbstractPlatformWebDialogsBridgeApiFactory abstractPlatformWebDialogsBridgeApiFactory : this.f8529d) {
                String a = abstractPlatformWebDialogsBridgeApiFactory.mo373a();
                stringBuilder.append(a).append(':').append(abstractPlatformWebDialogsBridgeApiFactory.mo374b()).append(',').append('\n');
            }
            facebookWebView.a(StringFormatUtil.a("function() {  var queue=[];  function bridge(method,params,callback,errback){    if(callback||errback){      var token='f'+(Math.random()*(1<<30)).toString(16).replace('.','');      window.addEventListener(token,function(event){        window.removeEventListener(token,arguments.callee);        if (event.data.error) {          errback(event.data);        } else {          callback(event.data);        }      });      params.%1$s=token;    }    queue.push(JSON.stringify({'%2$s':method,'%3$s':params}));    if(queue.length==1){window.prompt('%4$s:///');}  }  function bridgeMethodImpl(name){    return function(params,callback,errback){bridge(name,params,callback,errback);};  }  function dispatchEvent(eventName, data){    var event = document.createEvent('Event');    event.initEvent(eventName,true,true);    event.data = data;    document.dispatchEvent(event);  }  window.__fbPlatDialogHost = window.__fbPlatDialogHost || {    %5$s    %6$s:function(){return queue.shift();},    %7$s:function(eventName, data){dispatchEvent(eventName, data);}  };  dispatchEvent('fbPlatformReady',null);}();", new Object[]{"__callbackToken", "method", "params", "fbplatdialog", stringBuilder.toString(), "__dequeue", "__dispatchEvent"}), null);
            final WeakReference weakReference = new WeakReference(facebookWebView);
            HandlerDetour.b(new Handler(Looper.getMainLooper()), new Runnable(this) {
                final /* synthetic */ PlatformWebViewClient f8517b;

                public void run() {
                    PlatformWebDialogsFragment platformWebDialogsFragment = (PlatformWebDialogsFragment) this.f8517b.f8533h.get(weakReference.get());
                    if (platformWebDialogsFragment != null && !platformWebDialogsFragment.ar) {
                        PlatformWebDialogsFragment.av(platformWebDialogsFragment);
                    }
                }
            }, 5000, 1257276128);
        }
        super.onPageFinished(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (!FBLinks.a.equals(parse.getScheme()) || !"extbrowser".equals(parse.getHost())) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        this.f8530e.b(new Intent("android.intent.action.VIEW", Uri.parse(parse.getQueryParameter("url"))), webView.getContext());
        return true;
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str.contains("platformurlversion")) {
            InputStream a = this.f8528c.a(str);
            if (a != null) {
                return new WebResourceResponse("text/html", "utf-8", a);
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        final WeakReference weakReference = new WeakReference((FacebookWebView) webView);
        final int i2 = i;
        final String str3 = str;
        final String str4 = str2;
        HandlerDetour.a(new Handler(Looper.getMainLooper()), new Runnable(this) {
            final /* synthetic */ PlatformWebViewClient f8522e;

            public void run() {
                PlatformWebDialogsFragment platformWebDialogsFragment = (PlatformWebDialogsFragment) this.f8522e.f8533h.get(weakReference.get());
                if (platformWebDialogsFragment != null) {
                    PlatformWebDialogsFragment.aw(platformWebDialogsFragment);
                }
            }
        }, -838199503);
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!this.f8531f.a(InternalHttpPrefKeys.j, true)) {
            sslErrorHandler.proceed();
        } else if (BuildConstants.i || TriState.YES == this.f8532g) {
            Toaster.a(this.f8527b, 2131236458);
        } else {
            this.f8527b.getString(2131236459);
        }
    }

    public final void m8439a(FacebookWebView facebookWebView, String str, JSONObject jSONObject) {
        facebookWebView.a(StringFormatUtil.formatStrLocaleSafe("window.__fbPlatDialogHost.%1$s('%2$s',%3$s)", "__dispatchEvent", str, jSONObject != null ? jSONObject.toString() : "null"), this.f8535j);
    }

    public static void m8438d(PlatformWebViewClient platformWebViewClient, FacebookWebView facebookWebView) {
        facebookWebView.a(StringFormatUtil.formatStrLocaleSafe("window.__fbPlatDialogHost.%1$s()", "__dequeue"), platformWebViewClient.f8535j);
    }
}
