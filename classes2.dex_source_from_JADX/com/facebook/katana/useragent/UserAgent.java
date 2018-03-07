package com.facebook.katana.useragent;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.asserts.Assert;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: sending_mss */
public class UserAgent {
    private static final Class<?> f5577a = UserAgent.class;
    public static FbInjector f5578b;
    public static Provider<String> f5579c;
    private static AppVersionInfo f5580d;
    public static OnionUtils f5581e;
    public static final String[] f5582f = new String[(AppForegroundMode.values().length * 2)];
    public static String f5583g;
    public static String f5584h;
    private static String f5585i;
    private static String f5586j;
    private static String f5587k;

    /* compiled from: sending_mss */
    public enum AppForegroundMode {
        Foreground("0"),
        Background("1"),
        None("-1");
        
        private final String uaFlagValue;

        private AppForegroundMode(String str) {
            this.uaFlagValue = str;
        }

        public final String toString() {
            return this.uaFlagValue;
        }
    }

    public static String m9521a(Context context, Boolean bool) {
        return m9522a(context, bool, AppForegroundMode.None);
    }

    public static String m9522a(Context context, Boolean bool, AppForegroundMode appForegroundMode) {
        int i;
        int ordinal = appForegroundMode.ordinal() * 2;
        if (bool.booleanValue()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = i + ordinal;
        String str = f5582f[i2];
        if (str != null) {
            return str;
        }
        str = m9526b(context, bool, appForegroundMode);
        f5582f[i2] = str;
        return str;
    }

    private static String m9526b(Context context, Boolean bool, AppForegroundMode appForegroundMode) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (f5583g == null) {
            String str = "%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;";
            Object[] objArr = new Object[10];
            objArr[0] = "FBAN";
            objArr[1] = m9523a(m9525b());
            objArr[2] = "FBAV";
            objArr[3] = m9523a(m9530c(context));
            objArr[4] = "FBBV";
            objArr[5] = Integer.valueOf(m9524b(context).mo368b());
            objArr[6] = "FBDM";
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (!(windowManager == null || windowManager.getDefaultDisplay() == null)) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            objArr[7] = m9523a("{density=" + displayMetrics.density + ",width=" + point.x + ",height=" + point.y + "}");
            objArr[8] = "FBLC";
            if (f5578b == null) {
                f5578b = FbInjector.get(context);
            }
            objArr[9] = m9523a(Locales.m2604a(f5578b).m2613c());
            f5583g = StringFormatUtil.a(str, objArr);
        }
        stringBuilder.append(f5583g);
        if (bool.booleanValue()) {
            if (f5584h == null) {
                f5584h = StringFormatUtil.formatStrLocaleSafe("%s/%s;", "FB_FW", "2");
            }
            stringBuilder.append(f5584h);
        }
        m9529b(stringBuilder, context);
        Assert.m9534a((Object) appForegroundMode);
        if (appForegroundMode != AppForegroundMode.None) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s/%s;", "FBBK", appForegroundMode));
        }
        m9531c(stringBuilder, context);
        if (f5581e == null) {
            f5581e = OnionUtils.m9473a(f5578b);
        }
        if (f5581e.m9478c()) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s/%s;", "FBAT", f5581e.m9479d() ? "2" : "1"));
        }
        m9528b(stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String m9525b() {
        return BuildConstants.j ? "AtWorkForAndroid" : "FB4A";
    }

    private static void m9529b(StringBuilder stringBuilder, Context context) {
        if (f5585i == null) {
            f5585i = StringFormatUtil.a("%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;", new Object[]{"FBCR", m9523a(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName()), "FBMF", m9523a(Build.MANUFACTURER), "FBBD", m9523a(Build.BRAND), "FBPN", context.getPackageName(), "FBDV", m9523a(Build.MODEL), "FBSV", m9523a(VERSION.RELEASE)});
        }
        stringBuilder.append(f5585i);
    }

    private static StringBuilder m9528b(StringBuilder stringBuilder) {
        if (f5587k == null) {
            f5587k = StringFormatUtil.formatStrLocaleSafe("%s/%s:%s;", "FBCA", m9523a(Build.CPU_ABI), m9523a(Build.CPU_ABI2));
        }
        return stringBuilder.append(f5587k);
    }

    public static String m9523a(String str) {
        return StringUtil.m3601e(str).replace("/", "-").replace(";", "-");
    }

    public static AppVersionInfo m9524b(Context context) {
        if (f5578b == null) {
            f5578b = FbInjector.get(context);
        }
        if (f5580d == null) {
            f5580d = AppVersionInfoMethodAutoProvider.m2629a(f5578b);
        }
        return f5580d;
    }

    public static String m9530c(Context context) {
        return m9524b(context).mo367a();
    }

    private static void m9531c(StringBuilder stringBuilder, Context context) {
        if (f5578b == null) {
            f5578b = FbInjector.get(context);
        }
        if (f5579c == null) {
            f5579c = IdBasedProvider.m1811a(f5578b, 4459);
        }
        String b = m9527b((String) f5579c.get());
        if (b != null) {
            if (f5586j == null) {
                f5586j = StringFormatUtil.formatStrLocaleSafe("%s/%s;", "FBOP", m9523a(b));
            }
            stringBuilder.append(f5586j);
        }
    }

    @Nullable
    @VisibleForTesting
    public static String m9527b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toHexString(0))) ? null : str;
    }
}
