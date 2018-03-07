package com.facebook.messaging.payment.service.model.verification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.payment.model.verification.ScreenData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VerifyPaymentResultDeserializer.class)
/* compiled from: fetchPaymentPin */
public class VerifyPaymentResult implements Parcelable {
    public static final Creator<VerifyPaymentResult> CREATOR = new C17131();
    @JsonProperty("fallback_msite")
    private final boolean mFallbackMSite;
    @JsonProperty("fallback_uri")
    private final String mFallbackUri;
    @JsonProperty("screen")
    private final String mScreen;
    @JsonProperty("screen_data")
    private final ScreenData mScreenData;

    /* compiled from: fetchPaymentPin */
    final class C17131 implements Creator<VerifyPaymentResult> {
        C17131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VerifyPaymentResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new VerifyPaymentResult[i];
        }
    }

    private VerifyPaymentResult() {
        this.mFallbackMSite = false;
        this.mFallbackUri = null;
        this.mScreen = null;
        this.mScreenData = null;
    }

    public VerifyPaymentResult(Parcel parcel) {
        this.mFallbackMSite = ParcelUtil.a(parcel);
        this.mFallbackUri = parcel.readString();
        this.mScreen = parcel.readString();
        this.mScreenData = (ScreenData) parcel.readParcelable(ScreenData.class.getClassLoader());
    }

    public final boolean m15212a() {
        return this.mFallbackMSite;
    }

    @Nullable
    public final String m15213b() {
        return this.mFallbackUri;
    }

    @Nullable
    public final String m15214c() {
        return this.mScreen;
    }

    @Nullable
    public final ScreenData m15215d() {
        return this.mScreenData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.mFallbackMSite);
        parcel.writeString(this.mFallbackUri);
        parcel.writeString(this.mScreen);
        parcel.writeParcelable(this.mScreenData, 0);
    }
}
