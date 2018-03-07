package com.facebook.payments.shipping.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: backstage_camera_publish */
public class GetMailingAddressesResult implements Parcelable {
    public static final Creator<GetMailingAddressesResult> CREATOR = new C22441();
    public final ImmutableList<MailingAddress> f19044a;

    /* compiled from: backstage_camera_publish */
    final class C22441 implements Creator<GetMailingAddressesResult> {
        C22441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetMailingAddressesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetMailingAddressesResult[i];
        }
    }

    public GetMailingAddressesResult(ImmutableList<MailingAddress> immutableList) {
        this.f19044a = immutableList;
    }

    public GetMailingAddressesResult(Parcel parcel) {
        this.f19044a = ImmutableList.copyOf(parcel.readArrayList(MailingAddress.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f19044a);
    }
}
