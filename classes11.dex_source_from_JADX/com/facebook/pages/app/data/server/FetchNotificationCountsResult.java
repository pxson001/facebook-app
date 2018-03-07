package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.pages.app.data.model.PageNotificationCounts;
import java.util.HashMap;
import java.util.Map;

/* compiled from: surface_first_card_early_fetch */
public class FetchNotificationCountsResult extends BaseResult implements Parcelable {
    public static final Creator<FetchNotificationCountsResult> CREATOR = new C01621();
    private final Map<Long, PageNotificationCounts> f1209a = new HashMap();

    /* compiled from: surface_first_card_early_fetch */
    final class C01621 implements Creator<FetchNotificationCountsResult> {
        C01621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNotificationCountsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNotificationCountsResult[i];
        }
    }

    protected FetchNotificationCountsResult(Parcel parcel) {
        super(parcel);
        parcel.readMap(this.f1209a, PageNotificationCounts.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeMap(this.f1209a);
    }

    public int describeContents() {
        return 0;
    }
}
