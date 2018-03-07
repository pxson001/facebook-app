package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONArray;
import org.json.JSONObject;

@Immutable
/* compiled from: ig */
public class DeletePhotoTagParams implements Parcelable {
    public static final Creator<DeletePhotoTagParams> CREATOR = new C08321();
    public final String f12919a;
    public final String f12920b;
    public final String f12921c;

    /* compiled from: ig */
    final class C08321 implements Creator<DeletePhotoTagParams> {
        C08321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePhotoTagParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePhotoTagParams[i];
        }
    }

    public DeletePhotoTagParams(String str, @Nullable String str2, @Nonnull String str3) {
        Preconditions.checkNotNull(str3);
        this.f12919a = str;
        this.f12920b = str2;
        this.f12921c = str3;
    }

    public DeletePhotoTagParams(Parcel parcel) {
        this.f12919a = parcel.readString();
        this.f12920b = parcel.readString();
        this.f12921c = parcel.readString();
    }

    @Nullable
    public final String m20297b() {
        return this.f12920b;
    }

    public final String m20298c() {
        return this.f12921c;
    }

    public final String m20299d() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            if (m20297b() == null || Long.parseLong(m20297b()) <= 0) {
                jSONObject.put("tag_text", m20298c());
            } else {
                jSONObject.put("tag_uid", m20297b());
            }
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Throwable e) {
            BLog.b("DeletePhotoTagParams", "JSON exception encoding params", e);
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12919a);
        parcel.writeString(this.f12920b);
        parcel.writeString(this.f12921c);
    }
}
