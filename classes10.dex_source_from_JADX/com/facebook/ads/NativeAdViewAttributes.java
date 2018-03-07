package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.ads.internal.util.C1975b;
import com.facebook.ads.internal.util.C1976c;
import org.json.JSONObject;

public class NativeAdViewAttributes {
    private Typeface f13949a = Typeface.DEFAULT;
    private int f13950b = -1;
    private int f13951c = -16777216;
    private int f13952d = -11643291;
    private int f13953e = 0;
    private int f13954f = -12420889;
    private int f13955g = -12420889;
    private boolean f13956h = true;

    public NativeAdViewAttributes(JSONObject jSONObject) {
        int i = 0;
        try {
            int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
            int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
            int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
            int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
            if (!jSONObject.getBoolean("button_border_transparent")) {
                i = Color.parseColor(jSONObject.getString("button_border_color"));
            }
            int parseColor5 = Color.parseColor(jSONObject.getString("button_text_color"));
            Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
            this.f13950b = parseColor;
            this.f13951c = parseColor2;
            this.f13952d = parseColor3;
            this.f13953e = parseColor4;
            this.f13955g = i;
            this.f13954f = parseColor5;
            this.f13949a = create;
        } catch (Throwable e) {
            C1976c.m14446a(C1975b.m14443a(e, "Error retrieving native ui configuration data"));
        }
    }
}
