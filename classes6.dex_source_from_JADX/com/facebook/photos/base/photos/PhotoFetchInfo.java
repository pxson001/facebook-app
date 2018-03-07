package com.facebook.photos.base.photos;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;

/* compiled from: initial_rating */
public class PhotoFetchInfo implements Parcelable {
    public static final Creator<PhotoFetchInfo> CREATOR = new C08061();
    public final FetchCause f12753a;
    public final CallerContext f12754b;

    /* compiled from: initial_rating */
    final class C08061 implements Creator<PhotoFetchInfo> {
        C08061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoFetchInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoFetchInfo[i];
        }
    }

    /* compiled from: initial_rating */
    public enum FetchCause {
        USER_INITIATED(RequestPriority.NON_INTERACTIVE, RequestPriority.INTERACTIVE),
        REFRESH(RequestPriority.NON_INTERACTIVE, RequestPriority.NON_INTERACTIVE),
        PREFETCH(RequestPriority.CAN_WAIT, RequestPriority.CAN_WAIT),
        UNKNOWN(RequestPriority.CAN_WAIT, RequestPriority.CAN_WAIT);
        
        private final RequestPriority mFeedbackRequestPriority;
        private final RequestPriority mMetadataRequestPriority;

        private FetchCause(RequestPriority requestPriority, RequestPriority requestPriority2) {
            this.mFeedbackRequestPriority = requestPriority;
            this.mMetadataRequestPriority = requestPriority2;
        }

        public final RequestPriority getFeedbackRecommendedRequestPriority() {
            return this.mFeedbackRequestPriority;
        }

        public final RequestPriority getMetadataRecommendedRequestPriority() {
            return this.mMetadataRequestPriority;
        }

        public static FetchCause getFetchCauseFromName(String str) {
            for (FetchCause fetchCause : values()) {
                if (fetchCause.name().equals(str)) {
                    return fetchCause;
                }
            }
            return UNKNOWN;
        }
    }

    public PhotoFetchInfo(FetchCause fetchCause, CallerContext callerContext) {
        this.f12753a = (FetchCause) Preconditions.checkNotNull(fetchCause);
        this.f12754b = callerContext;
    }

    protected PhotoFetchInfo(Parcel parcel) {
        this.f12753a = FetchCause.getFetchCauseFromName(parcel.readString());
        this.f12754b = (CallerContext) parcel.readParcelable(CallerContext.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12753a != null ? this.f12753a.name() : null);
        parcel.writeParcelable(this.f12754b, i);
    }
}
