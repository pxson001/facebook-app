package android_src.mmsv2;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* compiled from: setThreadTheme */
public class DefaultUserAgentInfoLoader {
    private Context f3760a;
    private boolean f3761b;
    private String f3762c;
    private String f3763d;

    DefaultUserAgentInfoLoader(Context context) {
        this.f3760a = context;
    }

    public final String m3506a() {
        m3504c();
        return this.f3762c;
    }

    public final String m3507b() {
        m3504c();
        return this.f3763d;
    }

    private void m3504c() {
        Object obj = 1;
        if (!this.f3761b) {
            synchronized (this) {
                if (this.f3761b) {
                    obj = null;
                } else {
                    m3505d();
                    this.f3761b = true;
                }
            }
            if (obj != null) {
                new StringBuilder("Loaded user agent info: UA=").append(this.f3762c).append(", UAProfUrl=").append(this.f3763d);
            }
        }
    }

    private void m3505d() {
        Object obj;
        if (VERSION.SDK_INT >= 19) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f3760a.getSystemService("phone");
            this.f3762c = telephonyManager.getMmsUserAgent();
            this.f3763d = telephonyManager.getMmsUAProfUrl();
        }
        if (TextUtils.isEmpty(this.f3762c)) {
            this.f3762c = "Android MmsLib/1.0";
        }
        if (TextUtils.isEmpty(this.f3763d)) {
            this.f3763d = "http://www.gstatic.com/android/sms/mms_ua_profile.xml";
        }
    }
}
