package com.facebook.search.logging.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: event_tickets */
public class SearchTypeaheadSession implements Parcelable {
    public static final Creator<SearchTypeaheadSession> CREATOR = new C11221();
    public static final SearchTypeaheadSession f15913a = new SearchTypeaheadSession(null, null);
    @Nullable
    public final String f15914b;
    @Nullable
    public final String f15915c;

    /* compiled from: event_tickets */
    final class C11221 implements Creator<SearchTypeaheadSession> {
        C11221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchTypeaheadSession(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new SearchTypeaheadSession[0];
        }
    }

    public SearchTypeaheadSession(@Nullable String str, @Nullable String str2) {
        this.f15914b = str;
        this.f15915c = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15914b);
        parcel.writeString(this.f15915c);
    }
}
