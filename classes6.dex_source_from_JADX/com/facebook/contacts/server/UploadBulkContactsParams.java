package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.ContactSurface;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: p2p_send */
public class UploadBulkContactsParams implements Parcelable {
    public static final Creator<UploadBulkContactsParams> CREATOR = new C05511();
    public final String f8475a;
    public final ImmutableList<UploadBulkContactChange> f8476b;
    public final ContactSurface f8477c;

    /* compiled from: p2p_send */
    final class C05511 implements Creator<UploadBulkContactsParams> {
        C05511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadBulkContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadBulkContactsParams[i];
        }
    }

    public UploadBulkContactsParams(@Nullable String str, ImmutableList<UploadBulkContactChange> immutableList, ContactSurface contactSurface) {
        boolean z = true;
        boolean z2 = str == null || str.length() > 0;
        Preconditions.checkArgument(z2);
        if (immutableList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (immutableList.isEmpty()) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f8475a = str;
        this.f8476b = immutableList;
        this.f8477c = contactSurface;
    }

    public UploadBulkContactsParams(Parcel parcel) {
        this.f8475a = parcel.readString();
        this.f8476b = ImmutableList.copyOf(parcel.readArrayList(UploadBulkContactChange.class.getClassLoader()));
        this.f8477c = ContactSurface.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8475a);
        parcel.writeList(this.f8476b);
        parcel.writeString(this.f8477c.name());
    }
}
