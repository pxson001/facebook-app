package com.facebook.photos.data.method;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;
import org.json.JSONArray;
import org.json.JSONObject;

@Immutable
/* compiled from: image_full_screen */
public class AddPhotoTagParams implements Parcelable {
    public static final Creator<AddPhotoTagParams> CREATOR = new C08231();
    public final String f12887a;
    public final String f12888b;
    private final double f12889c;
    private final double f12890d;
    public final String f12891e;

    /* compiled from: image_full_screen */
    final class C08231 implements Creator<AddPhotoTagParams> {
        C08231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPhotoTagParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPhotoTagParams[i];
        }
    }

    public AddPhotoTagParams(String str, TaggingProfile taggingProfile, PointF pointF) {
        this.f12887a = str;
        this.f12888b = Long.toString(taggingProfile.f17539b);
        this.f12891e = taggingProfile.f17538a.i();
        Preconditions.checkNotNull(this.f12891e);
        this.f12889c = (double) pointF.x;
        this.f12890d = (double) pointF.y;
    }

    public AddPhotoTagParams(Parcel parcel) {
        this.f12887a = parcel.readString();
        this.f12888b = parcel.readString();
        this.f12889c = parcel.readDouble();
        this.f12890d = parcel.readDouble();
        this.f12891e = parcel.readString();
    }

    public final String m20273b() {
        return this.f12888b;
    }

    private double m20271e() {
        return this.f12889c;
    }

    private double m20272f() {
        return this.f12890d;
    }

    public final String m20274c() {
        return this.f12891e;
    }

    public final String m20275d() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject put = new JSONObject().put("x", m20271e() * 100.0d).put("y", m20272f() * 100.0d);
            if (Long.parseLong(m20273b()) > 0) {
                put.put("tag_uid", m20273b());
            } else {
                put.put("tag_text", m20274c());
            }
            jSONArray.put(put);
            return jSONArray.toString();
        } catch (Throwable e) {
            BLog.b("AddPhotoTagParams", "JSON exception encoding params", e);
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12887a);
        parcel.writeString(this.f12888b);
        parcel.writeDouble(this.f12889c);
        parcel.writeDouble(this.f12890d);
        parcel.writeString(this.f12891e);
    }
}
