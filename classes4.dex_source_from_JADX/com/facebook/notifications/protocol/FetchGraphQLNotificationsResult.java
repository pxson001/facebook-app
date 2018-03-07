package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.notifications.model.NotificationStories;

/* compiled from: has_unavailable_attachment */
public class FetchGraphQLNotificationsResult extends BaseResult implements Parcelable {
    public static final Creator<FetchGraphQLNotificationsResult> CREATOR = new C05101();
    public final NotificationStories f10826a;
    public final long f10827b;
    private boolean f10828c;

    /* compiled from: has_unavailable_attachment */
    final class C05101 implements Creator<FetchGraphQLNotificationsResult> {
        C05101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGraphQLNotificationsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGraphQLNotificationsResult[i];
        }
    }

    public FetchGraphQLNotificationsResult(NotificationStories notificationStories, long j, DataFreshnessResult dataFreshnessResult, long j2, boolean z) {
        this(notificationStories, j, dataFreshnessResult, j2);
        this.f10828c = z;
    }

    public FetchGraphQLNotificationsResult(NotificationStories notificationStories, long j, DataFreshnessResult dataFreshnessResult, long j2) {
        super(dataFreshnessResult, j2);
        this.f10828c = false;
        this.f10826a = notificationStories;
        this.f10827b = j;
    }

    public FetchGraphQLNotificationsResult(Parcel parcel) {
        boolean z;
        super(parcel);
        this.f10828c = false;
        this.f10827b = parcel.readLong();
        this.f10826a = (NotificationStories) parcel.readParcelable(NotificationStories.class.getClassLoader());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f10828c = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f10827b);
        parcel.writeParcelable(this.f10826a, i);
        parcel.writeInt(this.f10828c ? 1 : 0);
    }
}
