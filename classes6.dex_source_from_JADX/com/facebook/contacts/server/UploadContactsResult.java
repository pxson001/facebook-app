package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_payment_risk_failure */
public class UploadContactsResult implements Parcelable {
    public static final Creator<UploadContactsResult> CREATOR = new C05541();
    public final String f8482a;
    public final ImmutableList<Contact> f8483b;

    /* compiled from: p2p_payment_risk_failure */
    final class C05541 implements Creator<UploadContactsResult> {
        C05541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadContactsResult[i];
        }
    }

    public UploadContactsResult(String str, List<Contact> list) {
        this.f8482a = str;
        this.f8483b = ImmutableList.copyOf(list);
    }

    public UploadContactsResult(Parcel parcel) {
        this.f8482a = parcel.readString();
        this.f8483b = ImmutableList.copyOf(parcel.createTypedArrayList(Contact.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8482a);
        parcel.writeTypedList(this.f8483b);
    }
}
