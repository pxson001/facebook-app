package com.facebook.groups.create.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;

/* compiled from: payments_new_paypal_selected */
public class SetAsCoverPhotoParams implements Parcelable {
    public static final Creator<SetAsCoverPhotoParams> CREATOR = new C07051();
    public final String f6841a;
    public final String f6842b;

    /* compiled from: payments_new_paypal_selected */
    final class C07051 implements Creator<SetAsCoverPhotoParams> {
        C07051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetAsCoverPhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetAsCoverPhotoParams[i];
        }
    }

    /* compiled from: payments_new_paypal_selected */
    public class Builder {
        public String f6839a;
        public String f6840b;

        public final SetAsCoverPhotoParams m7122a() {
            if (!StringUtil.a(this.f6840b) && !StringUtil.a(this.f6839a)) {
                return new SetAsCoverPhotoParams(this.f6839a, this.f6840b);
            }
            throw new IllegalArgumentException("Missing required parameter for setting as cover photo");
        }
    }

    public SetAsCoverPhotoParams(String str, String str2) {
        this.f6841a = str;
        this.f6842b = str2;
    }

    public SetAsCoverPhotoParams(Parcel parcel) {
        this.f6841a = parcel.readString();
        this.f6842b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6841a);
        parcel.writeString(this.f6842b);
    }
}
