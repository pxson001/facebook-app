package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import javax.annotation.Nullable;

/* compiled from: android_page_header_add_photo_button */
public class FetchReactionsParams extends FetchNodeListParams {
    public static final Creator<FetchReactionsParams> CREATOR = new C09921();
    public final int f10307a;

    /* compiled from: android_page_header_add_photo_button */
    final class C09921 implements Creator<FetchReactionsParams> {
        C09921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchReactionsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchReactionsParams[i];
        }
    }

    public FetchReactionsParams(String str, FeedbackReaction feedbackReaction, int i, @Nullable String str2, @Nullable String str3, DataFreshnessParam dataFreshnessParam) {
        super(str, i, str2, str3, dataFreshnessParam);
        this.f10307a = feedbackReaction.e;
    }

    protected FetchReactionsParams(Parcel parcel) {
        super(parcel);
        this.f10307a = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f10307a);
    }
}
