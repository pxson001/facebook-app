package com.facebook.messaging.payment.model.verification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ScreenDataDeserializer.class)
@Immutable
/* compiled from: hash_key */
public class ScreenData implements Parcelable {
    public static final Creator<ScreenData> CREATOR = new C14901();
    @JsonProperty("card_issuer")
    private final String mCardIssuer;
    @JsonProperty("card_last_four")
    private final String mCardLastFour;
    @JsonProperty("dob_day")
    private final int mDobDay;
    @JsonProperty("dob_month")
    private final int mDobMonth;
    @JsonProperty("dob_year")
    private final int mDobYear;
    @JsonProperty("error_message")
    private final String mErrorMessage;
    @JsonProperty("first_name")
    private final String mFirstName;
    @JsonProperty("has_thrown_exception")
    private final boolean mHasThrownException;
    @JsonProperty("intro_reason")
    private final String mIntroReason;
    @JsonProperty("is_sender")
    private final boolean mIsSender;
    @JsonProperty("last_name")
    private final String mLastName;
    @JsonProperty("previous_attempt_failed")
    private final boolean mPreviousAttemptFailed;
    @JsonProperty("sender_short_name")
    private final String mSenderShortName;
    @JsonProperty("verification_succeeded")
    private final boolean mVerificationSucceeded;

    /* compiled from: hash_key */
    final class C14901 implements Creator<ScreenData> {
        C14901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ScreenData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ScreenData[i];
        }
    }

    private ScreenData() {
        this.mIntroReason = null;
        this.mFirstName = null;
        this.mLastName = null;
        this.mSenderShortName = null;
        this.mCardIssuer = null;
        this.mCardLastFour = null;
        this.mErrorMessage = null;
        this.mDobYear = 0;
        this.mDobMonth = 0;
        this.mDobDay = 0;
        this.mIsSender = false;
        this.mPreviousAttemptFailed = false;
        this.mHasThrownException = false;
        this.mVerificationSucceeded = false;
    }

    public ScreenData(Parcel parcel) {
        this.mIntroReason = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mSenderShortName = parcel.readString();
        this.mCardIssuer = parcel.readString();
        this.mCardLastFour = parcel.readString();
        this.mErrorMessage = parcel.readString();
        this.mDobYear = parcel.readInt();
        this.mDobMonth = parcel.readInt();
        this.mDobDay = parcel.readInt();
        this.mIsSender = ParcelUtil.a(parcel);
        this.mPreviousAttemptFailed = ParcelUtil.a(parcel);
        this.mHasThrownException = ParcelUtil.a(parcel);
        this.mVerificationSucceeded = ParcelUtil.a(parcel);
    }

    public final String m14072a() {
        return this.mIntroReason;
    }

    public final String m14073b() {
        return this.mFirstName;
    }

    public final String m14074c() {
        return this.mLastName;
    }

    public final String m14075d() {
        return this.mSenderShortName;
    }

    public final String m14076e() {
        return this.mCardIssuer;
    }

    public final String m14077f() {
        return this.mCardLastFour;
    }

    public final String m14078g() {
        return this.mErrorMessage;
    }

    public final int m14079h() {
        return this.mDobYear;
    }

    public final int m14080i() {
        return this.mDobMonth;
    }

    public final int m14081j() {
        return this.mDobDay;
    }

    public final boolean m14082k() {
        return this.mPreviousAttemptFailed;
    }

    public final boolean m14083l() {
        return this.mHasThrownException;
    }

    public final boolean m14084m() {
        return this.mVerificationSucceeded;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("intro_reason", this.mIntroReason).add("first_name", this.mFirstName).add("last_name", this.mLastName).add("sender_short_name", this.mSenderShortName).add("card_issuer", this.mCardIssuer).add("card_last_four", this.mCardLastFour).add("error_message", this.mErrorMessage).add("dob_year", this.mDobYear).add("dob_month", this.mDobMonth).add("dob_day", this.mDobDay).add("is_sender", this.mIsSender).add("previous_attempt_failed", this.mPreviousAttemptFailed).add("has_thrown_exception", this.mHasThrownException).add("verification_succeeded", this.mVerificationSucceeded).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIntroReason);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mSenderShortName);
        parcel.writeString(this.mCardIssuer);
        parcel.writeString(this.mCardLastFour);
        parcel.writeString(this.mErrorMessage);
        parcel.writeInt(this.mDobYear);
        parcel.writeInt(this.mDobMonth);
        parcel.writeInt(this.mDobDay);
        ParcelUtil.a(parcel, this.mIsSender);
        ParcelUtil.a(parcel, this.mPreviousAttemptFailed);
        ParcelUtil.a(parcel, this.mHasThrownException);
        ParcelUtil.a(parcel, this.mVerificationSucceeded);
    }
}
