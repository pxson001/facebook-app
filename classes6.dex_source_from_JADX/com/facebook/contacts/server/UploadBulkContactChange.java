package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.model.PhonebookContact;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_transfer_id */
public class UploadBulkContactChange implements Parcelable {
    public static final Creator<UploadBulkContactChange> CREATOR = new C05481();
    public final String f8464a;
    private final String f8465b;
    public final PhonebookContact f8466c;
    public final Type f8467d;

    /* compiled from: p2p_transfer_id */
    final class C05481 implements Creator<UploadBulkContactChange> {
        C05481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkContactChange(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkContactChange[i];
        }
    }

    /* compiled from: p2p_transfer_id */
    public enum Type {
        ADD,
        MODIFY,
        DELETE
    }

    public UploadBulkContactChange(String str, PhonebookContact phonebookContact, Type type, String str2) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(str != null);
        if (type != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (type == Type.DELETE || phonebookContact != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (str2 == null) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f8464a = str;
        this.f8466c = phonebookContact;
        this.f8467d = type;
        this.f8465b = str2;
    }

    public UploadBulkContactChange(Parcel parcel) {
        this.f8464a = parcel.readString();
        this.f8466c = (PhonebookContact) parcel.readParcelable(PhonebookContact.class.getClassLoader());
        this.f8467d = (Type) Enum.valueOf(Type.class, parcel.readString());
        this.f8465b = parcel.readString();
    }

    public final String m12296a() {
        return this.f8464a;
    }

    public final String m12297b() {
        return this.f8465b;
    }

    public final PhonebookContact m12298c() {
        return this.f8466c;
    }

    public final Type m12299d() {
        return this.f8467d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8464a);
        parcel.writeParcelable(this.f8466c, i);
        parcel.writeString(this.f8467d.toString());
        parcel.writeString(this.f8465b);
    }
}
