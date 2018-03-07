package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import org.json.JSONArray;
import org.json.JSONObject;

public class MediaQueueItem {
    private MediaInfo f10006a;
    public int f10007b = 0;
    private boolean f10008c = true;
    private double f10009d;
    private double f10010e = Double.POSITIVE_INFINITY;
    private double f10011f;
    private long[] f10012g;
    private JSONObject f10013h;

    public class Builder {
        public final MediaQueueItem f10005a;

        public Builder(MediaInfo mediaInfo) {
            this.f10005a = new MediaQueueItem(mediaInfo);
        }
    }

    public MediaQueueItem(MediaInfo mediaInfo) {
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.f10006a = mediaInfo;
    }

    MediaQueueItem(JSONObject jSONObject) {
        m11787a(jSONObject);
    }

    public final boolean m11787a(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        double d;
        long[] jArr;
        if (jSONObject.has("media")) {
            this.f10006a = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId")) {
            int i = jSONObject.getInt("itemId");
            if (this.f10007b != i) {
                this.f10007b = i;
                z = true;
            }
        }
        if (jSONObject.has("autoplay")) {
            z2 = jSONObject.getBoolean("autoplay");
            if (this.f10008c != z2) {
                this.f10008c = z2;
                z = true;
            }
        }
        if (jSONObject.has("startTime")) {
            d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.f10009d) > 1.0E-7d) {
                this.f10009d = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.f10010e) > 1.0E-7d) {
                this.f10010e = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            d = jSONObject.getDouble("preloadTime");
            if (Math.abs(d - this.f10011f) > 1.0E-7d) {
                this.f10011f = d;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            int i2;
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.f10012g == null) {
                jArr = jArr2;
                z2 = true;
            } else if (this.f10012g.length != length) {
                jArr = jArr2;
                z2 = true;
            } else {
                for (i2 = 0; i2 < length; i2++) {
                    if (this.f10012g[i2] != jArr2[i2]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                }
                long[] jArr3 = jArr2;
                z2 = false;
                jArr = jArr3;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.f10012g = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.f10013h = jSONObject.getJSONObject("customData");
        return true;
    }

    public final void m11788b() {
        if (this.f10006a == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.f10009d) || this.f10009d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.f10010e)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.f10011f) || this.f10011f < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        return (this.f10013h == null) == (mediaQueueItem.f10013h == null) ? (this.f10013h == null || mediaQueueItem.f10013h == null || zznu.a(this.f10013h, mediaQueueItem.f10013h)) && zzf.m11922a(this.f10006a, mediaQueueItem.f10006a) && this.f10007b == mediaQueueItem.f10007b && this.f10008c == mediaQueueItem.f10008c && this.f10009d == mediaQueueItem.f10009d && this.f10010e == mediaQueueItem.f10010e && this.f10011f == mediaQueueItem.f10011f && zzf.m11922a(this.f10012g, mediaQueueItem.f10012g) : false;
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f10006a, Integer.valueOf(this.f10007b), Boolean.valueOf(this.f10008c), Double.valueOf(this.f10009d), Double.valueOf(this.f10010e), Double.valueOf(this.f10011f), this.f10012g, String.valueOf(this.f10013h)});
    }
}
