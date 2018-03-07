package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.contacts.graphql.Contact;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_numbers */
public class AddContactResult implements Parcelable {
    public static final Creator<AddContactResult> CREATOR = new C05331();
    public final Contact f8427a;
    public final boolean f8428b;

    /* compiled from: page_numbers */
    final class C05331 implements Creator<AddContactResult> {
        C05331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddContactResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddContactResult[i];
        }
    }

    public AddContactResult(Contact contact, boolean z) {
        Preconditions.checkNotNull(contact);
        this.f8427a = contact;
        this.f8428b = z;
    }

    public AddContactResult(Parcel parcel) {
        this.f8427a = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.f8428b = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8427a, i);
        ParcelUtil.a(parcel, this.f8428b);
    }
}
