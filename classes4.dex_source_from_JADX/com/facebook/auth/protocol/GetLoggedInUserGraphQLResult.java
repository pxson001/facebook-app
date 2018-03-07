package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.user.model.User;

/* compiled from: sms_takeover_permanent_contact */
public class GetLoggedInUserGraphQLResult extends BaseResult implements Parcelable {
    public static final Creator<GetLoggedInUserGraphQLResult> CREATOR = new C00981();
    public final User f1998a;

    /* compiled from: sms_takeover_permanent_contact */
    final class C00981 implements Creator<GetLoggedInUserGraphQLResult> {
        C00981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetLoggedInUserGraphQLResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetLoggedInUserGraphQLResult[i];
        }
    }

    public GetLoggedInUserGraphQLResult(DataFreshnessResult dataFreshnessResult, User user, long j) {
        super(dataFreshnessResult, j);
        this.f1998a = user;
    }

    public GetLoggedInUserGraphQLResult(Parcel parcel) {
        super(parcel);
        this.f1998a = (User) parcel.readParcelable(User.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1998a, i);
    }
}
