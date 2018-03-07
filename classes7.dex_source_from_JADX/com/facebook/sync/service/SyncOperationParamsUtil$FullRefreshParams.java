package com.facebook.sync.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.sync.analytics.FullRefreshReason;
import javax.annotation.Nullable;

/* compiled from: featured_services */
public class SyncOperationParamsUtil$FullRefreshParams implements Parcelable {
    public static final Creator<SyncOperationParamsUtil$FullRefreshParams> CREATOR = new C10621();
    public final FullRefreshReason f14551a;
    @Nullable
    public final String f14552b;

    /* compiled from: featured_services */
    final class C10621 implements Creator<SyncOperationParamsUtil$FullRefreshParams> {
        C10621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SyncOperationParamsUtil$FullRefreshParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SyncOperationParamsUtil$FullRefreshParams[i];
        }
    }

    public SyncOperationParamsUtil$FullRefreshParams(FullRefreshReason fullRefreshReason, @Nullable String str) {
        this.f14551a = fullRefreshReason;
        this.f14552b = str;
    }

    public SyncOperationParamsUtil$FullRefreshParams(Parcel parcel) {
        this.f14551a = (FullRefreshReason) parcel.readParcelable(FullRefreshReason.class.getClassLoader());
        this.f14552b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14551a, i);
        parcel.writeString(this.f14552b);
    }
}
