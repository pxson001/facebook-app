package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new zzb();
    public final int f6516a;
    public final Uri f6517b;
    public final int f6518c;
    public final int f6519d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f6516a = i;
        this.f6517b = uri;
        this.f6518c = i2;
        this.f6519d = i3;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    private WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(m12189a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri m12189a(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject m12190e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f6517b.toString());
            jSONObject.put("width", this.f6518c);
            jSONObject.put("height", this.f6519d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.a(this.f6517b, webImage.f6517b) && this.f6518c == webImage.f6518c && this.f6519d == webImage.f6519d;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6517b, Integer.valueOf(this.f6518c), Integer.valueOf(this.f6519d)});
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.f6518c), Integer.valueOf(this.f6519d), this.f6517b.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6516a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f6517b, i, false);
        zzb.m12241a(parcel, 3, this.f6518c);
        zzb.m12241a(parcel, 4, this.f6519d);
        zzb.m12258c(parcel, a);
    }
}
