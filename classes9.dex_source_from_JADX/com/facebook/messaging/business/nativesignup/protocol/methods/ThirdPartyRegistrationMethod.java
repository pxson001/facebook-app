package com.facebook.messaging.business.nativesignup.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: multipart/byterantes */
public class ThirdPartyRegistrationMethod implements ApiMethod<Params, Void> {
    private static final Class<?> f8914a = ThirdPartyRegistrationMethod.class;

    /* compiled from: multipart/byterantes */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C10141();
        public final String f8910a;
        public final String f8911b;
        public final String f8912c;
        public final String f8913d;

        /* compiled from: multipart/byterantes */
        final class C10141 implements Creator<Params> {
            C10141() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2, String str3, String str4) {
            this.f8910a = str;
            this.f8911b = str2;
            this.f8912c = str3;
            this.f8913d = str4;
        }

        public Params(Parcel parcel) {
            this.f8910a = parcel.readString();
            this.f8911b = parcel.readString();
            this.f8912c = parcel.readString();
            this.f8913d = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8910a);
            parcel.writeString(this.f8911b);
            parcel.writeString(this.f8912c);
            parcel.writeString(this.f8913d);
        }
    }

    public final ApiRequest m9171a(Object obj) {
        Params params = (Params) obj;
        ImmutableList of = ImmutableList.of(new BasicNameValuePair("verified_phone_number", params.f8910a), new BasicNameValuePair("cc_credential", params.f8911b), new BasicNameValuePair("email", params.f8912c), new BasicNameValuePair("opaque", params.f8913d));
        of.toString();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "thirdPartyRegistration";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/v2.5/auth/third_party_registration";
        newBuilder = newBuilder;
        newBuilder.g = of;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m9172a(Object obj, ApiResponse apiResponse) {
        apiResponse.c().B();
        return null;
    }
}
