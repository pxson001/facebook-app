package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.user.model.UserKey;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_link_menu_create */
public class FetchContactParams implements Parcelable {
    public static final Creator<FetchContactParams> CREATOR = new C05371();
    public final UserKey f8440a;
    private final DataFreshnessParam f8441b;

    /* compiled from: page_link_menu_create */
    final class C05371 implements Creator<FetchContactParams> {
        C05371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchContactParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchContactParams[i];
        }
    }

    public FetchContactParams(Parcel parcel) {
        this.f8440a = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f8441b = DataFreshnessParam.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8440a, i);
        parcel.writeString(this.f8441b.toString());
    }
}
