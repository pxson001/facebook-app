package com.facebook.timeline.inforeview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: upload_interval */
public class FetchTimelineInfoReviewParams implements Parcelable {
    public static final Creator<FetchTimelineInfoReviewParams> CREATOR = new C00741();
    public String f846a;

    /* compiled from: upload_interval */
    final class C00741 implements Creator<FetchTimelineInfoReviewParams> {
        C00741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTimelineInfoReviewParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTimelineInfoReviewParams[i];
        }
    }

    public FetchTimelineInfoReviewParams(String str) {
        this.f846a = str;
    }

    public FetchTimelineInfoReviewParams(Parcel parcel) {
        this.f846a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f846a);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("session", this.f846a).toString();
    }
}
