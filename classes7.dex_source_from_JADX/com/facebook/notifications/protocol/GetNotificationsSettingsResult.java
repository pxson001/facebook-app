package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.notifications.model.FacebookNotificationSetting;
import com.google.common.collect.ImmutableList;

/* compiled from: nav_tile_type */
public class GetNotificationsSettingsResult extends BaseResult implements Parcelable {
    public static final Creator<GetNotificationsSettingsResult> CREATOR = new C06961();
    public final ImmutableList<FacebookNotificationSetting> f8555a;

    /* compiled from: nav_tile_type */
    final class C06961 implements Creator<GetNotificationsSettingsResult> {
        C06961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetNotificationsSettingsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetNotificationsSettingsResult[i];
        }
    }

    public GetNotificationsSettingsResult(DataFreshnessResult dataFreshnessResult, ImmutableList<FacebookNotificationSetting> immutableList, long j) {
        super(dataFreshnessResult, j);
        this.f8555a = immutableList;
    }

    protected GetNotificationsSettingsResult(Parcel parcel) {
        super(parcel);
        this.f8555a = ImmutableList.copyOf(parcel.readArrayList(null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f8555a);
    }
}
