package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: resolveTaggableFriendIds */
public class FetchMessagingFavoritesResult extends BaseResult implements Parcelable {
    public static final Creator<FetchMessagingFavoritesResult> CREATOR = new C01531();
    public final ImmutableList<User> f3424a;

    /* compiled from: resolveTaggableFriendIds */
    final class C01531 implements Creator<FetchMessagingFavoritesResult> {
        C01531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMessagingFavoritesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMessagingFavoritesResult[i];
        }
    }

    public FetchMessagingFavoritesResult(DataFreshnessResult dataFreshnessResult, ImmutableList<User> immutableList, long j) {
        super(dataFreshnessResult, j);
        this.f3424a = immutableList;
    }

    public FetchMessagingFavoritesResult(Parcel parcel) {
        super(parcel);
        this.f3424a = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f3424a);
    }
}
