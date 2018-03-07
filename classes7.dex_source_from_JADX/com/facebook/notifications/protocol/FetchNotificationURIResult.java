package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.notifications.model.SMSNotificationURL;

/* compiled from: negativeFeedbackMessageActionParams */
public class FetchNotificationURIResult extends BaseResult implements Parcelable {
    public static final Creator<FetchNotificationURIResult> CREATOR = new C06851();
    public final SMSNotificationURL f8443a;

    /* compiled from: negativeFeedbackMessageActionParams */
    final class C06851 implements Creator<FetchNotificationURIResult> {
        C06851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNotificationURIResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNotificationURIResult[i];
        }
    }

    protected FetchNotificationURIResult(SMSNotificationURL sMSNotificationURL, DataFreshnessResult dataFreshnessResult, long j) {
        super(dataFreshnessResult, j);
        this.f8443a = sMSNotificationURL;
    }

    public FetchNotificationURIResult(Parcel parcel) {
        super(parcel);
        this.f8443a = (SMSNotificationURL) parcel.readParcelable(SMSNotificationURL.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f8443a, i);
    }
}
