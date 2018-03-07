package com.facebook.ui.browser.prefs;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.facebook.browser.lite.BrowserLiteIntentServiceHelper;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.time.SystemClock;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: timezone_offset_seconds */
public class BrowserDataPreference extends DialogPreference {
    private final FbSharedPreferences f1621a;
    private final LayoutInflater f1622b;
    private final DefaultTimeFormatUtil f1623c;
    public int f1624d;

    public static BrowserDataPreference m1661a(InjectorLike injectorLike) {
        return new BrowserDataPreference((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), DefaultTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public BrowserDataPreference(Context context, FbSharedPreferences fbSharedPreferences, LayoutInflater layoutInflater, DefaultTimeFormatUtil defaultTimeFormatUtil) {
        super(context, null);
        this.f1621a = fbSharedPreferences;
        this.f1622b = layoutInflater;
        this.f1623c = defaultTimeFormatUtil;
        setKey(BrowserPrefKey.f.a());
        setSummary(m1662a());
    }

    private String m1662a() {
        long a = this.f1621a.a(BrowserPrefKey.f, -1);
        if (a == -1) {
            return "";
        }
        return "Last Cleared on " + this.f1623c.a(TimeFormatStyle.EXACT_TIME_DATE_STYLE, a);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (this.f1624d != 0) {
            textView.setTextAppearance(getContext(), this.f1624d);
        }
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        builder.setInverseBackgroundForced(true);
        builder.setTitle(2131236863);
        View inflate = this.f1622b.inflate(2130903435, null);
        ((TextView) inflate.findViewById(2131560001)).setText(2131236864);
        builder.setView(inflate);
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z) {
            WebView webView = new WebView(getContext());
            WebSettings settings = webView.getSettings();
            m1663b();
            CookieSyncManager.createInstance(getContext());
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
            settings.setAppCacheEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(getContext().getDir("appcache", 0).getPath());
            settings.setDatabasePath(getContext().getDir("databases", 0).getPath());
            webView.clearCache(true);
            webView.destroy();
            BrowserLiteIntentServiceHelper.b(getContext().getApplicationContext());
            Editor edit = this.f1621a.edit();
            edit.a(BrowserPrefKey.f, SystemClock.a.a());
            edit.commit();
            setSummary(m1662a());
        }
    }

    @TargetApi(14)
    private static void m1663b() {
        if (VERSION.SDK_INT >= 14) {
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            if (installed != null) {
                try {
                    installed.delete();
                } catch (IOException e) {
                    installed.toString();
                    e.toString();
                }
            }
        }
    }
}
