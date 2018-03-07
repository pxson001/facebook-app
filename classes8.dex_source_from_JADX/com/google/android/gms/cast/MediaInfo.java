package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    private final String f9989a;
    private int f9990b;
    private String f9991c;
    public MediaMetadata f9992d;
    private long f9993e;
    private List<MediaTrack> f9994f;
    private TextTrackStyle f9995g;
    private JSONObject f9996h;

    public class Builder {
        public final MediaInfo f9988a;

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.f9988a = new MediaInfo(str);
        }
    }

    MediaInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.f9989a = str;
        this.f9990b = -1;
        this.f9993e = -1;
    }

    MediaInfo(JSONObject jSONObject) {
        int i = 0;
        this.f9989a = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.f9990b = 0;
        } else if ("BUFFERED".equals(string)) {
            this.f9990b = 1;
        } else if ("LIVE".equals(string)) {
            this.f9990b = 2;
        } else {
            this.f9990b = -1;
        }
        this.f9991c = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.f9992d = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.f9992d.m11786a(jSONObject2);
        }
        this.f9993e = -1;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.f9993e = zzf.m11920a(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.f9994f = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.f9994f.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.f9994f = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.m11859a(jSONObject3);
            this.f9995g = textTrackStyle;
        } else {
            this.f9995g = null;
        }
        this.f9996h = jSONObject.optJSONObject("customData");
    }

    public final long m11770a() {
        return this.f9993e;
    }

    public final void m11771a(int i) {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.f9990b = i;
    }

    public final void m11772a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.f9991c = str;
    }

    public final void m11773b() {
        if (TextUtils.isEmpty(this.f9989a)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.f9991c)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.f9990b == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public final JSONObject m11774c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.f9989a);
            switch (this.f9990b) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.f9991c != null) {
                jSONObject.put("contentType", this.f9991c);
            }
            if (this.f9992d != null) {
                jSONObject.put("metadata", this.f9992d.m11784a());
            }
            if (this.f9993e <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.m11919a(this.f9993e));
            }
            if (this.f9994f != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack a : this.f9994f) {
                    jSONArray.put(a.m11799a());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.f9995g != null) {
                jSONObject.put("textTrackStyle", this.f9995g.m11858a());
            }
            if (this.f9996h != null) {
                jSONObject.put("customData", this.f9996h);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        return (this.f9996h == null) == (mediaInfo.f9996h == null) ? (this.f9996h == null || mediaInfo.f9996h == null || zznu.a(this.f9996h, mediaInfo.f9996h)) && zzf.m11922a(this.f9989a, mediaInfo.f9989a) && this.f9990b == mediaInfo.f9990b && zzf.m11922a(this.f9991c, mediaInfo.f9991c) && zzf.m11922a(this.f9992d, mediaInfo.f9992d) && this.f9993e == mediaInfo.f9993e : false;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f9989a, Integer.valueOf(this.f9990b), this.f9991c, this.f9992d, Long.valueOf(this.f9993e), String.valueOf(this.f9996h)});
    }
}
