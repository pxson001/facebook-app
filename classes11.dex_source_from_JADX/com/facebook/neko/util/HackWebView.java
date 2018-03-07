package com.facebook.neko.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Locale;

/* compiled from: tiny_profile_pic */
public class HackWebView extends WebView {
    private static String f891a = null;

    /* compiled from: tiny_profile_pic */
    class UserAgentFactory {
        private final Context f887a;
        private final String f888b;
        private final String f889c;
        private final int f890d;

        public UserAgentFactory(Context context, String str, int i, String str2) {
            this.f887a = context;
            this.f889c = str;
            this.f890d = i;
            this.f888b = str2;
        }

        public final String m1161a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.getProperty("http.agent"));
            stringBuilder.append(" [");
            stringBuilder.append(String.format("%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s:%s;%s/%s;FB_FW/1;", new Object[]{"FBAN", this.f888b, "FBAV", m1159a(this.f889c), "FBPN", this.f887a.getPackageName(), "FBLC", m1159a(Locale.getDefault().toString()), "FBBV", Integer.valueOf(this.f890d), "FBMF", m1159a(Build.MANUFACTURER), "FBBD", m1159a(Build.BRAND), "FBDV", m1159a(Build.MODEL), "FBSV", m1159a(VERSION.RELEASE), "FBCA", m1159a(Build.CPU_ABI), m1159a(Build.CPU_ABI2), "FBDM", m1159a(m1160b())}));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        private static String m1159a(String str) {
            if (str == null || str.isEmpty()) {
                return "null";
            }
            return str.replace("/", "-").replace(";", "-");
        }

        @TargetApi(13)
        private String m1160b() {
            DisplayMetrics displayMetrics = this.f887a.getResources().getDisplayMetrics();
            Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
            WindowManager windowManager = (WindowManager) this.f887a.getSystemService("window");
            if (!(windowManager == null || windowManager.getDefaultDisplay() == null)) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            return "{density=" + displayMetrics.density + ",width=" + point.x + ",height=" + point.y + "}";
        }
    }

    public HackWebView(Context context) {
        this(context, null, 0);
    }

    public HackWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HackWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1162a(context);
    }

    private void m1162a(Context context) {
        int i = 0;
        WebSettings settings = getSettings();
        if (f891a == null) {
            f891a = settings.getUserAgentString();
        }
        String str = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            i = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        settings.setUserAgentString(f891a + " " + new UserAgentFactory(context, str, i, context.getResources().getString(2131242237)).m1161a());
        settings.setJavaScriptEnabled(true);
    }
}
