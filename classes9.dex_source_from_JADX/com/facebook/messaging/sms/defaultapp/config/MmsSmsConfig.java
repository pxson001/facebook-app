package com.facebook.messaging.sms.defaultapp.config;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android_src.mmsv2.CarrierConfigValuesLoader;
import android_src.mmsv2.DefaultCarrierConfigValuesLoader;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.util.TelephonyUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.PARTICIPANTS */
public class MmsSmsConfig {
    public static volatile CarrierConfigValuesLoader f17675a = null;
    public final Context f17676b;
    private final FbSharedPreferences f17677c;
    private final SmsGatekeepers f17678d;
    private final TelephonyManager f17679e;
    private XConfigReader f17680f;

    public static MmsSmsConfig m17636b(InjectorLike injectorLike) {
        return new MmsSmsConfig((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsGatekeepers.b(injectorLike), TelephonyManagerMethodAutoProvider.b(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public MmsSmsConfig(Context context, FbSharedPreferences fbSharedPreferences, SmsGatekeepers smsGatekeepers, TelephonyManager telephonyManager, XConfigReader xConfigReader) {
        this.f17676b = context;
        this.f17677c = fbSharedPreferences;
        this.f17678d = smsGatekeepers;
        this.f17679e = telephonyManager;
        this.f17680f = xConfigReader;
    }

    public final boolean m17638a() {
        boolean z;
        FbSharedPreferences fbSharedPreferences = this.f17677c;
        PrefKey prefKey = SmsPrefKeys.J;
        if (this.f17678d.a.a(1124, false)) {
            z = false;
        } else {
            z = true;
        }
        if (fbSharedPreferences.a(prefKey, z) && TelephonyUtils.m17718c(this.f17676b)) {
            z = this.f17677c.a(SmsPrefKeys.K, false);
            if (!this.f17679e.isNetworkRoaming() || z) {
                return true;
            }
        }
        return false;
    }

    private Bundle m17637f() {
        if (f17675a == null) {
            f17675a = new DefaultCarrierConfigValuesLoader(this.f17676b);
        }
        return f17675a.mo117a(-1);
    }

    public final boolean m17640b() {
        if (VERSION.SDK_INT >= 21) {
            return m17637f().getBoolean("supportMmsContentDisposition", true);
        }
        return false;
    }

    public final int m17641c() {
        return m17637f().getInt("maxMessageSize", this.f17680f.a(CarrierXConfig.c, 614400));
    }

    public final int m17642d() {
        return m17637f().getInt("maxImageHeight", 480);
    }

    public final int m17643e() {
        return m17637f().getInt("maxImageWidth", 640);
    }

    public final boolean m17639a(String str) {
        if (Strings.isNullOrEmpty(str) || !m17637f().getBoolean("aliasEnabled", false)) {
            return false;
        }
        int length = str.length();
        int i = m17637f().getInt("aliasMinChars", 2);
        int i2 = m17637f().getInt("aliasMaxChars", 48);
        if (length < i || length > i2 || !Character.isLetter(str.charAt(0))) {
            return false;
        }
        for (i = 1; i < length; i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '.') {
                return false;
            }
        }
        return true;
    }
}
