package com.facebook.abtest.qe.bootstrap.protocol.sync;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: traces.txt */
public class SyncQuickExperimentMetaInfoResult implements Parcelable {
    public static final Creator<SyncQuickExperimentMetaInfoResult> CREATOR = new C01021();
    public final String f1708a;
    public final List<String> f1709b = new ArrayList();
    public final ImmutableMap<String, Map<String, String>> f1710c;
    public final String f1711d;
    public final long f1712e;

    /* compiled from: traces.txt */
    final class C01021 implements Creator<SyncQuickExperimentMetaInfoResult> {
        C01021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SyncQuickExperimentMetaInfoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SyncQuickExperimentMetaInfoResult[i];
        }
    }

    public SyncQuickExperimentMetaInfoResult(Parcel parcel) {
        this.f1708a = parcel.readString();
        parcel.readStringList(this.f1709b);
        this.f1710c = ImmutableMap.copyOf(parcel.readHashMap(SyncQuickExperimentMetaInfoResult.class.getClassLoader()));
        this.f1711d = parcel.readString();
        this.f1712e = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SyncQuickExperimentMetaInfoResult)) {
            return false;
        }
        SyncQuickExperimentMetaInfoResult syncQuickExperimentMetaInfoResult = (SyncQuickExperimentMetaInfoResult) obj;
        if (Objects.equal(this.f1708a, syncQuickExperimentMetaInfoResult.f1708a) && Objects.equal(this.f1709b, syncQuickExperimentMetaInfoResult.f1709b) && Objects.equal(this.f1710c, syncQuickExperimentMetaInfoResult.f1710c) && Objects.equal(this.f1711d, syncQuickExperimentMetaInfoResult.f1711d) && Objects.equal(Long.valueOf(this.f1712e), Long.valueOf(syncQuickExperimentMetaInfoResult.f1712e))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1708a, this.f1709b, this.f1710c, this.f1711d, Long.valueOf(this.f1712e)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1708a);
        parcel.writeStringArray((String[]) this.f1709b.toArray(new String[this.f1709b.size()]));
        parcel.writeMap(this.f1710c);
        parcel.writeString(this.f1711d);
        parcel.writeLong(this.f1712e);
    }
}
