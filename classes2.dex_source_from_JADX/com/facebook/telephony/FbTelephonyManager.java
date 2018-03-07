package com.facebook.telephony;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.SystemProperties;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.mediatek.telephony.TelephonyManagerEx;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: foreground_fetch_interval */
public class FbTelephonyManager {
    private static final Class<?> f23451a = FbTelephonyManager.class;
    public final Context f23452b;
    private final TelephonyManager f23453c;
    private final Provider<Boolean> f23454d;
    private final RuntimePermissionsUtil f23455e;
    private final FbMultiSimTelephonyManager f23456f;
    private final Lazy<SubscriptionManager> f23457g = new C09511(this);

    /* compiled from: foreground_fetch_interval */
    class C09511 implements Lazy<SubscriptionManager> {
        final /* synthetic */ FbTelephonyManager f23461a;

        C09511(FbTelephonyManager fbTelephonyManager) {
            this.f23461a = fbTelephonyManager;
        }

        @TargetApi(22)
        public Object get() {
            return SubscriptionManager.from(this.f23461a.f23452b);
        }
    }

    public static FbTelephonyManager m31732b(InjectorLike injectorLike) {
        return new FbTelephonyManager((Context) injectorLike.getInstance(Context.class), TelephonyManagerMethodAutoProvider.m3851b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4350), RuntimePermissionsUtil.m13589b(injectorLike), new FbMultiSimTelephonyManager((Context) injectorLike.getInstance(Context.class)));
    }

    public static FbTelephonyManager m31730a(InjectorLike injectorLike) {
        return m31732b(injectorLike);
    }

    @Inject
    public FbTelephonyManager(Context context, TelephonyManager telephonyManager, Provider<Boolean> provider, RuntimePermissionsUtil runtimePermissionsUtil, FbMultiSimTelephonyManager fbMultiSimTelephonyManager) {
        this.f23452b = context.getApplicationContext();
        this.f23453c = telephonyManager;
        this.f23454d = provider;
        this.f23455e = runtimePermissionsUtil;
        this.f23456f = fbMultiSimTelephonyManager;
    }

    @Nullable
    public final String m31741a(int i) {
        Throwable e;
        CharSequence l;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31760b();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get network operator name from MediaTek API.", e);
                l = m31735l(i);
                if (StringUtil.m3589a(l)) {
                    return l;
                }
                if (this.f23453c == null) {
                }
                return null;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get network operator name from MediaTek API.", e);
                l = m31735l(i);
                if (StringUtil.m3589a(l)) {
                    return l;
                }
                if (this.f23453c == null) {
                }
                return null;
            }
        }
        l = m31735l(i);
        if (StringUtil.m3589a(l)) {
            return l;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getNetworkOperatorName();
        }
        return null;
    }

    @Nullable
    public final String m31742b(int i) {
        Throwable e;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31761c();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get network country iso from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return null;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get network country iso from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return null;
            }
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getNetworkCountryIso();
        }
        return null;
    }

    public final int m31743c(int i) {
        Throwable e;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31762d();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get network type from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return -1;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get network type from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return -1;
            }
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getNetworkType();
        }
        return -1;
    }

    public final int m31744d(int i) {
        Throwable e;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31759a();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get phone type from MediaTek API.", e);
                if (this.f23453c != null) {
                }
                return -1;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get phone type from MediaTek API.", e);
                if (this.f23453c != null) {
                }
                return -1;
            }
        }
        if (this.f23453c != null || i != 0) {
            return -1;
        }
        try {
            return this.f23453c.getPhoneType();
        } catch (NotFoundException e4) {
            return -1;
        }
    }

    @Nullable
    public final String m31745e(int i) {
        Throwable e;
        CharSequence p;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31765g();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get sim country iso from MediaTek API.", e);
                p = m31739p(i);
                if (StringUtil.m3589a(p)) {
                    return p;
                }
                if (this.f23453c == null) {
                }
                return null;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get sim country iso from MediaTek API.", e);
                p = m31739p(i);
                if (StringUtil.m3589a(p)) {
                    return p;
                }
                if (this.f23453c == null) {
                }
                return null;
            }
        }
        p = m31739p(i);
        if (StringUtil.m3589a(p)) {
            return p;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getSimCountryIso();
        }
        return null;
    }

    @Nullable
    public final String m31746f(int i) {
        Throwable e;
        CharSequence o;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31764f();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get sim operator from MediaTek API.", e);
                o = m31738o(i);
                if (StringUtil.m3589a(o)) {
                    return o;
                }
                if (this.f23453c == null) {
                }
                return null;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get sim operator from MediaTek API.", e);
                o = m31738o(i);
                if (StringUtil.m3589a(o)) {
                    return o;
                }
                if (this.f23453c == null) {
                }
                return null;
            }
        }
        o = m31738o(i);
        if (StringUtil.m3589a(o)) {
            return o;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getSimOperator();
        }
        return null;
    }

    @Nullable
    public final String m31747g(int i) {
        Throwable e;
        if (!m31733b() && !m31734c()) {
            return null;
        }
        CharSequence n;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31768j();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get phone number from MediaTek API.", e);
                n = m31737n(i);
                if (StringUtil.m3589a(n)) {
                    return n;
                }
                if (this.f23453c == null) {
                }
                return this.f23456f.m31755a(i);
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get phone number from MediaTek API.", e);
                n = m31737n(i);
                if (StringUtil.m3589a(n)) {
                    return n;
                }
                if (this.f23453c == null) {
                }
                return this.f23456f.m31755a(i);
            }
        }
        n = m31737n(i);
        if (StringUtil.m3589a(n)) {
            return n;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getLine1Number();
        }
        return this.f23456f.m31755a(i);
    }

    @Nullable
    public final Map<String, String> m31748h(int i) {
        Object n;
        String str;
        Throwable e;
        Object obj;
        Object obj2;
        Object a;
        String str2 = null;
        Map<String, String> hashMap = new HashMap();
        if (m31733b() || m31734c()) {
            n = m31737n(i);
            if (this.f23453c == null || i != 0) {
                str = str2;
            } else {
                str = this.f23453c.getLine1Number();
            }
            if (m31731a()) {
                try {
                    TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                    str2 = TelephonyManagerEx.m31768j();
                } catch (RuntimeException e2) {
                    e = e2;
                    BLog.b(f23451a, "Error attempting to get phone number from MediaTek API.", e);
                    obj = str;
                    obj2 = str2;
                    a = this.f23456f.m31755a(i);
                    hashMap.put("android_subscription_manager", n);
                    hashMap.put("android_telephony_manager", obj);
                    hashMap.put("mediatek", obj2);
                    hashMap.put("java_reflection", a);
                    return hashMap;
                } catch (IllegalAccessError e3) {
                    e = e3;
                    BLog.b(f23451a, "Error attempting to get phone number from MediaTek API.", e);
                    obj = str;
                    obj2 = str2;
                    a = this.f23456f.m31755a(i);
                    hashMap.put("android_subscription_manager", n);
                    hashMap.put("android_telephony_manager", obj);
                    hashMap.put("mediatek", obj2);
                    hashMap.put("java_reflection", a);
                    return hashMap;
                }
            }
            obj = str;
            obj2 = str2;
            a = this.f23456f.m31755a(i);
        } else {
            str = str2;
            String str3 = str2;
            String str4 = str2;
        }
        hashMap.put("android_subscription_manager", n);
        hashMap.put("android_telephony_manager", obj);
        hashMap.put("mediatek", obj2);
        hashMap.put("java_reflection", a);
        return hashMap;
    }

    public final int m31749i(int i) {
        Throwable e;
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31763e();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get SIM card state from MediaTek API.", e);
                if (m31740q(i) == null) {
                    return 0;
                }
                if (this.f23453c == null) {
                }
                if (this.f23456f == null) {
                }
                return -1;
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get SIM card state from MediaTek API.", e);
                if (m31740q(i) == null) {
                    return 0;
                }
                if (this.f23453c == null) {
                }
                if (this.f23456f == null) {
                }
                return -1;
            }
        }
        if (m31740q(i) == null) {
            return 0;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getSimState();
        }
        if (this.f23456f == null && this.f23456f.m31756a()) {
            return 0;
        }
        return -1;
    }

    @Nullable
    public final String m31750j(int i) {
        Throwable e;
        CharSequence m;
        if (!m31733b()) {
            return null;
        }
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31766h();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get SIM card serial number from MediaTek API.", e);
                m = m31736m(i);
                if (StringUtil.m3589a(m)) {
                    return m;
                }
                if (this.f23453c == null) {
                }
                return this.f23456f.m31757b(i);
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get SIM card serial number from MediaTek API.", e);
                m = m31736m(i);
                if (StringUtil.m3589a(m)) {
                    return m;
                }
                if (this.f23453c == null) {
                }
                return this.f23456f.m31757b(i);
            }
        }
        m = m31736m(i);
        if (StringUtil.m3589a(m)) {
            return m;
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getSimSerialNumber();
        }
        return this.f23456f.m31757b(i);
    }

    @Nullable
    public final String m31751k(int i) {
        Throwable e;
        if (!m31733b()) {
            return null;
        }
        if (m31731a()) {
            try {
                TelephonyManagerEx telephonyManagerEx = new TelephonyManagerEx();
                return TelephonyManagerEx.m31767i();
            } catch (RuntimeException e2) {
                e = e2;
                BLog.b(f23451a, "Error attempting to get subscriber ID from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return this.f23456f.m31758c(i);
            } catch (IllegalAccessError e3) {
                e = e3;
                BLog.b(f23451a, "Error attempting to get subscriber ID from MediaTek API.", e);
                if (this.f23453c == null) {
                }
                return this.f23456f.m31758c(i);
            }
        }
        if (this.f23453c == null && i == 0) {
            return this.f23453c.getSubscriberId();
        }
        return this.f23456f.m31758c(i);
    }

    private boolean m31731a() {
        return ((Boolean) this.f23454d.get()).booleanValue() && "true".equals(SystemProperties.get("ro.mediatek.gemini_support"));
    }

    private boolean m31733b() {
        return this.f23455e.m13593a("android.permission.READ_PHONE_STATE");
    }

    private boolean m31734c() {
        return this.f23455e.m13593a("android.permission.READ_SMS");
    }

    @TargetApi(22)
    @Nullable
    private String m31735l(int i) {
        SubscriptionInfo q = m31740q(i);
        if (q == null || q.getCarrierName() == null) {
            return null;
        }
        return q.getCarrierName().toString();
    }

    @TargetApi(22)
    @Nullable
    private String m31736m(int i) {
        SubscriptionInfo q = m31740q(i);
        return q != null ? q.getIccId() : null;
    }

    @TargetApi(22)
    @Nullable
    private String m31737n(int i) {
        SubscriptionInfo q = m31740q(i);
        return q != null ? q.getNumber() : null;
    }

    @TargetApi(22)
    @Nullable
    private String m31738o(int i) {
        SubscriptionInfo q = m31740q(i);
        return q != null ? String.valueOf(q.getMcc()) + String.valueOf(q.getMnc()) : null;
    }

    @TargetApi(22)
    @Nullable
    private String m31739p(int i) {
        SubscriptionInfo q = m31740q(i);
        return q != null ? q.getCountryIso() : null;
    }

    @TargetApi(22)
    @Nullable
    private SubscriptionInfo m31740q(int i) {
        if (VERSION.SDK_INT < 22 || !m31733b()) {
            return null;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.f23457g.get();
        return subscriptionManager != null ? subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i) : null;
    }
}
