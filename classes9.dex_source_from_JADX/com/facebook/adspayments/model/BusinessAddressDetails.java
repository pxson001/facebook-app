package com.facebook.adspayments.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.adspayments.utils.AdsPaymentsPreconditions;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.locale.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Predicates;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;
import org.json.JSONObject;

@AutoGenJsonDeserializer
@JsonDeserialize(using = BusinessAddressDetailsDeserializer.class)
/* compiled from: UTF-8 not supported. */
public class BusinessAddressDetails implements Parcelable {
    public static final Creator<BusinessAddressDetails> CREATOR = new C28571();
    @JsonProperty("city")
    private final String mCity;
    @JsonProperty("country_code")
    @Nullable
    private final String mCountryCode;
    @JsonProperty("neighborhood")
    private final String mNeighborhood;
    @JsonProperty("zip")
    private final String mPostalCode;
    @JsonProperty("state")
    private final String mState;
    @JsonProperty("street1")
    private final String mStreet1;
    @JsonProperty("street2")
    @Nullable
    private final String mStreet2;
    @JsonProperty("street_number")
    @Nullable
    private final String mStreetNumber;

    /* compiled from: UTF-8 not supported. */
    final class C28571 implements Creator<BusinessAddressDetails> {
        C28571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BusinessAddressDetails(parcel);
        }

        public final Object[] newArray(int i) {
            return new BusinessAddressDetails[i];
        }
    }

    private BusinessAddressDetails() {
        this(null, null, null, null, null, null, null, null);
    }

    public BusinessAddressDetails(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mStreet1 = str;
        this.mStreet2 = str2;
        this.mCity = str3;
        this.mState = str4;
        this.mPostalCode = str5;
        this.mCountryCode = str6;
        this.mStreetNumber = null;
        this.mNeighborhood = null;
    }

    public BusinessAddressDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, Country country) {
        this.mStreet1 = str;
        this.mStreetNumber = str2;
        this.mStreet2 = str3;
        this.mNeighborhood = str4;
        this.mCity = str5;
        this.mState = str6;
        this.mPostalCode = str7;
        this.mCountryCode = country == null ? null : country.b();
    }

    public BusinessAddressDetails(Parcel parcel) {
        this.mStreet1 = parcel.readString();
        this.mStreetNumber = parcel.readString();
        this.mStreet2 = parcel.readString();
        this.mNeighborhood = parcel.readString();
        this.mCity = parcel.readString();
        this.mState = parcel.readString();
        this.mPostalCode = parcel.readString();
        this.mCountryCode = parcel.readString();
    }

    public BusinessAddressDetails(JsonNode jsonNode) {
        this(m25684a(jsonNode, "street1"), m25684a(jsonNode, "street_number"), m25684a(jsonNode, "street2"), m25684a(jsonNode, "neighborhood"), m25685b(jsonNode, "city"), m25685b(jsonNode, "state"), m25685b(jsonNode, "zip"), jsonNode.d("country_code") ? Country.a(m25685b(jsonNode, "country_code")) : null);
    }

    @Nullable
    private static String m25684a(JsonNode jsonNode, String str) {
        if (jsonNode.d(str)) {
            return jsonNode.b(str).B();
        }
        return null;
    }

    private static String m25685b(JsonNode jsonNode, String str) {
        return (String) AdsPaymentsPreconditions.m25752a(m25684a(jsonNode, str), Predicates.notNull());
    }

    public final String m25689a() {
        return this.mStreet1;
    }

    @Nullable
    private String m25686g() {
        return this.mStreetNumber;
    }

    @Nullable
    private String m25687h() {
        return this.mStreet2;
    }

    public final String m25690b() {
        return this.mCity;
    }

    public final String m25691c() {
        return this.mNeighborhood;
    }

    public final String m25692d() {
        return this.mState;
    }

    private String m25688i() {
        return this.mPostalCode;
    }

    @Nullable
    public final Country m25693e() {
        return this.mCountryCode == null ? null : Country.a(this.mCountryCode);
    }

    public String toString() {
        return m25694f();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStreet1);
        parcel.writeString(this.mStreetNumber);
        parcel.writeString(this.mStreet2);
        parcel.writeString(this.mNeighborhood);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mState);
        parcel.writeString(this.mPostalCode);
        parcel.writeString(this.mCountryCode);
    }

    public final String m25694f() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("street1", m25689a());
            jSONObject.put("street_number", m25686g());
            jSONObject.put("street2", m25687h());
            jSONObject.put("neighborhood", m25691c());
            jSONObject.put("city", m25690b());
            jSONObject.put("state", m25692d());
            jSONObject.put("zip", m25688i());
            jSONObject.put("country_code", this.mCountryCode);
            return jSONObject.toString();
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }
}
