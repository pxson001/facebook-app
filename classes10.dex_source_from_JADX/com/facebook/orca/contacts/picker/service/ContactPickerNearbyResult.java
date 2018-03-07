package com.facebook.orca.contacts.picker.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: num_non_existent_threads */
public class ContactPickerNearbyResult implements Parcelable {
    public static final Creator<ContactPickerNearbyResult> CREATOR = new C09301();
    public final ImmutableList<User> f6103a;

    /* compiled from: num_non_existent_threads */
    final class C09301 implements Creator<ContactPickerNearbyResult> {
        C09301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactPickerNearbyResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactPickerNearbyResult[i];
        }
    }

    public ContactPickerNearbyResult(ImmutableList<User> immutableList) {
        this.f6103a = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }

    public ContactPickerNearbyResult(Parcel parcel) {
        this.f6103a = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f6103a);
    }
}
