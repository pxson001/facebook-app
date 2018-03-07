package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_msg_saved_reply */
public class DeleteContactParams implements Parcelable {
    public static final Creator<DeleteContactParams> CREATOR = new C05341();
    public final Contact f8429a;

    /* compiled from: page_msg_saved_reply */
    final class C05341 implements Creator<DeleteContactParams> {
        C05341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteContactParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteContactParams[i];
        }
    }

    public DeleteContactParams(Parcel parcel) {
        this.f8429a = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8429a, 0);
    }
}
