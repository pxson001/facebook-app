package com.facebook.android.maps.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.Tile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.MapsRuntimePermissionManager;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.Semaphore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: duration */
public class MapConfig {
    public static String f13474a;
    public static String f13475b;
    public static String f13476c;
    public static MapsRuntimePermissionManager f13477d;
    public static String f13478e;
    public static long f13479f;
    public static final Semaphore f13480g = new Semaphore(1);
    public static final List<WeakReference<OnConfigUpdateListener>> f13481h = new LinkedList();
    public static volatile String f13482i = "https://graph.facebook.com/v2.2/maps_configs?fields=base_url,static_base_url,osm_config,url_override_config&pretty=0&access_token=";
    private static final ImmutableConfig f13483j = new ImmutableConfig("https://www.facebook.com/maps/tile/?", "https://www.facebook.com/maps/static/?", null, Integer.MAX_VALUE, null, null);
    private static final ImmutableConfig f13484k = new ImmutableConfig("https://maps.instagram.com/maps/tile/?", "https://maps.instagram.com/maps/static/?", null, Integer.MAX_VALUE, null, null);
    public static volatile ImmutableConfig f13485l = f13483j;
    public static Context f13486m;
    private static BroadcastReceiver f13487n;
    public static final Dispatchable f13488o = new C06381();
    public static final Dispatchable f13489p = new C06392();

    /* compiled from: duration */
    public class ImmutableConfig {
        final String f13490a;
        public final String f13491b;
        public final String f13492c;
        final Rect[] f13493d;
        final int f13494e;
        final String[] f13495f;
        final RectD[][] f13496g;

        ImmutableConfig(String str, String str2, Rect[] rectArr, int i, String[] strArr, RectD[][] rectDArr) {
            this.f13490a = str;
            String queryParameter = Uri.parse(str).getQueryParameter("v");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = "unknown";
            }
            this.f13491b = queryParameter;
            this.f13492c = str2;
            this.f13493d = rectArr;
            this.f13494e = i;
            this.f13495f = strArr;
            this.f13496g = rectDArr;
        }
    }

    /* compiled from: duration */
    final class C06381 extends Dispatchable {
        C06381() {
        }

        public final void run() {
            ListIterator listIterator = MapConfig.f13481h.listIterator();
            while (listIterator.hasNext()) {
                OnConfigUpdateListener onConfigUpdateListener = (OnConfigUpdateListener) ((WeakReference) listIterator.next()).get();
                if (onConfigUpdateListener != null) {
                    onConfigUpdateListener.i();
                } else {
                    listIterator.remove();
                }
            }
        }
    }

    /* compiled from: duration */
    final class C06392 extends Dispatchable {
        private int f13500a;

        C06392() {
        }

        public final void run() {
            this.f13500a++;
            JSONObject b = C06392.m14376b();
            if (b != null) {
                MapConfig.f13485l = C06392.m14375a(b);
                MapConfig.f13479f = SystemClock.uptimeMillis();
                GrandCentralDispatch.m14427c(MapConfig.f13488o);
            } else if (this.f13500a < 3) {
                Dispatchable dispatchable = MapConfig.f13489p;
                int i = GrandCentralDispatch.f13559d;
                GrandCentralDispatch.f13559d = i - 1;
                dispatchable.f13497a = ((long) i) << 32;
                dispatchable.f13499c = null;
                dispatchable.f13498b = SystemClock.uptimeMillis() + 5000;
                GrandCentralDispatch.f13557b.add(dispatchable);
                return;
            }
            this.f13500a = 0;
            MapConfig.f13480g.release();
        }

        public final void mo971a() {
            super.mo971a();
            MapConfig.f13480g.release();
        }

        private static JSONObject m14376b() {
            Location location;
            String str;
            InputStream openStream;
            Object obj;
            int i;
            int read;
            Throwable e;
            JSONObject jSONObject;
            InputStream inputStream = null;
            if (VERSION.SDK_INT < 23 || (MapConfig.f13486m.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && MapConfig.f13486m.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) {
                LocationManager locationManager = (LocationManager) MapConfig.f13486m.getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                if (providers != null) {
                    location = null;
                    for (String str2 : providers) {
                        Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
                        if (!(location == null || MyLocationHelper.m14378a(lastKnownLocation, location))) {
                            lastKnownLocation = location;
                        }
                        location = lastKnownLocation;
                    }
                    Object obj2 = new byte[512];
                    StringBuilder append = new StringBuilder().append(MapConfig.f13482i).append(MapConfig.f13478e);
                    if (location != null) {
                        str2 = "";
                    } else {
                        str2 = "&latitude=" + location.getLatitude() + "&longitude=" + location.getLongitude();
                    }
                    openStream = new URL(append.append(str2).toString()).openStream();
                    obj = obj2;
                    i = 0;
                    while (true) {
                        try {
                            read = openStream.read(obj, i, obj.length - i);
                            if (read != -1) {
                                break;
                            }
                            i += read;
                            if (i >= obj.length) {
                                Object obj3 = new byte[(obj.length << 1)];
                                System.arraycopy(obj, 0, obj3, 0, obj.length);
                                obj = obj3;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    jSONObject = new JSONObject(new String(obj, 0, i)).getJSONArray("data").getJSONObject(0);
                    if (openStream != null) {
                        try {
                            openStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return jSONObject;
                }
            }
            location = null;
            try {
                Object obj22 = new byte[512];
                StringBuilder append2 = new StringBuilder().append(MapConfig.f13482i).append(MapConfig.f13478e);
                if (location != null) {
                    str2 = "&latitude=" + location.getLatitude() + "&longitude=" + location.getLongitude();
                } else {
                    str2 = "";
                }
                openStream = new URL(append2.append(str2).toString()).openStream();
                obj = obj22;
                i = 0;
                while (true) {
                    read = openStream.read(obj, i, obj.length - i);
                    if (read != -1) {
                        break;
                    }
                    i += read;
                    if (i >= obj.length) {
                        Object obj32 = new byte[(obj.length << 1)];
                        System.arraycopy(obj, 0, obj32, 0, obj.length);
                        obj = obj32;
                    }
                }
                jSONObject = new JSONObject(new String(obj, 0, i)).getJSONArray("data").getJSONObject(0);
                if (openStream != null) {
                    openStream.close();
                }
            } catch (Exception e4) {
                e = e4;
                openStream = null;
                try {
                    AnalyticsEvent.f13530q.m14393a(e);
                    if (openStream != null) {
                        try {
                            openStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return jSONObject;
                } catch (Throwable th) {
                    e = th;
                    inputStream = openStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
            return jSONObject;
        }

        private static ImmutableConfig m14375a(JSONObject jSONObject) {
            int i;
            Rect[] rectArr;
            int i2;
            int i3;
            String[] strArr;
            RectD[][] rectDArr;
            String optString = jSONObject.optString("base_url", MapConfig.f13485l.f13490a);
            String optString2 = jSONObject.optString("static_base_url", MapConfig.f13485l.f13492c);
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("osm_config");
                i = jSONObject2.getInt("zoom_threshold");
                JSONArray jSONArray = jSONObject2.getJSONArray("rectangles");
                int length = jSONArray.length();
                rectArr = new Rect[length];
                i2 = 1 << i;
                for (i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    rectArr[i3] = new Rect((int) (((float) i2) * Projection.m14402d(jSONObject3.getDouble("west"))), (int) (((float) i2) * Projection.m14399b(jSONObject3.getDouble("north"))), (int) (((float) i2) * Projection.m14402d(jSONObject3.getDouble("east"))), (int) (Projection.m14399b(jSONObject3.getDouble("south")) * ((float) i2)));
                }
            } catch (JSONException e) {
                i = MapConfig.f13485l.f13494e;
                rectArr = MapConfig.f13485l.f13493d;
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("url_override_config");
                int length2 = jSONArray2.length();
                strArr = new String[length2];
                rectDArr = new RectD[length2][];
                for (i2 = 0; i2 < length2; i2++) {
                    jSONObject2 = jSONArray2.getJSONObject(i2);
                    strArr[i2] = jSONObject2.getString("base_url");
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("rectangles");
                    int length3 = jSONArray3.length();
                    rectDArr[i2] = new RectD[length3];
                    for (i3 = 0; i3 < length3; i3++) {
                        RectD rectD = new RectD();
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                        rectD.f13554c = (double) Projection.m14402d(jSONObject4.getDouble("west"));
                        rectD.f13552a = (double) Projection.m14399b(jSONObject4.getDouble("north"));
                        rectD.f13555d = (double) Projection.m14402d(jSONObject4.getDouble("east"));
                        rectD.f13553b = (double) Projection.m14399b(jSONObject4.getDouble("south"));
                        rectDArr[i2][i3] = rectD;
                    }
                }
            } catch (JSONException e2) {
                strArr = MapConfig.f13485l.f13495f;
                rectDArr = MapConfig.f13485l.f13496g;
            }
            return new ImmutableConfig(optString, optString2, rectArr, i, strArr, rectDArr);
        }
    }

    /* compiled from: duration */
    final class C06403 extends BroadcastReceiver {
        C06403() {
        }

        public final void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1176792704);
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                MapConfig.m14373m();
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1190956393, a);
        }
    }

    static {
        m14373m();
    }

    public static void m14371a() {
        if (f13478e != null && f13486m != null && f13480g.tryAcquire()) {
            Object obj = (f13479f == 0 || SystemClock.uptimeMillis() - f13479f >= 3600000) ? 1 : null;
            if (obj != null) {
                GrandCentralDispatch.m14421a(f13489p);
            } else {
                f13480g.release();
            }
        }
    }

    public static String m14370a(int i, int i2, int i3) {
        m14371a();
        ImmutableConfig immutableConfig = f13485l;
        if (immutableConfig.f13495f != null) {
            int i4 = 1 << i3;
            int length = immutableConfig.f13495f.length;
            for (int i5 = 0; i5 < length; i5++) {
                for (RectD rectD : immutableConfig.f13496g[i5]) {
                    if (((int) (rectD.f13554c * ((double) i4))) <= i && i <= ((int) (rectD.f13555d * ((double) i4))) && ((int) (rectD.f13552a * ((double) i4))) <= i2 && i2 <= ((int) (rectD.f13553b * ((double) i4)))) {
                        return immutableConfig.f13495f[i5];
                    }
                }
            }
        }
        return immutableConfig.f13490a;
    }

    public static int m14369a(Tile tile, int i) {
        int i2 = 0;
        if (i == 5) {
            return 2;
        }
        ImmutableConfig immutableConfig = f13485l;
        if (immutableConfig.f13493d == null) {
            return 0;
        }
        if (tile.e >= immutableConfig.f13494e) {
            int i3 = tile.e - immutableConfig.f13494e;
            int i4 = tile.f >> i3;
            i3 = tile.g >> i3;
            while (i2 < immutableConfig.f13493d.length) {
                Rect rect = immutableConfig.f13493d[i2];
                if (rect.left <= i4 && i4 <= rect.right && rect.top <= i3 && i3 <= rect.bottom) {
                    return 2;
                }
                i2++;
            }
        }
        return 1;
    }

    public static void m14373m() {
        String language = Locale.getDefault().getLanguage();
        if (language.length() == 2) {
            String country = Locale.getDefault().getCountry();
            f13474a = language + (country.length() == 2 ? "_" + country : "");
        } else {
            f13474a = "en";
        }
        f13475b = f13474a.toLowerCase(Locale.US);
        try {
            f13476c = Locale.getDefault().getISO3Language();
        } catch (MissingResourceException e) {
            f13476c = "eng";
        }
    }

    public static void m14372a(Context context, String str, MapsRuntimePermissionManager mapsRuntimePermissionManager) {
        f13477d = mapsRuntimePermissionManager;
        f13478e = str;
        f13486m = context.getApplicationContext();
        if ("com.instagram.android".equals(f13486m.getPackageName())) {
            f13482i = "https://logger.instagram.com/graph/server.php?_fb_url=v2.2/maps_configs&fields=base_url,static_base_url,osm_config,url_override_config&pretty=0&access_token=";
            f13485l = f13484k;
        }
        if (f13487n == null) {
            f13487n = new C06403();
            f13486m.registerReceiver(f13487n, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
        }
    }
}
