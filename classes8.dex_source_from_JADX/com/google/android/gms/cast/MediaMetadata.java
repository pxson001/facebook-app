package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    private static final String[] f10000a = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final zza f10001b = new zza().m11775a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).m11775a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).m11775a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).m11775a("com.google.android.gms.cast.metadata.TITLE", "title", 1).m11775a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).m11775a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).m11775a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).m11775a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).m11775a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).m11775a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).m11775a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).m11775a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).m11775a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).m11775a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).m11775a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).m11775a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).m11775a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).m11775a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).m11775a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).m11775a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
    public final List<WebImage> f10002c;
    private final Bundle f10003d;
    private int f10004e;

    class zza {
        private final Map<String, String> f9997a = new HashMap();
        private final Map<String, String> f9998b = new HashMap();
        private final Map<String, Integer> f9999c = new HashMap();

        public final zza m11775a(String str, String str2, int i) {
            this.f9997a.put(str, str2);
            this.f9998b.put(str2, str);
            this.f9999c.put(str, Integer.valueOf(i));
            return this;
        }

        public final String m11776a(String str) {
            return (String) this.f9997a.get(str);
        }

        public final String m11777b(String str) {
            return (String) this.f9998b.get(str);
        }

        public final int m11778c(String str) {
            Integer num = (Integer) this.f9999c.get(str);
            return num != null ? num.intValue() : 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this.f10002c = new ArrayList();
        this.f10003d = new Bundle();
        this.f10004e = i;
    }

    private static void m11779a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int c = f10001b.m11778c(str);
        if (c != i && c != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + f10000a[i]);
        }
    }

    private void m11780a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.f10003d.containsKey(str)) {
                    switch (f10001b.m11778c(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(f10001b.m11776a(str), this.f10003d.getString(str));
                            break;
                        case 2:
                            jSONObject.put(f10001b.m11776a(str), this.f10003d.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(f10001b.m11776a(str), this.f10003d.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.f10003d.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.f10003d.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean m11781a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m11781a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void m11782b() {
        this.f10003d.clear();
        this.f10002c.clear();
    }

    private void m11783b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String b = f10001b.m11777b(str);
                    if (b == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.f10003d.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.f10003d.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.f10003d.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(b)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (f10001b.m11778c(b)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.f10003d.putString(b, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.f10003d.putInt(b, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.f10003d.putDouble(b, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && zzln.m11967a((String) obj2) != null) {
                                            this.f10003d.putString(b, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    public final JSONObject m11784a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.f10004e);
        } catch (JSONException e) {
        }
        zzln.m11969a(jSONObject, this.f10002c);
        switch (this.f10004e) {
            case 0:
                m11780a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 1:
                m11780a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 2:
                m11780a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
                break;
            case 3:
                m11780a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                break;
            case 4:
                m11780a(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
                break;
            default:
                m11780a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public final void m11785a(String str, String str2) {
        m11779a(str, 1);
        this.f10003d.putString(str, str2);
    }

    public final void m11786a(JSONObject jSONObject) {
        m11782b();
        this.f10004e = 0;
        try {
            this.f10004e = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzln.m11968a(this.f10002c, jSONObject);
        switch (this.f10004e) {
            case 0:
                m11783b(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 1:
                m11783b(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 2:
                m11783b(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
                return;
            case 3:
                m11783b(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
                return;
            case 4:
                m11783b(jSONObject, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
                return;
            default:
                m11783b(jSONObject, new String[0]);
                return;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return m11781a(this.f10003d, mediaMetadata.f10003d) && this.f10002c.equals(mediaMetadata.f10002c);
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.f10003d.keySet()) {
            i *= 31;
            i = this.f10003d.get(str).hashCode() + i;
        }
        return (i * 31) + this.f10002c.hashCode();
    }
}
