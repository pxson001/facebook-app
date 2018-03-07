package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.Nullable;

/* compiled from: android_phone_app_post_call_screen */
public class FetchCommentsParams extends FetchNodeListParams {
    public static final Creator<FetchCommentsParams> CREATOR = new C09891();
    public final CommentOrderType f10304a;
    public final CommentLoadDirection f10305b;

    /* compiled from: android_phone_app_post_call_screen */
    final class C09891 implements Creator<FetchCommentsParams> {
        C09891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchCommentsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchCommentsParams[i];
        }
    }

    public FetchCommentsParams(String str, int i, @Nullable String str2, @Nullable String str3, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, CommentLoadDirection commentLoadDirection) {
        super(str, i, str2, str3, dataFreshnessParam);
        this.f10304a = commentOrderType;
        this.f10305b = commentLoadDirection;
    }

    protected FetchCommentsParams(Parcel parcel) {
        super(parcel);
        this.f10304a = CommentOrderType.getOrder(parcel.readString());
        this.f10305b = CommentLoadDirection.valueOf(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f10304a.toString());
        parcel.writeString(this.f10305b.name());
    }
}
