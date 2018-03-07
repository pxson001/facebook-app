package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.work.auth.request.model.WorkCommunity;
import com.google.common.collect.ImmutableList;

/* compiled from: suggested_members */
public class WorkCommunityPeekResult extends BaseResult implements Parcelable {
    public static final Creator<WorkCommunityPeekResult> CREATOR = new C01551();
    private final boolean f2394a;
    private final WorkCommunity f2395b;
    private final ImmutableList<WorkCommunity> f2396c;

    /* compiled from: suggested_members */
    final class C01551 implements Creator<WorkCommunityPeekResult> {
        C01551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WorkCommunityPeekResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new WorkCommunityPeekResult[i];
        }
    }

    public WorkCommunityPeekResult(DataFreshnessResult dataFreshnessResult, long j, boolean z, WorkCommunity workCommunity, ImmutableList<WorkCommunity> immutableList) {
        super(dataFreshnessResult, j);
        this.f2394a = z;
        this.f2395b = workCommunity;
        this.f2396c = immutableList;
    }

    public WorkCommunityPeekResult(Parcel parcel) {
        boolean z = true;
        super(parcel);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f2394a = z;
        this.f2395b = (WorkCommunity) parcel.readParcelable(WorkCommunity.class.getClassLoader());
        this.f2396c = ImmutableListHelper.a(parcel.readArrayList(WorkCommunity.class.getClassLoader()));
    }

    public final boolean m3305c() {
        return this.f2394a;
    }

    public final WorkCommunity m3306d() {
        return this.f2395b;
    }

    public final ImmutableList<WorkCommunity> m3307e() {
        return this.f2396c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f2394a ? 1 : 0));
        parcel.writeParcelable(this.f2395b, i);
        parcel.writeList(this.f2396c);
    }
}
