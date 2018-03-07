package android_src.mmsv2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: setPermissions */
public class Utils {
    static boolean m3583a() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m3587b() {
        return VERSION.SDK_INT >= 22;
    }

    public static SmsManager m3581a(int i) {
        if (m3587b()) {
            return SmsManager.getSmsManagerForSubscriptionId(i);
        }
        return SmsManager.getDefault();
    }

    public static int m3585b(int i) {
        int defaultSmsSubscriptionId;
        if (m3587b() && i == -1) {
            defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
        } else {
            defaultSmsSubscriptionId = i;
        }
        if (defaultSmsSubscriptionId < 0) {
            return -1;
        }
        return defaultSmsSubscriptionId;
    }

    static int[] m3584a(Context context, int i) {
        int[] iArr = new int[]{0, 0};
        if (m3587b()) {
            SubscriptionInfo activeSubscriptionInfo = SubscriptionManager.from(context).getActiveSubscriptionInfo(i);
            if (activeSubscriptionInfo != null) {
                iArr[0] = activeSubscriptionInfo.getMcc();
                iArr[1] = activeSubscriptionInfo.getMnc();
            }
        } else {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            try {
                iArr[0] = Integer.parseInt(simOperator.substring(0, 3));
                iArr[1] = Integer.parseInt(simOperator.substring(3));
            } catch (Exception e) {
                BLog.a("MmsLib", "Invalid mcc/mnc from system " + simOperator + ": " + e);
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return iArr;
    }

    static Context m3586b(Context context, int i) {
        if (!m3587b()) {
            return context;
        }
        int[] a = m3584a(context, i);
        int i2 = a[0];
        int i3 = a[1];
        if (i2 == 0 && i3 == 0) {
            return context;
        }
        Configuration configuration = new Configuration();
        configuration.mcc = i2;
        configuration.mnc = i3;
        return context.createConfigurationContext(configuration);
    }

    static String m3582a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "http";
        String str3 = "";
        try {
            URL url = new URL(str);
            str2 = url.getProtocol();
            str3 = url.getHost();
        } catch (MalformedURLException e) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append("://").append(str3).append("[").append(str.length()).append("]");
        return stringBuilder.toString();
    }

    public static boolean m3588d() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m3589e() {
        return VERSION.SDK_INT >= 22;
    }
}
