package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: continuous_contact_upload_setting */
public class FetchUpdatedUserInfoResult extends BaseResult implements Parcelable {
    public static final Creator<FetchUpdatedUserInfoResult> CREATOR = new C20341();
    public final ImmutableList<User> f17192a;
    public final long f17193b;

    /* compiled from: continuous_contact_upload_setting */
    final class C20341 implements Creator<FetchUpdatedUserInfoResult> {
        C20341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchUpdatedUserInfoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchUpdatedUserInfoResult[i];
        }
    }

    public FetchUpdatedUserInfoResult(Parcel parcel) {
        super(parcel);
        this.f17192a = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
        this.f17193b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f17192a);
        parcel.writeLong(this.f17193b);
    }
}
