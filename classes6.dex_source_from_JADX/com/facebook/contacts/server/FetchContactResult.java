package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_info_sections */
public class FetchContactResult extends BaseResult implements Parcelable {
    public static final Creator<FetchContactResult> CREATOR = new C05381();
    public static final FetchContactResult f8442a = new FetchContactResult(DataFreshnessResult.NO_DATA, -1, null, null);
    @Nullable
    private final Contact f8443b;
    private final long f8444c;
    @Nullable
    private final UserKey f8445d;

    /* compiled from: page_info_sections */
    final class C05381 implements Creator<FetchContactResult> {
        C05381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchContactResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchContactResult[i];
        }
    }

    public FetchContactResult(DataFreshnessResult dataFreshnessResult, long j, @Nullable Contact contact, @Nullable UserKey userKey) {
        super(dataFreshnessResult, j);
        this.f8443b = contact;
        this.f8444c = 0;
        this.f8445d = userKey;
    }

    public FetchContactResult(Parcel parcel) {
        super(parcel);
        this.f8443b = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.f8444c = parcel.readLong();
        this.f8445d = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f8443b, i);
        parcel.writeLong(this.f8444c);
        parcel.writeParcelable(this.f8445d, i);
    }

    public String toString() {
        return "FetchContactResult (ts " + this.clientTimeMs + ") (contactSummary " + this.f8443b + ") (freshness " + this.freshness + ")";
    }
}
