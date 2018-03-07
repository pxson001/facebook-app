package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.notifications.model.NotificationSeenStates;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: negative_action */
public class FetchNotificationSeenStatesResult extends BaseResult implements Parcelable {
    public static final Creator<FetchNotificationSeenStatesResult> CREATOR = new C06841();
    public final NotificationSeenStates f8441a;

    /* compiled from: negative_action */
    final class C06841 implements Creator<FetchNotificationSeenStatesResult> {
        C06841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNotificationSeenStatesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNotificationSeenStatesResult[i];
        }
    }

    public FetchNotificationSeenStatesResult(DataFreshnessResult dataFreshnessResult, NotificationSeenStates notificationSeenStates, long j) {
        super(dataFreshnessResult, j);
        this.f8441a = (NotificationSeenStates) Preconditions.checkNotNull(notificationSeenStates);
    }

    protected FetchNotificationSeenStatesResult(Parcel parcel) {
        super(parcel);
        this.f8441a = (NotificationSeenStates) parcel.readParcelable(NotificationSeenStates.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f8441a, i);
    }
}
