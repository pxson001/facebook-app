package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: event/{%s}/messagefriends/asgroup */
public final class Utility {
    private static final String[] f24048a = new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories"};
    private static Map<String, FetchedAppSettings> f24049b = new ConcurrentHashMap();
    public static AtomicBoolean f24050c = new AtomicBoolean(false);
    private static int f24051d = 0;
    private static long f24052e = -1;
    private static long f24053f = -1;
    private static long f24054g = -1;
    private static String f24055h = "";
    private static String f24056i = "NoCarrier";

    /* compiled from: event/{%s}/messagefriends/asgroup */
    public interface GraphMeRequestWithCacheCallback {
        void mo697a(FacebookException facebookException);

        void mo698a(JSONObject jSONObject);
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    final class C34521 implements Runnable {
        final /* synthetic */ Context f24032a;
        final /* synthetic */ String f24033b;
        final /* synthetic */ String f24034c;

        C34521(Context context, String str, String str2) {
            this.f24032a = context;
            this.f24033b = str;
            this.f24034c = str2;
        }

        public final void run() {
            JSONObject jSONObject;
            SharedPreferences sharedPreferences = this.f24032a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
            String string = sharedPreferences.getString(this.f24033b, null);
            if (!Utility.m25345a(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception e) {
                    Utility.m25338a("FacebookSDK", e);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    Utility.m25349b(this.f24034c, jSONObject);
                }
            }
            jSONObject = Utility.m25361f(this.f24034c);
            if (jSONObject != null) {
                Utility.m25349b(this.f24034c, jSONObject);
                sharedPreferences.edit().putString(this.f24033b, jSONObject.toString()).apply();
            }
            Utility.f24050c.set(false);
        }
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    final class C34532 implements Callback {
        final /* synthetic */ GraphMeRequestWithCacheCallback f24035a;
        final /* synthetic */ String f24036b;

        public final void mo693a(GraphResponse graphResponse) {
            if (graphResponse.f13827d != null) {
                this.f24035a.mo697a(graphResponse.f13827d.f13761o);
                return;
            }
            ProfileInformationCache.f24028a.put(this.f24036b, graphResponse.f13825b);
            this.f24035a.mo698a(graphResponse.f13825b);
        }

        C34532(GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
            this.f24035a = graphMeRequestWithCacheCallback;
            this.f24036b = str;
        }
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    final class C34543 implements FilenameFilter {
        C34543() {
        }

        public final boolean accept(File file, String str) {
            return Pattern.matches("cpu[0-9]+", str);
        }
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    public class DialogFeatureConfig {
        public String f24037a;
        public String f24038b;
        private Uri f24039c;
        private int[] f24040d;

        public static int[] m25311a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int optInt = jSONArray.optInt(i, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i);
                    if (!Utility.m25345a(optString)) {
                        try {
                            optInt = Integer.parseInt(optString);
                        } catch (Exception e) {
                            Utility.m25338a("FacebookSDK", e);
                            optInt = -1;
                        }
                    }
                }
                iArr[i] = optInt;
            }
            return iArr;
        }

        public DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.f24037a = str;
            this.f24038b = str2;
            this.f24039c = uri;
            this.f24040d = iArr;
        }
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    public class FetchedAppSettings {
        public boolean f24041a;
        private String f24042b;
        private boolean f24043c;
        private Map<String, Map<String, DialogFeatureConfig>> f24044d;
        private FacebookRequestErrorClassification f24045e;

        private FetchedAppSettings(boolean z, String str, boolean z2, Map<String, Map<String, DialogFeatureConfig>> map, FacebookRequestErrorClassification facebookRequestErrorClassification) {
            this.f24041a = z;
            this.f24042b = str;
            this.f24043c = z2;
            this.f24044d = map;
            this.f24045e = facebookRequestErrorClassification;
        }

        public final FacebookRequestErrorClassification m25312b() {
            return this.f24045e;
        }
    }

    /* compiled from: event/{%s}/messagefriends/asgroup */
    public class PermissionsPair {
        List<String> f24046a;
        List<String> f24047b;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.f24046a = list;
            this.f24047b = list2;
        }

        public final List<String> m25313a() {
            return this.f24046a;
        }

        public final List<String> m25314b() {
            return this.f24047b;
        }
    }

    public static void m25338a(String str, Exception exception) {
        if (FacebookSdk.f13773j && str != null && exception != null) {
            Log.d(str, exception.getClass().getSimpleName() + ": " + exception.getMessage());
        }
    }

    public static void m25339a(String str, String str2) {
        if (FacebookSdk.f13773j && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void m25340a(String str, String str2, Throwable th) {
        if (FacebookSdk.f13773j && !m25345a(str)) {
            Log.d(str, str2, th);
        }
    }

    public static <T> boolean m25346a(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean m25345a(String str) {
        return str == null || str.length() == 0;
    }

    public static <T> Collection<T> m25330a(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static String m25327a(byte[] bArr) {
        return m25325a("SHA-1", bArr);
    }

    private static String m25325a(String str, byte[] bArr) {
        try {
            return m25326a(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String m25326a(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString((b >> 0) & 15));
        }
        return stringBuilder.toString();
    }

    public static Uri m25318a(String str, String str2, Bundle bundle) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static Bundle m25348b(String str) {
        Bundle bundle = new Bundle();
        if (!m25345a(str)) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                } catch (Exception e) {
                    m25338a("FacebookSDK", e);
                }
            }
        }
        return bundle;
    }

    public static void m25336a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m25341a(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String m25323a(Context context) {
        Validate.m25366a((Object) context, "context");
        FacebookSdk.m14044a(context);
        return FacebookSdk.m14053i();
    }

    public static Object m25322a(JSONObject jSONObject, String str, String str2) {
        Object obj;
        Object opt = jSONObject.opt(str);
        if (opt == null || !(opt instanceof String)) {
            obj = opt;
        } else {
            obj = new JSONTokener((String) opt).nextValue();
        }
        if (obj == null || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, obj);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String m25324a(InputStream inputStream) {
        Closeable inputStreamReader;
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            stringBuilder.append(cArr, 0, read);
                        } else {
                            String stringBuilder2 = stringBuilder.toString();
                            m25336a(bufferedInputStream);
                            m25336a(inputStreamReader);
                            return stringBuilder2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = bufferedInputStream;
                    m25336a(closeable);
                    m25336a(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                closeable = bufferedInputStream;
                m25336a(closeable);
                m25336a(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            m25336a(closeable);
            m25336a(inputStreamReader);
            throw th;
        }
    }

    public static int m25315a(InputStream inputStream, OutputStream outputStream) {
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
                bufferedInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    private static void m25352b(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            for (String split : cookie.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length > 0) {
                    instance.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            instance.removeExpiredCookie();
        }
    }

    public static void m25351b(Context context) {
        m25352b(context, "facebook.com");
        m25352b(context, ".facebook.com");
        m25352b(context, "https://facebook.com");
        m25352b(context, "https://.facebook.com");
    }

    public static <T> boolean m25344a(T t, T t2) {
        if (t == null) {
            return t2 == null;
        } else {
            return t.equals(t2);
        }
    }

    public static void m25334a(Context context, String str) {
        boolean compareAndSet = f24050c.compareAndSet(false, true);
        if (!m25345a(str) && !f24049b.containsKey(str) && compareAndSet) {
            ExecutorDetour.a(FacebookSdk.m14050d(), new C34521(context, String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{str}), str), -954932539);
        }
    }

    public static FetchedAppSettings m25353c(String str) {
        return str != null ? (FetchedAppSettings) f24049b.get(str) : null;
    }

    public static FetchedAppSettings m25319a(String str, boolean z) {
        if (!z && f24049b.containsKey(str)) {
            return (FetchedAppSettings) f24049b.get(str);
        }
        JSONObject f = m25361f(str);
        if (f == null) {
            return null;
        }
        return m25349b(str, f);
    }

    public static FetchedAppSettings m25349b(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), m25350b(jSONObject.optJSONObject("android_dialog_configs")), optJSONArray == null ? FacebookRequestErrorClassification.m25260a() : FacebookRequestErrorClassification.m25261a(optJSONArray));
        f24049b.put(str, fetchedAppSettings);
        return fetchedAppSettings;
    }

    public static JSONObject m25361f(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", f24048a));
        GraphRequest graphRequest = new GraphRequest(null, str, null, null, null);
        graphRequest.f13812p = true;
        graphRequest.f13807k = bundle;
        return graphRequest.m14108f().f13825b;
    }

    private static Map<String, Map<String, DialogFeatureConfig>> m25350b(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Uri uri = null;
                    String optString = optJSONObject.optString("name");
                    if (!m25345a(optString)) {
                        String[] split = optString.split("\\|");
                        if (split.length == 2) {
                            String str = split[0];
                            String str2 = split[1];
                            if (!(m25345a(str) || m25345a(str2))) {
                                optString = optJSONObject.optString("url");
                                if (!m25345a(optString)) {
                                    uri = Uri.parse(optString);
                                }
                                Object dialogFeatureConfig = new DialogFeatureConfig(str, str2, uri, DialogFeatureConfig.m25311a(optJSONObject.optJSONArray("versions")));
                            }
                        }
                    }
                    Uri uri2 = uri;
                    if (uri2 != null) {
                        String str3 = uri2.f24037a;
                        Map map = (Map) hashMap.get(str3);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(str3, map);
                        }
                        map.put(uri2.f24038b, uri2);
                    }
                }
            }
        }
        return hashMap;
    }

    public static List<String> m25332a(JSONArray jSONArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static void m25343a(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) {
        boolean z2 = true;
        if (!(attributionIdentifiers == null || attributionIdentifiers.f23968b == null)) {
            jSONObject.put("attribution", attributionIdentifiers.f23968b);
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.f23969c == null)) {
            boolean z3;
            jSONObject.put("advertiser_id", attributionIdentifiers.f23969c);
            String str2 = "advertiser_tracking_enabled";
            if (attributionIdentifiers.f23971e) {
                z3 = false;
            } else {
                z3 = true;
            }
            jSONObject.put(str2, z3);
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.f23970d == null)) {
            jSONObject.put("installer_package", attributionIdentifiers.f23970d);
        }
        jSONObject.put("anon_id", str);
        String str3 = "application_tracking_enabled";
        if (z) {
            z2 = false;
        }
        jSONObject.put(str3, z2);
    }

    public static void m25342a(JSONObject jSONObject, Context context) {
        Locale locale;
        double d;
        int i;
        int i2;
        int i3;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        m25357d(context);
        String packageName = context.getPackageName();
        int i4 = -1;
        Object obj = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i4 = packageInfo.versionCode;
            obj = packageInfo.versionName;
        } catch (NameNotFoundException e) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(obj);
        jSONArray.put(VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(f24055h);
        jSONArray.put(f24056i);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i5 = displayMetrics.widthPixels;
                try {
                    int i6 = displayMetrics.heightPixels;
                    try {
                        d = (double) displayMetrics.density;
                        i = i6;
                        i2 = i5;
                    } catch (Exception e3) {
                        i3 = i6;
                        i4 = i5;
                        i = i3;
                        i2 = i4;
                        d = 0.0d;
                        jSONArray.put(i2);
                        jSONArray.put(i);
                        jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
                        jSONArray.put(m25347b());
                        jSONArray.put(f24053f);
                        jSONArray.put(f24054g);
                        jSONObject.put("extinfo", jSONArray.toString());
                    }
                } catch (Exception e4) {
                    i3 = 0;
                    i4 = i5;
                    i = i3;
                    i2 = i4;
                    d = 0.0d;
                    jSONArray.put(i2);
                    jSONArray.put(i);
                    jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
                    jSONArray.put(m25347b());
                    jSONArray.put(f24053f);
                    jSONArray.put(f24054g);
                    jSONObject.put("extinfo", jSONArray.toString());
                }
            }
            d = 0.0d;
            i = 0;
            i2 = 0;
        } catch (Exception e5) {
            i3 = 0;
            i4 = 0;
            i = i3;
            i2 = i4;
            d = 0.0d;
            jSONArray.put(i2);
            jSONArray.put(i);
            jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
            jSONArray.put(m25347b());
            jSONArray.put(f24053f);
            jSONArray.put(f24054g);
            jSONObject.put("extinfo", jSONArray.toString());
        }
        jSONArray.put(i2);
        jSONArray.put(i);
        jSONArray.put(String.format("%.2f", new Object[]{Double.valueOf(d)}));
        jSONArray.put(m25347b());
        jSONArray.put(f24053f);
        jSONArray.put(f24054g);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static Method m25328a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method m25329a(String str, String str2, Class<?>... clsArr) {
        try {
            return m25328a(Class.forName(str), str2, (Class[]) clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Object m25321a(Object obj, Method method, Object... objArr) {
        Object obj2 = null;
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return obj2;
    }

    public static String m25354c(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    public static long m25317a(Uri uri) {
        Cursor query;
        Throwable th;
        try {
            query = FacebookSdk.m14051f().getContentResolver().query(uri, null, null, null, null);
            try {
                int columnIndex = query.getColumnIndex("_size");
                query.moveToFirst();
                long j = query.getLong(columnIndex);
                if (query != null) {
                    query.close();
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static Date m25331a(Bundle bundle, String str, Date date) {
        if (bundle == null) {
            return null;
        }
        long longValue;
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            longValue = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                longValue = Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (longValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((longValue * 1000) + date.getTime());
    }

    public static void m25335a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    public static Map<String, String> m25333a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static void m25337a(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        JSONObject a = ProfileInformationCache.m25307a(str);
        if (a != null) {
            graphMeRequestWithCacheCallback.mo698a(a);
            return;
        }
        Callback c34532 = new C34532(graphMeRequestWithCacheCallback, str);
        GraphRequest g = m25363g(str);
        g.m14103a(c34532);
        g.m14109g();
    }

    public static JSONObject m25356d(String str) {
        JSONObject a = ProfileInformationCache.m25307a(str);
        if (a != null) {
            return a;
        }
        GraphResponse f = m25363g(str).m14108f();
        if (f.f13827d != null) {
            return null;
        }
        return f.f13825b;
    }

    private static GraphRequest m25363g(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    private static int m25347b() {
        if (f24051d > 0) {
            return f24051d;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C34543());
            if (listFiles != null) {
                f24051d = listFiles.length;
            }
        } catch (Exception e) {
        }
        if (f24051d <= 0) {
            f24051d = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f24051d;
    }

    private static void m25357d(Context context) {
        if (f24052e == -1 || System.currentTimeMillis() - f24052e >= 1800000) {
            f24052e = System.currentTimeMillis();
            m25355c();
            m25360e(context);
            m25362f();
            m25359e();
        }
    }

    private static void m25355c() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            f24055h = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
        } catch (Exception e) {
        }
    }

    private static void m25360e(Context context) {
        if (f24056i.equals("NoCarrier")) {
            try {
                f24056i = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e) {
            }
        }
    }

    private static boolean m25358d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void m25359e() {
        try {
            if (m25358d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f24054g = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            f24054g = m25316a((double) f24054g);
        } catch (Exception e) {
        }
    }

    private static void m25362f() {
        try {
            if (m25358d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f24053f = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            f24053f = m25316a((double) f24053f);
        } catch (Exception e) {
        }
    }

    private static long m25316a(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    public static PermissionsPair m25320a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        List arrayList = new ArrayList(jSONArray.length());
        List arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("permission");
            if (!(optString == null || optString.equals("installed"))) {
                String optString2 = optJSONObject.optString("status");
                if (optString2 != null) {
                    if (optString2.equals("granted")) {
                        arrayList.add(optString);
                    } else if (optString2.equals("declined")) {
                        arrayList2.add(optString);
                    }
                }
            }
        }
        return new PermissionsPair(arrayList, arrayList2);
    }
}
