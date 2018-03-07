package com.facebook.abtest.qe.protocol.sync.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

/* compiled from: thread_presence_remote_duration */
public class SyncMultiQuickExperimentUserInfoResult implements Parcelable {
    public static final Creator<SyncMultiQuickExperimentUserInfoResult> CREATOR = new C00691();
    public final ArrayList<SyncQuickExperimentUserInfoResult> f1123a;

    /* compiled from: thread_presence_remote_duration */
    public class Builder {
        public ArrayList<SyncQuickExperimentUserInfoResult> f1115a = new ArrayList();
    }

    /* compiled from: thread_presence_remote_duration */
    final class C00691 implements Creator<SyncMultiQuickExperimentUserInfoResult> {
        C00691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SyncMultiQuickExperimentUserInfoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SyncMultiQuickExperimentUserInfoResult[i];
        }
    }

    public SyncMultiQuickExperimentUserInfoResult(Builder builder) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = builder.f1115a;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add((SyncQuickExperimentUserInfoResult) arrayList2.get(i));
        }
        this.f1123a = arrayList;
    }

    public SyncMultiQuickExperimentUserInfoResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        while (parcel.dataAvail() > 0) {
            arrayList.add(new SyncQuickExperimentUserInfoResult(parcel));
        }
        this.f1123a = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f1123a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((SyncQuickExperimentUserInfoResult) this.f1123a.get(i2)).writeToParcel(parcel, i);
        }
    }
}
