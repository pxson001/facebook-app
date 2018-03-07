package com.facebook.messaging.inbox2.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;

/* compiled from: mPersonalTransferEligible */
public class SuggestedUser implements Parcelable {
    public static final Creator<SuggestedUser> CREATOR = new C12541();
    public final User f11353a;
    public ShareState f11354b = ShareState.PROFILE_PIC;

    /* compiled from: mPersonalTransferEligible */
    final class C12541 implements Creator<SuggestedUser> {
        C12541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SuggestedUser(parcel);
        }

        public final Object[] newArray(int i) {
            return new SuggestedUser[i];
        }
    }

    /* compiled from: mPersonalTransferEligible */
    public enum ShareState {
        PROFILE_PIC,
        SEND_BUTTON,
        SEND_CONFIRMED,
        SEND_ERROR
    }

    public SuggestedUser(User user) {
        this.f11353a = user;
    }

    public SuggestedUser(Parcel parcel) {
        this.f11353a = (User) parcel.readParcelable(User.class.getClassLoader());
        this.f11354b = (ShareState) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11353a, 0);
        parcel.writeSerializable(this.f11354b);
    }
}
