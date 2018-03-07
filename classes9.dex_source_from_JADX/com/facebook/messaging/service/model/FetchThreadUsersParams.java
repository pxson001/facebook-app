package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: conversations */
public class FetchThreadUsersParams implements Parcelable {
    public static final Creator<FetchThreadUsersParams> CREATOR = new C20311();
    public final ImmutableList<UserKey> f17186a;
    public final DataFreshnessParam f17187b;

    /* compiled from: conversations */
    final class C20311 implements Creator<FetchThreadUsersParams> {
        C20311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadUsersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadUsersParams[i];
        }
    }

    public FetchThreadUsersParams(DataFreshnessParam dataFreshnessParam, List<UserKey> list) {
        this.f17186a = ImmutableList.copyOf(list);
        this.f17187b = dataFreshnessParam;
    }

    public FetchThreadUsersParams(Parcel parcel) {
        this.f17186a = ImmutableList.copyOf(parcel.readArrayList(UserKey.class.getClassLoader()));
        this.f17187b = DataFreshnessParam.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.f17186a.toArray());
        parcel.writeString(this.f17187b.toString());
    }
}
