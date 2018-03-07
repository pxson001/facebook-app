package com.facebook.config.server;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.katana.app.module.common.String_AppNameInUserAgentMethodAutoProvider;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: serialized_param_data */
public class UserAgentFactory {
    public final Context f5555a;
    public final AppVersionInfo f5556b;
    private final TelephonyManager f5557c;
    public final String f5558d;
    private final Lazy<Set<UserAgentComponent>> f5559e;
    private final OnionUtils f5560f;

    public static UserAgentFactory m9470b(InjectorLike injectorLike) {
        return new UserAgentFactory((Context) injectorLike.getInstance(Context.class), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), TelephonyManagerMethodAutoProvider.m3851b(injectorLike), String_AppNameInUserAgentMethodAutoProvider.m9472a(injectorLike), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$UserAgentComponent(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), OnionUtils.m9473a(injectorLike));
    }

    public static UserAgentFactory m9468a(InjectorLike injectorLike) {
        return m9470b(injectorLike);
    }

    @Inject
    public UserAgentFactory(Context context, AppVersionInfo appVersionInfo, TelephonyManager telephonyManager, String str, Lazy<Set<UserAgentComponent>> lazy, OnionUtils onionUtils) {
        this.f5555a = context;
        this.f5556b = appVersionInfo;
        this.f5557c = telephonyManager;
        this.f5558d = str;
        this.f5559e = lazy;
        this.f5560f = onionUtils;
    }

    public final String m9471a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.getProperty("http.agent"));
        stringBuilder.append(" [");
        String str = "%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s;%s/%s:%s;%s/%s;FB_FW/1;";
        Object[] objArr = new Object[25];
        objArr[0] = "FBAN";
        objArr[1] = this.f5558d;
        objArr[2] = "FBAV";
        objArr[3] = m9469a(this.f5556b.mo367a());
        objArr[4] = "FBPN";
        objArr[5] = this.f5555a.getPackageName();
        objArr[6] = "FBLC";
        objArr[7] = m9469a(Locale.getDefault().toString());
        objArr[8] = "FBBV";
        objArr[9] = Integer.valueOf(this.f5556b.mo368b());
        objArr[10] = "FBCR";
        objArr[11] = m9469a(this.f5557c.getNetworkOperatorName());
        objArr[12] = "FBMF";
        objArr[13] = m9469a(Build.MANUFACTURER);
        objArr[14] = "FBBD";
        objArr[15] = m9469a(Build.BRAND);
        objArr[16] = "FBDV";
        objArr[17] = m9469a(Build.MODEL);
        objArr[18] = "FBSV";
        objArr[19] = m9469a(VERSION.RELEASE);
        objArr[20] = "FBCA";
        objArr[21] = m9469a(Build.CPU_ABI);
        objArr[22] = m9469a(Build.CPU_ABI2);
        objArr[23] = "FBDM";
        DisplayMetrics displayMetrics = this.f5555a.getResources().getDisplayMetrics();
        Point point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        WindowManager windowManager = (WindowManager) this.f5555a.getSystemService("window");
        if (!(windowManager == null || windowManager.getDefaultDisplay() == null)) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        objArr[24] = m9469a("{density=" + displayMetrics.density + ",width=" + point.x + ",height=" + point.y + "}");
        stringBuilder.append(StringFormatUtil.a(str, objArr));
        for (UserAgentComponent userAgentComponent : (Set) this.f5559e.get()) {
            String a = userAgentComponent.a();
            str = userAgentComponent.b();
            if (a != null) {
                stringBuilder.append(a).append("/").append(m9469a(str)).append(";");
            }
        }
        if (this.f5560f.m9478c()) {
            String str2 = "%s/%s;";
            Object[] objArr2 = new Object[2];
            objArr2[0] = "FBAT";
            objArr2[1] = this.f5560f.m9479d() ? "2" : "1";
            stringBuilder.append(StringFormatUtil.a(str2, objArr2));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String m9469a(String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return "null";
        }
        return StringUtil.m3601e(str).replace("/", "-").replace(";", "-");
    }
}
