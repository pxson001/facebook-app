package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: p2p_payment_failure */
public class UploadFriendFinderContactsParams implements Parcelable {
    public static final Creator<UploadFriendFinderContactsParams> CREATOR = new C05551();
    public final ContactsFlow f8484a;
    public final String f8485b;
    public final ImmutableList<UploadBulkContactChange> f8486c;
    public final boolean f8487d;

    /* compiled from: p2p_payment_failure */
    final class C05551 implements Creator<UploadFriendFinderContactsParams> {
        C05551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadFriendFinderContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadFriendFinderContactsParams[i];
        }
    }

    /* compiled from: p2p_payment_failure */
    public enum ContactsFlow {
        CONTACT_IMPORTER(0),
        CONTINUOUS_SYNC(1),
        QUICK_PROMOTION(2);
        
        public final int contactsFlow;

        private ContactsFlow(int i) {
            this.contactsFlow = i;
        }
    }

    public UploadFriendFinderContactsParams(ContactsFlow contactsFlow, String str, List<UploadBulkContactChange> list, boolean z) {
        boolean z2 = true;
        Preconditions.checkArgument(contactsFlow != null);
        if (StringUtil.a(str)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f8484a = contactsFlow;
        this.f8485b = str;
        this.f8486c = ImmutableList.copyOf(list);
        this.f8487d = z;
    }

    public UploadFriendFinderContactsParams(Parcel parcel) {
        this.f8484a = ContactsFlow.valueOf(parcel.readString());
        this.f8485b = parcel.readString();
        this.f8486c = ImmutableList.copyOf(parcel.readArrayList(UploadBulkContactChange.class.getClassLoader()));
        this.f8487d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8484a.name());
        parcel.writeString(this.f8485b);
        parcel.writeList(this.f8486c);
        ParcelUtil.a(parcel, this.f8487d);
    }
}
