package com.facebook.abtest.qe.protocol.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: threadsettings */
public class SyncMultiQuickExperimentParams implements Parcelable {
    public static final Creator<SyncMultiQuickExperimentParams> CREATOR = new C00671();
    public final ImmutableList<SyncQuickExperimentParams> f1110a;
    public final String f1111b;
    public final boolean f1112c;

    /* compiled from: threadsettings */
    public class Builder {
        public String f1104a;
        public com.google.common.collect.ImmutableList.Builder<SyncQuickExperimentParams> f1105b = ImmutableList.builder();
        public ImmutableList f1106c;
        public boolean f1107d;
    }

    /* compiled from: threadsettings */
    final class C00671 implements Creator<SyncMultiQuickExperimentParams> {
        C00671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SyncMultiQuickExperimentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SyncMultiQuickExperimentParams[i];
        }
    }

    public SyncMultiQuickExperimentParams(Builder builder) {
        this.f1111b = builder.f1104a;
        this.f1110a = builder.f1106c;
        this.f1112c = builder.f1107d;
    }

    public SyncMultiQuickExperimentParams(Parcel parcel) {
        boolean z = true;
        this.f1111b = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f1112c = z;
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        while (parcel.dataAvail() > 0) {
            builder.c(new SyncQuickExperimentParams(parcel));
        }
        this.f1110a = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 0;
        parcel.writeString(this.f1111b);
        if (this.f1112c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        int size = this.f1110a.size();
        while (i3 < size) {
            ((SyncQuickExperimentParams) this.f1110a.get(i3)).writeToParcel(parcel, i);
            i3++;
        }
    }

    public String toString() {
        return this.f1110a.toString() + " : " + this.f1111b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SyncMultiQuickExperimentParams)) {
            return false;
        }
        SyncMultiQuickExperimentParams syncMultiQuickExperimentParams = (SyncMultiQuickExperimentParams) obj;
        if (Objects.equal(this.f1111b, syncMultiQuickExperimentParams.f1111b) && Objects.equal(this.f1110a, syncMultiQuickExperimentParams.f1110a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1111b, this.f1110a});
    }
}
