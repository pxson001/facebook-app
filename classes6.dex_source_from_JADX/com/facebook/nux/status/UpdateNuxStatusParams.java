package com.facebook.nux.status;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: isCompleted */
public class UpdateNuxStatusParams implements Parcelable {
    public static final Creator<UpdateNuxStatusParams> CREATOR = new C07961();
    public final String f12263a;
    public final String f12264b;
    public final String f12265c;
    public final Status f12266d;
    public final ImmutableMap<String, String> f12267e;

    /* compiled from: isCompleted */
    final class C07961 implements Creator<UpdateNuxStatusParams> {
        C07961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateNuxStatusParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateNuxStatusParams[i];
        }
    }

    /* compiled from: isCompleted */
    public enum Status {
        COMPLETE,
        SKIPPED
    }

    public UpdateNuxStatusParams(String str, String str2, String str3, Status status, ImmutableMap<String, String> immutableMap) {
        this.f12263a = str;
        this.f12264b = str2;
        this.f12265c = str3;
        this.f12266d = status;
        this.f12267e = immutableMap;
    }

    public UpdateNuxStatusParams(Parcel parcel) {
        this.f12263a = parcel.readString();
        this.f12264b = parcel.readString();
        this.f12265c = parcel.readString();
        this.f12266d = Status.valueOf(parcel.readString());
        this.f12267e = ImmutableMap.copyOf(parcel.readHashMap(String.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12263a);
        parcel.writeString(this.f12264b);
        parcel.writeString(this.f12265c);
        parcel.writeString(this.f12266d.name());
        parcel.writeMap(this.f12267e);
    }
}
