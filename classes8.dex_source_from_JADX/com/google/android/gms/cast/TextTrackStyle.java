package com.google.android.gms.cast;

import android.graphics.Color;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    private float f10106a;
    private int f10107b;
    private int f10108c;
    private int f10109d;
    private int f10110e;
    private int f10111f;
    private int f10112g;
    private int f10113h;
    private String f10114i;
    private int f10115j;
    private int f10116k;
    private JSONObject f10117l;

    public TextTrackStyle() {
        m11857b();
    }

    private static int m11855a(String str) {
        int i = 0;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private static String m11856a(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    private void m11857b() {
        this.f10106a = 1.0f;
        this.f10107b = 0;
        this.f10108c = 0;
        this.f10109d = -1;
        this.f10110e = 0;
        this.f10111f = -1;
        this.f10112g = 0;
        this.f10113h = 0;
        this.f10114i = null;
        this.f10115j = -1;
        this.f10116k = -1;
        this.f10117l = null;
    }

    public final JSONObject m11858a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.f10106a);
            if (this.f10107b != 0) {
                jSONObject.put("foregroundColor", m11856a(this.f10107b));
            }
            if (this.f10108c != 0) {
                jSONObject.put("backgroundColor", m11856a(this.f10108c));
            }
            switch (this.f10109d) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.f10110e != 0) {
                jSONObject.put("edgeColor", m11856a(this.f10110e));
            }
            switch (this.f10111f) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.f10112g != 0) {
                jSONObject.put("windowColor", m11856a(this.f10112g));
            }
            if (this.f10111f == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.f10113h);
            }
            if (this.f10114i != null) {
                jSONObject.put("fontFamily", this.f10114i);
            }
            switch (this.f10115j) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.f10116k) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.f10117l != null) {
                jSONObject.put("customData", this.f10117l);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final void m11859a(JSONObject jSONObject) {
        String string;
        m11857b();
        this.f10106a = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.f10107b = m11855a(jSONObject.optString("foregroundColor"));
        this.f10108c = m11855a(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.f10109d = 0;
            } else if ("OUTLINE".equals(string)) {
                this.f10109d = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.f10109d = 2;
            } else if ("RAISED".equals(string)) {
                this.f10109d = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.f10109d = 4;
            }
        }
        this.f10110e = m11855a(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.f10111f = 0;
            } else if ("NORMAL".equals(string)) {
                this.f10111f = 1;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.f10111f = 2;
            }
        }
        this.f10112g = m11855a(jSONObject.optString("windowColor"));
        if (this.f10111f == 2) {
            this.f10113h = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.f10114i = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.f10115j = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.f10115j = 1;
            } else if ("SERIF".equals(string)) {
                this.f10115j = 2;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.f10115j = 3;
            } else if ("CASUAL".equals(string)) {
                this.f10115j = 4;
            } else if ("CURSIVE".equals(string)) {
                this.f10115j = 5;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.f10115j = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.f10116k = 0;
            } else if ("BOLD".equals(string)) {
                this.f10116k = 1;
            } else if ("ITALIC".equals(string)) {
                this.f10116k = 2;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.f10116k = 3;
            }
        }
        this.f10117l = jSONObject.optJSONObject("customData");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        return (this.f10117l == null) == (textTrackStyle.f10117l == null) ? (this.f10117l == null || textTrackStyle.f10117l == null || zznu.a(this.f10117l, textTrackStyle.f10117l)) && this.f10106a == textTrackStyle.f10106a && this.f10107b == textTrackStyle.f10107b && this.f10108c == textTrackStyle.f10108c && this.f10109d == textTrackStyle.f10109d && this.f10110e == textTrackStyle.f10110e && this.f10111f == textTrackStyle.f10111f && this.f10113h == textTrackStyle.f10113h && zzf.m11922a(this.f10114i, textTrackStyle.f10114i) && this.f10115j == textTrackStyle.f10115j && this.f10116k == textTrackStyle.f10116k : false;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Float.valueOf(this.f10106a), Integer.valueOf(this.f10107b), Integer.valueOf(this.f10108c), Integer.valueOf(this.f10109d), Integer.valueOf(this.f10110e), Integer.valueOf(this.f10111f), Integer.valueOf(this.f10112g), Integer.valueOf(this.f10113h), this.f10114i, Integer.valueOf(this.f10115j), Integer.valueOf(this.f10116k), this.f10117l});
    }
}
