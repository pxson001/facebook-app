package com.facebook.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StringUtil.StringProcessor;
import com.facebook.common.util.Tuple;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.webview.FacebookWebView.JsReturnHandler;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacebookWebView.UrlHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: shoebox_moments_interstitial_accept */
public class FacebookJsBridge {
    public static final StringProcessor f3493a = new C03201();
    public final UriHandler f3494b = new UriHandler(this);
    protected final Class<?> f3495c;
    protected final Map<String, Set<NativeCallHandler>> f3496d = new HashMap();
    protected Map<String, Tuple<String, JsReturnHandler>> f3497e = new HashMap();
    protected final AtomicInteger f3498f = new AtomicInteger();

    /* compiled from: shoebox_moments_interstitial_accept */
    final class C03201 implements StringProcessor {
        C03201() {
        }

        public final String m3281a(Object obj) {
            if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || (obj instanceof JSONStringer)) {
                return obj.toString();
            }
            return JSONObject.quote(obj.toString());
        }
    }

    /* compiled from: shoebox_moments_interstitial_accept */
    final class C03212 implements Runnable {
        Context f3489a = this.f3490b;
        final /* synthetic */ Context f3490b;

        C03212(Context context) {
            this.f3490b = context;
        }

        public final void run() {
            WebView webView = new WebView(this.f3489a);
            WebStorage.getInstance().deleteAllData();
        }
    }

    /* compiled from: shoebox_moments_interstitial_accept */
    public class NativeCallReturnHandler implements NativeCallHandler {
        final /* synthetic */ FacebookJsBridge f3491a;

        protected NativeCallReturnHandler(FacebookJsBridge facebookJsBridge) {
            this.f3491a = facebookJsBridge;
        }

        public final void mo85a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String a = facewebPalCall.mo93a(facebookWebView.getMobilePage(), "callId");
            String a2 = facewebPalCall.mo93a(facebookWebView.getMobilePage(), "exc");
            String a3 = facewebPalCall.mo93a(facebookWebView.getMobilePage(), "retval");
            boolean z = !StringUtil.a("null", a2);
            if (z) {
                BLog.b(this.f3491a.f3495c, "Exception was returned by js: " + a2);
            }
            synchronized (this.f3491a) {
                Tuple tuple = (Tuple) this.f3491a.f3497e.remove(a);
            }
            if (tuple != null) {
                JsReturnHandler jsReturnHandler = (JsReturnHandler) tuple.b;
                if (jsReturnHandler != null) {
                    jsReturnHandler.m3294a(facebookWebView, a, z, a3);
                    return;
                }
                return;
            }
            BLog.a(this.f3491a.f3495c, "js called native_return with callId " + a + " but no call with that callId was made.");
        }
    }

    /* compiled from: shoebox_moments_interstitial_accept */
    public class UriHandler implements UrlHandler {
        final /* synthetic */ FacebookJsBridge f3492a;

        protected UriHandler(FacebookJsBridge facebookJsBridge) {
            this.f3492a = facebookJsBridge;
        }

        public final void mo86a(Context context, FacebookWebView facebookWebView, Uri uri) {
            Object facewebUriPalCall = new FacewebUriPalCall(uri);
            if (!this.f3492a.m3289a(context, facebookWebView, facewebUriPalCall)) {
                BLog.b(this.f3492a.f3495c, "PAL call " + facewebUriPalCall.mo92a() + " not handled");
            }
        }
    }

    FacebookJsBridge(Class<?> cls) {
        this.f3495c = cls;
        m3288a("call_return", new NativeCallReturnHandler(this));
    }

    public final void m3288a(String str, NativeCallHandler nativeCallHandler) {
        Set set = (Set) this.f3496d.get(str);
        if (set == null) {
            set = new HashSet();
            this.f3496d.put(str, set);
        }
        set.add(nativeCallHandler);
    }

    public final String m3287a(String str, @Nullable JsReturnHandler jsReturnHandler) {
        String num = Integer.toString(this.f3498f.getAndIncrement());
        synchronized (this) {
            this.f3497e.put(num, new Tuple(str, jsReturnHandler));
        }
        return num;
    }

    public final boolean m3289a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
        Set<NativeCallHandler> set = (Set) this.f3496d.get(facewebPalCall.mo92a());
        if (set == null) {
            return false;
        }
        for (NativeCallHandler a : set) {
            a.mo85a(context, facebookWebView, facewebPalCall);
        }
        return true;
    }

    public static void m3286a(Context context) {
        Object obj = (9 > VERSION.SDK_INT || VERSION.SDK_INT > 18) ? null : 1;
        if (obj == null) {
            WebStorage.getInstance().deleteAllData();
        } else {
            HandlerDetour.a(new Handler(context.getMainLooper()), new C03212(context), 1748857953);
        }
    }
}
