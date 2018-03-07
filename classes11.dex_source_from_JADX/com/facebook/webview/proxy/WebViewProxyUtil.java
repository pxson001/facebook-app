package com.facebook.webview.proxy;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.webkit.WebView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: nativeTimeBeforeJS */
public class WebViewProxyUtil {
    private final Context f5282a;
    private final Class<? extends Application> f5283b;

    /* compiled from: nativeTimeBeforeJS */
    public class UnableToSetProxyException extends Exception {
        private boolean mAllowedRetries = false;

        public UnableToSetProxyException(Throwable th) {
            super(th);
        }

        public UnableToSetProxyException(Throwable th, boolean z) {
            super(th);
            this.mAllowedRetries = z;
        }
    }

    public WebViewProxyUtil(Context context, Class<? extends Application> cls) {
        this.f5282a = context;
        this.f5283b = cls;
    }

    public final void m6537a(WebView webView) {
        m6538a("", 0, webView);
    }

    public final synchronized void m6538a(String str, int i, WebView webView) {
        try {
            if (VERSION.SDK_INT < 14) {
                throw new AssertionError("Android version not supported");
            } else if (VERSION.SDK_INT <= 18) {
                m6535b(str, i, webView);
            } else if (VERSION.SDK_INT <= 19) {
                m6532a(str, i);
            } else {
                m6534b(str, i);
            }
        } catch (Throwable e) {
            throw new UnableToSetProxyException(e);
        } catch (Throwable e2) {
            throw new UnableToSetProxyException(e2);
        } catch (Throwable e22) {
            throw new UnableToSetProxyException(e22);
        } catch (Throwable e222) {
            throw new UnableToSetProxyException(e222);
        } catch (Throwable e2222) {
            throw new UnableToSetProxyException(e2222);
        } catch (Throwable e22222) {
            throw new UnableToSetProxyException(e22222);
        } catch (Throwable e222222) {
            if (e222222.toString().contains("JWebCoreJavaBridge")) {
                throw new UnableToSetProxyException(e222222, true);
            }
            throw new UnableToSetProxyException(e222222);
        }
    }

    @TargetApi(14)
    private static void m6535b(String str, int i, WebView webView) {
        Object a;
        if (VERSION.SDK_INT <= 15) {
            a = m6531a(Class.forName("android.webkit.WebView").getDeclaredField("mWebViewCore"), (Object) webView);
        } else {
            Class cls = Class.forName("android.webkit.WebViewClassic");
            a = m6531a(cls.getDeclaredField("mWebViewCore"), cls.getDeclaredMethod("fromWebView", new Class[]{Class.forName("android.webkit.WebView")}).invoke(null, new Object[]{webView}));
        }
        Object a2 = m6531a(Class.forName("android.webkit.BrowserFrame").getDeclaredField("sJavaBridge"), m6531a(Class.forName("android.webkit.WebViewCore").getDeclaredField("mBrowserFrame"), a));
        Constructor constructor = Class.forName("android.net.ProxyProperties").getConstructor(new Class[]{String.class, Integer.TYPE, String.class});
        Method declaredMethod = Class.forName("android.webkit.JWebCoreJavaBridge").getDeclaredMethod("updateProxy", new Class[]{Class.forName("android.net.ProxyProperties")});
        Object[] objArr = new Object[1];
        if (str.equals("")) {
            a = null;
        } else {
            a = constructor.newInstance(new Object[]{str, Integer.valueOf(i), null});
        }
        objArr[0] = a;
        declaredMethod.invoke(a2, objArr);
    }

    @TargetApi(19)
    private void m6532a(String str, int i) {
        System.setProperty("http.proxyHost", str);
        System.setProperty("http.proxyPort", i);
        System.setProperty("https.proxyHost", str);
        System.setProperty("https.proxyPort", i);
        ArrayMap arrayMap = (ArrayMap) m6531a(Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers"), m6531a(this.f5283b.getField("mLoadedApk"), this.f5282a));
        Constructor constructor = Class.forName("android.net.ProxyProperties").getConstructor(new Class[]{String.class, Integer.TYPE, String.class});
        Class cls = Class.forName("com.android.org.chromium.net.ProxyChangeListener$ProxyReceiver");
        Method declaredMethod = cls.getDeclaredMethod("onReceive", new Class[]{Context.class, Intent.class});
        for (ArrayMap keySet : arrayMap.values()) {
            for (Object next : keySet.keySet()) {
                if (next.getClass().equals(cls)) {
                    Intent intent = new Intent("android.intent.action.PROXY_CHANGE");
                    if (!str.equals("")) {
                        intent.putExtra("proxy", (Parcelable) constructor.newInstance(new Object[]{str, Integer.valueOf(i), null}));
                    }
                    declaredMethod.invoke(next, new Object[]{this.f5282a, intent});
                }
            }
        }
    }

    @TargetApi(21)
    private void m6534b(String str, int i) {
        if (!m6533a(str, i, "com.android.org.chromium.net.ProxyChangeListener$ProxyReceiver")) {
            m6533a(str, i, "org.chromium.net.ProxyChangeListener$ProxyReceiver");
        }
    }

    @TargetApi(21)
    private boolean m6533a(String str, int i, String str2) {
        System.setProperty("http.proxyHost", str);
        System.setProperty("http.proxyPort", Integer.toString(i));
        System.setProperty("https.proxyHost", str);
        System.setProperty("https.proxyPort", Integer.toString(i));
        for (ArrayMap keySet : ((ArrayMap) m6531a(Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers"), m6531a(this.f5283b.getField("mLoadedApk"), this.f5282a))).values()) {
            for (Object next : keySet.keySet()) {
                Class cls = next.getClass();
                if (cls.getName().equals(str2)) {
                    Method declaredMethod = cls.getDeclaredMethod("onReceive", new Class[]{Context.class, Intent.class});
                    Intent intent = new Intent("android.intent.action.PROXY_CHANGE");
                    if (!str.equals("")) {
                        intent.putExtra("android.intent.extra.PROXY_INFO", m6536c(str, i));
                    }
                    declaredMethod.invoke(next, new Object[]{this.f5282a, intent});
                    return true;
                }
            }
        }
        return false;
    }

    private static Parcelable m6536c(String str, int i) {
        return (Parcelable) Class.forName("android.net.ProxyInfo").getMethod("buildDirectProxy", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{str, Integer.valueOf(i)});
    }

    private static Object m6531a(Field field, Object obj) {
        boolean isAccessible = field.isAccessible();
        if (!isAccessible) {
            try {
                field.setAccessible(true);
            } catch (Throwable th) {
                if (!isAccessible) {
                    field.setAccessible(false);
                }
            }
        }
        Object obj2 = field.get(obj);
        if (!isAccessible) {
            field.setAccessible(false);
        }
        return obj2;
    }
}
