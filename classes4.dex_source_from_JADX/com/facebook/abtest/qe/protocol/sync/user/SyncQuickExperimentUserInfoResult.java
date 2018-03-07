package com.facebook.abtest.qe.protocol.sync.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

/* compiled from: thread_presence_received */
public class SyncQuickExperimentUserInfoResult implements Parcelable {
    public static final Creator<SyncQuickExperimentUserInfoResult> CREATOR = new C00681();
    public final String f1116a;
    public final String f1117b;
    public final boolean f1118c;
    public final boolean f1119d;
    public final String f1120e;
    private final ImmutableMap<String, String> f1121f;

    /* compiled from: thread_presence_received */
    final class C00681 implements Creator<SyncQuickExperimentUserInfoResult> {
        C00681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SyncQuickExperimentUserInfoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SyncQuickExperimentUserInfoResult[i];
        }
    }

    public SyncQuickExperimentUserInfoResult(String str, String str2, boolean z, boolean z2, String str3, ImmutableMap<String, String> immutableMap) {
        this.f1116a = str;
        this.f1117b = str2;
        this.f1119d = z2;
        this.f1118c = z;
        this.f1120e = str3;
        this.f1121f = ImmutableMap.copyOf(immutableMap);
    }

    public SyncQuickExperimentUserInfoResult(Parcel parcel) {
        boolean z = true;
        this.f1116a = parcel.readString();
        this.f1117b = parcel.readString();
        this.f1118c = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f1119d = z;
        this.f1120e = parcel.readString();
        this.f1121f = ImmutableMap.copyOf(parcel.readHashMap(SyncQuickExperimentUserInfoResult.class.getClassLoader()));
    }

    public final ImmutableMap<String, String> m1387f() {
        return ImmutableMap.copyOf(this.f1121f);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f1116a);
        parcel.writeString(this.f1117b);
        if (this.f1118c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f1119d) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f1120e);
        parcel.writeMap(this.f1121f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SyncQuickExperimentUserInfoResult)) {
            return false;
        }
        SyncQuickExperimentUserInfoResult syncQuickExperimentUserInfoResult = (SyncQuickExperimentUserInfoResult) obj;
        if (Objects.equal(this.f1116a, syncQuickExperimentUserInfoResult.f1116a) && Objects.equal(this.f1117b, syncQuickExperimentUserInfoResult.f1117b) && this.f1118c == syncQuickExperimentUserInfoResult.f1118c && this.f1119d == syncQuickExperimentUserInfoResult.f1119d && Objects.equal(this.f1120e, syncQuickExperimentUserInfoResult.f1120e) && Objects.equal(this.f1121f, syncQuickExperimentUserInfoResult.m1387f())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1116a, this.f1117b, Boolean.valueOf(this.f1118c), Boolean.valueOf(this.f1119d), this.f1120e, this.f1121f});
    }
}
