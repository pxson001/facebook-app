package com.facebook.contactlogs.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contactlogs.migrator.TopSmsContact;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: profile_nux_start_button_tapped */
public class MatchTopSMSContactsParams implements Parcelable {
    public static final Creator<MatchTopSMSContactsParams> CREATOR = new C06391();
    public final ImmutableList<TopSmsContact> f6170a;

    /* compiled from: profile_nux_start_button_tapped */
    final class C06391 implements Creator<MatchTopSMSContactsParams> {
        C06391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MatchTopSMSContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MatchTopSMSContactsParams[i];
        }
    }

    public MatchTopSMSContactsParams(ImmutableList<TopSmsContact> immutableList) {
        this.f6170a = immutableList;
    }

    public MatchTopSMSContactsParams(Parcel parcel) {
        this.f6170a = ImmutableList.copyOf(parcel.readArrayList(TopSmsContact.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f6170a);
    }
}
