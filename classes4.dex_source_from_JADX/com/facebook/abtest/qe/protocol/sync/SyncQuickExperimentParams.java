package com.facebook.abtest.qe.protocol.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: threads_db */
public class SyncQuickExperimentParams implements Parcelable {
    public final String f1108a;
    public final String f1109b;

    public SyncQuickExperimentParams(String str, String str2) {
        this.f1108a = (String) Preconditions.checkNotNull(str);
        this.f1109b = str2;
    }

    public SyncQuickExperimentParams(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1108a);
        parcel.writeString(this.f1109b);
    }

    public String toString() {
        return this.f1108a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SyncQuickExperimentParams)) {
            return false;
        }
        SyncQuickExperimentParams syncQuickExperimentParams = (SyncQuickExperimentParams) obj;
        if (Objects.equal(this.f1108a, syncQuickExperimentParams.f1108a) && Objects.equal(this.f1109b, syncQuickExperimentParams.f1109b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1108a, this.f1109b});
    }
}
