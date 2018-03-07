package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public long f10033a;
    public int f10034b;
    public String f10035c;
    private String f10036d;
    public String f10037e;
    public String f10038f;
    public int f10039g;
    public JSONObject f10040h;

    MediaTrack(JSONObject jSONObject) {
        m11798a(jSONObject);
    }

    private void m11798a(JSONObject jSONObject) {
        this.f10033a = 0;
        this.f10034b = 0;
        this.f10035c = null;
        this.f10037e = null;
        this.f10038f = null;
        this.f10039g = -1;
        this.f10040h = null;
        this.f10033a = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.f10034b = 1;
        } else if ("AUDIO".equals(string)) {
            this.f10034b = 2;
        } else if ("VIDEO".equals(string)) {
            this.f10034b = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.f10035c = jSONObject.optString("trackContentId", null);
        this.f10036d = jSONObject.optString("trackContentType", null);
        this.f10037e = jSONObject.optString("name", null);
        this.f10038f = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.f10039g = 1;
            } else if ("CAPTIONS".equals(string)) {
                this.f10039g = 2;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.f10039g = 3;
            } else if ("CHAPTERS".equals(string)) {
                this.f10039g = 4;
            } else if ("METADATA".equals(string)) {
                this.f10039g = 5;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.f10039g = 0;
        this.f10040h = jSONObject.optJSONObject("customData");
    }

    public final JSONObject m11799a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.f10033a);
            switch (this.f10034b) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.f10035c != null) {
                jSONObject.put("trackContentId", this.f10035c);
            }
            if (this.f10036d != null) {
                jSONObject.put("trackContentType", this.f10036d);
            }
            if (this.f10037e != null) {
                jSONObject.put("name", this.f10037e);
            }
            if (!TextUtils.isEmpty(this.f10038f)) {
                jSONObject.put("language", this.f10038f);
            }
            switch (this.f10039g) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.f10040h != null) {
                jSONObject.put("customData", this.f10040h);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        return (this.f10040h == null) == (mediaTrack.f10040h == null) ? (this.f10040h == null || mediaTrack.f10040h == null || zznu.a(this.f10040h, mediaTrack.f10040h)) && this.f10033a == mediaTrack.f10033a && this.f10034b == mediaTrack.f10034b && zzf.m11922a(this.f10035c, mediaTrack.f10035c) && zzf.m11922a(this.f10036d, mediaTrack.f10036d) && zzf.m11922a(this.f10037e, mediaTrack.f10037e) && zzf.m11922a(this.f10038f, mediaTrack.f10038f) && this.f10039g == mediaTrack.f10039g : false;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Long.valueOf(this.f10033a), Integer.valueOf(this.f10034b), this.f10035c, this.f10036d, this.f10037e, this.f10038f, Integer.valueOf(this.f10039g), this.f10040h});
    }
}
