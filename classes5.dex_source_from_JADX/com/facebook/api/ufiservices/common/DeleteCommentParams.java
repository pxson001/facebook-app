package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

/* compiled from: android_place_creation_v2 */
public class DeleteCommentParams implements Parcelable {
    public static final Creator<DeleteCommentParams> CREATOR = new C09871();
    public final String f10291a;
    public final String f10292b;
    public final String f10293c;

    /* compiled from: android_place_creation_v2 */
    final class C09871 implements Creator<DeleteCommentParams> {
        C09871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteCommentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteCommentParams[i];
        }
    }

    /* compiled from: android_place_creation_v2 */
    public class Builder {
        public String f10288a;
        public String f10289b;
        public String f10290c;

        public final DeleteCommentParams m18409a() {
            Preconditions.checkNotNull(this.f10288a);
            Preconditions.checkNotNull(this.f10289b);
            return new DeleteCommentParams(this);
        }
    }

    protected DeleteCommentParams(Parcel parcel) {
        this.f10291a = parcel.readString();
        this.f10292b = parcel.readString();
        if (parcel.dataAvail() > 0) {
            this.f10293c = parcel.readString();
        } else {
            this.f10293c = null;
        }
    }

    protected DeleteCommentParams(Builder builder) {
        this.f10291a = builder.f10288a;
        this.f10292b = builder.f10289b;
        this.f10293c = builder.f10290c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10291a);
        parcel.writeString(this.f10292b);
        if (this.f10293c != null) {
            parcel.writeString(this.f10293c);
        }
    }
}
