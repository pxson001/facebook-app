package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: audience_code */
public class CheckForInvalidStoriesResult extends BaseResult implements Parcelable {
    public static final Creator<CheckForInvalidStoriesResult> CREATOR = new C09371();
    private final List<String> f8685a;

    /* compiled from: audience_code */
    final class C09371 implements Creator<CheckForInvalidStoriesResult> {
        C09371() {
        }

        public final Object[] newArray(int i) {
            return new CheckForInvalidStoriesResult[i];
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckForInvalidStoriesResult(parcel);
        }
    }

    public CheckForInvalidStoriesResult(List<String> list, DataFreshnessResult dataFreshnessResult, long j) {
        super(dataFreshnessResult, j);
        this.f8685a = (List) Preconditions.checkNotNull(list);
    }

    public CheckForInvalidStoriesResult(Parcel parcel) {
        super(parcel);
        this.f8685a = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringList(this.f8685a);
    }

    public int describeContents() {
        return 0;
    }
}
