package com.facebook.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.C1931e;
import java.lang.reflect.Constructor;

public class C1984h {
    private static String f14333a = null;

    public static String m14467a() {
        if (C1994r.m14486a(AdSettings.f13894e)) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", new Object[]{AdSettings.f13894e});
    }

    @TargetApi(17)
    private static String m14468a(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }

    public static String m14469a(Context context, C1931e c1931e) {
        if (c1931e == C1931e.NATIVE_250 || c1931e == C1931e.NATIVE_UNKNOWN || c1931e == null) {
            return System.getProperty("http.agent");
        }
        if (f14333a == null) {
            if (VERSION.SDK_INT >= 17) {
                try {
                    String a = C1984h.m14468a(context);
                    f14333a = a;
                    return a;
                } catch (Exception e) {
                }
            }
            try {
                f14333a = C1984h.m14470a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f14333a = C1984h.m14470a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f14333a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
        }
        return f14333a;
    }

    private static String m14470a(Context context, String str, String str2) {
        Class cls = Class.forName(str);
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            String str3 = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
            return str3;
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    public static void m14471a(WebView webView) {
        webView.loadUrl("about:blank");
        webView.clearCache(true);
        if (VERSION.SDK_INT > 11) {
            webView.onPause();
            return;
        }
        try {
            WebView.class.getMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
        }
    }

    @TargetApi(21)
    public static void m14472b(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod("setMixedContentMode", new Class[0]).invoke(settings, new Object[]{Integer.valueOf(0)});
        } catch (Exception e) {
        }
    }
}
