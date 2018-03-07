package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: p2p_log_message_type */
public class UploadFriendFinderContactsResult implements Parcelable {
    public static final Creator<UploadFriendFinderContactsResult> CREATOR = new C05561();
    public final String f8488a;
    private final ServerStatusCode f8489b;

    /* compiled from: p2p_log_message_type */
    final class C05561 implements Creator<UploadFriendFinderContactsResult> {
        C05561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadFriendFinderContactsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadFriendFinderContactsResult[i];
        }
    }

    /* compiled from: p2p_log_message_type */
    public enum ServerStatusCode {
        SUCCESS(0),
        FAIL(1),
        RETRY(2),
        UNKNOWN(3);
        
        public final int statusCode;

        private ServerStatusCode(int i) {
            this.statusCode = i;
        }
    }

    public UploadFriendFinderContactsResult(String str, ServerStatusCode serverStatusCode) {
        this.f8488a = str;
        this.f8489b = serverStatusCode;
    }

    public UploadFriendFinderContactsResult(Parcel parcel) {
        this.f8488a = parcel.readString();
        this.f8489b = (ServerStatusCode) Enum.valueOf(ServerStatusCode.class, parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8488a);
        parcel.writeString(this.f8489b.name());
    }
}
