package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.feedtype.FeedType;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: audience_alert */
public class ClearCacheAfterCursorParams implements Parcelable {
    public static final Creator<ClearCacheAfterCursorParams> CREATOR = new C09381();
    public final FeedType f8686a;
    public final List<String> f8687b = Lists.a();

    /* compiled from: audience_alert */
    final class C09381 implements Creator<ClearCacheAfterCursorParams> {
        C09381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ClearCacheAfterCursorParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ClearCacheAfterCursorParams[i];
        }
    }

    public ClearCacheAfterCursorParams(Parcel parcel) {
        this.f8686a = (FeedType) parcel.readParcelable(FeedType.class.getClassLoader());
        parcel.readStringList(this.f8687b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8686a, i);
        parcel.writeStringList(this.f8687b);
    }

    public int describeContents() {
        return 0;
    }
}
