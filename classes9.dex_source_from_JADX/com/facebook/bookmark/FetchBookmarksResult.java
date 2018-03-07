package com.facebook.bookmark;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;

/* compiled from: reloadFeedViewForGroup */
public class FetchBookmarksResult extends BaseResult implements Parcelable {
    public static final Creator<FetchBookmarksResult> CREATOR = new C05921();
    public final ImmutableList<BookmarksGroup> f5597a;

    /* compiled from: reloadFeedViewForGroup */
    final class C05921 implements Creator<FetchBookmarksResult> {
        C05921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchBookmarksResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchBookmarksResult[i];
        }
    }

    public FetchBookmarksResult(DataFreshnessResult dataFreshnessResult, long j, ImmutableList<BookmarksGroup> immutableList) {
        super(dataFreshnessResult, j);
        this.f5597a = immutableList;
    }

    public FetchBookmarksResult(Parcel parcel) {
        super(parcel);
        Collection a = Lists.a();
        parcel.readTypedList(a, BookmarksGroup.CREATOR);
        this.f5597a = ImmutableList.copyOf(a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f5597a);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mBookmarksGroups", this.f5597a).add("status", this.freshness).add("syncTime", this.clientTimeMs).toString();
    }
}
