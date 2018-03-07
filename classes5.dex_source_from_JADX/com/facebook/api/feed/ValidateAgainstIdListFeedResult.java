package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;

/* compiled from: attached_story */
public class ValidateAgainstIdListFeedResult implements Parcelable {
    public static final Creator<ValidateAgainstIdListFeedResult> CREATOR = new C09561();
    private final ImmutableList<String> f8760a;

    /* compiled from: attached_story */
    final class C09561 implements Creator<ValidateAgainstIdListFeedResult> {
        C09561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ValidateAgainstIdListFeedResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ValidateAgainstIdListFeedResult[i];
        }
    }

    public ValidateAgainstIdListFeedResult(Parcel parcel) {
        Collection a = Lists.a();
        parcel.readStringList(a);
        this.f8760a = ImmutableList.copyOf(a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f8760a);
    }
}
