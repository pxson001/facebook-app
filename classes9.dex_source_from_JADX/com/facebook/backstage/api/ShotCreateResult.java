package com.facebook.backstage.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;

/* compiled from: security_code */
public class ShotCreateResult implements Parcelable {
    public static final Creator<ShotCreateResult> CREATOR = new C03881();
    public ImmutableList<String> f4302a;

    /* compiled from: security_code */
    final class C03881 implements Creator<ShotCreateResult> {
        C03881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShotCreateResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShotCreateResult[i];
        }
    }

    public ShotCreateResult(ImmutableList<String> immutableList) {
        this.f4302a = immutableList;
    }

    public ShotCreateResult(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != -1) {
            Iterable arrayList = new ArrayList(readInt);
            parcel.readList(arrayList, String.class.getClassLoader());
            this.f4302a = new Builder().b(arrayList).b();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f4302a == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(this.f4302a.size());
        parcel.writeList(this.f4302a);
    }
}
