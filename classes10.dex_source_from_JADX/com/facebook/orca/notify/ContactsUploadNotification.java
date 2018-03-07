package com.facebook.orca.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: notPausedTransferIds */
public class ContactsUploadNotification extends MessagingNotification {
    public static final Creator<ContactsUploadNotification> CREATOR = new C09481();
    public final String f6183a;
    public final String f6184b;
    public final String f6185c;
    public boolean f6186d;

    /* compiled from: notPausedTransferIds */
    final class C09481 implements Creator<ContactsUploadNotification> {
        C09481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactsUploadNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactsUploadNotification[i];
        }
    }

    public ContactsUploadNotification(String str, String str2, String str3) {
        super(Type.CONTACTS_UPLOAD);
        this.f6183a = str;
        this.f6184b = str2;
        this.f6185c = str3;
    }

    public ContactsUploadNotification(Parcel parcel) {
        super(parcel);
        this.f6183a = parcel.readString();
        this.f6184b = parcel.readString();
        this.f6185c = parcel.readString();
        this.f6186d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.a(parcel);
        parcel.writeString(this.f6183a);
        parcel.writeString(this.f6184b);
        parcel.writeString(this.f6185c);
        ParcelUtil.a(parcel, this.f6186d);
    }
}
