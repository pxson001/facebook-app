package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: seen_height */
public class FeedFetchContext implements Parcelable {
    public static final Creator<FeedFetchContext> CREATOR = new C02691();
    public static FeedFetchContext f5815a = new FeedFetchContext(null, null);
    public final String f5816b;
    public final String f5817c;

    /* compiled from: seen_height */
    final class C02691 implements Creator<FeedFetchContext> {
        C02691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FeedFetchContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new FeedFetchContext[i];
        }
    }

    public FeedFetchContext(@Nullable String str, @Nullable String str2) {
        this.f5816b = str;
        this.f5817c = str2;
    }

    public FeedFetchContext(Parcel parcel) {
        this.f5816b = parcel.readString();
        this.f5817c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5816b);
        parcel.writeString(this.f5817c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FeedFetchContext)) {
            return false;
        }
        FeedFetchContext feedFetchContext = (FeedFetchContext) obj;
        if (Objects.equal(feedFetchContext.f5816b, this.f5816b) && Objects.equal(feedFetchContext.f5817c, this.f5817c)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("toId", (Object) this.f5816b).add("viaId", (Object) this.f5817c).toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.f5816b, this.f5817c);
    }
}
