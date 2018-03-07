package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: continuous_import */
public class FetchThreadUsersResult extends BaseResult implements Parcelable {
    public static final Creator<FetchThreadUsersResult> CREATOR = new C20321();
    public final ImmutableList<User> f17188a;

    /* compiled from: continuous_import */
    final class C20321 implements Creator<FetchThreadUsersResult> {
        C20321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadUsersResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadUsersResult[i];
        }
    }

    public FetchThreadUsersResult(DataFreshnessResult dataFreshnessResult, long j, List<User> list) {
        super(dataFreshnessResult, j);
        this.f17188a = ImmutableList.copyOf(list);
    }

    public FetchThreadUsersResult(Parcel parcel) {
        super(parcel);
        this.f17188a = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeArray(this.f17188a.toArray());
    }

    public String toString() {
        return "FetchThreadUsersResult (ts " + this.clientTimeMs + ") (threadUserSummary " + this.f17188a + ") (freshness " + this.freshness + ")";
    }
}
