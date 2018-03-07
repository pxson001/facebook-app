package com.facebook.ads.internal.util;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.thirdparty.http.C1961a;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public class C1983g {
    private static final Uri f14330a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final String f14331b = C1983g.class.getSimpleName();
    private static boolean f14332c = false;

    final class C19811 implements X509TrustManager {
        C19811() {
        }

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public class C1982a {
        public String f14327a;
        public String f14328b;
        public boolean f14329c;

        public C1982a(String str, String str2, boolean z) {
            this.f14327a = str;
            this.f14328b = str2;
            this.f14329c = z;
        }
    }

    public static C1982a m14456a(ContentResolver contentResolver) {
        C1982a c1982a;
        Throwable th;
        Cursor query;
        try {
            ContentResolver contentResolver2 = contentResolver;
            query = contentResolver2.query(f14330a, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c1982a = new C1982a(query.getString(query.getColumnIndex("aid")), query.getString(query.getColumnIndex("androidid")), Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking"))).booleanValue());
                        if (query != null) {
                            query.close();
                        }
                        return c1982a;
                    }
                } catch (Exception e) {
                    try {
                        c1982a = new C1982a(null, null, false);
                        if (query != null) {
                            query.close();
                        }
                        return c1982a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            c1982a = new C1982a(null, null, false);
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            c1982a = new C1982a(null, null, false);
            if (query != null) {
                query.close();
            }
            return c1982a;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return c1982a;
    }

    public static Object m14457a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m14458a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static Method m14459a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m14460a(String str, String str2, Class<?>... clsArr) {
        try {
            return C1983g.m14459a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static void m14461a(Context context, String str) {
        if (AdSettings.m14170a(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    public static boolean m14462a() {
        String str = AdSettings.f13894e;
        return !C1994r.m14486a(str) && str.endsWith(".sb");
    }

    public static boolean m14463a(Context context) {
        try {
            return !((PowerManager) context.getSystemService("power")).isScreenOn() ? false : !((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m14464a(Context context, View view, int i) {
        if (view == null) {
            return false;
        }
        if (view.getParent() == null) {
            return false;
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        if (VERSION.SDK_INT >= 11 && view.getAlpha() < 0.9f) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                return false;
            }
            width = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
            return (iArr[1] >= 0 || Math.abs(iArr[1]) <= width) ? (height + iArr[1]) - displayMetrics.heightPixels > width ? false : C1983g.m14463a(context) : false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static void m14465b() {
        if (f14332c) {
            Log.d(f14331b, "Sandbox SSL validation already disabled, ignoring...");
            return;
        }
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C19811()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            Log.d(f14331b, "Sandbox SSL validation disabled.");
        } catch (Exception e) {
            Log.e(f14331b, "Failed to disable sandbox SSL validation: " + e);
        }
    }

    public static C1961a m14466c() {
        C1961a c1961a = new C1961a();
        c1961a.f14276e = 30000;
        c1961a.m14416a(3);
        if (C1983g.m14462a()) {
            C1983g.m14465b();
        }
        return c1961a;
    }
}
