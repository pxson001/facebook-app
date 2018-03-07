package com.facebook.messaging.peopleyoumaycall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.user.model.User;

/* compiled from: render_location */
public class PersonYouMayCall implements Parcelable {
    public static final Creator<PersonYouMayCall> CREATOR = new C05501();
    public final User f3464a;
    public final boolean f3465b;

    /* compiled from: render_location */
    final class C05501 implements Creator<PersonYouMayCall> {
        C05501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PersonYouMayCall(parcel);
        }

        public final Object[] newArray(int i) {
            return new PersonYouMayCall[i];
        }
    }

    public PersonYouMayCall(Parcel parcel) {
        this.f3464a = (User) parcel.readParcelable(User.class.getClassLoader());
        this.f3465b = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3464a, i);
        ParcelUtil.a(parcel, this.f3465b);
    }
}
