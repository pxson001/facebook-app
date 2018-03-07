package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_settings */
public class UploadBulkContactChangeResult implements Parcelable {
    public static final Creator<UploadBulkContactChangeResult> CREATOR = new C05491();
    public final Type f8468a;
    public final String f8469b;
    public final String f8470c;
    private final ImmutableList<UploadBulkContactFieldMatch> f8471d;
    public final Confidence f8472e;

    /* compiled from: p2p_settings */
    final class C05491 implements Creator<UploadBulkContactChangeResult> {
        C05491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkContactChangeResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkContactChangeResult[i];
        }
    }

    /* compiled from: p2p_settings */
    public enum Confidence {
        HIGH,
        MEDIUM,
        LOW,
        VERY_LOW,
        UNKNOWN
    }

    /* compiled from: p2p_settings */
    public enum Type {
        ADD,
        MODIFY,
        REMOVE,
        NONE
    }

    public UploadBulkContactChangeResult(Type type, String str, String str2, ImmutableList<UploadBulkContactFieldMatch> immutableList, Confidence confidence) {
        this.f8468a = type;
        this.f8469b = str;
        this.f8470c = str2;
        this.f8471d = immutableList;
        this.f8472e = confidence;
    }

    public UploadBulkContactChangeResult(Parcel parcel) {
        this.f8468a = (Type) Enum.valueOf(Type.class, parcel.readString());
        this.f8469b = parcel.readString();
        this.f8470c = parcel.readString();
        this.f8471d = ImmutableList.copyOf(parcel.readArrayList(UploadBulkContactFieldMatch.class.getClassLoader()));
        this.f8472e = (Confidence) Enum.valueOf(Confidence.class, parcel.readString());
    }

    public final String m12300b() {
        return this.f8469b;
    }

    public final String m12301c() {
        return this.f8470c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8468a.toString());
        parcel.writeString(this.f8469b);
        parcel.writeString(this.f8470c);
        parcel.writeList(this.f8471d);
        parcel.writeString(this.f8472e.toString());
    }

    public String toString() {
        return "UploadBulkContactChangeResult (" + this.f8468a + ") confidence: " + this.f8472e + " local id: [" + this.f8469b + "] -> remote id: [" + this.f8470c + "]";
    }
}
