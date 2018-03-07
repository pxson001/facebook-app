package com.facebook.messaging.payment.model.verification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = UserInputDeserializer.class)
@Immutable
@JsonSerialize(using = UserInputSerializer.class)
/* compiled from: has_thrown_exception */
public class UserInput implements Parcelable {
    public static final Creator<UserInput> CREATOR = new C14911();
    @JsonProperty("card_first_six")
    final String mCardFirstSix;
    @JsonProperty("dob_day")
    final String mDobDay;
    @JsonProperty("dob_month")
    final String mDobMonth;
    @JsonProperty("dob_year")
    final String mDobYear;
    @JsonProperty("first_name")
    final String mFirstName;
    @JsonProperty("last_name")
    final String mLastName;
    @JsonProperty("ssn_last_four")
    final String mSsnLastFour;

    /* compiled from: has_thrown_exception */
    final class C14911 implements Creator<UserInput> {
        C14911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserInput(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserInput[i];
        }
    }

    public UserInput(UserInputBuilder userInputBuilder) {
        this.mFirstName = userInputBuilder.f13480a;
        this.mLastName = userInputBuilder.f13481b;
        this.mCardFirstSix = userInputBuilder.f13482c;
        this.mDobYear = userInputBuilder.f13483d;
        this.mDobMonth = userInputBuilder.f13484e;
        this.mDobDay = userInputBuilder.f13485f;
        this.mSsnLastFour = userInputBuilder.f13486g;
    }

    public UserInput(Parcel parcel) {
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mCardFirstSix = parcel.readString();
        this.mDobYear = parcel.readString();
        this.mDobMonth = parcel.readString();
        this.mDobDay = parcel.readString();
        this.mSsnLastFour = parcel.readString();
    }

    public static UserInputBuilder newBuilder() {
        return new UserInputBuilder();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("first_name", this.mFirstName).add("last_name", this.mLastName).add("card_first_six", this.mCardFirstSix).add("dob_year", this.mDobYear).add("dob_month", this.mDobMonth).add("dob_day", this.mDobDay).add("ssn_last_four", this.mSsnLastFour).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mCardFirstSix);
        parcel.writeString(this.mDobYear);
        parcel.writeString(this.mDobMonth);
        parcel.writeString(this.mDobDay);
        parcel.writeString(this.mSsnLastFour);
    }
}
