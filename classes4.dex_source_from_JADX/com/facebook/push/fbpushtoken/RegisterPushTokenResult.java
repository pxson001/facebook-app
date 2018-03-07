package com.facebook.push.fbpushtoken;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;

/* compiled from: gmt_offset_minutes */
public class RegisterPushTokenResult extends BaseResult implements Parcelable {
    public static final Creator<RegisterPushTokenResult> CREATOR = new C05201();
    public boolean f11022a;
    public boolean f11023b;

    /* compiled from: gmt_offset_minutes */
    final class C05201 implements Creator<RegisterPushTokenResult> {
        C05201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RegisterPushTokenResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new RegisterPushTokenResult[i];
        }
    }

    public RegisterPushTokenResult(boolean z, boolean z2, long j) {
        super(DataFreshnessResult.FROM_SERVER, j);
        this.f11022a = z;
        this.f11023b = z2;
    }

    public RegisterPushTokenResult(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f11022a = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f11023b = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        if (this.f11022a) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f11023b) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
