package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdView.Type;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1918o extends C1896b {
    private final C1910p f14100b;
    public Type f14101c;
    public boolean f14102d;
    public boolean f14103e;
    public boolean f14104f;
    public View f14105g;
    public List<View> f14106h;

    public C1918o(Context context, C1885c c1885c, C1910p c1910p) {
        super(context, c1885c);
        this.f14100b = c1910p;
    }

    private String m14322b(View view) {
        try {
            return m14323c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject m14323c(View view) {
        boolean z = true;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f14106h == null || !this.f14106h.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = "unknown";
        if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof ImageView) {
            obj = "image";
        } else if (view instanceof MediaView) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt("type", obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m14323c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String m14324d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return "";
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, this.f14100b.mo717e(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    protected final void mo734b() {
        if (this.f14100b != null) {
            Map hashMap = new HashMap();
            if (this.f13984a != null) {
                hashMap.put("mil", Boolean.valueOf(this.f13984a.mo702b()));
                hashMap.put("eil", Boolean.valueOf(false));
                hashMap.put("eil_source", null);
            }
            if (this.f14101c != null) {
                hashMap.put("nti", String.valueOf(this.f14101c.getValue()));
            }
            if (this.f14102d) {
                hashMap.put("nhs", String.valueOf(this.f14102d));
            }
            if (this.f14103e) {
                hashMap.put("nmv", String.valueOf(this.f14103e));
            }
            if (this.f14104f) {
                hashMap.put("nmvap", String.valueOf(this.f14104f));
            }
            if (this.f14105g != null && this.f14100b.mo715c()) {
                hashMap.put("view", m14322b(this.f14105g));
            }
            if (this.f14105g != null && this.f14100b.mo716d()) {
                hashMap.put("snapshot", m14324d(this.f14105g));
            }
            this.f14100b.mo713a(hashMap);
        }
    }
}
